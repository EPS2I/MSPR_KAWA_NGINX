#!/bin/bash

# Supprimer le conteneur existant, s'il existe
echo "Suppression du conteneur existant..."
docker rm -f mspr_kawa_bdd_main || true

# Supprimer l'image existante, s'il existe
echo "Suppression de l'image existante..."
docker rmi -f mspr_kawa_bdd_main || true

# Construire l'image Docker
echo "Construction de l'image Docker..."
docker build -t mspr_kawa_bdd_main .

# Lancer le conteneur
#echo "Lancement du conteneur..."
#docker run --name mspr_kawa_bdd_main -d -p 8077:8077 mspr_kawa_bdd_main

echo "Déploiement terminé avec succès."
