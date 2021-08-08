package com.xjx.ddtcrawler.cache;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XieJiaxing
 * @date 2021/8/7 17:33
 */
@Component
public class CommonCache {
    private final Map<String, CacheDomain> CACHE_MAP = new ConcurrentHashMap<>();

    public void setCache(String key, Object value, Long expireTime) {
        Long expireAt = null;
        if (expireTime != null) {
            expireAt = System.currentTimeMillis() + expireTime;
        }
        CacheDomain cacheDomain = new CacheDomain(value, expireAt);
        CACHE_MAP.put(key, cacheDomain);
    }

    public void setCache(String ket, Object value) {
        setCache(ket, value, null);
    }

    public void delCache(String key) {
        CACHE_MAP.remove(key);
    }

    public Object getCache(String key) {
        CacheDomain cacheDomain = CACHE_MAP.get(key);
        if (cacheDomain == null) {
            return null;
        }

        Long expireAt = cacheDomain.getExpireAt();
        if (expireAt != null && expireAt < System.currentTimeMillis()) {
            CACHE_MAP.remove(key);
            return null;
        }
        return cacheDomain.getObject();
    }
}
