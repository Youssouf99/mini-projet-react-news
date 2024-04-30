package com.news.site.newsapi.services;

import com.news.site.newsapi.dtos.ArticleDTO;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.List;

public interface ScrapingService {


    @Scheduled(fixedRate = 5000)
    List<ArticleDTO> fetchArticles(int pageNumber) throws IOException;
}
