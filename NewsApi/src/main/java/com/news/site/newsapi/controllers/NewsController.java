package com.news.site.newsapi.controllers;

import com.news.site.newsapi.dtos.ArticleDTO;
import com.news.site.newsapi.dtos.SourceDTO;
import com.news.site.newsapi.dtos.SourceDetailDTO;
import com.news.site.newsapi.services.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.AlreadyBoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/news")
@AllArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping()
    public ResponseEntity<Map<SourceDTO, List<ArticleDTO>>> getAllNews() {
        try {
            Map<SourceDTO, List<ArticleDTO>> news = newsService.fetchLatestNews();
            return ResponseEntity.ok(news);
        } catch (Exception e) {
            // Gérer l'exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDTO>> getArticles(
            @RequestParam(name = "source", required = false) String sourceName,
            @RequestParam(defaultValue = "desc", required = false) String sort) {
        try {
            List<ArticleDTO> articles = newsService.getSortedArticles(sourceName, sort);
            return ResponseEntity.ok(articles);
        } catch (Exception e) {
            // Gérer l'exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/sources")
    public ResponseEntity<Set<SourceDTO>> getSources() {
        try {
            Set<SourceDTO> sources = newsService.getSources();
            return ResponseEntity.ok(sources);
        } catch (Exception e) {
            // Gérer l'exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/articles/{sourceName}")
    public ResponseEntity<List<ArticleDTO>> getNewsBySource(@PathVariable("sourceName") String sourceName) {
        try {
            List<ArticleDTO> articles = newsService.getArticlesBySourceName(sourceName);
            return ResponseEntity.ok(articles);
        } catch (AlreadyBoundException e) {
            // Gérer l'exception AlreadyBoundException
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            // Gérer les autres exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/sourcesDetail")
    public ResponseEntity<List<SourceDetailDTO>> getLatestNewsSources() {
        try {
            List<SourceDetailDTO> sourcesDetails = newsService.fetchNewsSourcesDetails();
            return ResponseEntity.ok(sourcesDetails);
        } catch (Exception e) {
            // Gérer l'exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
