# springboot-testcontainer-redis

[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/avides/springboot/testcontainer/springboot-testcontainer-redis/maven-metadata.xml.svg)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.avides.springboot.testcontainer%22%20AND%20a%3A%22springboot-testcontainer-redis%22)
[![Build](https://github.com/springboot-testcontainer/springboot-testcontainer-redis/workflows/release/badge.svg)](https://github.com/springboot-testcontainer/springboot-testcontainer-redis/actions)
[![Nightly build](https://github.com/springboot-testcontainer/springboot-testcontainer-redis/workflows/nightly/badge.svg)](https://github.com/springboot-testcontainer/springboot-testcontainer-redis/actions)
[![Coverage report](https://sonarcloud.io/api/project_badges/measure?project=springboot-testcontainer_springboot-testcontainer-redis&metric=coverage)](https://sonarcloud.io/dashboard?id=springboot-testcontainer_springboot-testcontainer-redis)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=springboot-testcontainer_springboot-testcontainer-redis&metric=alert_status)](https://sonarcloud.io/dashboard?id=springboot-testcontainer_springboot-testcontainer-redis)
[![Technical dept](https://sonarcloud.io/api/project_badges/measure?project=springboot-testcontainer_springboot-testcontainer-redis&metric=sqale_index)](https://sonarcloud.io/dashboard?id=springboot-testcontainer_springboot-testcontainer-redis)

### Dependency
```xml
<dependency>
	<groupId>com.avides.springboot.testcontainer</groupId>
	<artifactId>springboot-testcontainer-redis</artifactId>
	<version>1.0.0-RC1</version>
	<scope>test</scope>
</dependency>
```

### Configuration
Properties consumed (in `bootstrap.properties`):
- `embedded.container.redis.enabled` (default is `true`)
- `embedded.container.redis.startup-timeout` (default is `30`)
- `embedded.container.redis.docker-image` (default is `redis:4.0.12-alpine`)
- `embedded.container.redis.port` (default is `6379`)

Properties provided (in `application-it.properties`):
- `embedded.container.redis.host`
- `embedded.container.redis.port`

Example for minimal configuration in `application-it.properties`:
```
spring.redis.host=${embedded.container.redis.host} 
spring.redis.port=${embedded.container.redis.port}
```

## Logging
To reduce logging insert this into the logback-configuration:
```xml
<!-- Testcontainers -->
<logger name="com.github.dockerjava.jaxrs" level="WARN" />
<logger name="com.github.dockerjava.core.command" level="WARN" />
<logger name="org.apache.http" level="WARN" />
```

## Labels
The container exports multiple labels to analyze running testcontainers:
- `TESTCONTAINER_SERVICE=redis`
- `TESTCONTAINER_IMAGE=${embedded.container.redis.docker-image}`
- `TESTCONTAINER_STARTED=$currentTimestamp`
