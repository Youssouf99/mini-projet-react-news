package com.news.site.newsapi.services;

import com.news.site.newsapi.dtos.ArticleDTO;import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScrapingServiceImpl implements ScrapingService {
    public final String url;
    private SimpMessagingTemplate messagingTemplate;
    public ScrapingServiceImpl(@Value("${URL_SCRAPING}") String url, SimpMessagingTemplate messagingTemplate) {
        this.url = url;
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    @Scheduled(fixedRate = 600000)
    public List<ArticleDTO> fetchArticles(int pageNumber) throws IOException {
        List<ArticleDTO> articles = scrapeArticlesFromPage(url, pageNumber);
        // Envoyer des messages WebSocket avec les nouveaux articles
        messagingTemplate.convertAndSend("/topic/articles", articles);
        return articles;
    }

    public List<ArticleDTO> scrapeArticlesFromPage(String pageUrl, int pageNumber) throws IOException {
        List<ArticleDTO> articleDTOs = new ArrayList<>();
        String cHash = getCHash(pageUrl);
        String urlWithPageNumber = pageUrl + "?tx_paginate%5BcurrentPage%5D=" + pageNumber + "&cHash=" + cHash;
        Document doc = Jsoup.connect(urlWithPageNumber).get();
        Elements articles = doc.select(".news-block__item");

        for (Element article : articles) {
            ArticleDTO articleDTO = new ArticleDTO();
            String title = article.select(".news-block__title").text();
            String category = article.select(".news-block__category").text();
            String description = article.select(".news-block__teaser").text();
            String imageUrl = "https://www.boulognebillancourt.com" + article.select(".news-block__picture img").attr("src");
            articleDTO.setTitle(title);
            articleDTO.setAuthor(category);
            articleDTO.setDescription(description);
            articleDTO.setUrlToImage(imageUrl);
            articleDTOs.add(articleDTO);
        }

        return articleDTOs;
    }

    private String getCHash(String pageUrl) throws IOException {
        Document doc = Jsoup.connect(pageUrl).get();
        String cHash = doc.select("link[rel=canonical]").attr("href");
        int index = cHash.lastIndexOf("=") + 1;
        return cHash.substring(index);
    }
}
