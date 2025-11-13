# 🧠 Smart Pricing

> Sistema inteligente de precificação usando web scraping e IA

[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen?logo=spring)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql)](https://www.postgresql.org/)

## 🚀 Quick Start

```bash
git clone https://github.com/lucasgls/smart-pricing.git
cd smart-pricing
./mvnw spring-boot:run
```

Acesse: http://localhost:8080

## 💡 Sobre

Automatize a precificação do seu petshop com:

- 🕷️ Web scraping de preços concorrentes
- 🤖 Sugestões de preços com IA
- 📊 Dashboard de análise de mercado
- 💰 Otimização de margem de lucro

## 📦 Stack

- Java 21
- Spring Boot 3.5.7 (Web + Data JPA ...)
- PostgreSQL 15o
- Maven

## ⚙️ Configuração 
- [Java 21+](https://docs.aws.amazon.com/corretto/latest/corretto-21-ug/downloads-list.html)
- [Docker Desktop](https://www.docker.com/products/docker-desktop)
  
### 🐘 Banco de Dados
**1. Subir PostgreSQL:**

```
docker-compose up -d
```
**2. Verificar status:**

```
docker-compose ps
```

**Credenciais:**

- **Host:** localhost:5432
- **Database:** smart_pricing_test
- **User/Pass:** postgres/postgres

**Uteis:**

```
# Parar banco
docker-compose down

# Ver logs
docker-compose logs -f postgres

# Acessar psql
docker exec -it smart-pricing-db psql -U postgres -d smart_pricing_test

# Recriar do zero
docker-compose down -v && docker-compose up -d
```

## 🔒 Segurança e CORS (Desenvolvimento)

#### CORS (Cross-Origin Resource Sharing)
Permite requisições de frontends locais para a API.

**Origens permitidas:**
- `http://localhost:3000` (React/Next.js) ainda por decidir...
- `http://localhost:4200` (Angular)

**Métodos HTTP:** GET, POST, PUT, PATCH, DELETE, OPTIONS

#### 🔓 CSRF (Cross-Site Request Forgery)

⚠️ **ATENÇÃO:** CSRF **temporariamente desabilitado** em desenvolvimento.

**Motivo:** Facilitar testes e desenvolvimento inicial.

**Status:** Será reabilitado na Sprint 2/3 junto com autenticação JWT.


## 🧪 Testes

```bash
./mvnw test
```

### 🔒 Testando CORS

```bash
curl -H "Origin: http://localhost:3000" \
     -H "Access-Control-Request-Method: POST" \
     -X OPTIONS http://localhost:8080/api/hello
```

## 📊 Status - Sprint 1

```
Progresso: █████░░░░░ 40% (4/10)
```

- [x] 1.1 - Setup Spring Boot
- [x] 1.2 - PostgreSQL / Docker
- [x] 1.3 - Estrutura MVC
- [x] 1.4 - CORS e segurança
- [ ] 1.5 - Modelo Produto
- [ ] 1.6 - Modelo NotaFiscal
- [ ] 1.7 - Upload XML NF-e
- [ ] 1.8 - Parser XML
- [ ] 1.9 - Persistência
- [ ] 1.10 - Testes unitários

## 🗺️ Roadmap (Planejado, pode haver mudanças...)

**Sprint 1** - Fundação (atual)  
**Sprint 2** - Web Scraping  
**Sprint 3** - IA e Dashboard

## 📞 Contato

**Lucas Gabriel** - [@lucasgls](https://github.com/lucasgls)

---