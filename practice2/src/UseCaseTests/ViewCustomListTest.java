package UseCaseTests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentLists;

public class ViewCustomListTest {
	static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
		ContentLists.login(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ContentLists.menubutton_content)).click();
		driver.findElement(By.xpath(ContentLists.menubutton_lists)).click();
	}
			
	@Test
	public static void find_list_test() {
		ContentLists.button_view_custom_list(driver, "Feature");
		ContentLists.button_view_custom_list_edit(driver);
	}
	
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
