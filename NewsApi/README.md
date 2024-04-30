# News API - Tesla News

News API est une application backend qui récupère les actualités liées à Tesla à partir d'une API externe et scrape également des articles du site web de la ville de Boulogne-Billancourt. Ces actualités sont ensuite diffusées en temps réel via une API REST et des WebSockets. L'application est construite avec Spring Boot.

## Fonctionnalités

- Récupération des actualités de Tesla à partir d'une API externe.
- Scraping des articles du site web de la ville de Boulogne-Billancourt.
- Diffusion des nouvelles en temps réel via des WebSockets.
- Exposition d'une API REST pour récupérer les articles paginés.
- Documentation API Swagger générée automatiquement avec Springdoc.

## Configuration

Avant d'exécuter l'application, assurez-vous d'avoir Maven installé sur votre machine et de configurer les variables d'environnement suivantes dans un fichier `.env` à la racine du projet :

```plaintext
API_URL=https://example.com/api/news
API_KEY=votre_clé_api
```

## Exécution du projet

1. Clonez ce dépôt sur votre machine locale :

    ```bash
   https://github.com/Youssouf99/news-site
    ```

2. Accédez au répertoire du projet :

    ```bash
    cd news-api
    ```

3. Compilez et exécutez l'application à l'aide de Maven :

    ```bash
    mvn spring-boot:run
    ```
   
4. **L'application sera accessible à l'adresse :** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

   ![Interface Swagger](/src/main/resources/static/images/img1.png)

   Vous pouvez également accéder à la documentation JSON de l'API à l'adresse [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs).

   ![Documentation JSON de l'API](/src/main/resources/static/images/img2.png)

## Technologies utilisées

- Java
- Spring Boot
- Spring Data JPA
- Spring Validation
- Spring Web
- Spring Actuator
- Spring DevTools
- Spring WebFlux
- H2 Database
- MapStruct
- Lombok
- Maven
- Jsoup
- SLF4J
- Logback
- Spring Websocket
- Spring Messaging
- Springdoc OpenAPI

## Auteur

[Youssouf]




