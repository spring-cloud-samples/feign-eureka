# feign-eureka
Example of using feign with eureka

Assumes eureka (from [spring-cloud-samples](https://github.com/spring-cloud-samples/eureka)) is running on http://localhost:8761

## building

`mvn package`

## hello server

run `java -jar server/target/feign-eureka-hello-server-0.0.1-SNAPSHOT.jar`

verify it is functioning at [http://localhost:7111](http://localhost:7111)

You should see `Hello World: HelloServer:myhostname:7111`

## hello client

run `java -jar client/target/feign-eureka-hello-client-0.0.1-SNAPSHOT.jar`

verify it is functioning at [http://localhost:7211](http://localhost:7211)

You should see `Hello World: HelloServer:myhostname:7111`

### hellow client error

You may see an error while the eureka/ribbon caches warm up similar to the following:

    Whitelabel Error Page

    This application has no explicit mapping for /error, so you are seeing this as a fallback.

    Wed Jan 07 13:13:39 MST 2015
    There was an unexpected error (type=Internal Server Error, status=500).
    com.netflix.client.ClientException: Load balancer does not have available server for client: HelloServer

It should go away shortly.

## See round robin load balancing in action

run `java -jar server/target/feign-eureka-hello-server-0.0.1-SNAPSHOT.jar --server.port=7112`

Go back to [http://localhost:7211](http://localhost:7211) and you should see both ports `7111` and `7112` in the output after a minute or two as you keep refreshing.
