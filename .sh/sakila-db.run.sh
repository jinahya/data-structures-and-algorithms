#!/bin/sh
echo trying to stop previously running container...
sh ./sakila-db.stop.sh
echo running the container...
docker run --rm -d --name ${docker.container} -p ${mysql.port}:3306 ${docker.image}
