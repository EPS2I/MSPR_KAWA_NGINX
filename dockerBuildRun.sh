#!/bin/bash

docker rm -f mspr-kawa-nginx || true &
docker rm -f mspr-kawa-rabbitmq || true &
docker rm -f mspr-kawa-keycloak || true &
docker rm -f postgresql || true &
wait

docker rmi -f mspr-kawa-nginx || true &
docker rmi -f mspr-kawa-rabbitmq || true &
docker rmi -f mspr-kawa-keycloak || true &
docker rmi -f postgresql || true &
wait

docker build -t mspr-kawa-nginx . &
docker build -t mspr-kawa-rabbitmq ./rabbitMQ/. &
docker build -t mspr-kawa-keycloak ./keycloak/. &
docker build -t postgresql ./db_main/. &
wait

echo ""
echo ""
echo "image nginx rabbitMQ              | OK |"
echo ""
echo ""

#docker run --name mspr-kawa-nginx -d -p 8082:8082 mspr-kawa-nginx &
#docker run --name mspr-kawa-rabbitmq -d -p 15672:15672 -p 5672:5672 mspr-kawa-rabbitmq &
#docker run --name mspr-kawa-keycloak -d -p 8081:8081 mspr-kawa-keycloak &
#docker run --name postgresql -d -p 5432:5432 postgresql &
#wait
#
#
#echo ""
#echo ""
#echo "Containre nginx rabbitMQ              | OK |"
#echo ""
#echo ""
