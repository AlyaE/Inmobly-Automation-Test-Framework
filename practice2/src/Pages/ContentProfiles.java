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
	
	public static WebElement menubutton_profiles(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"contentMenu\"]/ul/li[1]/a"));
		return element;
	}
	
	public static WebElement button_new_profile(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/button"));
		return element;
	}
	
	public static WebElement find_profile(WebDriver driver, String profile_name) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[1]/app-profile-detail/div[1]/div/div[1]/h5"));
		System.out.print("text in element before loop  " + element.getText() + "\n");
		
		int i = 2;
		while (element.getText() != profile_name) {
			if (element.getText().isEmpty()) {
				System.out.print("profile name: " + profile_name + " not found!\n");
				return null;
			}
			else {
				System.out.print("text in element in while loop  !" + element.getText() + "! but the actual is " + profile_name + "\n");
				element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div["+i+"]/app-profile-detail/div[1]/div/div[1]/h5"));
				i++;
			}
		}
		
		return element;
		
		/*
		 * profile name xpath
		 * /html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[1]/app-profile-detail/div[1]/div/div[1]/h5
		 * /html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[2]/app-profile-detail/div[1]/div/div[1]/h5
		 * 
		 * profile whole box xpath
		 * /html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[2]/app-profile-detail/div[1]/div
		 * /html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[1]/app-profile-detail/div[1]/div
		 * 
		 * /html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div
		 * 
		 * /html/body/app-root/div/div/div[2]/div/app-profiles/app-profile-list/div[1]/div[2]/div/div/div/div/div/div/div[7]/app-profile-detail/div[2]/div/div[1]/h5
		*/
		
	}
}
