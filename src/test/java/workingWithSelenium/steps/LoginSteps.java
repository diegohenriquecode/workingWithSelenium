package workingWithSelenium.steps;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import workingWithSelenium.pageobjects.HomePage;
import workingWithSelenium.pageobjects.LoginPage;

public class LoginSteps {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Dado("^que o usuario esteja na pagina de login$")
	public void queOUsuarioEstejaNaPaginaDeLogin() {
		loginPage.toLoginPage();
	}

	@Quando("^o usuario inputar as credenciais na pagina$")
	public void oUsuarioInputarAsCredenciaisNaPAgina(DataTable data) {
		for (Map<Object, Object> map : data.asMaps(String.class, String.class)) {
			loginPage.loginAuthenticate(map.get("user").toString(), map.get("password").toString());
		}
	}

	@Entao("^o usuario deve acessar a pagina inicial do Orange HRM$")
	public void oUsuarioDeveAcessarAPaginaInicialDoOrangeHRM() {
		homePage.successHomePageRedirect();
	}


	@Entao("o usuario deve permanecer na pagina de login")
	public void oUsuarioDevePermanecerNaPaginaDeLogin() {
		loginPage.checkInvalidCredentialsMessage();
	}

}
