package com.shenhai.redis.service.impl;

import com.shenhai.redis.service.RedisServiceStr;
import com.shenhai.redis.util.RedisOperationKey;
import com.shenhai.redis.util.RedisOperationStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program RedisServiceStrImpl
 * @description:
 * @author: Chen Xi
 * @date: 2019/5/14 20:46
 */
@Service("redisServiceStr")
public class RedisServiceStrImpl implements RedisServiceStr {

    @Autowired
    private RedisOperationStr strOp;

    @Override
    public String get(String key){
        return strOp.get(key);
    }

    @Override
    public long add(String key, String value){
        return strOp.add(key,value);
    }

    @Override
    public String set(String key, String value){
        return strOp.set(key,value);
    }

    @Override
    public long del(String key){
        return strOp.del(key);
    }
}
