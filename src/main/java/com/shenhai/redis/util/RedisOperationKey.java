package com.shenhai.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * @program RedisOperationKey
 * @description:
 * @author: Chen Xi
 * @date: 2019/5/14 9:52
 */
public class RedisOperationKey {

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean keyExists(String key){
        Jedis jedis = RedisConnection.getJedis();
        boolean s = jedis.exists(key);
        RedisConnection.returnJedis(jedis);
        return s;
    }
}
