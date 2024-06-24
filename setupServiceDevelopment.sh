#!/bin/bash

./dockerBuildRun.sh

docker-compose -p mspr-kawa-services up -d

echo ""
echo ""
echo "Service Paye Ton KAWA up              | OK |"
echo ""
echo ""
