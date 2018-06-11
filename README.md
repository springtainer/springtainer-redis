springboot-testcontainer-redis
==============================

[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/avides/springboot/testcontainer/springboot-testcontainer-redis/maven-metadata.xml.svg)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.avides.springboot.testcontainer%22%20AND%20a%3A%22springboot-testcontainer-redis%22)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/72df4bf465a44e63895dd66b142bde8d)](https://www.codacy.com/app/avides-builds/springboot-testcontainer-redis?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=springboot-testcontainer/springboot-testcontainer-redis&amp;utm_campaign=Badge_Grade)
[![Coverage Status](https://coveralls.io/repos/springboot-testcontainer/springboot-testcontainer-redis/badge.svg)](https://coveralls.io/r/springboot-testcontainer/springboot-testcontainer-redis)
[![Build Status](https://travis-ci.org/springboot-testcontainer/springboot-testcontainer-redis.svg?branch=master)](https://travis-ci.org/springboot-testcontainer/springboot-testcontainer-redis)

### Dependency
```xml
<dependency>
	<groupId>com.avides.springboot.testcontainer</groupId>
	<artifactId>springboot-testcontainer-redis</artifactId>
	<version>0.1.0-RC4</version>
	<scope>test</scope>
</dependency>
```

### Configuration
Properties consumed (in `bootstrap.properties`):
- `embedded.container.redis.enabled` (default is `true`)
- `embedded.container.redis.startup-timeout` (default is `30`)
- `embedded.container.redis.docker-image` (default is `redis:4.0.8-alpine`)
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
