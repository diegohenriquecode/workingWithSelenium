#language: pt
#Version: 1.0
#Author: Diego Henrique
#Encoding: UTF-8
@Login @OrangeHRM
Funcionalidade: Login
#LEMBRAR QUE EU USO OS CAMPOS COM NOME EM INGLÊS
  @LoginSucesso
  Cenario: Login com sucesso no Orange HRM
    Dado que o usuario esteja na pagina de login
    Quando o usuario inputar as credenciais na pagina
      |	user	|	password	|
      |	Admin	|	admin123	|
    Entao o usuario deve acessar a pagina inicial do Orange HRM

	@InvalidLogin
	Cenario: Login invalido no Orange HRM
		Dado que o usuario esteja na pagina de login
		Quando o usuario inputar as credenciais na pagina
			|	user	|	password 	|
			|	Admina| admina123	|
		Entao o usuario deve permanecer na pagina de login