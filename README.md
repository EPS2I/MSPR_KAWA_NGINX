# Build Docker

### Build image

    docker build -t mspr_kawa_nginx .

### Run container

    docker run --name mspr_kawa_nginx -d -p 8082:8082 mspr_kawa_nginx

### Run services MSPR_KAWA


    docker-compose -p msprkawa up

