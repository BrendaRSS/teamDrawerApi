# Team Drawer
This repository contains a project team generator built using Java Spring. From a list of player names, containing first and last name, the api forms teams based on the players' last names. To persist the data I used an in-memory database, called H2 Database.

## Installation

1. Clone the repository:

```bash
git clone git@github.com:BrendaRSS/teamDrawerApi.git
```

2. Install dependencies with Maven

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
GET /times - Retrieve a list of all teams.

POST /jogador - Register a new player.
Body: {"nome": "Nome Sobrenome}

DELETE /jogador/all - Delete data.
```