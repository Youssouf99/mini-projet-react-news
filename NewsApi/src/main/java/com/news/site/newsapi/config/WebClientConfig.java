package com.news.site.newsapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

/*    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder
                .baseUrl("https://newsapi.org/v2/everything?q=tesla&from=2024-03-23&sortBy=publishedAt&apiKey=dee2c7beca6b48e0851e7a443853dea5")
                .build();
    }*/

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
