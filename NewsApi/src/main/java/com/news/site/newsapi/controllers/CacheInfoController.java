package com.news.site.newsapi.controllers;

import com.news.site.newsapi.dtos.ArticleDTO;
import com.news.site.newsapi.services.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@AllArgsConstructor
public class NewsController {
    private final NewsService newsService;


    @GetMapping
    public ResponseEntity<List<ArticleDTO>> getLatestNews() {
        List<ArticleDTO> articles = newsService.fetchLatestNews();
        if (articles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }



}
