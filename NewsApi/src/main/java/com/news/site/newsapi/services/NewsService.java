package com.news.site.newsapi.services;

import com.news.site.newsapi.dtos.ArticleDTO;
import com.news.site.newsapi.dtos.SourceDTO;
import com.news.site.newsapi.dtos.SourceDetailDTO;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface NewsService {

    Map<SourceDTO, List<ArticleDTO>> fetchLatestNews();

    List<ArticleDTO> getSortedArticles(String sourceName, String sort);

    List<SourceDetailDTO> fetchNewsSourcesDetails();

    List<ArticleDTO> getArticlesBySourceName(String sourceName) throws AlreadyBoundException;

    Set<SourceDTO> getSources();

    List<ArticleDTO> getArticles();
}
