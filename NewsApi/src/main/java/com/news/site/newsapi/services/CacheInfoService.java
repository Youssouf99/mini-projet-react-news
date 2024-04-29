package com.news.site.newsapi.services;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public interface CacheInfoService {


    Map<String, Object> getCacheData(String cacheName);
}
