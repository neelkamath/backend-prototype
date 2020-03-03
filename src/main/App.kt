package backend.prototype

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.LoggerContext
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mongodb.client.MongoClients
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
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import org.slf4j.LoggerFactory

data class Explanation(val explanation: String)

private const val database =
    "mongodb://heroku_j2z4kg55:ll047cm6gqbklksejr9orastv1@ds337418.mlab.com:37418/heroku_j2z4kg55"
private val db = MongoClients.create("$database?retryWrites=false").getDatabase("heroku_j2z4kg55")
private const val token =
    "pk.eyJ1IjoibmVlbGthbWF0aCIsImEiOiJjanp0cHV4cjkwNGVyM21vYXVnYW5oYzU4In0.ioLnaLd2Awv1gMc4kI1FmA"
val explanation = Explanation("Quick reliable backend prototypes")
/** Shared Gson configuration for the entire project. */
val gson: Gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

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
        get("explanation") { call.respond(explanation) }
        get("health_check") { call.respond(HttpStatusCode.NoContent) }
    }
}