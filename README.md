# Bootcamp-Java-turma-2

Projeto desenvolvido durante o Bootcamp de Java, com foco em criação de um **CRUD de Usuários** utilizando **Spring Boot**, **Spring Data JPA**, **Spring Security** e **Thymeleaf**.

## 🚀 Tecnologias utilizadas
- Java 21
- Spring Boot 3.2.2
- Spring Web
- Spring Data JPA
- Spring Security
- Thymeleaf
- Banco de dados H2 (testes) e PostgreSQL (produção)
- Maven

## 📂 Estrutura do projeto
- `src/main/java/com/banco/usuario` → código fonte
  - `controller` → controladores REST e páginas
  - `service` → regras de negócio
  - `repository` → acesso ao banco de dados
  - `model` → entidades
  - `config` → configuração de segurança
- `src/main/resources/static` → arquivos HTML estáticos (ex.: login.html)
- `src/main/resources/templates` → páginas Thymeleaf (se usadas)
- `pom.xml` → dependências e configuração do Maven

## 🔐 Autenticação
O projeto utiliza **Spring Security** para proteger o CRUD:
- Página de login em `/login.html`
- Após login, o usuário é redirecionado para `/usuarios`.

## ⚙️ Como executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/Bootcamp-Java-turma-2.git
