🚀 Bootcamp Java – Arquitetura Corporativa com Spring Boot
👩‍💻 Objetivo Estratégico

Este projeto foi desenvolvido como parte do Bootcamp Java com o propósito de evoluir um CRUD em Java puro para uma aplicação estruturada em Spring Boot, utilizando JPA e Hibernate, alinhada às boas práticas adotadas em ambientes corporativos.
---
Mais do que implementar funcionalidades, o foco foi:

Aplicar arquitetura em camadas

Garantir organização e escalabilidade

Simular padrão utilizado em consultorias

Preparar estrutura compatível com ambientes empresariais

🏗 Arquitetura Aplicada

A aplicação segue o padrão Layered Architecture, amplamente utilizado em projetos corporativos.

src/main/java
├── controller → Camada de exposição (API REST)
├── service → Regras de negócio
├── repository → Acesso a dados
└── model → Entidades JPA

Princípios aplicados:

Separação de responsabilidades

Inversão de controle (IoC)

Injeção de dependência

Baixo acoplamento

Código orientado à manutenção

🛠 Stack Tecnológica

Java 17

Spring Boot

Spring Data JPA

Hibernate (ORM)

Maven

H2 Database

Git

🔄 Evolução Técnica do Projeto
🔹 Fase 1 – CRUD em Java Puro

Estrutura básica orientada a objetos

Manipulação manual de dados

Organização inicial do domínio

🔹 Fase 2 – Migração para Spring Boot

Estruturação via Maven

Configuração automática via Spring

Criação de endpoints REST

Separação em camadas

🔹 Fase 3 – Persistência com JPA/Hibernate

Mapeamento de entidades com @Entity

Identificação automática com @GeneratedValue

Interface JpaRepository

Banco H2 configurado via application.properties


📊 Conceitos Corporativos Aplicados

✔ Organização em camadas
✔ Padronização de código
✔ Uso de framework consolidado de mercado
✔ Estrutura pronta para escalabilidade
✔ Base para implementação de logs e monitoramento
✔ Preparação para ambientes com SLA e gestão de incidentes

🧠 Visão de Mercado

Este projeto foi desenvolvido considerando padrões utilizados em empresas de consultoria e ambientes corporativos que utilizam:

Governança de TI

Controle de mudanças

Versionamento estruturado

Documentação organizada
