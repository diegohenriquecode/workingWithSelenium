package workingWithSelenium.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import workingWithSelenium.pagepbjects.HomePage;
import workingWithSelenium.pagepbjects.NacionalitiePage;

public class NacionalitiesSteps {
	HomePage homePage = new HomePage();
	NacionalitiePage nacionalitiesPage = new NacionalitiePage();

	@Dado("^que o usuario esteja na pagina Nacionalities$")
	public void queOUsuarioEstejaNaPaginaNacionalities() throws Throwable {
		homePage.acessAdminMenu();
		nacionalitiesPage.acessaOpcaoMenuNacionalities();
	}

	@Quando("^adicionar a nacionalitie \"([^\"]*)\"$")
	public void adicionarANacionalitie(String nacionalitie) throws Throwable {
		nacionalitiesPage.cadastraNacionalitie(nacionalitie);
	}

	@Entao("^a nacionalidade sera exibida na lista$")
	public void aNacionalidadeSeraExibidaNaLista() throws Throwable {
		nacionalitiesPage.verificaNacionalidadeCadastrada();
	}

	@Dado("a nacionalitie {string} nao exista")
	public void aNacionalitieNaoExista(String nacionalidade) {
		nacionalitiesPage.validaNacionalidadeNaoExistenteNaLista(nacionalidade);
	}
}

