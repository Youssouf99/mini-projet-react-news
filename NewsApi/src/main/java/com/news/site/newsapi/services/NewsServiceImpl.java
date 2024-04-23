package com.news.site.newsapi.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.news.site.newsapi.dtos.ArticleDTO;
import com.news.site.newsapi.mappers.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {


    private final String NEWS_API_URL;
    private final RestTemplate restTemplate;
    private final ArticleMapper articleMapper;


    @Autowired
    public NewsServiceImpl(Environment env, RestTemplate restTemplate, ArticleMapper articleMapper) {
        NEWS_API_URL = env.getProperty("API_URL")+env.getProperty("API_KEY");
        this.restTemplate = restTemplate;
        this.articleMapper = articleMapper;
    }



    @Override
    public List<ArticleDTO> fetchLatestNews(){
        List<ArticleDTO> articles = new ArrayList<>();

        // Appel à l'API d'actualités
        JsonNode response = restTemplate.getForObject(NEWS_API_URL, JsonNode.class);
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
