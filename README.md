# 🎯 Design Patterns em Java - Projeto Exemplo

Este repositório reúne exemplos práticos de três padrões de projeto fundamentais em Java: **Facade**, **Singleton** e **Strategy**. O objetivo é demonstrar suas aplicações em um cenário de gerenciamento de clientes e transações bancárias, utilizando Spring Boot.

---

## 🧠 Conceitos de Design Patterns

### Facade

O padrão **Facade** simplifica a interação com subsistemas complexos, expondo uma interface única e fácil de usar.

* **Cenário**: Uma operação de cadastro de cliente exige (`nome`, `cep`, `cidade`, `estado`).
* **Solução**: A `ClienteFacade` recebe apenas (`nome`, `cep`), consulta a API de CEP (via Feign Client) e fornece `cidade` e `estado` à camada de serviço.

### Singleton

Garante que apenas uma instância de uma classe exista durante todo o ciclo de vida da aplicação.

* **Eager**: Instancia o objeto assim que a classe é carregada.
* **Lazy**: Instancia o objeto somente quando é solicitado, via método `getInstance()`.
* **No Spring**: Todos os beans anotados com `@Component` ou `@Service` e injetados com `@Autowired` são singletons por padrão.

### Strategy

Define uma família de algoritmos intercambiáveis, permitindo que o comportamento mude em tempo de execução.

* **Contexto**: `TransacaoService` recebe uma estratégia de execução conforme o tipo de transação: `Pix`, `DOC` ou `Boleto`.
* **Implementações**: Cada classe `*TransacaoStrategy` implementa a interface `TransacaoStrategy` e encapsula sua lógica específica.

---

## 🚀 Sobre o Projeto

Este projeto foi desenvolvido com Spring Boot e utiliza injeção de dependências para gerenciar beans, o padrão **Strategy** para regras de transação e o padrão **Facade** para centralizar a lógica de cadastro de cliente.

### Dependências

* `spring-boot-starter-data-jpa`
* `spring-boot-starter-web`
* `spring-cloud-starter-openfeign`
* `springdoc-openapi-starter-webmvc-ui` (Swagger)
* `lombok`
* `h2` (banco em memória)
* `spring-boot-starter-test`

---

## 📂 Estrutura do Projeto

```
DesignPatterns/
├── controller/
│   ├── ClienteController.java      # Facade para cadastro de clientes
│   └── TransacaoController.java    # Facade para operações de transação
│
├── model/
│   ├── cliente/
│   │   ├── Cliente.java
│   │   └── ClienteRepository.java
│   └── transacao/
│       ├── Tipo.java              # enum: Pix, DOC, Boleto
│       ├── Transacao.java
│       └── TransacaoRepository.java
│
├── service/
│   ├── cliente/
│   │   ├── ClienteService.java    # Strategy (interface)
│   │   └── impl/                  # implementação padrão
│   │       └── ClienteServiceImpl.java
│   │   └── DtoCadastrarCliente.java
│   │
│   └── transacao/
│       ├── TransacaoService.java   # Strategy (interface)
│       ├── impl/                   # implementação da fachada de transação
│       │   └── TransacaoServiceImpl.java
│       └── strategy/               # pacotes de Strategy
│           ├── PixTransacaoStrategy.java
│           ├── DOCTransacaoStrategy.java
│           ├── BoletoTransacaoStrategy.java
│           └── TransacaoStrategy.java
│       └── DtoTransacao.java
│
└── Main.java                       # Classe main para bootstrapping do Spring Boot
```

---

## 📊 Diagrama de Classes

![Diagrama UML de Classes](https://github.com/user-attachments/assets/106f2cca-d3a5-46b0-b163-cb9198c32430)

---

## 🔄 Fluxo de Requisição

1. **Client** envia requisição HTTP a um **Controller** (Facade).
2. O **Controller** valida o DTO e invoca o **Service** apropriado.
3. O **Service** (Strategy) seleciona a implementação de acordo com o tipo (`Pix`, `DOC` ou `Boleto`).
4. A lógica de negócio é executada e persistida via **Repository**.
5. Resposta JSON é retornada ao **Client**.

---
