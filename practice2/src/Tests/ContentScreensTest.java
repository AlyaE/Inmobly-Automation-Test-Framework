package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentScreens;

public class ContentScreensTest {

	private static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
	}
	

	@Test
	public static void create_new_screen_test() {
		ContentScreens.login(driver);
		ContentScreens.menubutton_content(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentScreens.menubutton_screens(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentScreens.button_new_screens(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//change name of screen
		ContentScreens.button_new_screens_change_name(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentScreens.textbox_new_screens_row_name(driver).click();
		ContentScreens.textbox_new_screens_row_name(driver).clear();
		ContentScreens.textbox_new_screens_row_name(driver).sendKeys("Screen 1");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentScreens.button_new_screens_row_name_save(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		ContentScreens.button_new_screens_new_row(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//*[@id="styleModal"]/div/div/div[2]/div/div[1]/span/img
		//*[@id="styleModal"]/div/div/div[2]/div/div[2]/span/img
		//*[@id="styleModal"]/div/div/div[2]/div/div[1]/label/input
	}
	
	@AfterSuite
	public static void teardown() {
		//driver.close();
	}
}
