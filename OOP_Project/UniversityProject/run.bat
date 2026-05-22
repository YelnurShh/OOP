@echo off
if not exist out mkdir out
if not exist data mkdir data
dir /S /B src\*.java > sources.txt
javac -d out @sources.txt
if errorlevel 1 goto end
echo Compiled. Running...
java -cp out Main
:end
