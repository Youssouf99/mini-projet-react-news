package com.news.site.newsapi.controllers;

import com.news.site.newsapi.services.CacheInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/cache")
@AllArgsConstructor
public class CacheInfoController {
    private final CacheInfoService cacheInfoService;


    @GetMapping("/{cacheName}")
    public Map<String, Object> getCacheData(@PathVariable String cacheName) {
        return cacheInfoService.getCacheData(cacheName);
    }


}
