package backend.prototype.test

import backend.prototype.Explanation
import backend.prototype.explanation
import backend.prototype.gson
import backend.prototype.main
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication

// Tests for the `/explanation` endpoint.
class ExplanationTest : StringSpec({
    "An explanation request should beckon an explanation with a response code of 200" {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/explanation")) {
                response.status()!!.value shouldBe 204
                gson.fromJson(response.content, Explanation::class.java) shouldBe explanation
            }
        }
    }
})

// Tests for the `/health_check` endpoint.
class HealthCheckTest : StringSpec({
    "A health check request should beckon a status code of 204" {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/health_check")) { response.status()!!.value shouldBe 204 }
        }
    }
})
