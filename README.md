# Configuração do Ambiente para um Projeto Spring com MySQL

Este documento fornece instruções para configurar um ambiente de desenvolvimento usando IntelliJ IDEA, criar um projeto Spring, importar um projeto do GitHub e configurar um banco de dados MySQL a partir de um arquivo de migration.

---

## Pré-requisitos

Antes de iniciar, certifique-se de ter os seguintes programas instalados no seu computador:

- **Java JDK 17 ou superior**  
  [Download do JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

- **IntelliJ IDEA**  
  [Download do IntelliJ IDEA Community/Ultimate](https://www.jetbrains.com/idea/download/)

- **MySQL**  
  [Download do MySQL](https://dev.mysql.com/downloads/installer/)

- **Git**  
  [Download do Git](https://git-scm.com/)

---

## 1. Baixar e Configurar o IntelliJ IDEA

1. Acesse o site oficial do IntelliJ IDEA e faça o download da versão desejada (Community ou Ultimate).  
   - **Community**: Gratuita, ideal para iniciantes.  
   - **Ultimate**: Pago, mas oferece mais recursos para desenvolvimento web.  

2. Instale o IntelliJ seguindo o assistente de instalação.

3. Após a instalação, abra o IntelliJ e configure o **JDK**:  
   - Vá em File > Project Structure > SDKs.  
   - Clique em +, selecione o diretório onde o JDK foi instalado e adicione-o.

---

## 2. Criar um Projeto Spring Boot

1. No IntelliJ, clique em **"New Project"**.

2. Escolha **Spring Initializr** como modelo de projeto.

3. Configure os seguintes detalhes:
   - **Project SDK**: Selecione o JDK instalado.
   - **Language**: Java.  
   - **Build System**: Maven.  
   - **Group**: com.seuprojeto.  
   - **Artifact**: projeto.  

4. Clique em "Next" e selecione as seguintes dependências:
   - **Spring Web**
   - **Spring Data JPA**
   - **MySQL Driver**
   - **Spring Boot DevTools** (opcional, mas recomendado)
   - **Flyway Migration** (para configurar migrations)

5. Clique em "Finish" e o IntelliJ criará o esqueleto do seu projeto.

---

## 3. Importar um Projeto do GitHub

1. Abra o IntelliJ IDEA.

2. Clique em **"Get from Version Control"**.

3. Cole a URL do repositório GitHub (por exemplo: https://github.com/usuario/repositorio.git).

4. Clique em **"Clone"** e aguarde o IntelliJ importar o projeto.

5. Verifique se as dependências estão sincronizadas corretamente:  
   - Vá até o arquivo pom.xml e clique em **"Load Maven Changes"** (ícone do elefante na barra superior).

---

## 4. Configurar o Banco de Dados MySQL

### 4.1 Criar o Banco de Dados no MySQL

1. Abra o MySQL Workbench ou o terminal MySQL.

2. Crie o banco de dados com o comando:
   
sql
   CREATE DATABASE nome_do_banco;
## 5. Atualize as credenciais de conexão no arquivo **application.properties** ou **application.yml** do projeto:
--- 
### 5.1 **application.properties**:

```
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true

```
### 5.2 **application.yml**

spring:

  datasource:
  
    url: jdbc:mysql://localhost:3306/nome_do_banco
    username: seu_usuario
    password: sua_senha
    
  jpa:
  
    hibernate:
      ddl-auto: none
    show-sql: true
---
## 6. Executar o Projeto

Execute o projeto no IntelliJ:

Clique com o botão direito em ProjetoApplication.java (classe principal do Spring Boot).
Selecione Run 'ProjetoApplication'.
Verifique os logs para garantir que a aplicação está conectada ao banco de dados e que as migrations foram aplicadas corretamente.

Acesse a aplicação no navegador em http://localhost:8080.

---
## 7. Problemas comuns:
### 7.1 Erro no arquivo migration:

Podo ocorrer de o banco não ser criado ou não ser posssível executar o arquivo migration manualmente, caso isso ocorra, confirme no arquivo **pom.xml** se as dependências do projeto foram devidamente instaladas, caso não, selecione a opção de atualizar e instalar 
as dependências:
![image](https://github.com/user-attachments/assets/d6d982d2-2323-498f-876f-33e2451176ce)


---
## 8. Contato
Em caso de dúvida, fico a disposição:

natan90125@gmail.com

natan.alcantara@unesp.com




