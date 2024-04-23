package com.news.site.newsapi.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import com.news.site.newsapi.dtos.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ArticleMapper {

    @Mappings({
            @Mapping(target = "author", expression = "java(articleNode.has(\"author\") ? articleNode.get(\"author\").asText() : null)"),
            @Mapping(target = "title", expression = "java(articleNode.has(\"title\") ? articleNode.get(\"title\").asText() : null)"),
            @Mapping(target = "description", expression = "java(articleNode.has(\"description\") ? articleNode.get(\"description\").asText() : null)"),
            @Mapping(target = "url", expression = "java(articleNode.has(\"url\") ? articleNode.get(\"url\").asText() : null)"),
            @Mapping(target = "urlToImage", expression = "java(articleNode.has(\"urlToImage\") ? articleNode.get(\"urlToImage\").asText() : null)"),
            @Mapping(target = "publishedAt", expression = "java(articleNode.has(\"publishedAt\") ? articleNode.get(\"publishedAt\").asText() : null)"),
            @Mapping(target = "content", expression = "java(articleNode.has(\"content\") ? articleNode.get(\"content\").asText() : null)")
    })
    ArticleDTO jsonNodeToDto(JsonNode articleNode);
}
