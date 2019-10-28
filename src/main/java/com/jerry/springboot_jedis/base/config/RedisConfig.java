package com.jerry.springboot_jedis.base.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@PropertySource("classpath:redis.properties")
@Configuration
public class RedisConfig {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.timeout}")
    private int timeout;
    @Value("${redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${redis.jedis.pool.max-wait}")
    private long maxWaitMills;
    @Bean
    public JedisPool redisPoolFactory() throws Exception
    {
        log.info("jedis注入成功");
        log.info("redis地址: "+host+": "+port);
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMills);
        jedisPoolConfig.setJmxEnabled(true);
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,host,port,timeout,null);
        return jedisPool;
    }
}
