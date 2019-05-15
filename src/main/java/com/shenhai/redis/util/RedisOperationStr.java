package com.shenhai.redis.util;

import redis.clients.jedis.Jedis;
import redis.clients.util.SafeEncoder;

/**
 * @program RedisOperationStr
 * @description:
 * @author: Chen Xi
 * @date: 2019/5/14 9:52
 */
public class RedisOperationStr {

    /**
     * 根据key获取value
     * @param key
     */
    public String get(String key){
        Jedis jedis = RedisConnection.getJedis();
        String v = jedis.get(key);
        RedisConnection.returnJedis(jedis);
        return v;
    }

    /**
     * 插入一条新纪录
     * @param key
     * @param value
     * @return long 状态码，1：key不存在，且插入成功；0：key存在，未插入
     */
    public long add(String key, String value){
        Jedis jedis = RedisConnection.getJedis();
        long v = jedis.setnx(key,value);
        RedisConnection.returnJedis(jedis);
        return v;
    }

    /**
     * 更新一条记录
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value){
        Jedis jedis = RedisConnection.getJedis();
        String v = jedis.set(SafeEncoder.encode(key),SafeEncoder.encode(value));
        RedisConnection.returnJedis(jedis);
        return v;
    }

    /**
     * 删除一条记录
     * @param key
     * @return long 状态码 1 成功删除一条记录，0 key不存在，不进行任何操作
     */
    public long del(String key){
        Jedis jedis = RedisConnection.getJedis();
        long v = jedis.del(key);
        RedisConnection.returnJedis(jedis);
        return v;
    }
}
