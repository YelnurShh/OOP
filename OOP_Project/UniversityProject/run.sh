#!/bin/bash
set -e
mkdir -p out data
find src -name "*.java" > sources.txt
javac -d out @sources.txt
echo "Compiled. Running..."
java -cp out Main
