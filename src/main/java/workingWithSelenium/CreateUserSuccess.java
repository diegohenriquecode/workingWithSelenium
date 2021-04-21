package workingWithSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateUserSuccess {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//src//main//resources//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//Daqui pra baixo eu que fiz
//		driver.findElement(By.id("menu_admin_UserManagement")).click();
//		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
//		driver.findElement(By.id("btnAdd")).click();
//		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Alice Duval");
//		driver.findElement(By.id("systemUser_userName")).sendKeys("Diego Henrique");
//		driver.findElement(By.id("systemUser_password")).sendKeys("Amesmadoface@10");
//		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("Amesmadoface@10");
//		driver.findElement(By.id("btnSave")).click();
//		driver.findElement(By.id("btnSave")).click();
//		driver.quit();
		
		//Deletando um usuário
		driver.findElement(By.xpath("//td/input[contains(.,'Diego Henrique')]")).click();
		driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
	}
	
}