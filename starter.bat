@echo off
REM This script sets environment variables and starts the StoreMate API application
Rem Uncomment the following lines to set your database URL and credentials.
:: set DB_URL= ReplaceWithYourDatabaseURLHere
:: set DB_USERNAME= ReplaceWithYourUsernameHere
:: set DB_PASSWORD= ReplaceWithYourPasswordHere

Rem Note
:: Use gradle for global settings and 
:: ./gradlew for gradle wrapper

if "%1"=="bootRun" (
    gradle bootRun --no-daemon
) else if "%1"=="test" (
    gradle test --no-daemon
) else if "%1"=="build" (
    gradle build --no-daemon
) else if "%1"=="run" (
    Rem Replace Filename.jar with the actual name of your JAR file
    :: java -jar build\libs\Filename.jar
) else (
    echo Invalid argument. Use bootRun, test, build, or run.
    exit /b 1
)