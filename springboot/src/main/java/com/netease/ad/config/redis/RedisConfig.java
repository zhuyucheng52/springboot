package com.netease.ad.config.redis;

import com.netease.ad.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by bjzhuyucheng on 2017/4/21.
 */
@Configuration
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<Long, User> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Long, User> template = new RedisTemplate<Long, User>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new RedisObjectSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
