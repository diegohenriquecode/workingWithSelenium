package workingWithSelenium.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import workingWithSelenium.pageobjects.HomePage;
import workingWithSelenium.pageobjects.NacionalitiePage;

public class NacionalitiesSteps {
	HomePage homePage = new HomePage();
	NacionalitiePage nacionalitiesPage = new NacionalitiePage();

	@Dado("^que o usuario esteja na pagina Nacionalities$")
	public void queOUsuarioEstejaNaPaginaNacionalities() throws Throwable {
		homePage.acessAdminMenu();
		nacionalitiesPage.acessaOpcaoMenuNacionalities();
	}
	
	@Dado("a nacionalitie {string} nao exista")
	public void aNacionalitieNaoExista(String nacionalidade) {
		nacionalitiesPage.validaNacionalidadeNaoExistenteNaLista(nacionalidade);
	}
	
	@Quando("^adicionar a nacionalitie \"([^\"]*)\"$")
	public void adicionarANacionalitie(String nacionalitie) throws Throwable {
		nacionalitiesPage.cadastraNacionalitie(nacionalitie);
	}

	@Entao("^a nacionalidade sera exibida na lista$")
	public void aNacionalidadeSeraExibidaNaLista() throws Throwable {
		nacionalitiesPage.verificaNacionalidadeCadastrada();
	}
	
	@Entao("exibir a mensagem para a nacionalitie {string}")
	public void exibirAMensagemParaANacionalitie(String nationality) {
	   nacionalitiesPage.getNationalityAlreadyExistd(nationality);
	}
}

