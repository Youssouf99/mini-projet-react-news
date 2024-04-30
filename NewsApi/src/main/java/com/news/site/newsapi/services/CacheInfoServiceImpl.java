package com.news.site.newsapi.services;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CacheInfoServiceImpl implements CacheInfoService {
    private final CacheManager cacheManager;
    public CacheInfoServiceImpl(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
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

    public void clearCache() {
        cacheManager.getCache("latestNews").clear(); // Replace "myCacheName" with your actual cache name
    }
}
