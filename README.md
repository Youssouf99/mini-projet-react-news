# Résumé du Projet News Tesla et de la ville de Boulogne-Billancourt

Ce projet consiste en une application News API décomposée en deux parties : un backend et un frontend, permettant de récupérer et de diffuser des actualités liées à Tesla et de la ville de Boulogne-Billancourt.

## Description

L'application récupère les actualités concernant Tesla à partir d'une API externe et scrape également des articles du site web de la ville de Boulogne-Billancourt. Les actualités sont ensuite diffusées en temps réel via une API REST et des WebSockets. L'interface utilisateur permet de consulter les actualités de manière conviviale.

## Fonctionnalités

### News API Backend

- Récupération des actualités de Tesla à partir d'une API externe.
- Scraping des articles du site web de la ville de Boulogne-Billancourt.
- Diffusion des nouvelles en temps réel via des WebSockets.
- Exposition d'une API REST pour récupérer les articles paginés.
- Documentation API Swagger générée automatiquement avec Springdoc.

### News API Frontend

- Affichage des dernières actualités récupérées par l'API backend.
- Possibilité de filtrer les actualités par source.
- Options de tri pour organiser les actualités par date ou pertinence.
- Gestion des erreurs avec des messages d'alerte en cas de problème de chargement des données.

## Technologies Utilisées

### Backend

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
- Jsoup
- SLF4J
- Logback
- Spring Websocket
- Spring Messaging
- Springdoc OpenAPI

### Frontend

- React
- Axios
- Material-tailwind/react
- Tailwind CSS

## Installation et Exécution

1. Cloner le dépôt sur votre machine locale.
2. Configurer les variables d'environnement pour le backend.
3. Installer les dépendances et configurer l'URL de l'API backend pour le frontend.
4. Exécuter le backend et le frontend selon les instructions fournies dans leurs sections respectives.

## Aperçu

### Interface Swagger du Backend

![Interface Swagger](https://github.com/Youssouf99/news-site/blob/main/NewsApi/src/main/resources/static/img1.png)

### Interface Utilisateur du Frontend

![Page d'Accueil](https://github.com/Youssouf99/news-site/blob/main/news-site-frontend/src/assets/images/img1.png)

![Page d'Accueil](https://github.com/Youssouf99/news-site/blob/main/news-site-frontend/src/assets/images/img2.png)

![Page d'Accueil](https://github.com/Youssouf99/news-site/blob/main/news-site-frontend/src/assets/images/img3.png)

![Page d'Accueil](https://github.com/Youssouf99/news-site/blob/main/news-site-frontend/src/assets/images/img4.png)

![Page d'Accueil](https://github.com/Youssouf99/news-site/blob/main/news-site-frontend/src/assets/images/img5.png)

![Page d'Accueil](https://github.com/Youssouf99/news-site/blob/main/news-site-frontend/src/assets/images/img6.png)

![Page d'Accueil](https://github.com/Youssouf99/news-site/blob/main/news-site-frontend/src/assets/images/img7.png)

![Page d'Accueil](https://github.com/Youssouf99/news-site/blob/main/news-site-frontend/src/assets/images/img8.png)

## Auteur

[Youssouf]

Ce résumé fournit un aperçu global du projet News API sur Tesla, décrivant ses fonctionnalités, les technologies utilisées, ainsi que les étapes d'installation et d'exécution, avec des captures d'écran pour illustrer l'interface utilisateur et Swagger.
