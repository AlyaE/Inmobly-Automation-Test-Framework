package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ContentMetadata {
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
	public static String menubutton_metadata = "//*[@id=\"contentMenu\"]/ul/li[5]/a";
	
	public static String button_find_video = "/html/body/app-root/div/div/div[2]/div/app-metadata/app-metadata-details/div/button";
	
	public static void button_edit_metadata (WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-metadata/app-metadata-details/div/div[2]/div"));
		//element.findElement(By.xpath("./div[1]")).findElement(By.xpath("./div/button/img")).click();
		List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 System.out.print(list.get(i).findElement(By.tagName("h4")).getText() + " end text\n");
			 if(list.get(i).findElement(By.xpath("./div[1]")).isDisplayed()) {
				 driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-metadata/app-metadata-details/div/div[2]/div/div[1]/div/button")).click();
				 break;
			 }
		}
	}
}
