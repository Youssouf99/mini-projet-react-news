package com.news.site.newsapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheInfoServiceImpl {
    private final CacheManager cacheManager;
    public CacheInfoServiceImpl(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public Map<String, Object> getCacheData(String cacheName) {
        Map<String, Object> cacheData = new HashMap<>();
        Cache cache = cacheManager.getCache(cacheName);
        if (cache != null) {
            cacheData.put("name", cache.getName());
            cacheData.put("size", cacheManager.getCache(cacheName));
            cacheData.put("content", cacheManager.getCache(cacheName).getNativeCache());
        }
        return cacheData;
    }
}
