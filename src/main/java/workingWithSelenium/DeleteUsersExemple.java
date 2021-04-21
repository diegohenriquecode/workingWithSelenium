package workingWithSelenium;

import workingWithSelenium.pagepbjects.DeleteUsersPage;
import workingWithSelenium.pagepbjects.LoginPage;
import workingWithSelenium.pagepbjects.UsersPanelPage;

public class DeleteUsersExemple {
	public static void main(String[] args) {
		LoginPage login = new LoginPage();
		login.toLoginPage();
		login.loginAuthenticate("Admin", "admin123");
		
		UsersPanelPage usersPanel= new UsersPanelPage();
		usersPanel.setUserMenu();
		usersPanel.searchUser("Anthony.Nolan");
		
		DeleteUsersPage deleteUsers = new DeleteUsersPage();
		deleteUsers.getCheckboxUser();
		deleteUsers.clickDeleteButton();
		deleteUsers.clickConfirmDeleteButton();
	}
}
