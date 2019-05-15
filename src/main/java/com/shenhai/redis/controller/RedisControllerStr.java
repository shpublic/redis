package com.shenhai.redis.controller;

import com.shenhai.redis.service.RedisServiceStr;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

/**
 * @program RedisControllerStr
 * @description:
 * @author: Chen Xi
 * @date: 2019/5/14 21:49
 */
@RestController
@RequestMapping("/redis/str")
public class RedisControllerStr {

    @Autowired
    private RedisServiceStr serviceStr;

    private static final Logger LOG = LoggerFactory.getLogger(RedisControllerStr.class);

    @PostMapping("/get")
    public String get(@RequestBody ){

    }

}
