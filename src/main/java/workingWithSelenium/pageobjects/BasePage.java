package workingWithSelenium.pageobjects;
import workingWithSelenium.util.Navegacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BasePage {
	WebDriver driver = Navegacao.getChromeDriver();
	
	public WebElement getElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement getElementByCssSelector(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));
	}
	
	public WebElement getElementById(String id) {
		return driver.findElement(By.id(id));
	}

}
