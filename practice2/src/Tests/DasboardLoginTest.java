package Tests;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.DashboardLogin;

public class DasboardLoginTest {

	static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
	}
	
	@Test
	public static void Login() {
		DashboardLogin.testbox_username(driver).click();
		DashboardLogin.testbox_username(driver).sendKeys("inmobly-admin");
		DashboardLogin.testbox_password(driver).click();
		DashboardLogin.testbox_password(driver).sendKeys("support123456");
		DashboardLogin.button_signin(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String msg = DashboardLogin.button_inmobly_app(driver).getText();
		assertEquals(msg, "Inmobly App");
	}
	
	@AfterTest
	public static void teardown() {
		driver.close();
	}
}
