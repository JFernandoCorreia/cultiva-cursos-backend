
# Flor da Cidade

Este é o projeto **Flor da Cidade**, desenvolvido para gerenciar o cadastro e a inscrição de interessados em cursos oferecidos pela **Secretaria de Agricultura Urbana**. O sistema contém funcionalidades de autenticação, cadastro de usuários, gestão de cursos e uma lista de espera. A aplicação foi desenvolvida utilizando uma arquitetura **full stack**, com backend em **Java Spring Boot**, frontend em **React.js**, e persistência de dados em **MySQL**.

## Funcionalidades

### Backend

- **Autenticação JWT**: O backend usa **JSON Web Tokens (JWT)** para autenticar usuários. O token é gerado após o login e enviado nas requisições subsequentes para proteger as rotas privadas.
- **Gestão de Usuários**: O backend permite o cadastro de usuários, bem como sua autenticação para acessar funcionalidades do sistema.
- **Gestão de Cursos**: API para criação, listagem, atualização e remoção de cursos.
- **Lista de Espera**: Implementação de uma lista de espera para cursos onde os usuários podem se inscrever.
- **Segurança**: Utiliza **BCrypt** para hash de senhas e **Spring Security** para autenticação e autorização.
- **Migrações de Banco de Dados**: O backend utiliza **Flyway** para controle de versão das migrações do banco de dados, garantindo que o esquema do banco seja consistente em diferentes ambientes.

#### Principais Endpoints:

- **/login**: Autenticação de usuários.
- **/register**: Cadastro de novos usuários.
- **/cursos**: CRUD de cursos (criação, listagem, edição, exclusão).
- **/lista-espera**: Gerenciamento da lista de espera dos cursos.

### Frontend

- **React.js**: O frontend foi desenvolvido com **React.js**, utilizando componentes funcionais, hooks como `useState` e `useEffect`, e a biblioteca **React Router** para navegação entre páginas.
- **Formulários de Cadastro e Login**: O frontend possui páginas para cadastro de novos usuários e login, com validação de campos obrigatórios.
- **Integração com API**: O frontend utiliza a biblioteca **Axios** para comunicação com o backend, enviando requisições para cadastro, login e outras operações. O token JWT é armazenado no **localStorage** após o login e adicionado automaticamente no cabeçalho das requisições subsequentes.
- **Interceptores de Requisições**: O axios possui interceptores para adicionar automaticamente o token JWT em todas as requisições protegidas.
- **Acessibilidade**: A interface é projetada pensando em acessibilidade, com contraste de cores e navegação amigável.
- **Chatbot (Tawk.to)**: O projeto inclui um chatbot integrado com **Tawk.to** (pode ser temporariamente removido).

#### Principais Páginas:

- **Página Inicial**: Apresenta informações básicas e permite navegar para o login e cadastro.
- **Login**: Permite o acesso de usuários ao sistema.
- **Cadastro de Interessados**: Página de registro para novos interessados em cursos.
- **Gestão de Cursos**: Interface para visualizar e se inscrever nos cursos disponíveis.

### Banco de Dados

O banco de dados utilizado é o **MySQL** e as tabelas principais incluem:

- **Users**: Tabela que armazena as informações dos usuários, como nome, e-mail, CPF, senha e dados de criação e atualização.
- **Courses**: Armazena informações sobre os cursos disponíveis, incluindo título, descrição, instrutor e localização.
- **ListaEspera**: Armazena as inscrições de usuários na lista de espera dos cursos.
- **UserProfiles**: Perfil de usuários que armazenam dados adicionais como endereço e telefone.

#### Estrutura do Banco de Dados:

- **Users**: Contém as colunas `id`, `name`, `email`, `cpf`, `password`, entre outras.
- **Courses**: Contém as colunas `id`, `title`, `description`, `instructor`, `location`, entre outras.
- **ListaEspera**: Relaciona os cursos e os usuários inscritos na lista de espera.

O gerenciamento de versões e migrações do banco de dados é feito com **Flyway**.

## Tecnologias Utilizadas

### Backend:

- **Java 21**: Linguagem principal do backend.
- **Spring Boot 3.1.5**: Framework para criar o backend com componentes RESTful.
- **Spring Security**: Framework para gerenciamento de autenticação e autorização.
- **JWT (JSON Web Token)**: Usado para autenticação de usuários.
- **BCrypt**: Usado para hash de senhas.
- **Flyway**: Ferramenta de migração de banco de dados para controle de versão.
- **MySQL**: Banco de dados relacional para armazenar informações de usuários, cursos e inscrições.

### Frontend:

- **React.js**: Biblioteca JavaScript para criação de interfaces de usuário.
- **Axios**: Biblioteca para requisições HTTP.
- **React Router**: Biblioteca de roteamento para navegação entre páginas.
- **Tailwind CSS**: Framework CSS para estilização e layout.

### Ferramentas de Desenvolvimento:

- **Node.js & npm**: Utilizados para gerenciamento de pacotes no frontend.
- **Jest**: Biblioteca de testes para o frontend.
- **Postman**: Utilizado para testar e debugar as requisições HTTP do backend.

## Metodologia

O projeto foi desenvolvido utilizando uma abordagem ágil com base em **Scrum**. As principais práticas incluem:

- **Sprints curtas**: Entregas incrementais e regulares de funcionalidades.
- **Revisão contínua**: O código foi revisado regularmente para garantir qualidade e aderência às boas práticas.
- **Testes unitários**: No backend e frontend, foram implementados testes automatizados para verificar a integridade das funcionalidades críticas.

## Como Executar o Projeto

### Backend:

1. Clone o repositório.
2. Configure o banco de dados MySQL e as variáveis de ambiente no arquivo `.env`.
3. Execute as migrações com o Flyway.
4. Inicie o servidor Spring Boot com o Maven ou qualquer IDE de sua preferência.

### Frontend:

1. Navegue até o diretório `frontend` e execute `npm install` para instalar as dependências.
2. Execute `npm start` para iniciar o servidor de desenvolvimento React.
3. Acesse o frontend em `http://localhost:3000`.

## Contribuição

Fique à vontade para contribuir com o projeto enviando *pull requests* ou relatando problemas na seção de *issues*.

## Licença

Este projeto está sob a licença MIT.
