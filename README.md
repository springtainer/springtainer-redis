# springtainer-redis

[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/avides/springboot/springtainer/springtainer-redis/maven-metadata.xml.svg)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.avides.springboot.springtainer%22%20AND%20a%3A%22springtainer-redis%22)
[![Build](https://github.com/springtainer/springtainer-redis/workflows/release/badge.svg)](https://github.com/springtainer/springtainer-redis/actions)
[![Nightly build](https://github.com/springtainer/springtainer-redis/workflows/nightly/badge.svg)](https://github.com/springtainer/springtainer-redis/actions)
[![Coverage report](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-redis&metric=coverage)](https://sonarcloud.io/dashboard?id=springtainer_springtainer-redis)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-redis&metric=alert_status)](https://sonarcloud.io/dashboard?id=springtainer_springtainer-redis)
[![Technical dept](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-redis&metric=sqale_index)](https://sonarcloud.io/dashboard?id=springtainer_springtainer-redis)

### Dependency
```xml
<dependency>
	<groupId>com.avides.springboot.springtainer</groupId>
	<artifactId>springtainer-redis</artifactId>
	<version>1.0.0</version>
	<scope>test</scope>
</dependency>
```

### Configuration
Properties consumed (in `bootstrap.properties`):
- `embedded.container.redis.enabled` (default is `true`)
- `embedded.container.redis.startup-timeout` (default is `30`)
- `embedded.container.redis.docker-image` (default is `redis:5.0.6-alpine`)
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
<!-- Springtainer -->
<logger name="com.github.dockerjava.jaxrs" level="WARN" />
<logger name="com.github.dockerjava.core.command" level="WARN" />
<logger name="org.apache.http" level="WARN" />
```

## Labels
The container exports multiple labels to analyze running springtainers:
- `SPRINGTAINER_SERVICE=redis`
- `SPRINGTAINER_IMAGE=${embedded.container.redis.docker-image}`
- `SPRINGTAINER_STARTED=$currentTimestamp`
