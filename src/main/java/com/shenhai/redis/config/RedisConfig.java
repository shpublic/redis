package com.shenhai.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program RedisConfig
 * @description:
 * @author: Chen Xi
 * @date: 2019/5/14 20:56
 */
@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix = "redis")
@PropertySource("classpath:redis.properties")
public class RedisConfig {

    /**
     * host 主机地址
     */
    private String host;
    /**
     * port 端口号
     */
    private int port;
    /**
     * password auth密码
     */
    private String password;
    /**
     * timeout 连接超时（毫秒）
     */
    private int timeout;

    /**
     * maxActive 连接池最大连接数，默认200
     * 0 表示无限制
     */
    @Value("200")
    private int maxActive;

    /**
     * maxWait 最大建立连接等待时间（毫秒），默认为10000
     * 如果超过此时间将产生异常；值为-1表示无限制
     */
    @Value("10000")
    private int maxWait;

    /**
     * maxIdle 连接池最大空闲连接数，默认8
     * 空闲连接数表示即使没有数据库连接时，依然可以有这么多
     * 空闲的连接，而不被清除，随时处于被连接状态。
     */
    @Value("8")
    private int maxIdle;

    /**
     * minIdle 连接池最小空闲连接数，默认0
     */
    @Value("0")
    private int minIdle;

    /**
     * 产生JedisPool对象
     * @return JedisPool
     */
    @Bean
    public JedisPool redisPoolFactory(){
        try{
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMaxTotal(maxActive);
            jedisPoolConfig.setMaxWaitMillis(maxWait);
            jedisPoolConfig.setMinIdle(minIdle);

            JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password);

            return jedisPool;
        }catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
}
