package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentMetadata;


public class ContentMetadataTest {
	private static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
		ContentMetadata.login(driver);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ContentMetadata.menubutton_content)).click();
		driver.findElement(By.xpath(ContentMetadata.menubutton_metadata)).click();
	}
	
	
	@Test
	public static void edit_profile_test() throws InterruptedException {
		driver.findElement(By.xpath(ContentMetadata.button_find_video)).click();
		//select video temp code
		Thread.sleep(50); //find different way of waiting
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[3]/div/table/tbody/tr[3]/td[1]/input")).click();
		Thread.sleep(50); //find different way of waiting
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[4]/div/button[2]")).click();
		Thread.sleep(50); //find different way of waiting
		ContentMetadata.button_edit_metadata(driver);
	}
	
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
