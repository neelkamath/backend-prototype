# Explanation

## GitHub

[GitHub](https://github.com/) is an excellent platform for prototypes. It version controls your application using [Git](https://git-scm.com/) so that you can revert to what worked to a prior commit. It has a marketplace, free private repositories, enables you to share your project with collaborators and your future self, etc. 

## Gradle

[Gradle](https://gradle.org/) is the most advanced automation system. It automatically builds your Kotlin, Swift, JavaScript, etc. apps by bringing in dependencies (e.g., ktor), compilers (the Kotlin compiler), plugins (e.g., GitHub release plugin, Bintray release plugin), etc.

## Kotlin

[Kotlin](https://kotlinlang.org/) can seamlessly leverage one of the biggest ecosystems out there, namely the JVM. Its concise syntax, superior IDE support, and excellent tooling allow the complex configuration setups of Java in the past. Clearly, Kotlin isn't just production ready, but is an excellent language choice for building prototypes.

## Kotest

[Kotest](https://github.com/kotest/kotest) is similar to Kotlin's standard testing library, except that includes goodies like hamcrest matchers which greatly improve error reporting while drastically cutting down on the amount of code that needs to be written. Testing core logic on the backend is done the easiest through automated test suites. In prototypes, test suites should be significantly smaller than their production equivalents.

## ktor

[ktor](http://ktor.io/) is an easy to use, fun, and asynchronous framework. It is foundationally strong, has support for everything from websockets to templating languages, and is trivial to set up.

## OpenAPI

[OpenAPI](https://www.openapis.org/) is an HTTP API specification tool which provides the following benefits.
- Only non-program assets (e.g., logos) may be created prior to a hackathon. By formally specifying which endpoints will be created, the developer has a clearer idea of what will be built during the event.
- Using a tool such as [OpenAPI Generator](https://openapi-generator.tech/), you can generate server and client stubs.
- Using a tool such as [Redoc](https://github.com/Redocly/redoc), the frontend developer would have access to the API docs.
- Using a tool like [Prism](https://github.com/stoplightio/prism), the frontend developer can make use of a mock server while the real one is being implemented.

## GitLab CI

[GitLab CI](https://docs.gitlab.com/ee/ci/) allows you to verify that your application works (CI) even in an isolated environment (e.g., on Heroku), and then deploys it (CD). Unlike GitHub Actions, GitLab CI has better static pages support, registries, etc.

## MongoDB

Although a production application would favor an RDBMS, prototypes simply require runtime objects to be persisted This is not the same thing as a traditional DB. Unlike advanced systems such as Postgres, the occasional corruption of data (which has a negligible chance of occurring during prototyping), and lack of features such as views, functions, and custom datatypes, is a nonissue. Since we're not storing real data (i.e., the DB is insensitive to security defects and data loss), [MongoDB](https://www.mongodb.com/)'s lack of schemas is a pro rather than a con. We can easily dump runtime objects without having to worry about table creation, DB migrations, etc.

## Heroku

[Heroku](https://www.heroku.com/) provides the following benefits.
 - It includes a generous free tier which allows you to run your application even after the demo is over so that people who see the project years later won't be greeted by a 404. Unlike services like AWS whose free tiers expire after a certain duration, Heroku allows you to run any number of apps for free as long as they don't receive traffic 24/7/365.
 - It's easy to use since it's a PaaS.
 - It has support for major technologies such as Python and Docker.
 - It sets up entire environments with just the click of a button.
 - It's GUI allows you to rollback deploys in a single click.

## mLab

Since we're using the Heroku add-on to attach [mLab](https://mlab.com/) to our application, everything is already set up for us (i.e., there is no need for us to create an mLab account, create an mLab DB, or connect mLab to our Heroku application). mLab provides a GUI which allows us to easily wipe the DB, and manually inspect and manipulate entries. Instead of maintaining different database environments (e.g., development, staging), we'll use the hosted instance for all stages (including development). By using mLab's hosted MongoDB databases, we can rid ourselves of concerns such as differing database environments, the inability to quickly manipulate data, and wiping the DB when you frequently update its schema.