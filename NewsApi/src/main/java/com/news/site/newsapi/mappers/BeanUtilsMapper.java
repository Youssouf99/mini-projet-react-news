package com.news.site.newsapi.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import com.news.site.newsapi.dtos.SourceDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class BeanUtilsMapper {


    public static SourceDTO jsonNodeToSourceDto(JsonNode source) {
        SourceDTO sourceDTO = new SourceDTO();
        try {
            if (source.has("id")) {
                sourceDTO.setId(source.get("id").asText());
            }
            if (source.has("name")) {
                sourceDTO.setName(source.get("name").asText());
            }
        } catch (Exception e) {
            // Gérer l'exception si nécessaire
            e.printStackTrace();
        }
        return sourceDTO;
    }
}
