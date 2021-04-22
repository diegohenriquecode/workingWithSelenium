package workingWithSelenium.pageobjects;

import org.junit.Assert;

public class NacionalitiePage extends BasePage {

	private String nacionalidade = "";

	private String opcaoMenuNacionalities = "//*[@id='menu_admin_nationality']";
	private String botaoAddNacionalitie = "//*[@id='btnAdd']";
	private String inputNameNacionalitie = "//*[@id='nationality_name']";
	private String botaoSaveNacionalitie = "//*[@id='btnSave']";
	private String opcaoNaLista = "//*[@id='resultTable']//td/a[contains(.,'" + nacionalidade + "')]";
	private String labelNacionalitieCadastrada = "//*[@id='frmNationality']/fieldset/ol/li[1]/span";

	public void acessaOpcaoMenuNacionalities() {
		getElementByXpath(opcaoMenuNacionalities).click();
	}

	public void cadastraNacionalitie(String nacionalitie) {
		nacionalidade = nacionalitie;
		getElementByXpath(botaoAddNacionalitie).click();
		getElementByXpath(inputNameNacionalitie).sendKeys(nacionalitie);
		getElementByXpath(botaoSaveNacionalitie).click();
	}

	public void verificaNacionalidadeCadastrada() {
		Assert.assertTrue(getElementByXpath(opcaoNaLista).isDisplayed());
	}
	
	public void validaLabelNacionalitieExistente(String mensagem) {
		Assert.assertTrue(getElementByXpath(labelNacionalitieCadastrada).getText().equals(mensagem));
	}
	public void validaNacionalidadeNaoExistenteNaLista(String nacio) {
		this.nacionalidade = nacio;
		boolean existe = true;
		try {
			existe = getElementByXpath(opcaoNaLista.replace("''", "'" + nacio + "'")).isDisplayed();
		} catch (Exception e) {
			existe = false;
		}
		Assert.assertFalse("Nacionalitie [ " + nacio + " ] já cadastrada", existe);
	}
}