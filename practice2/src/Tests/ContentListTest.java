package Tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	}
	
	//creates then cancels adding list
	@Test
	public static void create_new_list_test() {
		ContentLists.login(driver);
		ContentLists.button_new_list(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.button_new_list_name(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//Renaming the new list to "Alya List"
		ContentLists.textbox_new_list_name(driver).click();
		ContentLists.textbox_new_list_name(driver).clear();
		ContentLists.textbox_new_list_name(driver).sendKeys("Alya List");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.button_new_list_save_name(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@Test
	public static void create_new_list_with_rules_test() {
		//Add a rule by tag
		ContentLists.button_new_list_add_rule(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_filter_type(driver, "Tag");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_tag(driver, "business");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.textbox_add_rule_order(driver).click();
		ContentLists.textbox_add_rule_order(driver).clear();
		ContentLists.textbox_add_rule_order(driver).sendKeys("1");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_sort_by(driver, "Date");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_direction(driver, "Desc");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_min_year(driver, "1996");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.textbox_add_rule_count(driver).click();
		ContentLists.textbox_add_rule_count(driver).clear();
		ContentLists.textbox_add_rule_count(driver).sendKeys("8");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.textbox_add_rule_keywords(driver).click();
		ContentLists.textbox_add_rule_keywords(driver).clear();
		ContentLists.textbox_add_rule_keywords(driver).sendKeys("Movie");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.button_add_rule_save(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//Add a rule by Category
		ContentLists.button_new_list_add_rule(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_filter_type(driver, "Category");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_category(driver, "site");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_sort_by(driver, "Date");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_direction(driver, "Desc");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_min_year(driver, "1996");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.textbox_add_rule_count(driver).click();
		ContentLists.textbox_add_rule_count(driver).clear();
		ContentLists.textbox_add_rule_count(driver).sendKeys("8");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.button_add_rule_save(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//Add a rule by Series
		ContentLists.button_new_list_add_rule(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_filter_type(driver, "Series");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.dropdown_select_rule_series(driver, "SUITS");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.button_add_rule_save(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	/*@Test
	public static void create_new_list_with_videos_test() {
		ContentLists.login(driver);
		ContentLists.button_new_list(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.button_new_list_name(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//Add video to the list
		ContentLists.button_new_list_add_video(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		ContentLists.button_add_video_cancel(driver).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}*/
	
	/*@Test
	public static void find_profile_Movies_test() {
		ContentLists.login(driver);
		ContentLists.menubutton_content(driver);
		ContentLists.menubutton_lists(driver);
		ContentLists.find_list(driver, "Feature");
	}*/
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
