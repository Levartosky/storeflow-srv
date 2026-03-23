# Storeflow Service

## Descrição do Projeto
O **Storeflow Service** é uma aplicação backend desenvolvida em Java com o framework Spring Boot. Este serviço é responsável por gerenciar o catálogo de produtos e categorias de uma loja, fornecendo endpoints RESTful para operações CRUD e outras funcionalidades relacionadas.

## Estrutura do Projeto
A estrutura do projeto segue as melhores práticas do Spring Boot, com separação clara de responsabilidades:

```
src/
  main/
    java/
      br/com/storeflow/srv/
        catalog/
          controller/    # Controladores REST
          domain/        # Entidades do domínio
          dto/           # Objetos de transferência de dados
          repository/    # Interfaces de repositórios (JPA)
          service/       # Lógica de negócios
        config/          # Configurações da aplicação
        exception/       # Tratamento de exceções globais
        health/          # Endpoints de saúde da aplicação
    resources/
      application.yml    # Configurações padrão
      application-local.yml # Configurações para ambiente local
      db/
        migration/       # Scripts de migração do banco de dados
```

## Funcionalidades
- **Gerenciamento de Produtos**: CRUD completo para produtos.
- **Gerenciamento de Categorias**: CRUD completo para categorias.
- **Monitoramento de Saúde**: Endpoint para verificar o status da aplicação.
- **Tratamento de Exceções**: Manipulação centralizada de erros.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (para desenvolvimento e testes)
- **Flyway** (para controle de versão do banco de dados)
- **Docker** e **Docker Compose**
- **Maven**

## Pré-requisitos
Certifique-se de ter as seguintes ferramentas instaladas:
- **Java 17**
- **Maven**
- **Docker** e **Docker Compose**

## Configuração e Execução

### 1. Clonar o Repositório
```bash
git clone <URL_DO_REPOSITORIO>
cd storeflow-srv
```

### 2. Configurar o Ambiente
Edite o arquivo `application-local.yml` para ajustar as configurações locais, se necessário.

### 3. Executar com Maven
Para rodar a aplicação localmente:
```bash
mvn spring-boot:run
```

### 4. Executar com Docker
Para rodar a aplicação usando Docker Compose:
```bash
docker-compose up --build
```

### 5. Acessar a Aplicação
- **API Base**: `http://localhost:8080`
- **Endpoint de Saúde**: `http://localhost:8080/actuator/health`

## Endpoints Principais

### Produtos
- **GET** `/products`: Listar todos os produtos
- **POST** `/products`: Criar um novo produto
- **GET** `/products/{id}`: Buscar produto por ID
- **PUT** `/products/{id}`: Atualizar produto por ID
- **DELETE** `/products/{id}`: Deletar produto por ID

### Categorias
- **GET** `/categories`: Listar todas as categorias
- **POST** `/categories`: Criar uma nova categoria
- **GET** `/categories/{id}`: Buscar categoria por ID
- **PUT** `/categories/{id}`: Atualizar categoria por ID
- **DELETE** `/categories/{id}`: Deletar categoria por ID

## Banco de Dados
O projeto utiliza o Flyway para gerenciar as migrações do banco de dados. O script inicial está localizado em `src/main/resources/db/migration/V1__create_initial_tables.sql`.

### Estrutura Inicial
- **Tabela `products`**: Armazena informações sobre os produtos.
- **Tabela `categories`**: Armazena informações sobre as categorias.

## Testes
Os testes estão localizados no diretório `src/test/java`. Para executar os testes:
```bash
mvn test
```

## Contribuição
Contribuições são bem-vindas! Siga os passos abaixo para contribuir:
1. Faça um fork do repositório.
2. Crie uma branch para sua feature/bugfix: `git checkout -b minha-feature`.
3. Faça commit das suas alterações: `git commit -m 'Minha nova feature'`.
4. Envie para o repositório remoto: `git push origin minha-feature`.
5. Abra um Pull Request.

## Licença
Este projeto está licenciado sob a [MIT License](LICENSE).

---

**Mantenedores**: Para dúvidas ou suporte, entre em contato com a equipe de desenvolvimento.
