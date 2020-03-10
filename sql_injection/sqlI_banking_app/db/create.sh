#!/bin/bash

PGPASSWORD=postgres psql -U postgres -h localhost -c "drop database sqli_example"
PGPASSWORD=postgres psql -U postgres -h localhost -c "create database sqli_example OWNER = postgres"
