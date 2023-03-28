package com.avides.springboot.springtainer.redis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RedisPropertiesTest
{
    @Test
    public void testDefaults()
    {
        var properties = new RedisProperties();
        assertTrue(properties.isEnabled());
        assertEquals(30, properties.getStartupTimeout());
        assertEquals("redis:6.2.11-alpine", properties.getDockerImage());

        assertEquals(6379, properties.getPort());
    }
}
