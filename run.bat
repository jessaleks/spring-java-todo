@echo off
FOR /F "tokens=* delims=" %%g IN (src/main/resources/.env) DO (SET "%%g")
java -jar build/libs/spring-java-todo-0.0.1-plain.jar
