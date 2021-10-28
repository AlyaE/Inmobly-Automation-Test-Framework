package UseCaseTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentNotification;

public class CreateTextNotificationTest {
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
		driver.findElement(By.xpath(ContentNotification.button_text_notification)).click();
		ContentNotification.dropdown_select_text_profile(driver, "Family");
		driver.findElement(By.xpath(ContentNotification.textbox_text_title)).click();
		driver.findElement(By.xpath(ContentNotification.textbox_text_title)).clear();
		driver.findElement(By.xpath(ContentNotification.textbox_text_title)).sendKeys("New Content!");
		driver.findElement(By.xpath(ContentNotification.textbox_text_description)).click();
		driver.findElement(By.xpath(ContentNotification.textbox_text_description)).clear();
		driver.findElement(By.xpath(ContentNotification.textbox_text_description)).sendKeys("New Content!\nMore Content!\nMore Content!\n");
		driver.findElement(By.xpath(ContentNotification.textbox_text_link)).click();
		driver.findElement(By.xpath(ContentNotification.textbox_text_link)).clear();
		driver.findElement(By.xpath(ContentNotification.textbox_text_link)).sendKeys("https://www.google.com/");
		
	}
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
