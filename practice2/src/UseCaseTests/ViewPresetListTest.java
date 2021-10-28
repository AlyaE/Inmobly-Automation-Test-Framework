package UseCaseTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentLists;

public class ViewPresetListTest {
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
	public static void find_and_edit_list_test() {
		ContentLists.button_view_preset_list(driver, "trending");
		driver.findElement(By.xpath(ContentLists.textbox_preset_list_name)).click();
		driver.findElement(By.xpath(ContentLists.textbox_preset_list_name)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_preset_list_name)).sendKeys("changed_name_test");
		//cancels the name change
		//driver.findElement(By.xpath(ContentLists.button_preset_list_name_cancel)).click();
	}
	
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}

