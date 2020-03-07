package backend.prototype.test

import backend.prototype.*
import com.mongodb.client.model.Filters
import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.extensions.TestListener
import io.kotlintest.matchers.collections.shouldBeEmpty
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.ktor.application.Application
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.setBody
import io.ktor.server.testing.withTestApplication

// Tests for the HTTP DELETE /names endpoint.
class NameDeleterTest : StringSpec() {
    init {
        "Deleting an existing name should respond with a status code of 204" {
            val name = Name("John")
            DB.insertName(name)
            deleteName(name) shouldBe 204
        }

        "Deleting a nonexistent name should respond with a status code of 400" { deleteName(Name("Rick")) shouldBe 400 }

        "Deleting a name should cause it to not be retrieved" {
            listOf("John", "Rick").map { DB.insertName(Name(it)) }
            deleteName(Name("John"))
            DB.getNames().names shouldBe listOf("Rick")
        }
    }

    override fun listeners(): List<TestListener> = listOf(NameListener)

    /** Returns the HTTP status code after making an HTTP DELETE request to the /names endpoint. */
    private fun deleteName(name: Name): Int = withTestApplication(Application::main) {
        handleRequest(HttpMethod.Delete, "/names") {
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            setBody(gson.toJson(name))
        }.response.status()!!.value
    }
}

// Tests for the HTTP GET /names endpoint.
class NameGetterTest : StringSpec() {
    init {
        "Getting names should respond with a status code of 200" {
            withTestApplication(Application::main) {
                with(handleRequest(HttpMethod.Get, "/names")) {
                    response.status()!!.value shouldBe 200
                }
            }
        }

        "There should be no names when none were inserted" { getNames().names.shouldBeEmpty() }

        "The DB should only contain the inserted names" {
            val names = listOf("John", "Doe")
            names.map { DB.insertName(Name(it)) }
            getNames().names shouldBe names
        }
    }

    override fun listeners(): List<TestListener> = listOf(NameListener)

    private fun getNames(): Names = withTestApplication(Application::main) {
        with(handleRequest(HttpMethod.Get, "/names")) {
            gson.fromJson(response.content, Names::class.java)
        }
    }
}

// Tests for the HTTP PATCH /names endpoint.
class NamePatcherTest : StringSpec() {
    init {
        "Successfully updating a name should respond with a status code of 204" {
            DB.insertName(Name("Mazer Rackham"))
            val update = NameUpdate(oldName = "Mazer Rackham", newName = "John Connor")
            patchName(update) shouldBe 204
        }

        "Updating a nonexistent name should respond with a status code of 400" {
            patchName(NameUpdate(oldName = "John", newName = "Joe")) shouldBe 400
        }

        "Updating a name should cause retrieving the names to contain the updated one" {
            DB.insertName(Name("Joe"))
            patchName(NameUpdate(oldName = "Joe", newName = "Elmo"))
            DB.getNames().names shouldBe listOf("Elmo")
        }
    }

    override fun listeners(): List<TestListener> = listOf(NameListener)

    /** Returns the HTTP status code after making an HTTP PATCH request to the /names endpoint. */
    private fun patchName(update: NameUpdate): Int = withTestApplication(Application::main) {
        handleRequest(HttpMethod.Patch, "/names") {
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            setBody(gson.toJson(update))
        }.response.status()!!.value
    }
}

// Tests for the HTTP POST /names endpoint.
class NamePosterTest : StringSpec() {
    init {
        "Uploading a new name should respond with a status code of 204" { postName(Name("John")) shouldBe 204 }

        "Uploading an existing name should respond with a status code of 400" {
            val name = Name("John")
            DB.insertName(name)
            postName(name) shouldBe 400
        }

        "Uploading names should cause the same ones to be retrieved" {
            val names = listOf("John", "Rick", "Joe")
            names.map { postName(Name(it)) }
            DB.getNames().names shouldBe names
        }
    }

    override fun listeners(): List<TestListener> = listOf(NameListener)

    /** Returns the HTTP status code after making an HTTP POST request to the /names endpoint. */
    private fun postName(name: Name): Int = withTestApplication(Application::main) {
        handleRequest(HttpMethod.Post, "/names") {
            addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
            setBody(gson.toJson(name))
        }.response.status()!!.value
    }
}

object NameListener : TestListener {
    override fun beforeTest(testCase: TestCase): Unit = wipeDb()

    override fun afterTest(testCase: TestCase, result: TestResult): Unit = wipeDb()

    private fun wipeDb() {
        collection.deleteMany(Filters.exists("name"))
    }
}