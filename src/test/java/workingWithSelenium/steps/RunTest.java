package workingWithSelenium.steps;

import org.junit.runner.RunWith;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, snippets = SnippetType.CAMELCASE, plugin = {
		"json:target/surefire-reports/cucumber.json" }, 
        glue = "br.com.jumptreinamentos.selenium_test.steps", 
        features = {".\\src\\test\\resources\\features\\" }, 
        tags = {"@Login" }, stepNotifications = true, 
        dryRun = false)
public class RunTest {
}

}
