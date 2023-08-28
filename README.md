# This repository is a Final Project PROG2 (Spring) at HEI
- You will find in the Script sql folder the entities or tables used in the tournament_app and in the Mock Data folder of the Script sql folder 
you will also find the fictitious users and matches generated by Mockaroo
- In the tournoi_app API file you'll find the API specification codes, the Swagger API link is below:
https://petstore.swagger.io/?url=https://raw.githubusercontent.com/Ravo1401/Final-Project-PROG2/main/API%20Tournoi_app.yml

# Some explanations
- There are four packages in tournoi_app: controller, entity, repository and service.
- In the controller package you will find the entity controllers, in the entity package the models: user, tournaments and match
- In the repository package you will find the DatabaseConfiguration class, a configuration that links Postgresql and Java, as well as the DAO interfaces for the entities and the class UserPostgres, TournamentsPostgres and MatchPostgres.
- And the last package the service package .

I used Postman to test GET, GET BY ID, POST, PUT, DELETE requests.

I wish you good coding 
