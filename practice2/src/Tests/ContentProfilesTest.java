package Tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

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
		driver.get("https://ott.bolt-play.com/login");
	}
	
	@Test
	public static void add_new_profile_test() {
		ContentProfiles.login(driver);
		ContentProfiles.button_new_profile(driver).click();
		//needs find_profile_Movies_test to work
	}
	
	@Test
	public static void find_profile_Movies_test() {
		ContentProfiles.login(driver);
		ContentProfiles.menubutton_content(driver).click();
		ContentProfiles.menubutton_profiles(driver).click();
		String msg = ContentProfiles.find_profile(driver, "Music").getText();
		System.out.print("msg is " + msg);
		assertEquals(msg, "Music");
		
	}
	
	@AfterTest
	public static void teardown() {
		driver.close();
	}

}
