#  Tasks

## TP Ecommerce :  https://jcdominguez.notion.site/TP-panier-ecommerce-fbec6eadedd64fea95f92bc5768fdf3c

## TP Bibliotheque : 
### Gestion de Bibliothèque en Ligne avec Jakarta EE
### Objectif:

### Développer une application web de gestion de bibliothèque qui permet aux utilisateurs de rechercher, d'ajouter et de modifier(ou supprimer pour simplifier) des livres.

### Technologies Utilisées:

### - Jakarta EE
### - JSP
### - Servlets

### - Créer une classe Java simple Livre avec des propriétés comme titre, auteur, et isbn.
### - Créer une classe GestionnaireLivres pour gérer une liste de livres.
### - Créer une Servlet de Recherche : permet de rechercher des livres par titre ou auteur.
### - Créer une Servlet d'Ajout de Livre : permet d'ajouter un nouveau livre à la bibliothèque.
### - Créer une Servlet de modification de Livre : permet de modifier un livre de la bibliothèque.
### - Créer les JSP pour l'affichage de la liste des livres, pour ajouter et rechercher des livres.
### - Utiliser les sessions HTTP pour conserver l’historique de recherche de l’utilisateur
### - Gestion d’erreurs : lors de la création d’un Livre, si des champs ne sont pas correctement remplis, le formulaire est à nouveau affiché avec un message d’erreur et les champs saisis correctement sont pré-remplis
### - Pagination: Lorsque la liste des livres est trop grande, elle doit s’afficher sur plusieurs pages. L’utilisateur doit pouvoir naviguer de page en page.

## TP multi-servlet
### Créer une webapp qui permet de stocker un annuaire de personnes et qui propose 2 pages différentes, la 1re afficher les personnes non VIP et la 2e affiche les personnes VIP.
### - POST /personnes : ajouter une personne dans l'annuaire
### - GET /personnes : qui affiche la iste de personnes non VIP
### - GET /vip : qui affiche la liste des personnes VIP
### Il existe un seul objet pour toute l'application contenant les personnes

## TP Voitures (Exercise MVC Jakarta )
### - Créer une application web MVC permettant de créer des objets Voiture (nom, marque, immatriculation, année) et les stocker dans un objet de la classe Garage. 
### - Créer les Servlets et JSP nécessaires pour ajouter et afficher des voitures.

## TP Personne (Exercice JSP):
### Créer :
### - Servlet
### - JSP
### - un Form HTML pour envoyer le prénom et le nom et l'age d'une personne.
### Et afficher dans la page une phrase du style:
### Vous vous appelez : Alain Delon
### Et vous êtes une personne majeure
### PS: si la personne a moins de 18 ans alors il faudra afficher que la personne est mineure.

## TP Todolist:
### Créer une Servlet qui affiche dans le navigateur une liste de taches à faire.
### Les tâches seront un ArrayList de String stocké comme attribut de la Servlet.
### Le doGet() retourne une page HTML contenant la liste de taches et en dessous un formulaire permettant d’envoyer une nouvelle tache à ajouter à la liste.
### Le doPost() de la Servlet permet d’ajouter la tache à la liste
### Bonus : version multi-utilisateur avec Sessions

## TP Jeu du nombre à deviner (Part 3):
### Utiliser la session HTTP pour stocker les informations de la partie et permettre ainsi que chaque joueur joue sur sa propre partie.

## TP Exercice Session :
### Créer une nouvelle Servlet permettant de stocker dans la Session votre couleur préférée. Vérifier avec plusieurs clients qu'on peut afficher une couleur différente et spécifique à chaque Client

## TP Jeu du nombre à deviner (Part 2)
### Proposer 3 tentatives dans une même partie pour permettre au joueur de deviner le nombre aléatoire

## TP Jeu du nombre à deviner (Part 1)
### Créer une Servlet jeu du nombre à deviner.  
### La servlet reçoit le nombre proposé par le joueur, puis calcule un nombre aléatoire entre 1 et 10, puis affiche dans la page web : gagné ou trop grand ou trop petit.
### Aide : int randomNumber = new Random().nextInt(min, max);

## TP Horloge
### Ecrire une nouvelle Servlet qui affiche l'heure en temps reel quand on envoie une requete GET sur /clock
### Aide: pour calculer l'heure :
### LocalDateTime hour = LocalDateTime.now();