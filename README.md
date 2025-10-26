# DESF5-Atividade-do-Desafio-Final-Rodrigo-Damasceno
Repositório com a entrega do desafio final - Rodrigo Damasceno

# Products API
Foi adicionado o arquivo Collection.json na pasta raiz do projeto contendo as requisições para testar a aplicação através do Postman.

## Diagramas
Os Diagramas C4 de Contexto, de Conteiners e de Componentes se encontram na pasta Diagrams do projeto.

## Estrutura de pastas e explicação dos componentes

### 1. Controller
- **Função:** Recebe as requisições HTTP do cliente, valida os dados e chama os serviços adequados.  
- **Exemplo:** `ProdutoController` com métodos como:
  - `GET /products`
  - `POST /products`
  - `GET /products/search?name=Notebook`
- **Observação:** Mantém o Controller "magro", apenas orquestrando a interação com o Service.

### 2. Model (ou Entidades) 
- **Função:** Representa os objetos de negócio e a estrutura de dados persistidos.  
- **Exemplo:** `Product` com atributos `id`, `name`, `price`, etc.  
- **Observação:** Normalmente mapeado para o banco de dados com JPA/Hibernate (`@Entity`).

### 3. Service
- **Função:** Contém a **lógica de negócio** do sistema, processando dados do Controller e interagindo com o Repository.  
- **Exemplo:** `ProductService` com métodos:
  - `findByName(String name)`
  - `update(Long id, Product product)`

### 4. Repository 
- **Função:** Responsável pelo acesso a dados, como consultas ao banco de dados.  
- **Exemplo:** `ProductRepository` pode estender `JpaRepository<Product, Long>` e fornecer métodos como `findByNameContainingIgnoreCase(String name)`.


## Descrição
Esta aplicação é um sistema completo para gerenciamento de produtos, construída com arquitetura MVC, oferecendo APIs REST para operações CRUD. Construído em Java com Spring Boot.

O sistema inclui:
- Cadastro e gerenciamento de produtos.
- Pesquisa de produtos por nome e id.
- Persistência de dados com H2.

## Tecnologias Utilizadas
- **Backend:** Java 17, Spring Boot, JPA
- **Banco de Dados:** H2
- **Controle de Versão:** Git
- **Ferramentas de Build:** Maven



