#!/bin/bash
sudo apt-get install jq
location=$(pwd)
gnome-terminal --tab -- /bin/bash -c "$location/client.sh; bash"

mvn package
java -jar target/qikserve-0.0.1-SNAPSHOT.jar
