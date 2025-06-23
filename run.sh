#!/bin/bash
clear
echo 'delete logs'
rm -rf logs/
echo 'logs cleared'
clear
mvn clean package && java -jar target/Delivery-0.0.1-SNAPSHOT.jar
