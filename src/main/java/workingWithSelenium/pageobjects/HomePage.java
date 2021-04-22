package workingWithSelenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class HomePage extends BasePage {
	
	private By QuickLaunchPanel = By.xpath("//tbody/tr[1]/td[3]/div[1]/a[1]/img[1]"); 
	private By AdminMenuOption = By.xpath("//a[@id='menu_admin_viewAdminModule']"); 
	
	Actions action = new Actions(this.driver);

	public void successHomePageRedirect() {
		Assert.assertTrue(driver.findElement(QuickLaunchPanel).isDisplayed());
	}
	
	public void acessAdminMenu() {
//		driver.findElement(AdminMenuOption).click();
			action.click(driver.findElement(AdminMenuOption)).perform();
	}
	
}
