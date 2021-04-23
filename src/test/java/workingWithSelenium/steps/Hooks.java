package workingWithSelenium.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import workingWithSelenium.util.Navegacao;

public class Hooks {

	@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Iniciando a execução do Teste: " + scenario.getName());

	}

	@After
	public void afterScenario(Scenario scenario) {
		System.out.println("Finalizando a execução do Teste: " + scenario.getName());
		Navegacao.quitDriver();
	}
	
}