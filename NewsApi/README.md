# News API

Ce projet est une application qui utilise une API d'actualités pour récupérer les dernières nouvelles et les afficher.

## Technologies utilisées

- Java
- Spring Boot
- MapStruct
- Lombok
- Maven

## Configuration

Assurez-vous d'avoir Maven installé sur votre machine.

1. Clonez ce dépôt sur votre machine locale :
    ```
    git clone https://github.com/votre-utilisateur/news-api.git
    ```

2. Assurez-vous d'avoir configuré les variables d'environnement suivantes dans un fichier `.env` à la racine du projet :
    ```
    API_URL=https://example.com/api/news
    API_KEY=votre_clé_api
    ```

## Exécution du projet

1. Accédez au répertoire du projet :
    ```
    cd news-api
    ```

2. Compilez et exécutez l'application à l'aide de Maven :
    ```
    mvn spring-boot:run
    ```

3. L'application sera accessible à l'adresse : [http://localhost:8080](http://localhost:8080)

## Fonctionnalités

- Récupération des dernières nouvelles à partir de l'API d'actualités.
- Affichage des nouvelles sous forme de liste.

## Auteur

[Youssouf]



