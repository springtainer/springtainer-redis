package com.avides.springboot.testcontainer.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.avides.springboot.testcontainer.common.container.AbstractEmbeddedContainerProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties("embedded.container.redis")
@Getter
@Setter
@ToString(callSuper = true)
public class RedisProperties extends AbstractEmbeddedContainerProperties
{
    public static final String BEAN_NAME = "embeddedRedisContainer";

    private int port = 6379;

    public RedisProperties()
    {
        setDockerImage("redis:5.0.6-alpine");
    }
}
