# Backend Prototype

_Quick reliable backend prototypes_

![Cover](cover.jpg)

For backend developers who need to build a prototype, this project is a template that provides boilerplate for the required technologies. Unlike other templates, this project provides the best technologies for prototyping modern applications.

To know why particular technologies were chosen, read the [explanation](docs/explanation.md).

It is best for prototypes to use HTTP GET requests due to innumerable problems which arise which from attempting to use other HTTP methods like POST. If you're using this template for a hackathon, feel free to set up your project prior to the event. Setting up non-program assets such as CI/CD pipelines isn't against the rules. You might want to create a separate repository to host the specification(s) such as the frontend's wireframes, the application's objectives, the OpenAPI specification, etc. In that case, remove the OpenAPI parts of this repo.

Follow the **Contributing** section if you are using this template (building the HTTP API; the backend developer) to create an application. Follow the **Installation** and **Usage** sections if you are using the application (consuming the HTTP API; the frontend developer) that was built with this template.

## Installation

1. Install the [dependencies](docs/dependencies.md).
1. Optionally, generate a client SDK for the HTTP API using [OpenAPI Generator](https://openapi-generator.tech/) on the file https://raw.githubusercontent.com/neelkamath/backend-prototype/master/docs/openapi.yaml.

## Usage

### [Documentation](https://neelkamath.gitlab.io/backend-prototype/)

### [Running the Server](docs/production.md)

## [Contributing](docs/CONTRIBUTING.md)

## License

This project is under the [MIT License](LICENSE).
