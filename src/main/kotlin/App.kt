package backend.prototype

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.LoggerContext
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters.eq
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.gson.GsonConverter
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.*
import org.slf4j.LoggerFactory

private val dbUri = System.getenv("MONGODB_URI")

// We set <retryWrites> to <false> because mLab's free tier doesn't support writes being retried.
val db: MongoDatabase = MongoClients.create("$dbUri?retryWrites=false").getDatabase(dbUri.split("/").last())

/** The only MongoDB collection this project uses. */
val collection = db.getCollection("names")

/** Shared Gson configuration for the entire project. */
val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

fun Application.main() {
    (LoggerFactory.getILoggerFactory() as LoggerContext).getLogger("org.mongodb.driver").level = Level.ERROR
    install(CallLogging)
    install(ContentNegotiation) { register(ContentType.Application.Json, GsonConverter(gson)) }
    install(CORS) {
        HttpMethod.DefaultMethods.map { method(it) }
        header(HttpHeaders.AccessControlAllowHeaders)
        header(HttpHeaders.ContentType)
        header(HttpHeaders.AccessControlAllowOrigin)
        anyHost()
        allowCredentials = true
        allowNonSimpleContentTypes = true
    }
    install(Routing) {
        route("names") {
            delete {
                val name = call.receive<Name>()
                if (collection.find(eq("name", name.name)).toList().isEmpty())
                    call.respond(HttpStatusCode.BadRequest)
                else {
                    DB.deleteName(name)
                    call.respond(HttpStatusCode.NoContent)
                }
            }
            get { call.respond(DB.getNames()) }
            patch {
                val update = call.receive<NameUpdate>()
                if (collection.find(eq("name", update.oldName)).toList().isEmpty())
                    call.respond(HttpStatusCode.BadRequest)
                else {
                    DB.updateName(update)
                    call.respond(HttpStatusCode.NoContent)
                }
            }
            post {
                val name = call.receive<Name>()
                if (collection.find(eq("name", name.name)).toList().isEmpty()) {
                    DB.insertName(name)
                    call.respond(HttpStatusCode.NoContent)
                } else
                    call.respond(HttpStatusCode.BadRequest)
            }
        }
        get("health_check") { call.respond(HttpStatusCode.NoContent) }
    }
}