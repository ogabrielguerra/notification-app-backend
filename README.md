# NOTIFICATION APP
This is the backend part for a notification app.
## Features
It runs on Spring Boot and has the feature below available:
- Send a notification message for a given category;
- Send a notification in three different message channels: Email, SMS or/and Push;
- Log the main message in MESSAGE table;
- Log the notifications sent through channels in MESSAGE_LOG table;
- Notifications sent through Push are being redirected to a STOMP queue which can be consumed be a subscriber client;
- STOMP queue working and reachable through STOMPMessageController;
- JPA/Hibernate is implemented and main structures can be fetched by repositories.
## Documentation
### Git Repository
- https://github.com/ogabrielguerra/notification-app-backend
### Diagrams
- Can be found at Documentation/Diagrams path (TBD).
### REST API
- REST Api endpoints can be found at: http://localhost:8080/swagger-ui/index.html#
### Tests
- Unit tests can be found at test package and runned through ```mvn test``` command (TBD)