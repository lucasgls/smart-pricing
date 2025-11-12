# 🧠 Smart Pricing

> Sistema inteligente de precificação usando web scraping e IA

[![Java](https://img.shields.io/badge/Java-21-orange?logo=openjdk)](https://openjdk.org/)
[[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen?logo=spring)](https://spring.io/projects/spring-boot)
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
- PostgreSQL 15a
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

## 🧪 Testes

```bash
./mvnw test
```

## 📊 Status - Sprint 1

```
Progresso: ████░░░░░░ 30% (3/10)
```

- [x] 1.1 - Setup Spring Boot
- [x] 1.2 - PostgreSQL / Docker
- [x] 1.3 - Estrutura MVC
- [ ] 1.4 - CORS e segurança
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