# Reservation Service

## Building and running the project
### Java
Assuming java (a version of the JDK supporting java 17) is installed and configured.
Run `./gradlew clean build jar` to build the project as a standalone jar, 
and run it with `java -jar build/libs/reservation-service-1.0.0-RELEASE.jar`

### Docker build
Assuming docker is installed

An optimized and layered docker image can build with `./gradlew bootBuildImage` and ran with `docker run docker.io/library/reservation-service:1.0.0-RELEASE`
If control of the built docker image is required, one can modify the included Dockerfile and build using the custom
gradle task `./gradlew buildImageFromDockerfile`

### docker-compose build
Assuming docker-compose is installed it can also be leveraged to (build and) start the application
running `docker-compose up --build` will build the image and start it with the configured ports exposed as 8080.

## Testing the REST Endpoints
`example-requests.http` should be recognized by most IDEs with a few examples of the REST endpoints exposed by the API and the parameters they accept
Alternatively, OpenAPI definitions are available at `http://server:port/swagger-ui/index.html` eg. `http://localhost:8080/swagger-ui/index.html`

## Health Check Endpoints
Actuator endpoints are avaiable at `http://server:port/actuator/health` eg. `http://localhost:8080/actuator/health` for healthcheck endpoints

## Unit tests 
Unit tests are ran against the project as part of the build process with `./gradlew build`