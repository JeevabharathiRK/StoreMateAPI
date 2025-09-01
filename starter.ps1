param(
    [Parameter(Position=0)]
    [string]$Action
)

# This script sets environment variables and starts the StoreMate API application
# Set the database URL and credentials
$env:DB_URL = "Replace_with_your_database_url"
$env:DB_USERNAME = "Replace_with_your_database_username"
$env:DB_PASSWORD = "Replace_with_your_database_password"

# Note: Use gradle for global settings and ./gradlew for gradle wrapper

switch ($Action) {
    "bootRun" {
        .\gradlew.bat bootRun --no-daemon
    }
    "test" {
        .\gradlew.bat test --no-daemon
    }
    "build" {
        .\gradlew.bat build --no-daemon
    }
    "run" {
        java -jar "build\libs\storemateapi-0.0.1-SNAPSHOT.jar"
    }
    default {
        Write-Host "Invalid argument. Use bootRun, test, build, or run." -ForegroundColor Red
        exit 1
    }
}
