package Pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContentSeriesAndSeasons {
private static WebElement element = null;
	
	public static void login(WebDriver driver) {
		driver.findElement(By.xpath(DashboardLogin.textbox_uername)).click();
		driver.findElement(By.xpath(DashboardLogin.textbox_uername)).sendKeys("inmobly-admin");
		driver.findElement(By.xpath(DashboardLogin.testbox_password)).click();
		driver.findElement(By.xpath(DashboardLogin.testbox_password)).sendKeys("support123456");
		driver.findElement(By.xpath(DashboardLogin.button_signin)).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		String msg = driver.findElement(By.xpath(DashboardLogin.button_inmobly_app)).getText();
		assertEquals(msg, "Inmobly App");
	}
	
	public static String menubutton_content = "//*[@id=\"contentMenu\"]/a";
	public static String menubutton_series_and_seasons = "//*[@id=\"contentMenu\"]/ul/li[6]/a";
	public static String button_new_series = "/html/body/app-root/div/div/div[2]/div/app-series-list/button";
	
	//New Series Functions
	public static String textbox_new_series_title = "//*[@id=\"Details\"]/form/fieldset[1]/div[1]/div/input";
	public static String textbox_new_series_short_description = "//*[@id=\"Details\"]/form/fieldset[1]/div[2]/div/textarea";
	public static String textbox_new_series_description = "//*[@id=\"Details\"]/form/fieldset[1]/div[3]/div/textarea";
	public static String textbox_new_series_tag = "//*[@id=\"Details\"]/form/fieldset[1]/div[4]/div/div/input";
	public static String button_new_series_save = "//*[@id=\"Details\"]/div/div/button[2]";
}
