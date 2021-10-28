package Tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentProfiles;

public class ContentProfilesTest {
	
static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
		ContentProfiles.login(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ContentProfiles.menubutton_content)).click();
		driver.findElement(By.xpath(ContentProfiles.menubutton_profiles)).click();
	}
	
	//cancels it after testing the features
	/*@Test
	public static void add_new_profile_test() {
		driver.findElement(By.xpath(ContentProfiles.button_new_profile)).click();
		ContentProfiles.add_new_profile(driver, "Tester Profile");
		//ContentProfiles.cancel_new_profile(driver, "Profile");
	}*/
			
	/*@Test
	public static void edit_profile_test() {
		ContentProfiles.button_edit_profile(driver, "Sport");
		ContentProfiles.button_cancel_edit_profile(driver, "Sport");
	}*/
	
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}

}
