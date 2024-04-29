package com.news.site.newsapi.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.news.site.newsapi.dtos.ArticleDTO;
import com.news.site.newsapi.dtos.SourceDTO;
import com.news.site.newsapi.dtos.SourceDetailDTO;
import com.news.site.newsapi.mappers.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static com.news.site.newsapi.mappers.BeanUtilsMapper.jsonNodeToSourceDto;

@Service
public class NewsServiceImpl implements NewsService {

    @Value("${API_URL}")
    private String apiUrl;

    @Value("${API_KEY}")
    private String apiKey;

    @Value("${API_TESLA}")
    private String apiTesla;

    @Autowired
    private final RestTemplate restTemplate;
    private final NewsMapper newsMapper;


    public NewsServiceImpl(RestTemplate restTemplate, NewsMapper newsMapper) {
        this.restTemplate = restTemplate;
        this.newsMapper = newsMapper;
    }

    @Override
    @Cacheable(value = "latestNews")
    public Map<SourceDTO, List<ArticleDTO>> fetchLatestNews(){
        Map<SourceDTO, List<ArticleDTO>> newsBySource = new HashMap<>();
        String newsApiUrl = apiUrl + "everything" + apiTesla + apiKey;

        // Appel à l'API d'actualités
        JsonNode response = restTemplate.getForObject(newsApiUrl, JsonNode.class);
        if (response != null && response.has("articles")) {
            JsonNode articlesNode = response.get("articles");
            articlesNode.forEach(articleNode -> {
                ArticleDTO articleDTO = newsMapper.jsonNodeToArticleDto(articleNode);
                SourceDTO sourceDTO = jsonNodeToSourceDto(articleNode.get("source"));
                if (!articleNode.get("author").isNull()){

                    // Vérifier si la source existe déjà dans la map
                    if (newsBySource.containsKey(sourceDTO)) {
                        newsBySource.get(sourceDTO).add(articleDTO);
                    } else {
                        List<ArticleDTO> articlesList = new ArrayList<>();
                        articlesList.add(articleDTO);
                        newsBySource.put(sourceDTO, articlesList);
                    }

                }



            });
        }

        return newsBySource;
    }


    @Override
    public List<ArticleDTO> getArticlesBySourceName(String sourceName) {
        Map<SourceDTO, List<ArticleDTO>> news = fetchLatestNews();
        Optional<SourceDTO> optionalSource = news.keySet().stream()
                .filter(sourceDTO -> sourceName.equals(sourceDTO.getName()))
                .findFirst();

        if (optionalSource.isPresent()) {
            SourceDTO source = optionalSource.get();
            return news.get(source);
        } else {

            return Collections.emptyList(); // Renvoie une liste vide
        }

    }

    @Override
    public Set<SourceDTO> getSources() {
       return fetchLatestNews().keySet();

    }

    @Override
    public List<ArticleDTO> getArticles() {

        return  fetchLatestNews()
                .values()
                .stream()
                .flatMap(Collection::stream) // Utiliser flatMap pour fusionner toutes les listes d'articles en une seule liste
                .collect(Collectors.toList());

    }

    @Override
    public List<ArticleDTO> getSortedArticles(String sourceName, String sort) {
        List<ArticleDTO> articles;
        if (sourceName != null) {
            articles = getArticlesBySourceName(sourceName);
        } else {
            articles = getArticles();
        }

        if (articles.size() > 1) {
            // Trier les articles par date
            Comparator<ArticleDTO> dateComparator = Comparator.comparing(ArticleDTO::getPublishedAt);
            articles.sort(sort.equalsIgnoreCase("desc") ? dateComparator.reversed() : dateComparator);

        }



        return articles;
    }



    @Override
    public List<SourceDetailDTO> fetchNewsSourcesDetails(){
        List<SourceDetailDTO> sources = new ArrayList<>();
        String newsApiUrl = apiUrl + "sources" + apiTesla + apiKey;

        JsonNode response = restTemplate.getForObject(newsApiUrl, JsonNode.class);
        if (response != null && response.has("sources")) {
            JsonNode sourcesNode = response.get("sources");
            sourcesNode.forEach(sourceNode -> {
                SourceDetailDTO sourceDetailDTO = newsMapper.jsonNodeToSourceDetailDto(sourceNode);
                sources.add(sourceDetailDTO);
            });
        }

        return sources;
    }




}
