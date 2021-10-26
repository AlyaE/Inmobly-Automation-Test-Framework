package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentLists;
import Pages.ContentNotification;

public class ContentNotificationTest {
private static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	//creates then cancels adding list
	@Test
	public static void create_new_text_notification_test() {
		ContentNotification.login(driver);
		ContentNotification.menubutton_content(driver).click();
		ContentNotification.menubutton_notification(driver).click();
		ContentNotification.button_text_notification(driver).click();
		ContentNotification.dropdown_select_text_profile(driver, "Family");
		ContentNotification.text_box_text_title(driver).click();
		ContentNotification.text_box_text_title(driver).clear();
		ContentNotification.text_box_text_title(driver).sendKeys("New Content!");
		ContentNotification.text_box_text_description(driver).click();
		ContentNotification.text_box_text_description(driver).clear();
		ContentNotification.text_box_text_description(driver).sendKeys("Description of new content\n more content\n more content");
		ContentNotification.text_box_text_link(driver).click();
		ContentNotification.text_box_text_link(driver).clear();
		ContentNotification.text_box_text_link(driver).sendKeys("https://www.google.com/");
		
	}
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
