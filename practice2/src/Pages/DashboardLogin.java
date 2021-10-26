package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardLogin {
	
	private static WebElement element = null;
	
	public static String textbox_uername = "/html/body/app-root/div/div/div/div/ng-component/div/div/form/div[1]/input";
	public static String testbox_password = "/html/body/app-root/div/div/div/div/ng-component/div/div/form/div[2]/input";
	public static String button_signin = "/html/body/app-root/div/div/div/div/ng-component/div/div/form/div[3]/button";
	
	//used to verify login worked
	public static String button_inmobly_app = "/html/body/app-root/app-navbar/div/ul/li/a";

}
