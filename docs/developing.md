# Developing

## Server

### Running

```
heroku local develop
```
Runs the server with automatic reload enabled on http://0.0.0.0:80.

### Production

```
heroku local web
```
The server will be running on http://localhost:80.

### Testing

```
heroku local test
```
Test reports save to `build/reports/tests/test/`.

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

- Serve with automatic reload enabled on http://localhost:80: `npx redoc-cli serve docs/openapi.yaml -w`
- Build a production file saved as `redoc-static.html`: `npx redoc-cli bundle docs/openapi.yaml --title 'Backend Prototype'`


