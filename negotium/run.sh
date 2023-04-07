#!/bin/bash

# stop all docker containers 
docker-compose down

# stop all running containers
echo '####################################################'
echo 'Stopping running containers (if available)...'
echo '####################################################'
docker stop $(docker ps -aq)

# remove all stopped containers
echo '####################################################'
echo 'Removing containers ..'
echo '####################################################'
docker rm $(docker ps -aq)

# remove all images
echo '####################################################'
echo 'Removing images ...'
echo '####################################################'
docker rmi -f $(docker images -q)

# remove all stray volumes if any
echo '####################################################'
echo 'Revoming docker container volumes (if any)'
echo '####################################################'
docker volume rm $(docker volume ls -q)

docker-compose -f docker-compose.yml up --build
