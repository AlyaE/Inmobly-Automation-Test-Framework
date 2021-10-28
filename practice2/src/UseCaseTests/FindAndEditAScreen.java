package UseCaseTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentScreens;

public class FindAndEditAScreen {
private static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//navigate to Screens page
		ContentScreens.login(driver);
		driver.findElement(By.xpath(ContentScreens.menubutton_content)).click();
		driver.findElement(By.xpath(ContentScreens.menubutton_screens)).click();
	}
	
	@Test
	public static void find_and_edit_screen_test() {
		ContentScreens.button_view_screen(driver, "Regression", "123");
		ContentScreens.button_view_row(driver, "Shelf portrait", "row-3");
	}
	
	@AfterSuite
	public static void teardown() {
		//driver.close();
	}
}
