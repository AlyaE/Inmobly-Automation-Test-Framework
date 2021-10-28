package UseCaseTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentLists;

public class CreateNewListWithRulesTest {
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
	
	@Test
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

	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}