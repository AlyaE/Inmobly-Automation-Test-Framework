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
		driver.findElement(By.xpath(DashboardLogin.textbox_username)).click();
		driver.findElement(By.xpath(DashboardLogin.textbox_username)).sendKeys("inmobly-admin");
		driver.findElement(By.xpath(DashboardLogin.testbox_password)).click();
		driver.findElement(By.xpath(DashboardLogin.testbox_password)).sendKeys("support123456");
		driver.findElement(By.xpath(DashboardLogin.button_signin)).click();
		String msg = driver.findElement(By.xpath(DashboardLogin.button_inmobly_app)).getText();
		assertEquals(msg, "Inmobly App");
	}
	
	public static String menubutton_content = "//*[@id=\"contentMenu\"]/a";
	public static String menubutton_notification = "//*[@id=\"contentMenu\"]/ul/li[8]/a";

	
	//Text Notification functions
	public static String button_text_notification = "/html/body/app-root/div/div/div[2]/div/ng-component/div/div[2]/div/div/ul/li[2]/a";
	public static String textbox_text_title = "//*[@id=\"textTitle\"]";
	public static String textbox_text_description = "//*[@id=\"textDescription\"]";
	public static String textbox_text_link = "//*[@id=\"textLink\"]";
	public static String button_text_push = "//*[@id=\"Text-Notification\"]/form/div[2]/button";
	
	public static void dropdown_select_text_profile(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"Text-Notification\"]/form/div[1]/div/div[1]/select")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"Text-Notification\"]/form/div[1]/div/div[1]/select")));
		selection.selectByVisibleText(name);	
		driver.findElement(By.xpath("//*[@id=\"Text-Notification\"]/form/div[1]/div/div[1]/select")).click();
	}

	
	//Video Notification functions
	public static String button_video_notification = "/html/body/app-root/div/div/div[2]/div/ng-component/div/div[2]/div/div/ul/li[1]/a";
	public static String textbox_video_title = "//*[@id=\"videoTitle\"]";
	public static String textbox_video_description = "//*[@id=\"videoDescription\"]";
	public static String button_video_push = "//*[@id=\"Video-Notification\"]/form/div[2]/button";
	
	public static void dropdown_select_video_profile(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"Video-Notification\"]/form/div[1]/div[1]/div[1]/select")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"Video-Notification\"]/form/div[1]/div[1]/div[1]/select")));
		selection.selectByVisibleText(name);	
		driver.findElement(By.xpath("//*[@id=\"Video-Notification\"]/form/div[1]/div[1]/div[1]/select")).click();
	}

}
