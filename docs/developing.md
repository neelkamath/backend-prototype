# Developing

## Server

### Running

Run the server with automatic reload enabled on http://0.0.0.0:80.
- Windows: `heroku local develop-win`
- Others: `heroku local develop`

### Production

Run the server on http://0.0.0.0:80.
- Windows: `heroku local web-win`
- Others: `heroku local web`

### Testing

Run tests and save the reports to `build/reports/tests/test/`.
- Windows: `heroku local test-win`
- Others: `heroku local test`

## Spec

[`docs/openapi.yaml`](openapi.yaml) is the OpenAPI specification.

### Mock Server

```
npx @stoplightio/prism mock docs/openapi.yaml
```
The mock server will be running on http://localhost:4010.

### Testing

```
npx @stoplight/spectral lint docs/openapi.yaml
```

### Documentation

- Serve with automatic reload enabled on http://127.0.0.1:8080: `npx redoc-cli serve docs/openapi.yaml -w`
- Build a production file named `redoc-static.html`: `npx redoc-cli bundle docs/openapi.yaml --title 'Backend Prototype'`