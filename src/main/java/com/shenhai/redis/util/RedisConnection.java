package com.shenhai.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;

/**
 * @program RedisConnection
 * @description:
 * @author: Chen Xi
 * @date: 2019/5/14 9:52
 */
@Component
public class RedisConnection {

    private static JedisPool jedisPool;

    @Autowired
    public void setJedisPool(JedisPool jedisPool){

        RedisConnection.jedisPool = jedisPool;
    }

    /**
     * 获取jedis链接
     * @return redis.client.jedis.Jedis
     */
    public static synchronized Jedis getJedis(){
        try{
            if(jedisPool!=null){
                return jedisPool.getResource();
            }else{
                return null;
            }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    /**
     * 关闭jedis
     * @param jedis
     */
    public static void returnJedis(Jedis jedis){
        try{
            if(jedis!=null){
                jedis.close();
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
