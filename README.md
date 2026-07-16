# springtainer-redis

[![Maven Central](https://img.shields.io/maven-central/v/com.avides.springboot.springtainer/springtainer-redis.svg?label=maven-central)](https://search.maven.org/artifact/com.avides.springboot.springtainer/springtainer-redis)
[![Release](https://github.com/springtainer/springtainer-redis/actions/workflows/release.yml/badge.svg)](https://github.com/springtainer/springtainer-redis/actions/workflows/release.yml)
[![Nightly build](https://github.com/springtainer/springtainer-redis/actions/workflows/nightly.yml/badge.svg)](https://github.com/springtainer/springtainer-redis/actions/workflows/nightly.yml)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-redis&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=springtainer_springtainer-redis)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-redis&metric=coverage)](https://sonarcloud.io/summary/new_code?id=springtainer_springtainer-redis)

### Dependency

```xml

<dependency>
  <groupId>com.avides.springboot.springtainer</groupId>
  <artifactId>springtainer-redis</artifactId>
  <version>2.0.0-RC1</version>
  <scope>test</scope>
</dependency>
```

### Configuration

Properties consumed (in `bootstrap.properties`):

- `embedded.container.redis.enabled` (default is `true`)
- `embedded.container.redis.startup-timeout` (default is `30`)
- `embedded.container.redis.docker-image` (default is `redis:6.2.11-alpine`)
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
