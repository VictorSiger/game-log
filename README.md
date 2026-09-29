# 🎮 Game Log API

API REST desenvolvida com **Java e Spring Boot** para gerenciamento de uma biblioteca de jogos.

O projeto implementa um CRUD completo de jogos, permitindo cadastrar, consultar, atualizar e remover registros utilizando **Spring Data JPA** e **MySQL**.

## 🚀 Tecnologias

* **Java 25**
* **Spring Boot 4.1.1**
* **Spring Web MVC**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Maven**

## 📌 Funcionalidades

A API permite realizar as principais operações de um CRUD:

* ✅ Cadastrar um jogo
* ✅ Listar todos os jogos
* ✅ Buscar um jogo pelo ID
* ✅ Atualizar um jogo
* ✅ Excluir um jogo

Cada jogo possui as seguintes informações:

| Campo         | Tipo   | Descrição                                  |
| ------------- | ------ | ------------------------------------------ |
| `id`          | Long   | Identificador único gerado automaticamente |
| `name`        | String | Nome do jogo                               |
| `description` | String | Descrição do jogo                          |
| `genre`       | String | Gênero do jogo                             |
| `playedHours` | String | Quantidade de horas jogadas                |

## 🏗️ Estrutura do projeto

O projeto utiliza uma separação básica de responsabilidades entre Controller, Service e Repository.

```text
src/
└── main/
    ├── java/
    │   └── com.victor.game_log/
    │       ├── controller/
    │       │   └── GameController.java
    │       │
    │       ├── service/
    │       │   └── GameService.java
    │       │
    │       ├── infrastructure/
    │       │   ├── entities/
    │       │   │   └── Game.java
    │       │   │
    │       │   └── repository/
    │       │       └── GameRepository.java
    │       │
    │       └── GameLogApplication.java
    │
    └── resources/
        └── application.properties
```

### Fluxo da aplicação

```text
HTTP Request
     ↓
Controller
     ↓
Service
     ↓
Repository
     ↓
MySQL
```

### Controller

Responsável por receber as requisições HTTP e encaminhá-las para a camada de serviço.

### Service

Responsável pelas operações da aplicação, como criação, consulta, atualização e exclusão de jogos.

### Repository

Utiliza `JpaRepository` para fornecer as operações de persistência no banco de dados.

### Entity

A classe `Game` representa a entidade persistida no banco através do JPA.

## 🔗 Endpoints

### Criar jogo

```http
POST /games
```

Exemplo de requisição:

```json
{
  "name": "The Witcher 3",
  "description": "RPG de mundo aberto",
  "genre": "RPG",
  "playedHours": "120"
}
```

### Listar jogos

```http
GET /games
```

Retorna todos os jogos cadastrados.

### Buscar jogo por ID

```http
GET /games/{id}
```

Exemplo:

```http
GET /games/1
```

### Atualizar jogo

```http
PUT /games?id=1
```

Exemplo de requisição:

```json
{
  "name": "The Witcher 3",
  "description": "RPG de mundo aberto",
  "genre": "RPG",
  "playedHours": "150"
}
```

### Excluir jogo

```http
DELETE /games?id=1
```

## 🗄️ Banco de dados

O projeto utiliza **MySQL**.

Por padrão, a aplicação está configurada para utilizar um banco chamado:

```text
gamelog
```

Configure as credenciais do banco no arquivo:

```text
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gamelog
spring.datasource.username=root
spring.datasource.password=SUA_SENHA
```

O Hibernate está configurado para atualizar automaticamente a estrutura das tabelas:

```properties
spring.jpa.hibernate.ddl-auto=update
```

> **Importante:** não coloque senhas reais no repositório. Utilize variáveis de ambiente ou outro mecanismo de configuração para projetos publicados.

## ▶️ Como executar

### Pré-requisitos

Antes de executar o projeto, tenha instalado:

* Java 25 ou compatível com a configuração do projeto
* MySQL
* Maven (opcional, pois o projeto possui Maven Wrapper)

### 1. Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/game-log.git
```

Entre na pasta:

```bash
cd game-log
```

### 2. Crie o banco de dados

No MySQL:

```sql
CREATE DATABASE gamelog;
```

### 3. Configure o acesso ao banco

Edite:

```text
src/main/resources/application.properties
```

e informe seu usuário e senha do MySQL.

### 4. Execute a aplicação

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

## 🧪 Testes

O projeto possui um teste de contexto da aplicação utilizando Spring Boot Test.

Para executar:

```bash
./mvnw test
```

No Windows:

```bash
mvnw.cmd test
```

## 📚 Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais do desenvolvimento **Back-end com Java e Spring Boot**, incluindo:

* Criação de APIs REST
* Arquitetura em camadas
* Injeção de dependências
* Spring Data JPA
* Mapeamento de entidades
* Persistência de dados
* Operações CRUD
* Integração com MySQL
* Requisições HTTP

---

## 👨‍💻 Autor

**Victor Oliveira**

Projeto desenvolvido como parte dos estudos de desenvolvimento Back-end com Java e Spring Boot.
