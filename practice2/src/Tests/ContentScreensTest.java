package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentLists;
import Pages.ContentScreens;

public class ContentScreensTest {

	private static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//navigate to Screens page
		ContentScreens.login(driver);
		driver.findElement(By.xpath(ContentScreens.menubutton_content)).click();
		driver.findElement(By.xpath(ContentScreens.menubutton_screens)).click();
	}
	

	@Test
	public static void create_new_screen_test() {
		driver.findElement(By.xpath(ContentScreens.button_new_screens)).click();
		
		//change name of screen
		driver.findElement(By.xpath(ContentScreens.button_new_screens_change_name)).click();
		driver.findElement(By.xpath(ContentScreens.textbox_new_screens_row_name)).click();
		driver.findElement(By.xpath(ContentScreens.textbox_new_screens_row_name)).clear();
		driver.findElement(By.xpath(ContentScreens.textbox_new_screens_row_name)).sendKeys("Screen 1");
		driver.findElement(By.xpath(ContentScreens.button_new_screens_row_name_save)).click();
		driver.findElement(By.xpath(ContentScreens.button_new_screens_new_row)).click();
		driver.findElement(By.xpath(ContentScreens.button_new_screens_new_theme)).click();
		ContentScreens.button_theme_minimize(driver, "Theme no. 1");
		
	}
	
	@AfterSuite
	public static void teardown() {
		//driver.close();
	}
}
