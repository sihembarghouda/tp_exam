# BookApp

Cette application est un projet de gestion de livres développé avec Spring Boot. Elle offre une API REST permettant de gérer des livres, avec une base de données PostgreSQL et une gestion de cache avec Redis.

## Fonctionnalités

- CRUD (Créer, Lire, Mettre à jour, Supprimer) pour les livres.
- Documentation Swagger pour explorer l’API.
- Connexion à PostgreSQL pour la persistance des données.
- Cache Redis pour améliorer les performances.

## Technologies utilisées

- Java 17
- Spring Boot 3.x
- PostgreSQL
- Redis
- Spring Data JPA
- Spring Web
- Spring Validation
- Swagger OpenAPI

## Installation

1. Cloner le dépôt ou décompresser l’archive.
2. Configurer la base de données PostgreSQL dans `application.properties`.
3. S'assurer que Redis est en cours d'exécution sur le port 6379.
4. Lancer l'application avec votre IDE ou la commande :

```bash
./mvnw spring-boot:run
```

## Accès Swagger

[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Exemple d'appel API

```http
GET /books
```

