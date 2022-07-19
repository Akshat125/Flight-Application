@echo OFF
@echo "Start Project.."
set mypath=%cd%
call ./gradlew clean build

if exist ./build/libs/T01E01-Exercise-1.0.0.jar (
    @echo "Start Server.."
) else (
    @echo "Failed to generate Server-Application.jar"
)
cd "./build/libs/"
start  java -jar T01E01-Exercise-1.0.0.jar
@echo "Wait the server to start.."
timeout 10
@echo "Start React.."
cd "%mypath%"
cd "./src/client/src"
@echo "Install React-Dependencies.."
call npm install --force --silent
@echo "Project Running.."
call npm start --silent