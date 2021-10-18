package Pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContentNotification {
private static WebElement element = null;
	
	public static void login(WebDriver driver) {
		DashboardLogin.testbox_username(driver).click();
		DashboardLogin.testbox_username(driver).sendKeys("inmobly-admin");
		DashboardLogin.testbox_password(driver).click();
		DashboardLogin.testbox_password(driver).sendKeys("support123456");
		DashboardLogin.button_signin(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String msg = DashboardLogin.button_inmobly_app(driver).getText();
		assertEquals(msg, "Inmobly App");
	}
	
	public static WebElement menubutton_content(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"contentMenu\"]/a"));
		return element;
	}
	
	public static WebElement menubutton_notification(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"contentMenu\"]/ul/li[8]/a"));
		return element;
	}
	
	//Text Notification functions
	public static WebElement button_text_notification(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/ng-component/div/div[2]/div/div/ul/li[2]/a"));
		return element;
	}
	
	public static void dropdown_select_text_profile(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"Text-Notification\"]/form/div[1]/div/div[1]/select")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"Text-Notification\"]/form/div[1]/div/div[1]/select")));
		selection.selectByVisibleText(name);	
	}
	
	public static WebElement text_box_text_title(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"textTitle\"]"));
		return element;
	}
	
	public static WebElement text_box_text_description(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"textDescription\"]"));
		return element;
	}
	
	public static WebElement text_box_text_link(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"textLink\"]"));
		return element;
	}
	
	public static WebElement button_text_push(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"Text-Notification\"]/form/div[2]/button"));
		return element;
	}
	
	//Video Notification functions
		public static WebElement button_video_notification(WebDriver driver) {
			element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/ng-component/div/div[2]/div/div/ul/li[1]/a"));
			return element;
		}
}
