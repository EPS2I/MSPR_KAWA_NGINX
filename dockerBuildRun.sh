#!/bin/bash

# Supprimer le conteneur existant, s'il existe
#echo "Suppression du conteneur existant..."
#docker rm -f mspr-kawa-nginx || true

# Supprimer l'image existante, s'il existe
echo "Suppression de l'image existante..."
docker rmi -f mspr-kawa-nginx || true

# Construire l'image Docker
echo "Construction de l'image Docker..."
docker build -t mspr-kawa-nginx .

# Lancer le conteneur
#echo "Lancement du conteneur..."
#docker run --name mspr-kawa-nginx -d -p 8082:8082 mspr-kawa-nginx

#echo "Déploiement terminé avec succès."
