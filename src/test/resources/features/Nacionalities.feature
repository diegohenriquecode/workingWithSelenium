#language: pt
#Version: 1.0
#Author: Diego Henrique
#Encoding: UTF-8
@Nacionalities @Regressivo
Funcionalidade: Nacionalities

  Contexto: 
    Dado que o usuario esteja na pagina de login
    E o usuario inputar as credenciais na pagina
      | user    | password |
      | Admin   | admin123 |

	@IncluirNacionalidade
  Cenario: Cadastrar Nacionalidade
    Dado que o usuario esteja na pagina Nacionalities
    E a nacionalitie "Brasileira" nao exista
    Quando adicionar a nacionalitie "Brasileira"
    Entao a nacionalidade sera exibida na lista
#
  #Cenario: Cadastrar Nacionalidade já cadastrada
    #Dado que o usuario esteja na pagina Nacionalities
    #Quando adicionar a nacionalitie "Brasileira"
    #Entao exibira a mensagem para a nacionalitie "Already exists"
#
  #Cenario: Excluir Nacionalitie
    #Dado que o usuario esteja na pagina Nacionalities
    #E a nacionalitie "Brasileira" nao exista
    #Entao exibira a mensagem para a nacionalitie "Already exists"
