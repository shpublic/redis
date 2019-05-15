package com.shenhai.redis.service;

/**
 * @program RedisServiceStr
 * @description:
 * @author: Chen Xi
 * @date: 2019/5/14 20:43
 */
public interface RedisServiceStr {

    /**
     * 查询
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 新增
     * @param key
     * @param value
     * @return
     */
    long add(String key, String value);

    /**
     * 更新
     * @param key
     * @param value
     * @return
     */
    String set(String key, String value);

    /**
     * 删除
     * @param key
     * @return
     */
    long del(String key);
}
