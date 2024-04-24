package com.news.site.newsapi.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.news.site.newsapi.dtos.ArticleDTO;
import com.news.site.newsapi.mappers.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Value("${API_URL}")
    private String apiUrl;

    @Value("${API_KEY}")
    private String apiKey;

    private final String NEWS_API_URL = apiUrl + apiKey;
    private final RestTemplate restTemplate;
    private final ArticleMapper articleMapper;


    @Autowired
    public NewsServiceImpl(RestTemplate restTemplate, ArticleMapper articleMapper) {
        this.restTemplate = restTemplate;
        this.articleMapper = articleMapper;
    }



    @Override
    public List<ArticleDTO> fetchLatestNews(){
        List<ArticleDTO> articles = new ArrayList<>();
        String newsApiUrl = apiUrl + apiKey;

        // Appel à l'API d'actualités
        JsonNode response = restTemplate.getForObject(newsApiUrl, JsonNode.class);
        if (response != null && response.has("articles")) {
            JsonNode articlesNode = response.get("articles");
            articlesNode.forEach(articleNode -> {
                ArticleDTO articleDTO = articleMapper.jsonNodeToDto(articleNode);
                articles.add(articleDTO);
            });
        }

        return articles;
    }


}
