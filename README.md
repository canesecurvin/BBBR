<img src="https://github.com/canesecurvin/X3-Coursework/blob/master/readmeheader.png" width="1000" height=auto />
<p align="center"><img src="https://github.com/canesecurvin/BBBR/blob/readme/bbbr-graphql-server/photos/Screen_Shot_2022-08-07_at_11.17.41_AM-removebg-preview.png" width="200" height=auto /><h1 align="center">Black Businesses of Baton Rouge (BBBR)</h1></p>
<p align="center">
  <a href="https://www.postgresql.org/">
    <img alt="node" src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=lightblue&style=flat" target="_blank" />
  </a>
  <a href="https://www.npmjs.com/">
    <img alt="node" src="https://img.shields.io/badge/NPM-%23000000.svg?style=for-the-badge&logo=npm&logoColor=white&style=flat" target="_blank" />
  </a>
  <a href="https://reactjs.org/">
    <img alt="node" src="https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB&style=flat" target="_blank" />
  </a>
  <a href="https://spring.io/">
    <img alt="node" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white&style=flat" target="_blank" />
  </a>
  <a href="https://azure.microsoft.com/en-us/free/">
    <img alt="node" src="https://img.shields.io/badge/azure-%230072C6.svg?style=for-the-badge&logo=microsoftazure&logoColor=white&style=flat" target="_blank" />
  </a>
  <a href="https://www.jetbrains.com/idea/">
    <img alt="node" src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white&style=flat" target="_blank" />
  </a>
  <a href="https://code.visualstudio.com/">
    <img alt="node" src="https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white&style=flat" target="_blank" />
  </a>
  <a href="https://www.java.com/en/">
    <img alt="node" src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white&style=flat" target="_blank" />
  </a>
  <a href="https://www.javascript.com/">
    <img alt="node" src="https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E&style=flat" target="_blank" />
  </a>
  <a href="https://trello.com/">
    <img alt="node" src="https://img.shields.io/badge/Trello-%23026AA7.svg?style=for-the-badge&logo=Trello&logoColor=white&style=flat" target="_blank" />
  </a>
  <a href="https://discord.com/">
    <img alt="node" src="https://img.shields.io/badge/Discord-%235865F2.svg?style=for-the-badge&logo=discord&logoColor=white&style=flat" target="_blank" />
  </a>
</p>

> BBBR is an interactive directory for Black Businesses is the local area of Baton Rouge, Louisiana. This idea was created in response to the Black Lives Matter movement during the pandemic as a way to be a positive change in the community and uplift Black Lives. BBBR's goal is so serve Baton Rouge and the surrounding areas by providing a platform that celebrates Black Culture through entreprenuership, art and community outreach. 

## ✨ Demo

[BBBR Demo - No Sound](https://github.com/user-attachments/assets/a3bcbacd-d3b3-45ea-b209-eaaebaf8c40a")(https://drive.google.com/file/d/16U5hBFuEz03SnPG0VsLCF8iGIcBY01Vp/view?usp=sharing)


<p>[BBBR Demo - No Sound] <video src="https://drive.google.com/file/d/16U5hBFuEz03SnPG0VsLCF8iGIcBY01Vp/view?usp=sharing"></video></p> 

<br />
<br />

## 🚀 Usage & Tips

> The BBBR project is set up as a project of microservices. As of now, I have not implemented containerizing the individual services. ```bbbr-frontend``` and ```bbbr-graphql-server``` can be ran as stand-alone applications.

Clone [BBBR Repository](https://github.com/canesecurvin/BBBR)
```git clone https://github.com/canesecurvin/BBBR```

Run ```bbbr-graphql-server``` as a `Maven Project` (Right-click on ```pom.xml```) and maven install
```mvn install```

Open terminal and `CD` into bbbr-frontend and install dependencies
```
cd bbbr-frontend
npm install
```

Run ```bbbr-frontend```
```ng s``` or ```ng serve```
> Access UI at ```localhost:4200/home```

Add `application.properties` file to `src/main/resources directory`

Your `application.properties` should have these properties:
```
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

spring.datasource.driverClassName=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL95Dialect

# create-drop
spring.jpa.hibernate.ddl-auto=update
logging.level.sql=debug
spring.jpa.show-sql=true

graphql.servlet.mapping=/graphql
graphql.servlet.enabled=true
graphql.servlet.corsEnabled=true

graphiql.enabled=true
graphiql.endpoint=/graphql
graphiql.mapping=graphiql

bbbr.app.secret= 
bbbr.app.expiration= 
```

## Documentation

Access GraphQL Interface at ```localhost:8080/graphiql``` or use Chrome dev tool: ```Altair GraphQL Client```
<img src="bbbr-graphql-server/photos/Screen Shot 2022-12-13 at 12.48.29 PM.png" width="700" height="400"/></a>

#### Documentation Usage

1. Create user at the `user-controller -> register API` endpoint.
2. Login with <b>newly created</b> `email` and `password` at the `user-controller -> login API`. You should receive a JWT token in the login response.
3. Click `Authorize` button above `genre-controller` and enter JWT from login response.
4. You should then be able to test `genre`, `movie`, `movie-comments` and `rating APIs` with JWT from login response.
<br />
<br />
<br />

## Future Goals
1. Implement Admin UI
2. Implement search capability
3. Implement Business Owner UI
4. Containerize microservices using Docker

## Code Contributors

<a href="https://github.com/diamondcurvin"><img src="https://avatars.githubusercontent.com/u/77984787?v=4" width="100" height="100"/></a>

## Author

👤 **CA'NESE CURVIN**

- Twitter: [@ccurvin1](https://twitter.com/ccurvin1)
- Github: [@canesecurvin](https://github.com/canesecurvin)

## Show your support

Please ⭐️ this repository if this project helped you!
