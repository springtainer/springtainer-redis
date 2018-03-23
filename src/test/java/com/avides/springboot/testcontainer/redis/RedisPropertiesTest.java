package com.avides.springboot.testcontainer.redis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RedisPropertiesTest
{
    @Test
    public void testDefaults()
    {
        RedisProperties properties = new RedisProperties();
        assertTrue(properties.isEnabled());
        assertEquals(30, properties.getStartupTimeout());
        assertEquals("redis:4.0.8-alpine", properties.getDockerImage());

        assertEquals(6379, properties.getPort());
    }
}
