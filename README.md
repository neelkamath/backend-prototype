# Backend Prototype

_Quick reliable backend prototypes_

For backend developers who need to build a prototype, this project is a template that provides boilerplate for the required technologies. Unlike other templates, this project provides the best technologies for prototyping modern applications.

Read the [explanation](docs/explanation.md) for why the particular technologies were chosen.

You might want to create a separate repository to host the specification(s) such as the frontend's wireframes, the application's objectives, the OpenAPI specification, etc. In that case, remove the OpenAPI parts of this repo.

If you're using this template for a hackathon, feel free to set up your project prior to the event. Setting up non-program assets such as CI/CD pipelines isn't against the rules.

## Installation

### Template

(Follow these steps if you are using this template.)

1. Install the [dependencies](docs/installation.md).
1. [Use this template](https://github.com/neelkamath/backend-prototype/generate).
1. Set up the [deployment](docs/deployment.md).
1. Optionally, generate a server stub for the HTTP API using [OpenAPI Generator](https://openapi-generator.tech/) on the file https://raw.githubusercontent.com/neelkamath/backend-prototype/master/docs/openapi.yaml.

### Application

(Follow these steps if you are using the application built with this template.)

Optionally, generate a wrapper for the HTTP API using [OpenAPI Generator](https://openapi-generator.tech/) on the file https://raw.githubusercontent.com/neelkamath/backend-prototype/master/docs/openapi.yaml.

## Usage

### Template

(Follow these steps if you are using this template.)

Read [this gist](https://gist.github.com/neelkamath/df9198b13ac344b17938a7909cdb31f2) to learn how to set up projects.

### Application

(Follow these steps if you are using the application built with this template.)

The HTTP API's base URL is https://backend-prototype.herokuapp.com/. You can read the [documentation](https://neelkamath.gitlab.com/backend-prototype).

## Contributing

The [contribution guide](docs/CONTRIBUTING.md) is meant for the users of the app built with this template.

## License

This project is under the [MIT License](LICENSE).