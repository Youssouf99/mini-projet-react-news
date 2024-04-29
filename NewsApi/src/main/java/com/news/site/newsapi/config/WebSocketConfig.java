package com.news.site.newsapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Permet de simplifier le routage des messages en utilisant "/topic" comme préfixe
        config.enableSimpleBroker("/topic");
        // Préfixe à ajouter devant les destinations des applications clientes pour envoyer des messages
        config.setApplicationDestinationPrefixes("/ws");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Point de terminaison WebSocket permettant aux clients de se connecter
        registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();
    }


}
