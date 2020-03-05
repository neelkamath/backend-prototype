# Production

```
docker-compose \
    -f docker/docker-compose.prod.yml \
    --project-directory . \
    up --build 
```
Runs the server on http://0.0.0.0:80. You can use ngrok to securely expose your local web server to the internet by running `./ngrok http 80`.