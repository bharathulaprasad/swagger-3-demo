# # Using Swagger 3 in Spring Boot 3 example demo

Assume you have the following requirement
If i send a request as a POST request:

[http://localhost:8080/employees/filter](http://localhost:8080/employees/filter)
{

"secret": "includeSalary",

"employees": [

{

"id": 1,

"firstName": "John",

"lastName": "Doe",

"department": "R&D",

"salary": 500000.223346346346

},

{

"id": 2,

"firstName": "Zebra",

"lastName": "Cross",

"department": "Finance",

"salary": 1000.22557

}

]

}

I should then get a response:

{

"employees": [

{

"id": 1,

"firstName": "John",

"lastName": "Doe",

"department": "R&D",

"salary": 500000.22334634635

},

{

"id": 2,

"firstName": "Zebra",

"lastName": "Cross",

"department": "Finance",

"salary": 1000.22557

}

]

}

But if i skip the secret then no salary value should come in response.

Request:

{

"employees": [

{

"id": 1,

"firstName": "John",

"lastName": "Doe",

"department": "R&D",

"salary": 500000.223346346346

},

{

"id": 2,

"firstName": "Zebra",

"lastName": "Cross",

"department": "Finance",

"salary": 1000.22557

}

]

}

{

"employees": [

{

"id": 1,

"firstName": "John",

"lastName": "Doe",

"department": "R&D",

"salary": null

},

{

"id": 2,

"firstName": "Zebra",

"lastName": "Cross",

"department": "Finance",

"salary": null

}

]

}

# Files

Use your favorite tool to generate a new spring application. For example [https://start.spring.io/](https://start.spring.io/)
The pom.xml should contain the swagger 3 related dependencies! 

## Create files 

Create your OpenApi Spec as described in src\main\resources\openapi.yaml
Run command 
mvn generate-sources. This will generate the interface for implementing our Rest API

## Implementation of the Rest Interface

Implement your class public  class  EmployeeApiController  implements  EmployeesApi as descibed in the project

## Run the project

Try it out, command
mvn spring-boot:run

## Testing

Access API docs:
http://localhost:8080/api-docs

Access swagger:
http://localhost:8080/swagger-ui/index.html

## Test using postman

Send a request like:
Send without secret:
{

"employees":  [

{

"id":  1,

"firstName":  "John",

"lastName":  "Doe",

"department":  2,

"salary":  2.55

},

{

"id":  2,

"firstName":  "Zebra",

"lastName":  "Cross",

"department":  "Finance",

"salary":  1000.22557

}

]

}

Send with secret:
{

"secret":  "includeSalary",

"employees":  [

{

"id":  1,

"firstName":  "John",

"lastName":  "Doe",

"department":  2,

"salary":  2.55

},

{

"id":  2,

"firstName":  "Zebra",

"lastName":  "Cross",

"department":  "Finance",

"salary":  1000.22557

}

]

}



# Observation during test

Salary will be included or excluded based on your input json.

# Dependencies check
mvn dependency:tree
you may see some thing like
[INFO] --- dependency:3.6.1:tree (default-cli) @ demo ---
[INFO] com.example:demo:jar:0.0.1-SNAPSHOT
[INFO] +- jakarta.annotation:jakarta.annotation-api:jar:3.0.0:compile
[INFO] +- javax.annotation:javax.annotation-api:jar:1.3.2:compile
[INFO] +- javax.validation:validation-api:jar:2.0.1.Final:compile
[INFO] +- jakarta.validation:jakarta.validation-api:jar:3.0.0:compile
[INFO] +- org.springframework.boot:spring-boot-starter-validation:jar:3.2.6:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter:jar:3.2.6:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-logging:jar:3.2.6:compile
[INFO] |  |  |  +- ch.qos.logback:logback-classic:jar:1.4.14:compile
[INFO] |  |  |  |  \- ch.qos.logback:logback-core:jar:1.4.14:compile
[INFO] |  |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.21.1:compile
[INFO] |  |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.21.1:compile
[INFO] |  |  |  \- org.slf4j:jul-to-slf4j:jar:2.0.13:compile
[INFO] |  |  \- org.yaml:snakeyaml:jar:2.2:compile
[INFO] |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:10.1.24:compile
[INFO] |  \- org.hibernate.validator:hibernate-validator:jar:8.0.1.Final:compile
[INFO] |     +- org.jboss.logging:jboss-logging:jar:3.5.3.Final:compile
[INFO] |     \- com.fasterxml:classmate:jar:1.6.0:compile
[INFO] +- org.springframework.boot:spring-boot-starter-web:jar:3.2.6:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-json:jar:3.2.6:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.15.4:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.15.4:compile
[INFO] |  |  \- com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.15.4:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-tomcat:jar:3.2.6:compile
[INFO] |  |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:10.1.24:compile
[INFO] |  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:10.1.24:compile
[INFO] |  +- org.springframework:spring-web:jar:6.1.8:compile
[INFO] |  |  +- org.springframework:spring-beans:jar:6.1.8:compile
[INFO] |  |  \- io.micrometer:micrometer-observation:jar:1.12.6:compile
[INFO] |  |     \- io.micrometer:micrometer-commons:jar:1.12.6:compile
[INFO] |  \- org.springframework:spring-webmvc:jar:6.1.8:compile
[INFO] |     +- org.springframework:spring-aop:jar:6.1.8:compile
[INFO] |     +- org.springframework:spring-context:jar:6.1.8:compile
[INFO] |     \- org.springframework:spring-expression:jar:6.1.8:compile
[INFO] +- org.springframework.boot:spring-boot-devtools:jar:3.2.6:runtime
[INFO] |  +- org.springframework.boot:spring-boot:jar:3.2.6:compile
[INFO] |  \- org.springframework.boot:spring-boot-autoconfigure:jar:3.2.6:compile
[INFO] +- javax.servlet:javax.servlet-api:jar:4.0.1:provided
[INFO] +- org.springframework.boot:spring-boot-starter-test:jar:3.2.6:test
[INFO] |  +- org.springframework.boot:spring-boot-test:jar:3.2.6:test
[INFO] |  +- org.springframework.boot:spring-boot-test-autoconfigure:jar:3.2.6:test
[INFO] |  +- com.jayway.jsonpath:json-path:jar:2.9.0:test
[INFO] |  |  \- org.slf4j:slf4j-api:jar:2.0.13:compile
[INFO] |  +- jakarta.xml.bind:jakarta.xml.bind-api:jar:4.0.2:compile
[INFO] |  |  \- jakarta.activation:jakarta.activation-api:jar:2.1.3:compile
[INFO] |  +- net.minidev:json-smart:jar:2.5.1:test
[INFO] |  |  \- net.minidev:accessors-smart:jar:2.5.1:test
[INFO] |  |     \- org.ow2.asm:asm:jar:9.6:test
[INFO] |  +- org.assertj:assertj-core:jar:3.24.2:test
[INFO] |  |  \- net.bytebuddy:byte-buddy:jar:1.14.16:test
[INFO] |  +- org.awaitility:awaitility:jar:4.2.1:test
[INFO] |  +- org.hamcrest:hamcrest:jar:2.2:test
[INFO] |  +- org.junit.jupiter:junit-jupiter:jar:5.10.2:test
[INFO] |  |  +- org.junit.jupiter:junit-jupiter-api:jar:5.10.2:test
[INFO] |  |  |  +- org.opentest4j:opentest4j:jar:1.3.0:test
[INFO] |  |  |  +- org.junit.platform:junit-platform-commons:jar:1.10.2:test
[INFO] |  |  |  \- org.apiguardian:apiguardian-api:jar:1.1.2:test
[INFO] |  |  +- org.junit.jupiter:junit-jupiter-params:jar:5.10.2:test
[INFO] |  |  \- org.junit.jupiter:junit-jupiter-engine:jar:5.10.2:test
[INFO] |  |     \- org.junit.platform:junit-platform-engine:jar:1.10.2:test
[INFO] |  +- org.mockito:mockito-core:jar:5.7.0:test
[INFO] |  |  +- net.bytebuddy:byte-buddy-agent:jar:1.14.16:test
[INFO] |  |  \- org.objenesis:objenesis:jar:3.3:test
[INFO] |  +- org.mockito:mockito-junit-jupiter:jar:5.7.0:test
[INFO] |  +- org.skyscreamer:jsonassert:jar:1.5.1:test
[INFO] |  |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
[INFO] |  +- org.springframework:spring-core:jar:6.1.8:compile
[INFO] |  |  \- org.springframework:spring-jcl:jar:6.1.8:compile
[INFO] |  +- org.springframework:spring-test:jar:6.1.8:test
[INFO] |  \- org.xmlunit:xmlunit-core:jar:2.9.1:test
[INFO] +- org.openapitools:jackson-databind-nullable:jar:0.2.1:compile
[INFO] |  \- com.fasterxml.jackson.core:jackson-databind:jar:2.15.4:compile
[INFO] |     +- com.fasterxml.jackson.core:jackson-annotations:jar:2.15.4:compile
[INFO] |     \- com.fasterxml.jackson.core:jackson-core:jar:2.15.4:compile
[INFO] +- org.springdoc:springdoc-openapi-starter-webmvc-api:jar:2.5.0:compile
[INFO] |  \- org.springdoc:springdoc-openapi-starter-common:jar:2.5.0:compile
[INFO] |     \- io.swagger.core.v3:swagger-core-jakarta:jar:2.2.21:compile
[INFO] |        +- org.apache.commons:commons-lang3:jar:3.13.0:compile
[INFO] |        +- io.swagger.core.v3:swagger-annotations-jakarta:jar:2.2.21:compile
[INFO] |        +- io.swagger.core.v3:swagger-models-jakarta:jar:2.2.21:compile
[INFO] |        \- com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:jar:2.15.4:compile
[INFO] +- org.springdoc:springdoc-openapi-starter-webmvc-ui:jar:2.0.2:compile
[INFO] |  +- org.webjars:swagger-ui:jar:4.15.5:compile
[INFO] |  +- org.webjars:webjars-locator-core:jar:0.55:compile
[INFO] |  \- io.github.classgraph:classgraph:jar:4.8.149:compile
[INFO] +- org.springdoc:springdoc-openapi-starter-webflux-api:jar:2.5.0:compile
[INFO] |  \- org.springframework:spring-webflux:jar:6.1.8:compile
[INFO] |     \- io.projectreactor:reactor-core:jar:3.6.6:compile
[INFO] |        \- org.reactivestreams:reactive-streams:jar:1.0.4:compile
[INFO] +- org.springdoc:springdoc-openapi-ui:jar:1.6.4:compile
[INFO] |  \- org.springdoc:springdoc-openapi-webmvc-core:jar:1.6.4:compile
[INFO] |     \- org.springdoc:springdoc-openapi-common:jar:1.6.4:compile
[INFO] |        \- io.swagger.core.v3:swagger-core:jar:2.1.12:compile
[INFO] |           \- io.swagger.core.v3:swagger-models:jar:2.1.12:compile
[INFO] \- io.swagger.core.v3:swagger-annotations:jar:2.2.22:compile


Ensure that 
All the transitive dependencies that _org.springdoc:springdoc-openapi-starter-webmvc-ui_ pulled in. Double check that _io.swagger.core.v3:swagger-core-jakarta_ is there.

this is a difference when compared to swagger 2!
