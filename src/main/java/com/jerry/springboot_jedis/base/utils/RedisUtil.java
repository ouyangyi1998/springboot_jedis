package com.jerry.springboot_jedis.base.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
@Slf4j
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;
    public byte[] get(byte[] key,int indexdb)
    {
        Jedis jedis=null;
        byte[] value=null;
        try{
            jedis=jedisPool.getResource();
            jedis.select(indexdb);
           value=jedis.get(key);
        }catch (Exception e)
        {
            log.error(e.getMessage());
        }finally {
            returnRes(jedis,jedisPool);
        }
        return value;
    }
    public String get(String key,int indexdb)
    {
        Jedis jedis=null;
        String value=null;
        try{
            jedis=jedisPool.getResource();
            jedis.select(indexdb);
            value=jedis.get(key);
            log.info(value);
        }catch (Exception e)
        {
            log.error(e.getMessage());
        }finally {
            returnRes(jedis,jedisPool);
        }
        return value;
    }
    public String set(String key,String value,int indexdb)
    {
        Jedis jedis=null;
        try
        {
            jedis=jedisPool.getResource();
            jedis.select(indexdb);
            return jedis.set(key,value);
        }catch (Exception e)
        {
            log.error(e.getMessage());
            return "0";
        }finally {
            returnRes(jedis,jedisPool);
        }
    }
    public String set(byte[] key,byte[] value,int indexdb)
    {
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            jedis.select(indexdb);
            return jedis.set(key,value);
            }catch(Exception e)
        {
            log.error(e.getMessage());
            return "0";
        }finally {
            returnRes(jedis,jedisPool);
        }
    }

    public Long expire(String key,int value,int indexdb)
    {
        Jedis jedis=null;
        try{
            jedis=jedisPool.getResource();
            jedis.select(indexdb);
            return jedis.expire(key,value);
        }catch (Exception e)
        {
            log.error(e.getMessage());
            return 0L;
        }finally {
            returnRes(jedis,jedisPool);
        }
    }
    public static void returnRes(Jedis jedis,JedisPool jedisPool)
    {
        if(jedis!=null)
        {
            jedisPool.returnResource(jedis);
        }
    }
}
