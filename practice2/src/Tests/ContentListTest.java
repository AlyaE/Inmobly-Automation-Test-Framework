package Tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentLists;

public class ContentListTest {
	
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
	
	//creates then cancels adding list
	/*@Test
	public static void create_new_list_test() {
		driver.findElement(By.xpath(ContentLists.button_new_list)).click();
		driver.findElement(By.xpath(ContentLists.button_new_list_name)).click();
		
		//Renaming the new list to "Alya List"
		driver.findElement(By.xpath(ContentLists.textbox_new_list_name)).click();
		driver.findElement(By.xpath(ContentLists.textbox_new_list_name)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_new_list_name)).sendKeys("Alya List");
		driver.findElement(By.xpath(ContentLists.button_new_list_save_name)).click();
	}*/
	
	/*@Test
	public static void create_new_list_with_rules_test() {
		//Add a rule by tag
		driver.findElement(By.xpath(ContentLists.button_new_list_add_rule)).click();
		ContentLists.dropdown_select_rule_filter_type(driver, "Tag");
		ContentLists.dropdown_select_rule_tag(driver, "business");
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).click();
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).sendKeys("1");
		ContentLists.dropdown_select_rule_sort_by(driver, "Date");
		ContentLists.dropdown_select_rule_direction(driver, "Desc");
		ContentLists.dropdown_select_rule_min_year(driver, "1996");
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).click();
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).sendKeys("8");
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_keywords)).click();
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_keywords)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_keywords)).sendKeys("Movie");
		driver.findElement(By.xpath(ContentLists.button_add_rule_save)).click();

		
		//Add a rule by Category
		driver.findElement(By.xpath(ContentLists.button_new_list_add_rule)).click();
		ContentLists.dropdown_select_rule_filter_type(driver, "Category");
		ContentLists.dropdown_select_rule_category(driver, "site");
		ContentLists.dropdown_select_rule_sort_by(driver, "Date");
		ContentLists.dropdown_select_rule_direction(driver, "Desc");
		ContentLists.dropdown_select_rule_min_year(driver, "1996");
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).click();
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).sendKeys("8");
		driver.findElement(By.xpath(ContentLists.button_add_rule_save)).click();

		
		//Add a rule by Series
		driver.findElement(By.xpath(ContentLists.button_new_list_add_rule)).click();
		ContentLists.dropdown_select_rule_filter_type(driver, "Series");
		ContentLists.dropdown_select_rule_series(driver, "SUITS");
		driver.findElement(By.xpath(ContentLists.button_add_rule_save)).click();
	}
	
	@Test
	public static void create_new_list_with_videos_test() {
		/*driver.findElement(By.xpath(ContentLists.button_new_list_add_video)).click();
		ContentLists.dropdown_add_video_video_type(driver, "Video");
		ContentLists.dropdown_add_video_keyword_type(driver, "Tag");
		ContentLists.dropdown_add_video_select_category(driver, "business");
		driver.findElement(By.xpath(ContentLists.textbox_add_video_keywords)).click();
		driver.findElement(By.xpath(ContentLists.textbox_add_video_keywords)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_add_video_keywords)).sendKeys("KMS");
		driver.findElement(By.xpath(ContentLists.textbox_add_video_filter)).click();
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[3]/div/table/tbody/tr[1]/td[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[3]/div/table/tbody/tr[3]/td[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[4]/div/button[2]")).click();
		
		//ContentLists.button_select_video_from_list(driver, "Once Upon a Time");
	}*/

	
	@Test
	public static void find_list_test() {
		ContentLists.button_view_preset_list(driver, "trending");
		driver.findElement(By.xpath(ContentLists.textbox_preset_list_name)).click();
		driver.findElement(By.xpath(ContentLists.textbox_preset_list_name)).clear();
		driver.findElement(By.xpath(ContentLists.textbox_preset_list_name)).sendKeys("changed_name_test");
		//cancels the name change
		//driver.findElement(By.xpath(ContentLists.button_preset_list_name_cancel)).click();
		
		//ContentLists.button_view_custom_list(driver, "Feature");
		//new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ContentLists.button_view_custom_list_edit))));  
		//ContentLists.button_view_custom_list_edit(driver);
	}
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
