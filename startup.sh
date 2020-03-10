#!/bin/bash

APP=$1

if [ "$APP" = "down" ]; then
   kill -9 $(lsof -i :8080 -t);
   kill -9 $(lsof -i :8081 -t); 
fi

if [ "$APP" = "xss" ]; then
   cd xss/shopping_app/; 
   ./gradlew bootRun &

   echo "Starting shopping app on port 8080";   
   cd ../data_sink/; 
   ./gradlew bootRun &  
   echo "Starting data sink on port 8081"; 
   cd ../../;
fi 


if [ "$APP" = "csrf" ]; then
   cd csrf/banking_app/;
   ./gradlew bootRun &

   echo "Starting banking app on port 8080";
   cd ../malicious_app/;
   ./gradlew bootRun &
   echo "Starting malicious app on port 8081";
   cd ../../;
fi

if [ "$APP" = "sqli" ]; then
   cd sql_injection/sqlI_banking_app;
   ./gradlew bootRun &

   echo "Starting banking app on port 8080";
   cd ../../;
fi
