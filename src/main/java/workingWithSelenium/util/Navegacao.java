package workingWithSelenium.util;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navegacao {
	
	public static WebDriver driver = null;

	@BeforeClass
	public static WebDriver getChromeDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}

	@AfterClass
	public static void quitDriver() {
//		if (driver != null) {
//			driver.quit();
//			driver = null;
//		}
		driver.quit();
	}
}
