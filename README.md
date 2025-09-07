# 🐶 Sistema Petshop

Este é um projeto Java com Spring Boot para gerenciamento de um petshop. Nele é possível cadastrar clientes, pets e realizar operações básicas de CRUD por meio de uma API REST.

---

## 🚀 Tecnologias utilizadas (até o momento...)

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (para testes locais)
- Maven
- Postman (para testes de API)

---
## ⚙️ Como rodar
Basta rodar a aplicação pela IDE ou usando o terminal (PowerShell ou terminal da própria IDE) com o seguinte código:
### mvn spring-boot:run 
A API estará disponível em http://localhost:8080
- http://localhost:8080/funcionarios 
- http://localhost:8080/clientes
- http://localhost:8080/pets
---
## 📚 Endpoints disponíveis
- /clientes — Operações CRUD para clientes
- /pets — Operações CRUD para pets
- /funcionarios — Operações CRUD para funcionários
  ## OBS:
  - Quando for cadastrar telefone e cpf colocar sem caracteres especiais (Ex: 000.000.000-00 e sim 00000000000)
  - Pets: CACHORRO, GATO, PASSARO, PEIXE, ROEDOR, REPTIL
  - Funcionários:  BANHISTA, TOSADOR, VETERINARIO, ATENDENTE
---
## 🛠️ Funcionalidades
- Cadastro, listagem e exclusão de clientes, pets e funcionários
- Uso de DTOs para transferência de dados entre camadas
- Validação automática dos dados via Bean Validation
- Tratamento global de exceções com mensagens claras de erro
- Uso de banco em memória H2 para facilitar testes locais
## 👨‍💻 Autor
- Feito por **José Wendel**

