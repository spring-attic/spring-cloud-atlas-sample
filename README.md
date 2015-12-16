# Atlas Sample

Before running this project, start a local Atlas server:

```
$ curl -Lo memory.conf https://raw.githubusercontent.com/Netflix/atlas/master/conf/memory.conf
$ curl -LO https://github.com/Netflix/atlas/releases/download/v1.4.5/atlas-1.4.5-standalone.jar
$ java -jar atlas-1.4.5-standalone.jar memory.conf
```

More information about interacting with the Atlas server can be found on the [Atlas wiki](https://github.com/Netflix/atlas/wiki/Getting-Started).

Run the project as a Spring Boot app (e.g. import into IDE and run
main method, or use "mvn spring-boot:run or gradle bootRun or ./gradlew bootRun"). It will start up on port
8080 and begin publishing a counter metric via Spectator every 5 seconds.