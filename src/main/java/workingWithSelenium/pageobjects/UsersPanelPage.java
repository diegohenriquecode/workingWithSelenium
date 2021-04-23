package workingWithSelenium.pageobjects;

import org.openqa.selenium.By;

public class UsersPanelPage extends BasePage {
	
	private By userNameField = By.id("searchSystemUser_userName");
	private By searchButton = By.id("searchBtn");
	private By usersManagmentMainMenu = By.id("menu_admin_UserManagement");
	private By usersMenu = By.id("menu_admin_viewSystemUsers");
	
	public void setUserMenu() {
		driver.findElement(usersManagmentMainMenu).click();
		driver.findElement(usersMenu).click();
	}
	
	public void searchUser(String username) {
		driver.findElement(userNameField).sendKeys(username);
		driver.findElement(searchButton).click();
	}
	
}
