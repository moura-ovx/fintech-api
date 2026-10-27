# 💰 Fintech API - Gestão de Finanças Pessoais

API RESTful desenvolvida com **Spring Boot** para gerenciamento de finanças pessoais. O sistema permite o controle centralizado de usuários, categorias de despesas e receitas, lançamentos financeiros e metas de economia, para um sistema que estou construindo.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+

* **Framework Principal:** Spring Boot 3

* **Persistência de Dados:** Spring Data JPA / Hibernate

* **Banco de Dados:** H2 Database (Banco em memória configurado para ambiente de teste/desenvolvimento)

* **Documentação da API:** OpenAPI 3 / Swagger UI (`springdoc-openapi`)

* **Gerenciador de Dependências:** Apache Maven

## 📐 Arquitetura e Estrutura do Projeto

O projeto foi estruturado seguindo os princípios da **Clean Architecture** e o padrão **MVC (Model-View-Controller)** para garantir o desacoplamento e a organização em camadas:

```
src/main/java/br/com/fiap/fintech/
├── controller/     # Exposição dos endpoints REST
├── model/          # Entidades do JPA e Enums de domínio
├── repository/     # Interfaces de acesso ao banco de dados (Spring Data JPA)
├── service/        # Camada de regras de negócio
└── FintechApplication.java

```

### Boas Práticas Aplicadas:

* **Padrões REST:** Utilização correta dos verbos HTTP (`GET`, `POST`, `PUT`, `DELETE`) e códigos de status HTTP adequados (`200 OK`, `201 Created`, `204 No Content`, `404 Not Found`).

* **Documentação Viva:** Documentação automática de todas as rotas com anotações OpenAPI/Swagger.

* **Isolamento de Segurança:** Uso do banco de dados H2 em memória, garantindo que credenciais sensíveis não sejam expostas no repositório.

## 📍 Documentação Interativa da API (Swagger)

A aplicação conta com a interface gráfica do **Swagger UI** para que avaliadores e recrutadores possam visualizar e testar os endpoints interativamente pelo navegador sem necessidade de importar coleções externas.

Com a aplicação rodando, acesse:
👉 [**http://localhost:8080/swagger-ui.html**](http://localhost:8080/swagger-ui.html)

### Resumo dos Endpoints

| Recurso | Método | Endpoint | Descrição | 
| ----- | ----- | ----- | ----- | 
| **Categorias** | `GET` | `/categorias` | Lista todas as categorias | 
|  | `GET` | `/categorias/{id}` | Busca categoria por ID | 
|  | `POST` | `/categorias` | Cadastra nova categoria | 
|  | `PUT` | `/categorias/{id}` | Atualiza categoria existente | 
|  | `DELETE` | `/categorias/{id}` | Remove uma categoria | 
| **Lançamentos** | `GET` | `/lancamentos` | Lista todos os lançamentos | 
|  | `GET` | `/lancamentos/{id}` | Busca lançamento por ID | 
|  | `POST` | `/lancamentos` | Registra nova receita ou despesa | 
|  | `PUT` | `/lancamentos/{id}` | Atualiza lançamento existente | 
|  | `DELETE` | `/lancamentos/{id}` | Remove um lançamento | 
| **Metas** | `GET` | `/metas` | Lista todas as metas | 
|  | `POST` | `/metas` | Cadastra nova meta financeira | 
|  | `PUT` | `/metas/{id}` | Atualiza meta existente | 
|  | `DELETE` | `/metas/{id}` | Exclui uma meta | 
| **Usuários** | `GET` | `/usuarios` | Lista todos os usuários | 
|  | `POST` | `/usuarios` | Cadastra novo usuário | 
|  | `PUT` | `/usuarios/{id}` | Atualiza perfil de usuário | 

## 🗄️ Banco de Dados (H2)

Para simplificar a execução do projeto sem a necessidade de instalar e configurar um SGBD local (como PostgreSQL ou Oracle), o projeto está configurado por padrão para usar o banco **H2 em memória**.

* **Console de Gerenciamento H2:** <http://localhost:8080/h2-console>

* **JDBC URL:** `jdbc:h2:mem:fintechdb`

* **Usuário:** `sa`

* **Senha:** *(deixar em branco)*

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos

* **JDK 17** ou superior instalado.

* **Git** instalado.

### Passo a Passo

1. **Clonar o repositório:**

   ```
   git clone https://github.com/moura-ovx/fintech.git
   cd fintech
   
   ```

2. **Compilar e rodar a aplicação via Maven:**

   * No **Linux/Mac**:

     ```
     ./mvnw spring-boot:run
     
     ```

   * No **Windows**:

     ```
     mvnw.cmd spring-boot:run
     
     ```

3. **Acessar a documentação no navegador:**
   Abra `http://localhost:8080/swagger-ui.html` para testar as requisições.

## ✒️ Autor

Desenvolvido por: **Gustavo Moura**

* **LinkedIn:** www.linkedin.com/in/gustavo-barbosa-112846440
