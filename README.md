# Backend Prototype

_Quick reliable backend prototypes_

![Cover](cover.jpg)

For backend developers who need to build a prototype, this project is a template that provides boilerplate for the required technologies. Unlike other templates, this project provides the best technologies for prototyping modern applications.

Read the [explanation](docs/explanation.md) on why particular technologies were chosen.

You might want to create a separate repository to host the specification(s) such as the frontend's wireframes, the application's objectives, the OpenAPI specification, etc. In that case, remove the OpenAPI parts of this repo.

If you're using this template for a hackathon, feel free to set up your project prior to the event. Setting up non-program assets such as CI/CD pipelines isn't against the rules.

Follow the **Contributing** section if you are using this template (building the HTTP API; the backend developer) to create an application. Follow the **Installation** and **Usage** sections if you are using the application (consuming the HTTP API; the frontend developer) that was built with this template.

## Installation

Optionally, generate a client SDK for the HTTP API using [OpenAPI Generator](https://openapi-generator.tech/) on the file https://raw.githubusercontent.com/neelkamath/backend-prototype/master/docs/openapi.yaml.

## Usage

The HTTP API's base URL is https://backend-prototype.herokuapp.com/. You can read the [documentation](https://neelkamath.gitlab.io/backend-prototype/).

## Contributing

### Installation

1. [Use this template](https://github.com/neelkamath/backend-prototype/generate).
1. Read [this gist](https://gist.github.com/neelkamath/df9198b13ac344b17938a7909cdb31f2) to learn how to set up projects.
1. Install a [Java 8 JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).
1. Install the latest [node.js LTS](https://nodejs.org/en/download/).
1. Set up the CI/CD pipeline.
    1. Create a [GitLab account](https://gitlab.com/users/sign_up).
    1. [Connect](https://docs.gitlab.com/ee/ci/ci_cd_for_external_repos/github_integration.html) the GitHub repo to a GitLab repo.
1. Set up the deployment.
    1. Create a [Heroku account](https://signup.heroku.com/).
    1. Install the [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli#download-and-install).
    1. [![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)
    1. Set it to [deploy using GitHub](https://devcenter.heroku.com/articles/github-integration#enabling-github-integration).
    1. Perform the following in the **Automatic deploys** section.
        1. Check the **Wait for CI to pass before deploy** checkbox.
        1. Click **Enable Automatic Deploys**.
1. Set up environment variables.
    1. Find your DB connection URL in your [config vars](https://devcenter.heroku.com/articles/config-vars#using-the-heroku-dashboard).
    1. Create a file named `.env`.
    1. Add the line `MONGODB_URI=<VALUE>` to `.env`. Replace `<VALUE>` with the value of the `MONGODB_URI` config var.
1. Optionally, generate a server stub for the HTTP API using [OpenAPI Generator](https://openapi-generator.tech/) on the file https://raw.githubusercontent.com/neelkamath/backend-prototype/master/docs/openapi.yaml.

### [Developing](docs/developing.md)

## License

This project is under the [MIT License](LICENSE).