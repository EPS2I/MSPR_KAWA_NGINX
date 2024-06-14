---
## Service MSPR - PAYE TON KAWA

## Mise en place des services

Ce guide explique comment mettre en place et lancer les services dans des conteneurs Docker.
Il y a deux façons de le faire : lancer tous les services dans un seul conteneur ou lancer chaque service dans des conteneurs séparés.
Afin de pouvoir intervenir seulement sur l'un d'entre eux pour le developpement.

---

### Prérequis

Assurez-vous d'avoir installé Docker sur votre machine.
Si ce n'est pas déjà fait, vous pouvez suivre les instructions [ici](https://docs.docker.com/get-docker/).

---

### Lancer tous les services dans un seul conteneur

1. Exécutez le script pour créer les images Docker :
    ```bash
    ./dockerBuildRun.sh
    ```

2. Lancez le conteneur avec les 4 services :
    ```bash
    ./setupServiceDevelopment.sh 
    ```

---

### Lancer les services dans des conteneurs séparés (DEV) 

1. Décommentez les lignes nécessaires dans le script pour créer les images Docker :
    ```bash
    # Décommentez les dernières lignes correspondantes dans ./dockerBuildRun.sh
    # Celle commençant par : docker run --name ...
    ```

2. Exécutez le script pour créer les images Docker :
    ```bash
    ./dockerBuildRun.sh
    ```
Celui-ci va donc construire les images et les lancer indivduellements.

---

## Scripts

### dockerBuildRun.sh

Ce script crée les images Docker nécessaires pour vos services. 
Assurez-vous que le Dockerfile pour chaque service est présent et correctement configuré avant d'exécuter ce script.
 - db_main
 - keycloak
 - rabbitMQ
 - posgresql

### setupServiceDevelopment.sh

Ce script lance un conteneur Docker qui inclut tous les services. Il est utile pour un déploiement simple et rapide.

### Lancer les services dans des conteneurs séparés

Cette solution lance des conteneurs Docker séparés pour chaque service. Il permet un déploiement plus modulaire et flexible.

---
