# 🚀 Sistema de Autenticação com Spring Boot

Este é um projeto de autenticação de usuários desenvolvido com Spring Boot, Spring Security, envio de e-mails via SMTP e integração com DataTables para exibição dinâmica de dados.
  <hr>
  
  Login Page with /login  <hr>

  
  ![login](https://github.com/user-attachments/assets/758462b9-1c9e-44d3-8c1e-efcb73444537)


<hr>

Register Page /cadastro with e-mail, password and repeat password fields

<hr>

![register](https://github.com/user-attachments/assets/84268f78-5410-4713-85ec-0375445ca24a)



<hr>

After Register your will receive an e-mail for confirmation

<hr>



![after-register-verification](https://github.com/user-attachments/assets/88747f4b-73c8-4e64-a4d7-daff64e6de85)


<hr>

You need confirmation your account

<hr>

![template-cadastro-verification](https://github.com/user-attachments/assets/2fd28088-54ef-4222-b809-6c375a4ac197)


<hr>


Registration active, you are ready to enter

<hr>

![after-verification-register-can-login](https://github.com/user-attachments/assets/f3b73aa6-87b0-4ab6-a6a1-f9442e07ff4e)

<hr>

Password recovery function, enter your e-mail
 
<hr>

![forget-password-email](https://github.com/user-attachments/assets/d6f56858-c7cc-4244-862c-a2e8e55c8906)

<hr>

After entering your email you will receive a template in your email with a code to change your password

<hr>

![code-for-enter-with-new-password](https://github.com/user-attachments/assets/6f56e53e-18cf-4f9e-924c-8559955a4aae)

<hr>


Then enter your email, your new password and the code you received in your email.

<hr>

![enter-a-new-password-with-code](https://github.com/user-attachments/assets/4e245109-47af-4ff3-a0f7-6b1511244c7c)

<hr>


Ready!!! Password changed successfully

<hr>

![already-password-reset-success](https://github.com/user-attachments/assets/a2cbf540-cb35-482c-bc9f-1a5a862925e3)




## 🛠 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3** (Spring MVC, Spring Security, Spring Mail, Spring Validation)
- **Thymeleaf**
- **Banco de Dados MySQL**
- **JPA/Hibernate** para manipulação de dados
- **Protocolo SMTP** para envio de e-mails
- **DataTables** para exibição interativa dos dados na interface
- **Docker** para containerização

## 📌 Funcionalidades
✅ Cadastro de usuários com perfis (ADMIN e USUARIO)
✅ Proteção de rotas com Spring Security
✅ Envio de e-mails automáticos via SMTP
✅ Listagem de dados dinâmica com DataTables
✅ Spring MVC
✅ Suporte a Docker para deploy facilitado

## 🚀 Como Rodar o Projeto

### 🔹 Requisitos
- **Java 17**
- **Maven**
- **MySQL**
- **Docker** (opcional)

### 🔹 Configuração do Banco de Dados
Crie um banco de dados no MySQL:
```sql
CREATE DATABASE sistema_autenticacao;
```
Altere o arquivo `application.properties` para definir as credenciais do banco:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sistema_autenticacao
spring.datasource.username=root
spring.datasource.password=senha
```

### 🔹 Configuração do Envio de E-mails (SMTP)
Atualize o `application.properties` com os dados do servidor SMTP:
```properties
spring.mail.host=smtp.seuprovedor.com
spring.mail.port=587
spring.mail.username=seuemail@dominio.com
spring.mail.password=suasenha
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### 🔹 Executando o Projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/sistema-autenticacao.git
   cd sistema-autenticacao
   ```
2. Compile e execute o projeto com Maven:
   ```bash
   mvn spring-boot:run
   ```
3. Acesse a API via Postman ou navegador: `http://localhost:8080`

### 🔹 Executando com Docker
Caso prefira usar Docker:
```bash
docker-compose up -d
```

## 🔑 Endpoints Principais
| Método | Endpoint         | Descrição |
|---------|----------------|-------------|
| POST    | /auth/register | Cadastro de usuário |
| POST    | /auth/login    | Autenticação e geração de token |
| GET     | /users         | Lista todos os usuários (ADMIN) |

## 🎨 Interface Web com DataTables
A interface conta com a biblioteca DataTables para exibição dinâmica de usuários, com ordenação, busca e paginação.

## 🤝 Contribuição
Sinta-se à vontade para contribuir com melhorias! Basta seguir os passos:
1. Fork o repositório
2. Crie uma branch (`feature-novidade`)
3. Commit suas mudanças (`git commit -m "Adiciona nova funcionalidade"`)
4. Push para o branch (`git push origin feature-novidade`)
5. Abra um Pull Request

## 📜 Licença
Este projeto está sob a licença MIT - veja o arquivo `LICENSE` para mais detalhes.

---
💻 Desenvolvido por [Jorge Matheus](https://github.com/Jorge-Matheus) 🚀

