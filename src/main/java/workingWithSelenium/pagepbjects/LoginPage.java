package workingWithSelenium.pagepbjects;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	private String userNameField = "//input[@id='txtUsername']";
	private String passwordField = "#txtPassword";
	private String loginButton = "btnLogin";

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
		driver.navigate().
		to("https://opensource-demo.orangehrmlive.com/index.php/admin/saveSystemUser");
	}

}
