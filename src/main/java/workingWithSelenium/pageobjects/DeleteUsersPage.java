package workingWithSelenium.pageobjects;

import org.openqa.selenium.By;

public class DeleteUsersPage extends BasePage {
	
	private By checkboxUser = By.xpath("//thead/tr[1]/th[1]");
	private By deleteUserButton = By.id("btnDelete");
	private By confirmDeleteButton = By.id("dialogDeleteBtn");
	
	public void getCheckboxUser() {
		driver.findElement(checkboxUser).click();
	}
	
	public void clickDeleteButton() {
		driver.findElement(deleteUserButton).click();
	}
	
	public void clickConfirmDeleteButton() {
		driver.findElement(confirmDeleteButton).click();
	}
	
}
