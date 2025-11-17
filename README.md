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
- PostgreSQL 15
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

## 📦 Modelo de Dados

### Entidade: Produto

Representa produtos cadastrados no sistema para análise de precificação.

#### Campos da entidade

| Campo         | Tipo          | Descrição                  | Obrigatório                  |
|---------------|---------------|----------------------------|------------------------------|
| `id`          | UUID          | Identificador único global | Sim (gerado automaticamente) |
| `name`        | String(150)   | Nome do produto            | Sim                          |
| `description` | Text          | Descrição detalhada        | Não                          |
| `category`    | Enum          | Categoria do produto       | Sim                          |
| `costPrice`   | Numeric(10,2) | Preço de custo em reais    | Sim                          |
| `createdAt`   | Timestamp     | Data de criação            | Sim (automático)             |
| `updatedAt`   | Timestamp     | Última atualização         | Sim (automático)             |

#### Categorias disponíveis

| Enum               | Descrição                            |
|--------------------|--------------------------------------|
| `ACESSORIOS`       | Coleiras, guias, roupas e acessórios |
| `ALIMENTOS`        | Alimentos secos e úmidos para pets   |
| `BRINQUEDOS`       | Brinquedos e itens de entretenimento |
| `CAMA_TRANSPORTE`  | Camas, casinhas, caixas de transporte|
| `HIGIENE`          | Produtos de higiene e limpeza        |
| `MEDICAMENTOS`     | Medicamentos e suplementos           |
| `OUTROS`           | Produtos diversos não categorizados  |

### Entidade: Nota Fiscal (Invoice)

Representa notas fiscais de compra de fornecedores.

#### Campos da entidade

| Campo         | Tipo          | Descrição                     | Obrigatório                  |
|---------------|---------------|-------------------------------|------------------------------|
| `id`          | UUID          | Identificador único global    | Sim (gerado automaticamente) |
| `number`      | String(100)   | Número da nota fiscal         | Sim (único)                  |
| `supplier`    | String(200)   | Nome do fornecedor            | Sim                          |
| `issueDate`   | Timestamp     | Data de emissão               | Sim                          |
| `totalAmount` | Numeric(10,2) | Valor total da nota           | Sim                          |
| `status`      | Enum          | Status do processamento       | Sim                          |
| `items`       | Collection    | Itens da nota fiscal          | -                            |
| `createdAt`   | Timestamp     | Data de criação no sistema    | Sim (automático)             |
| `updatedAt`   | Timestamp     | Última atualização            | Sim (automático)             |

#### Status disponíveis

| Enum         | Descrição                              |
|--------------|----------------------------------------|
| `PENDENTE`   | Aguardando processamento               |
| `PROCESSADA` | Processada e persistida com sucesso    |
| `ERRO`       | Erro durante processamento             |
| `CANCELADA`  | Nota fiscal cancelada                  |

---

### Entidade: Item da Nota Fiscal (InvoiceItem)

Representa cada item/produto presente em uma nota fiscal.

#### Campos da entidade

| Campo        | Tipo          | Descrição                  | Obrigatório |
|--------------|---------------|----------------------------|-------------|
| `id`         | UUID          | Identificador único global | Sim (gerado)|
| `invoice`    | Invoice       | Nota fiscal (FK)           | Sim         |
| `product`    | Product       | Produto (FK)               | Sim         |
| `quantity`   | Integer       | Quantidade comprada        | Sim         |
| `unitPrice`  | Numeric(10,2) | Preço unitário             | Sim         |
| `totalPrice` | Numeric(10,2) | Preço total (calculado)    | Sim         |
| `unit`       | String(5)     | Unidade (UN, KG, CX, etc)  | Não         |


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
Progresso: ███████░░░ 60% (6c/10)
```

- [x] 1.1 - Setup Spring Boot
- [x] 1.2 - PostgreSQL / Docker
- [x] 1.3 - Estrutura MVC
- [x] 1.4 - CORS e segurança
- [x] 1.5 - Modelo Produto
- [x] 1.6 - Modelo NotaFiscal
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