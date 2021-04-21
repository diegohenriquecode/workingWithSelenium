package workingWithSelenium;

import workingWithSelenium.pagepbjects.LoginPage;

public class LoginPageExemple {
	public static void main(String[] args) {
		LoginPage login = new LoginPage();
		
		login.toLoginPage();
		login.loginAuthenticate("Admin", "admin123");
		
	}
}
