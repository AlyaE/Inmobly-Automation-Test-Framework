package UseCaseTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentNotification;

public class CreateVideoNotificationTest {
private static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentNotification.login(driver);
		driver.findElement(By.xpath(ContentNotification.menubutton_content)).click();
		driver.findElement(By.xpath(ContentNotification.menubutton_notification)).click();
	}
	
	//creates then cancels adding list
	@Test
	public static void create_new_text_notification_test() {
		driver.findElement(By.xpath(ContentNotification.button_video_notification)).click();
		ContentNotification.dropdown_select_video_profile(driver, "Family");
		driver.findElement(By.xpath(ContentNotification.textbox_video_title)).click();
		driver.findElement(By.xpath(ContentNotification.textbox_video_title)).clear();
		driver.findElement(By.xpath(ContentNotification.textbox_video_title)).sendKeys("New Content!");
		driver.findElement(By.xpath(ContentNotification.textbox_video_description)).click();
		driver.findElement(By.xpath(ContentNotification.textbox_video_description)).clear();
		driver.findElement(By.xpath(ContentNotification.textbox_video_description)).sendKeys("New Content!\nMore Content!\nMore Content!\n");
		
	}
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
