# Customer Service

Bem-vindo ao Customer Service, o microserviço responsável por processar os dados dos clientes no Barber API.

## Visão Geral

Este microserviço é parte integrante do sistema de barbearia e se concentra no gerenciamento de informações dos clientes. Ele oferece endpoints RESTful para criar, recuperar, atualizar e excluir dados de clientes, proporcionando uma interface fácil e eficiente para interações relacionadas a clientes.

## Funcionalidades Principais

- **Cadastro de Clientes:** Adicione novos clientes ao sistema fornecendo informações como nome, email, senha e localização geográfica.

- **Consulta de Clientes:** Recupere informações detalhadas sobre os clientes registrados no sistema.

- **Atualização de Dados:** Atualize facilmente os detalhes dos clientes quando necessário.

- **Remoção de Clientes:** Remova registros de clientes conforme necessário, mantendo o banco de dados organizado.

## Tecnologias Utilizadas

- Spring Boot: Framework Java para desenvolvimento rápido de aplicativos baseados em Spring.
- PostgreSQL: Banco de dados relacional para armazenamento eficiente e seguro dos dados dos clientes.
- Spring Data JPA: Facilita a implementação da camada de persistência de dados baseada em JPA.
- Lombok: Reduz a verbosidade do código Java, promovendo uma codificação mais limpa e concisa.

## Configuração

1. **Requisitos:**
   - Java 11 ou superior
   - PostgreSQL

2. **Configuração do Banco de Dados:**
   - Crie um banco de dados PostgreSQL chamado "customer".
   - Atualize as configurações do banco de dados no arquivo `application.properties` ou `application.yml`.

3. **Execução do Microserviço:**
   - Execute o microserviço usando sua IDE preferida ou via linha de comando (`./mvnw spring-boot:run`).


## Contribuição

Se desejar contribuir para o desenvolvimento do Customer Service, siga estas etapas:

1. Faça um fork do repositório.
2. Crie um branch para suas alterações (`git checkout -b feature/nova-feature`).
3. Faça commit de suas alterações (`git commit -am 'Adiciona nova feature'`).
4. Envie um push para o branch (`git push origin feature/nova-feature`).
5. Abra um pull request.

## Contato

Para mais informações ou dúvidas, entre em contato com a equipe de desenvolvimento:

- [Jonatan](mailto:jonatan.santos.contato@gmail.com)
