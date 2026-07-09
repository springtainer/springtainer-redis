package com.avides.springboot.springtainer.redis;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.dockerjava.api.DockerClient;
import com.avides.springboot.springtainer.common.util.DockerClients;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = { "spring.data.redis.host=${embedded.container.redis.host}", "spring.data.redis.port=${embedded.container.redis.port}" })
@DirtiesContext
public abstract class AbstractIT
{
    protected DockerClient dockerClient = DockerClients.build();

    @Autowired
    protected ConfigurableEnvironment environment;

    @Autowired
    protected RedisTemplate<String, Object> redisTemplate;
}
