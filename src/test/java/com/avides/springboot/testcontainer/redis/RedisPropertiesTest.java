package com.avides.springboot.testcontainer.redis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RedisPropertiesTest
{
    @Test
    public void testDefaults()
    {
        RedisProperties properties = new RedisProperties();
        assertTrue(properties.isEnabled());
        assertEquals(30, properties.getStartupTimeout());
        assertEquals("redis:5.0.6-alpine", properties.getDockerImage());

        assertEquals(6379, properties.getPort());
    }
}
