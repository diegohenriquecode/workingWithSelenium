package workingWithSelenium;

import workingWithSelenium.pagepbjects.LoginPage;
import workingWithSelenium.pagepbjects.UsersPanelPage;

public class UsersPanelPageExample {

	public static void main(String[] args) {
		LoginPage login= new LoginPage();
		login.toLoginPage();
		login.loginAuthenticate("Admin", "admin123");
		
		UsersPanelPage usersPanel= new UsersPanelPage();
		usersPanel.setUserMenu();
		usersPanel.searchUser("Anthony.Nolan");
		
	}
	
}
