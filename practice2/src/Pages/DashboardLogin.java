package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardLogin {
	
	private static WebElement element = null;
	
	public static WebElement testbox_username(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/ng-component/div/div/form/div[1]/input"));
		return element;
	}
	
	public static WebElement testbox_password(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/ng-component/div/div/form/div[2]/input"));
		return element;
	}
	
	public static WebElement button_signin(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/ng-component/div/div/form/div[3]/button"));
		return element;
	}
	
	//used to verify login worked
	public static WebElement button_inmobly_app(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/app-navbar/div/ul/li/a"));
		return element;
	}

}
