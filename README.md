# Auth API 🔐

REST API de autenticação completa com JWT, construída do zero com Spring Boot 3, PostgreSQL e Flyway.

## 🚀 Tecnologias

- Java 25
- Spring Boot 3.5
- Spring Security 6
- JWT (JJWT 0.12.6)
- PostgreSQL 17
- Flyway (migrations)
- Lombok
- Gradle

## ✨ Funcionalidades

- ✅ Cadastro de usuário com senha criptografada (BCrypt)
- ✅ Login com geração de Access Token + Refresh Token
- ✅ Renovação de token via Refresh Token
- ✅ Logout com blacklist de token
- ✅ Endpoint protegido com autenticação JWT
- ✅ Validação de dados com Bean Validation
- ✅ Tratamento global de exceções

## 📋 Endpoints

| Método | Endpoint | Descrição | Auth |
|--------|----------|-----------|------|
| POST | `/auth/register` | Cadastro de usuário | ❌ |
| POST | `/auth/login` | Login e geração de tokens | ❌ |
| POST | `/auth/refresh` | Renovar access token | ❌ |
| POST | `/auth/logout` | Invalidar token | ✅ |
| GET | `/api/me` | Dados do usuário logado | ✅ |

## 🏗️ Arquitetura

src/

├── config/         # Configuração do Spring Security

├── controller/     # Controllers REST

├── domain/         # Entidades JPA (User, RefreshToken, TokenBlacklist)

├── dto/            # Records de request/response

├── filter/         # Filtro JWT

├── repository/     # Repositórios JPA

├── service/        # Regras de negócio e JWT

└── exception/      # Handler global de exceções

## ⚙️ Como rodar

### Pré-requisitos
- Java 17+
- PostgreSQL 17
- Gradle

### Configuração

1. Clone o repositório
```bash
git clone https://github.com/JeffrySmith117/auth-api.git
cd auth-api
```

2. Crie o banco de dados
```sql
CREATE DATABASE authdb;
```

3. Configure o `application.yaml`
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/authdb
    username: postgres
    password: sua_senha
```

4. Execute
```bash
./gradlew bootRun
```

## 🔒 Segurança

- Senhas criptografadas com BCrypt
- Access Token com expiração de 24h
- Refresh Token com expiração de 7 dias
- Blacklist de tokens para logout seguro
- Sessão stateless (sem estado no servidor)

## 📝 Exemplos de uso

### Register
```bash
curl -X POST http://localhost:8080/auth/register \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john@email.com","password":"123456"}'
```

### Login
```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"john@email.com","password":"123456"}'
```

### Endpoint protegido
```bash
curl -X GET http://localhost:8080/api/me \
  -H "Authorization: Bearer {seu_token}"
```

---

Desenvolvido por [Jeffry Smith](https://github.com/JeffrySmith117)