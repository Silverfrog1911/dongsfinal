package com.dongs.dongsfinal.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisUtil<T> {
    @Autowired
    @Qualifier("getRedisTemplate")
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 查看某个键是否存在
     */
    public Boolean exist(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除
     */
    public Boolean del(String key) {
        return redisTemplate.delete(key);
    }


    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Object getTrim(String key)  {
        Object res = redisTemplate.opsForValue().get(key);
        if (!ObjectUtils.isEmpty(res)) {
            res = String.valueOf(res).replace("\"", "");
            return res;
        }
        return null;
    }

    public Boolean set(String key, Object o) {
        redisTemplate.delete(key);
        return redisTemplate.opsForValue().setIfAbsent(key, new Jackson().toJson(o));
    }

    public Boolean setIfAbsent(String key, Object o) {
        return redisTemplate.opsForValue().setIfAbsent(key, new Jackson().toJson(o));
    }

    public void set(String key, Object o, int time) {
        redisTemplate.delete(key);
        redisTemplate.opsForValue().setIfAbsent(key, new Jackson().toJson(o));
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }


    public void lSet(String key, List<Object> o) {
        redisTemplate.delete(key);
        o.forEach(temp -> redisTemplate.opsForList().rightPush(key, new Jackson().toJson(temp)));
    }

    public String getAndSet(String key, String o) {
        return redisTemplate.opsForValue().getAndSet(key, o);
    }


    public void lPush(String key, Object o) {
        redisTemplate.opsForList().leftPush(key, new Jackson().toJson(o));
    }


    public String lTop(String key) {
        if (!exist(key)) {
            return null;
        }
        return redisTemplate.opsForList().index(key, 0);
    }


    public void lPopTop(String key) {
        redisTemplate.opsForList().leftPop(key);
    }


    public List lGet(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }


    public List<String> lGet(String key, int start, int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }


    public int lLen(String key) {
        Long size = redisTemplate.opsForList().size(key);
        if (size != null) {
            return Math.toIntExact(size);
        }
        return 0;
    }


    public void sSet(String key, Object o) {
        redisTemplate.opsForSet().add(key, new Jackson().toJson(o));
    }


    public void sDel(String key, Object o) {
        redisTemplate.opsForSet().remove(key, o);
    }


    public int sLen(String key) {
        return Integer.valueOf(String.valueOf(redisTemplate.opsForSet().size(key)));
    }


    public Set<String> sList(String key) {
        return redisTemplate.opsForSet().members(key);
    }


}