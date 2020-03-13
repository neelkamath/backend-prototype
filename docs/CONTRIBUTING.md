# Contributing

## Installation

1. [Use this template](https://github.com/neelkamath/backend-prototype/generate).
1. Clone the repository using one of the following methods.
    - SSH: `git clone git@github.com:neelkamath/backend-prototype.git`
    - HTTPS: `git clone https://github.com/neelkamath/backend-prototype.git`
1. Read [this gist](https://gist.github.com/neelkamath/df9198b13ac344b17938a7909cdb31f2) to learn how to set up projects.
1. Install the [dependencies](dependencies.md).
1. Install the latest [node.js LTS](https://nodejs.org/en/download/).
1. Set up the CI/CD pipeline.
    1. Create a [GitLab account](https://gitlab.com/users/sign_up).
    1. [Connect](https://docs.gitlab.com/ee/ci/ci_cd_for_external_repos/github_integration.html) the GitHub repo to a GitLab repo.
1. Set up [ngrok](https://dashboard.ngrok.com/).
1. Optionally, generate a server stub for the HTTP API using [OpenAPI Generator](https://openapi-generator.tech/) on the file https://raw.githubusercontent.com/neelkamath/backend-prototype/master/docs/openapi.yaml.

### [Developing](developing.md)

## DB Schema

We use MongoDB. There is one MongoDB collection named `names`. Every MongoDB document in the collection contains a single name in the format `{"name": "<NAME>"}` (where `<NAME>` is a name such as `Neel`). No duplicate names are to be allowed.