package workingWithSelenium;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, snippets = SnippetType.CAMELCASE, plugin = {
		"json:target/surefire-reports/cucumber.json" }, 
        glue = "workingWithSelenium.steps", 
        features = {".//src//test//resources//features//" }, 
        tags = "@IncluirNacionalidade" , stepNotifications = true, 
        dryRun = false)
public class RunTest {
}

