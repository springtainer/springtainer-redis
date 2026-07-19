package com.avides.springboot.springtainer.redis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RedisPropertiesTest
{
    @Test
    public void testDefaults()
    {
        var properties = new RedisProperties();
        assertTrue(properties.isEnabled());
        assertEquals(30, properties.getStartupTimeout());
        assertEquals("redis:6.2.22-alpine", properties.getDockerImage());

        assertEquals(6379, properties.getPort());
    }
}
