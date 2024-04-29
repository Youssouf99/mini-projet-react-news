package com.news.site.newsapi.controllers;

import com.news.site.newsapi.dtos.ArticleDTO;
import com.news.site.newsapi.services.ScrapingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/scraping/news")
@AllArgsConstructor
public class ScrapingController {

    public ScrapingService scrapingService;


    @GetMapping()
    public List<ArticleDTO> getArticles(
            @RequestParam(name = "page",
                    defaultValue = "1") int pageNumber) throws IOException {
        return scrapingService.fetchArticles(pageNumber);
    }

}
