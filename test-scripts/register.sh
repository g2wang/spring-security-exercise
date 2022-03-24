#!/bin/sh

curl -iL -X POST http://127.0.0.1:8080/api/register -d '
{
    "username":"g2wang",
    "password":"#9Ba-%$23"
}'
