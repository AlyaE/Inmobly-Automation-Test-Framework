package Pages;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContentScreens {

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
	
	public static WebElement menubutton_screens(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"contentMenu\"]/ul/li[3]/a"));
		return element;
	}
	
	//New Screen Functions
	public static WebElement button_new_screens(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-templates/app-template-list/div/div[2]/div/button"));
		return element;
	}
	
	public static WebElement button_new_screens_new_row(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/div[2]/div/button/b/i"));
		return element;
	}
	
	public static WebElement button_new_screens_new_theme(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/div[2]/div/button"));
		return element;
	}
	
	public static WebElement button_new_screens_cancel(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/app-row-detail/div[1]/div/div/div/div/div[1]/div/div/button[1]"));
		return element;
	}
	
	public static WebElement button_new_screens_save(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/app-row-detail/div[1]/div/div/div/div/div[1]/div/div/button[2]/img"));
		return element;
	}
	
	//New Screens New Name functions
	public static WebElement button_new_screens_change_name(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/div[1]/div/div[1]/div/h4/button"));
		return element;
	}
	
	public static WebElement textbox_new_screens_row_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"template_name\"]"));
		return element;
	}
	
	public static WebElement button_new_screens_row_name_save(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"editScreenNameModal\"]/div/div/div[3]/button[2]"));
		return element;
	}
	
	public static WebElement button_new_screens_row_name_cancel(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"editRowNameModal\"]/div/div/div[3]/button[1]"));
		return element;
	}
}
