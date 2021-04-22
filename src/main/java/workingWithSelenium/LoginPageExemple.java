package workingWithSelenium;

import workingWithSelenium.pageobjects.LoginPage;

public class LoginPageExemple {
	public static void main(String[] args) {
		LoginPage login = new LoginPage();
		
		login.toLoginPage();
		login.loginAuthenticate("Admin", "admin123");
		
	}
}
