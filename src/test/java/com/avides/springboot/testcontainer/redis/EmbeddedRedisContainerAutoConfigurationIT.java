package com.avides.springboot.testcontainer.redis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EmbeddedRedisContainerAutoConfigurationIT extends AbstractIT
{
    @Test
    public void testGeneratedProperties()
    {
        assertThat(environment.getProperty("embedded.container.redis.host")).isNotBlank();
        assertThat(environment.getProperty("embedded.container.redis.port")).isNotBlank();

        System.out.println();
        System.out.println("Resolved properties:");
        System.out.println("Host:      " + environment.getProperty("embedded.container.redis.host"));
        System.out.println("Port:      " + environment.getProperty("embedded.container.redis.port"));
        System.out.println();
    }

    @Test
    public void testCrud()
    {
        redisTemplate.opsForValue().set("key1", "value1");
        assertEquals("value1", redisTemplate.opsForValue().get("key1"));

        redisTemplate.opsForValue().set("key1", "value2");
        assertEquals("value2", redisTemplate.opsForValue().get("key1"));

        redisTemplate.delete("key1");
        assertNull(redisTemplate.opsForValue().get("key1"));
    }

    @EnableAutoConfiguration
    @Configuration
    static class TestConfiguration
    {
        @Bean
        public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory)
        {
            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
            redisTemplate.setConnectionFactory(connectionFactory);
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            return redisTemplate;
        }
    }
}
