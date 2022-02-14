package com.avides.springboot.springtainer.redis;

import static com.avides.springboot.springtainer.redis.RedisProperties.BEAN_NAME;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

import com.avides.springboot.springtainer.common.container.AbstractBuildingEmbeddedContainer;
import com.avides.springboot.springtainer.common.container.EmbeddedContainer;

import io.lettuce.core.RedisClient;

@Configuration
@ConditionalOnProperty(name = "embedded.container.redis.enabled", matchIfMissing = true)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(RedisProperties.class)
public class EmbeddedRedisContainerAutoConfiguration
{
    @ConditionalOnMissingBean(RedisContainer.class)
    @Bean(BEAN_NAME)
    public EmbeddedContainer redisContainer(ConfigurableEnvironment environment, RedisProperties properties)
    {
        return new RedisContainer("redis", environment, properties);
    }

    public static class RedisContainer extends AbstractBuildingEmbeddedContainer<RedisProperties>
    {
        public RedisContainer(String string, ConfigurableEnvironment environment, RedisProperties properties)
        {
            super(string, environment, properties);
        }

        @Override
        protected Map<String, Object> providedProperties()
        {
            Map<String, Object> provided = new HashMap<>();
            provided.put("embedded.container.redis.host", getContainerHost());
            provided.put("embedded.container.redis.port", Integer.valueOf(getContainerPort(properties.getPort())));
            return provided;
        }

        @Override
        protected boolean isContainerReady(RedisProperties properties)
        {
            RedisClient redisClient = RedisClient.create("redis://" + getContainerHost() + ":" + getContainerPort(properties.getPort()));
            redisClient.connect();
            return true;
        }
    }
}
