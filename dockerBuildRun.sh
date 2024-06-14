#!/bin/bash

docker rm -f mspr-kawa-nginx || true &
docker rm -f mspr-kawa-rabbitmq || true &
wait

docker rmi -f mspr-kawa-nginx || true &
docker rmi -f mspr-kawa-rabbitmq || true &
wait

docker build -t mspr-kawa-nginx . &
docker build -t mspr-kawa-rabbitmq ./rabbitMQ/. &
wait

echo ""
echo ""
echo "image nginx rabbitMQ              | OK |"
echo ""
echo ""

#docker run --name mspr-kawa-nginx -d -p 8082:8082 mspr-kawa-nginx &
#wait
#gs
#
#echo ""
#echo ""
#echo "Containre nginx rabbitMQ              | OK |"
#echo ""
#echo ""
