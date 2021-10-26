package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContentScreens {

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
	public static String menubutton_screens = "//*[@id=\"contentMenu\"]/ul/li[3]/a";
	public static String button_new_screens = "/html/body/app-root/div/div/div[2]/div/app-templates/app-template-list/div/div[2]/div/button";
	public static String button_new_screens_new_row = "/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/div[2]/div/button/b/i";
	public static String button_new_screens_new_theme = "/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/div[2]/div/button/b/i";
	public static String button_new_screens_cancel = "/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/app-row-detail/div[1]/div/div/div/div/div[1]/div/div/button[1]";
	public static String button_new_screens_save = "/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/app-row-detail/div[1]/div/div/div/div/div[1]/div/div/button[2]/img";
	
	//New Screens New Name functions
	public static String button_new_screens_change_name = "/html/body/app-root/div/div/div[2]/div/app-templates/app-template-detail/div[1]/div/div[1]/div/h4/button";
	public static String textbox_new_screens_row_name = "//*[@id=\"template_name\"]";
	public static String button_new_screens_row_name_save = "//*[@id=\"editScreenNameModal\"]/div/div/div[3]/button[2]";
	public static String button_new_screens_row_name_cancel = "//*[@id=\"editRowNameModal\"]/div/div/div[3]/button[1]";

	//Edit Style of new row theme
	public static WebElement button_theme_edit_style(WebDriver driver, String theme_name) {
		element = driver.findElement(By.xpath("//*[@id=\"rowContainer\"]"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 System.out.print(list.get(i).findElement(By.tagName("h5")).getText() +"\n");
			 if(list.get(i).findElement(By.tagName("h5")).getText().equals(theme_name)) {
				 System.out.print(driver.findElement(By.partialLinkText("Edit Style")).getText() +"\n");
				 driver.findElement(By.className("btn btn-labeled btn-primary row-edit-btn")).click();
				//*[@id="theme-0"]/div/div[2]
				//*[@id="theme-0"]/div/div[2]/div[1]/div/div/div[1]/div[1]/button
				 //driver.findElement(By.className("btn btn-labeled btn-primary row-edit-btn")).click();
			 }
		}
		return element;
	}
	
	public static WebElement button_theme_delete(WebDriver driver, String theme_name) {
		element = driver.findElement(By.xpath("//*[@id=\"rowContainer\"]"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 System.out.print(list.get(i).findElement(By.tagName("h5")).getText() +"\n");
			 if(list.get(i).findElement(By.tagName("h5")).getText().equals(theme_name)) {
				 driver.findElement(By.className("btn btn-icon btn-circle btn-img no-back no-border")).click();
			 }
		}
		return element;
	}
	
	public static WebElement button_theme_minimize(WebDriver driver, String theme_name) {
		element = driver.findElement(By.xpath("//*[@id=\"rowContainer\"]"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 System.out.print(list.get(i).findElement(By.tagName("h5")).getText() +"\n");
			 if(list.get(i).findElement(By.tagName("h5")).getText().equals(theme_name)) {
				 driver.findElement(By.tagName("div")).findElement(By.tagName("div"));
				 driver.findElement(By.className("btn btn-icon btn-circle btn-img no-back no-border")).click();
			 }
		}
		return element;
	}
}
