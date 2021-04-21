#language: pt
#Version: 1.0
#Author: Adilson Ferreira
#Encoding: UTF-8
@Login @OrangeHRM
Funcionalidade: Login
#LEMBRAR QUE EU USO OS CAMPOS COM NOME EM INGLÊS
  @LoginSucesso
  Cenario: Login com sucesso no Orange HRM
    Dado que o usuario esteja na pagina de login
    Quando o usuario inputar as credenciais na pagina
      | user    | password |
      | Admin   | admin123 |
    Entao o usuario deve acessar a pagina inicial do Orange HRM
