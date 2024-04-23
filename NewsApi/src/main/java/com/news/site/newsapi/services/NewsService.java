package com.news.site.newsapi.services;

import com.news.site.newsapi.dtos.ArticleDTO;
import reactor.core.publisher.Mono;

import java.util.List;

public interface NewsService {

    List<ArticleDTO> fetchLatestNews();
}
