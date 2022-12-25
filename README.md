# Examen-Blanc-CQRS-EventSourcing
Objectifs :
On souhaite créer un système distribué basé sur les micro-services en utilisant une architecture pilotée par les événements respectant les deux patterns Event Sourcing et CQRS. Cette application devrait permettre de gérer les infractions concernant des véhicules suites à des dépassement de vitesses détectés par des radars automatiques.
1.	Architecture Technique du projet :
Le CQRS est un design pattern qui propose de faire une séparation entre la lecture et les écritures dans votre application. Cette séparation se fait au niveau du model de donnée, mais peut également se faire au niveau projet et des services qui le compose.
Nous avons 3 micro services :
	Immatriculation
	Radar
	Infraction 
Voici comment je propose de structurer l'application basée sur les micro-services en utilisant une architecture pilotée par les événements respectant les deux patterns Event Sourcing et CQRS :
1.	Projet "common-api" :
Ce projet maven sera utilisé pour déclarer les composants communs aux différents projets, tels que les Commandes, les Événements, les Queries, les DTOs, etc. Il peut être implémenté en Java ou Kotlin.
2.	Projet "radar-service" :
	Ce micro-service sera utilisé pour gérer les radars. Il comprendra les fonctionnalités suivantes :
	Ajout d'un nouveau radar
	Modification des informations d'un radar existant
	Consultation des informations d'un radar
	Envoi d'un événement de dépassement de vitesse détecté par un radar (cet événement sera utilisé par le micro-service d'infractions pour créer une nouvelle infraction)
	La partie commande de ce micro-service implémentera les fonctionnalités de modification et d'ajout de radars.
	La partie Query de ce micro-service implémentera la fonctionnalité de consultation des informations d'un radar.
3.	Projet "immatriculation-service" :
Ce micro-service sera utilisé pour gérer les véhicules et les propriétaires. Il comprendra les fonctionnalités suivantes :
	Ajout d'un nouveau propriétaire et de ses véhicules
	Modification des informations d'un propriétaire ou d'un véhicule existant
	Consultation des informations d'un propriétaire ou d'un véhicule
	Consultation des infractions d'un propriétaire (cette fonctionnalité utilisera la partie Query du micro-service d'infractions pour obtenir les infractions associées à un propriétaire donné)
	La partie commande de ce micro-service implémentera les fonctionnalités de modification et d'ajout de propriétaires et de véhicules.
	La partie Query de ce micro-service implémentera les fonctionnalités de consultation des informations d'un propriétaire ou d'un véhicule, ainsi que la consultation des infractions d'un propriétaire.
4.	Projet "infractions-service" :
	Ce micro-service sera utilisé pour gérer les infractions. Il comprendra les fonctionnalités suivantes :
	Création d'une nouvelle infraction à partir de l'événement de dépassement de vitesse reçu du micro-service de radars
	Modification des informations d'une infraction existante
	Consultation des informations d'une infraction
5.	Projet Discovery Eureka :
Eureka Discovery Service est un service de découverte de services dans l'architecture de microservices de Netflix. Il s'agit d'un service qui s'exécute en arrière-plan et qui maintient une liste à jour de tous les microservices qui sont actuellement disponibles et enregistrés dans l'application. Lorsqu'un microservice souhaite communiquer avec un autre microservice, il envoie une requête à Eureka Discovery Service pour obtenir l'adresse IP et le port du microservice cible. Eureka Discovery Service utilise cette liste pour renvoyer l'adresse et le port du microservice cible à la demande du microservice appelant, permettant ainsi à l'application de communiquer entre ses différents microservices de manière efficace et fiable. 
6.	Projet Gateway :
Il s'agit d'un service qui s'exécute à l'avant-plan de l'application et qui gère les requêtes entrantes en les routant vers les différents microservices en arrière-plan qui composent l'application. Le rôle de Eureka Gateway est de servir de passerelle entre l'interface utilisateur de l'application et les microservices qui effectuent les traitements et les calculs nécessaires pour répondre aux requêtes de l'utilisateur. En agissant comme un point d'entrée unique pour les requêtes entrantes, Eureka Gateway peut également être configuré pour offrir des fonctionnalités de sécurité, de gestion des performances et de suivi des erreurs pour l'ensemble de l'application.

Structure CQRS : 
 ![image](https://user-images.githubusercontent.com/85801662/209483879-56e6df94-1aa2-4c7b-bd41-aeba4cf35514.png)
![image](https://user-images.githubusercontent.com/85801662/209483885-003b1bd6-5205-4c24-a089-f10079c2491a.png)

 
