<h1>🩺Clínica Spring Security</h1>
<p>Sistema Web com Spring Boot e Spring Security que simula uma clínica médica.</p>
<p>Esse projeto foi desenvolvido durante o curso "Spring Boot & MVC com Spring Security" ministrado pelo Marcio Ballem, disponível na Udemy.
Tem como objetivo simular uma aplicação de um site de uma clínca médica, onde possui 3 perfis de usuários: admin, médico e paciente, sendo que admin também pode ter o 
perfil de médico</p>

<h3>📝Requisitos</h3>

- [x] CRUD de usuarios<br>
- [x] CRUD especialidades<br>
- [x] CRUD de consultas agendadas(apenas pacientes podem deletar as consultas agendadas)<br>
- [x] Editar senha<br>
- [x] Autenticação baseada em login e senha<br>
- [x] Autorização baseado em lista de perfis(Cada perfil possui um menu)<br>
- [x] Envio de e-mail para confirmação de cadastro e recuperação de senha(codigo de verificação)<br>
- [x] Não permitir logins simultâneos em diferentes dispositivos para um mesmo usuário<br>

<h3>📝Requisitos Administrador</h3>

- [x] Cadastrar paciente, médico ou outros admins
- [x] Cadastrar todas as especialidades médicas
- [x] Manipulação de alguns dados pacientes e medicos

<h3>📝Requisitos Médico</h3>

- [x] Cadastro de dados pessoais e suas especialidades<br>
- [x] Vizualizar consultas agendadas por pacientes<br>

<h3>📝Requisitos Paciente</h3>

- [x] Cadastro de dados pessoais<br>
- [x] Agendar consultas: escolher médico, área de especialidade, data e horário da consulta<br>
- [x] historico de consultas paciente<br>

<div align="center">
  <h4>🏠Página Inicial</h4>
  <img src="https://github.com/nathaliafelix31/clinica-security/assets/55997404/d603bed1-6249-44cb-929f-966835c1bd8a" width="700px"></div>

<div align="center">
  <h4>🔐Página de Login</h4>
  <img src="https://github.com/nathaliafelix31/clinica-security/assets/55997404/fe24dbcb-6644-4e12-b38f-f28734c1dabd" width="700px"></div>



<h3>⚙Tecnologias Utilizadas</h3>

- Java
- Spring Boot 3
- Spring Security 6
- Servlet
- SQL e HQL/JPQL
- Hibernate e JPA
- HTML, CSS e Bootstrap
- JavaScript, jQuery
- Ajax
