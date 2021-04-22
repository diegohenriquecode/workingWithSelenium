package workingWithSelenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	private String userNameField = "//input[@id='txtUsername']";
	private String passwordField = "#txtPassword";
	private String loginButton = "btnLogin";
	private By invalidCredential = By.id("spanMessage");
	// span[contains(,."Invalid credentials")]

	public WebElement getNameField() {
		return getElementByXpath(userNameField);
	}

	public WebElement getPasswordField() {
		return getElementByCssSelector(passwordField);
	}

	public WebElement getLoginButton() {
		return getElementById(loginButton);
	}

	public void loginAuthenticate(String user, String password) {
		getNameField().sendKeys(user);
		getPasswordField().sendKeys(password);
		getLoginButton().click();
	}

	public void toLoginPage() {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUser");
	}

	public WebElement getInavlidCredentialsMessage() {
		return driver.findElement(invalidCredential);
	}

	public void checkInvalidCredentialsMessage() {
		Assert.assertTrue(getInavlidCredentialsMessage().isDisplayed());
	}

}
