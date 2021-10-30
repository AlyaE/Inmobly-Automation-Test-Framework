package UseCaseTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentLists;

public class CreateNewListWithVideosTest {
	private static WebDriver driver = null;
	
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
	public static void create_new_list_with_videos_test() {
		driver.findElement(By.xpath(ContentLists.button_new_list_add_video)).click();
		/*ContentLists.dropdown_add_video_video_type(driver, "Video");
		ContentLists.dropdown_add_video_keyword_type(driver, "Tag");
		ContentLists.dropdown_add_video_select_category(driver, "business");
		driver.findElement(By.xpath(ContentLists.textbox_add_video_keywords)).click();
		driver.findElement(By.xpath(ContentLists.textbox_add_video_keywords)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_add_video_keywords)).sendKeys("KMS");
		driver.findElement(By.xpath(ContentLists.textbox_add_video_filter)).click();*/
		
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[3]/div/table/tbody/tr[1]/td[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[3]/div/table/tbody/tr[3]/td[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[4]/div/button[2]")).click();
		//doesn't work right now
		//ContentLists.button_select_video_from_list(driver, "Once Upon a Time");
	}
	
	//creates then cancels adding list
	@Test
	public static void create_new_list_test() {
		driver.findElement(By.xpath(ContentLists.button_new_list)).click();
		driver.findElement(By.xpath(ContentLists.button_new_list_name)).click();
		
		//Renaming the new list to "Test List"
		driver.findElement(By.xpath(ContentLists.textbox_new_list_name)).click();
		driver.findElement(By.xpath(ContentLists.textbox_new_list_name)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_new_list_name)).sendKeys("Test List");
		driver.findElement(By.xpath(ContentLists.button_new_list_save_name)).click();
	}


	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
