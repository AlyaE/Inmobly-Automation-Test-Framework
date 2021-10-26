package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Pages.DashboardLogin;

public class ContentProfiles {

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
	public static String menubutton_profiles = "//*[@id=\"contentMenu\"]/ul/li[1]/a";
	public static String button_new_profile = "/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/button";
	
	public static void add_new_profile(WebDriver driver, String profile_default_name, String profile_name) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("div")).getText().equals(profile_default_name)) {
				 
				 driver.findElement(By.className("border ng-pristine ng-valid ng-touched")).click();
				 driver.findElement(By.className("border ng-pristine ng-valid ng-touched")).clear();
				 driver.findElement(By.className("border ng-pristine ng-valid ng-touched")).sendKeys(profile_name);
				 //driver.findElement(By.className("btn btn-success btn-icon save-btn")).click();
			 }
		}
	}
	
	public static void button_edit_profile(WebDriver driver, String profile_name) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("h5")).getText().equals(profile_name)) {	
				 list.get(i).findElement(By.className("heading-btn")).findElement(By.xpath("./button[2]")).click();
			 }
		}
	}
	
	public static void button_delete_profile(WebDriver driver, String profile_name) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("h5")).getText().equals(profile_name)) {	
				 list.get(i).findElement(By.className("heading-btn")).findElement(By.xpath("./button[1]")).click();
			 }
		}
	}
	
	public static void button_cancel_edit_profile(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("h5")).getText().equals("Profile")) {
				 System.out.println(list.get(i).findElement(By.tagName("h5")).getText() + "\n");	
				 list.get(i).findElement(By.className("heading-btn")).findElement(By.xpath("./button[1]")).click();
			 }
		}
	}
//	/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[2]/app-profile-detail/div[1]/div/div[1]/h5
//	/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[2]/app-profile-detail/div[1]/div/div[1]/div/div/button[1]
	
	public static void button_save_edit_profile(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[2]/app-profile-detail/div[2]/div"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("h5")).getText().equals("Profile")) {	
				 list.get(i).findElement(By.className("heading-btn")).findElement(By.xpath("./button[2]")).click();
			 }
		}
	}
	
	public static void textbox_change_profile_name(WebDriver driver, String name) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[2]/app-profile-detail/div[2]/div"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.xpath("./div[1]/h5")).getText().equals("Profile")) {	
				 element.findElement(By.xpath("./div[2]"));
				 if(element.findElement(By.tagName("h6")).getText().equals("Profile Name")) {
					 
				 }
			 }
		}
	//	 /html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[2]/app-profile-detail/div[2]/div/div[1]/h5
	//	 /html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[2]/app-profile-detail/div[2]/div
	//	 /html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[2]/app-profile-detail/div[2]/div/div[2]
	}
}
