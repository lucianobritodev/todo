# ToDo

Projeto desenvolvido para gerenciamento e agendamento de atividades.

O `ToDo` fornece uma camanda de `REST API` que permite operações de `CRUD` em domínios de Usuários, Agendamentos e Atividades. Os dados são armazenados em Banco de Dados `PostgreSQL`. Foi utilizado diversos conceitos de modelagem, padrões de projeto, desenvolvimento e documentação seguindo (para esse projeto) a abordagem `Code-First`.



## Descrição

A aplicação `ToDo` foi desenvolvida com backend `Java/Spring` para realização de operações CRUD em banco de dados `Postgres` utilizando o ORM `Hibernate` e utilização da biblioteca `Jackson` para serialização e deserialização customizada de reprentações de domínio em formato `JSON`.

Foi utilizado diversos conceitos de modelagem seguindo as boas práticas, aplicando padrões de projeto e princípios `REST`, `SOLID`, `DRY`, `KISS`, `Clean Code`, `Clean Arquitecture`, desenvolvimento focado na alta coesão e baixo acoplamento das camadas através da `Inversão de Controle` e `Injeção de Dependências` provida pelo container IoC do SpringFramework.

A aplicação conta ainda com `Maven` como gerente de build e configuração, controle de versão e modificação de projeto com `Git`, gerência de migrações de banco de dados com `FlyWay` e ainda documentação com padrão OpenAPI de forma automática com `Swagger`, `Lombok` para geração automática de código boilerplate, `ModelMapper` para mapeamento de objeto para objeto permitindo a transformação de Entidade para `DTO`, `Jakarta Validation Constraints` para a criação de beans validation, tratamento de exceções de forma global com status code devidamente tratados através de `ControllerAdvice` e `ExceptionHandler`.

As features do projeto Spring que foram utilizadas são: `SpringBoot`, `SpringSecurity` e `SpringDataJpa`.

- SpringBoot para inicialização, autoconfiguração e criação de beans de configuração customizados dentro do projeto.
- SpringDataJpa para auxiliar na manipulação de dados e facilitação de criação de queries mais elaboradas através de `Query Methods` e paginação de dados com `Pageable`.
- SpringSecurity para segurança, autenticação e autorização. Dentro do SpringSecurity foram utilizados ferramentas como `BCrypt` para encriptação e verificação de senhas, `UserDatails` para autenticação e autorização de com base em dados e perfis previamente cadastrados utilizando o `Basic Auth` com `JWT` como formato de autenticação.



## Contribuidor

[Luciano Brito](https://github.com/lucianobritodev)

Brasileiro, casado, nascido em 1991, apaixonado por tecnologia. Graduado em Ánálise e Desenvolvimento de Sistemas pela Universidade Paulista (UNIP) em 2019 e Pós Graduado em Arquitetura de Software pela InfNet em 2023. 



## Contatos

- [LinkeIn](https://www.linkedin.com/in/luciano-brito-dev)
- [Gmail](mailto:lucianobrito.dev@gmail.com)
- [Instagram](https://www.instagram.com/lucianobrito.dev)



## Doações

[![paypal](https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif)](https://www.paypal.com/donate/?hosted_button_id=SX3L4N89M8ZRW)