#language: pt
#Version: 1.0
#Author: Adilson Ferreira
#Encoding: UTF-8
@Login @OrangeHRM
Funcionalidade: Login

  @LoginSucesso
  Cenario: Login com sucesso no Orange HRM
    Dado que o usuario esteja na pagina de login
    Quando o usuario inputar as credenciais na pagina
      | usuario | senha    |
      | Admin   | admin123 |
    Então o usuario deve acessar a pagina inicial do Orange HRM
