#!/bin/sh

./gradlew clean build;

sleep 10 &
xterm -e "cd src/client; npm install --force --silent; npm start --silent;" &

./gradlew bootRun;
