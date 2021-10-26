package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;

public class ContentLists {
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
	public static String menubutton_lists = "//*[@id=\"contentMenu\"]/ul/li[2]/a";
	
	//New List functions
	public static String button_new_list = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-list/div[1]/button";
	public static String button_new_list_name = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[1]/div/div[1]/div/h4/button/img";
	public static String textbox_new_list_name = "//*[@id=\"myModal\"]/div/div/div[2]/div/div/div/input";
	public static String button_new_list_save_name = "//*[@id=\"myModal\"]/div/div/div[3]/button[2]";
	public static String button_new_list_cancel_name = "//*[@id=\"myModal\"]/div/div/div[3]/button[1]";
	public static String button_new_list_save = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[1]/div/div/button[2]";
	public static String button_new_list_cancel = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[1]/div/div/button[1]";
	
	//Customizable lists functions
	public static String parent_view_custom_list_details = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[1]/div[1]";
	public static String button_view_list_delete = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[1]/div[1]/div/div/button[1]";
	
	public static void button_view_custom_list(WebDriver driver, String list_name) {
		element = driver.findElement(By.xpath("//*[@id=\"rowContainer\"]"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("h6")).getText().equals(list_name)) {
				 driver.findElement(By.className("icon-eye")).click();
			 }
		}
	}
	
	public static void button_delete_custom_list(WebDriver driver, String list_name) {
		element = driver.findElement(By.xpath("//*[@id=\"rowContainer\"]"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("h6")).getText().equals(list_name)) {
				 driver.findElement(By.className("btn bg-delete-button btn-icon")).click();
			 }
		}
	}
	
	public static void button_view_custom_list_edit(WebDriver driver) {
		element = driver.findElement(By.xpath(parent_view_custom_list_details));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("h5")).getText().equals("List details")) {
				 driver.findElement(By.className("btn bg-primary btn-icon edit-btn")).click();
			 }
		}
	}
	
	
	//after clicking edit on list view page
	public static String button_view_list_cancel = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[1]/div/div/button[1]/img";
	public static String button_view_list_save = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[1]/div/div/button[2]/img";
	
	public static void button_delete_video_from_list(WebDriver driver, String video_name) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/div"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("div")).getText().equals(video_name)) {
				 System.out.print(list.get(i).findElement(By.tagName("div")).getText() +"\n");
				 driver.findElement(By.className("btn bg-delete-button btn-icon")).click();
			 }
		}
	}
	
	public static void button_change_video_order_from_list(WebDriver driver, String video_name, String new_position) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/div"));
		 List<WebElement> list = element.findElements(By.xpath("./child::*"));
		 for(int i = 0; i < list.size(); i++) {
			 if(list.get(i).findElement(By.tagName("div")).getText().equals(video_name)) {
				 System.out.print(list.get(i).findElement(By.tagName("div")).getText() +"\n");
				 driver.findElement(By.className("form-control")).click();
				 driver.findElement(By.className("form-control")).clear();
				 driver.findElement(By.className("form-control")).sendKeys(new_position);
			 }
		}
	}
	
	//Add Video functions
	public static String button_new_list_add_video = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[2]/div/button[1]";
	public static String dropdown_add_video_filter_type = "//*[@id=\"select2-k3o9-container\"]";
	public static String textbox_add_video_keywords = "//*[@id=\"modal_default\"]/div/div/div[2]/form/div[2]/div[1]/input";
	public static String textbox_add_video_filter = "//*[@id=\"modal_default\"]/div/div/div[2]/form/div[2]/div[2]/input";
	public static String button_add_video_cancel = "//*[@id=\"modal_default\"]/div/div/div[2]/form/div[4]/div/button[1]";
	public static String button_add_video_select = "//*[@id=\"modal_default\"]/div/div/div[2]/form/div[4]/div/button[2]";
	
	public static void dropdown_add_video_video_type(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[1]/div[1]/select2/span/span[1]/span")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[1]/div[1]/select2/select")));
		selection.selectByVisibleText(name);	
	}
	
	//to select whether you want to search by Tag, Category, or both
	public static void dropdown_add_video_keyword_type(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[1]/div[2]/select2/span/span[1]/span")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[1]/div[2]/select2/select")));
		selection.selectByVisibleText(name);
	}
	
	public static void dropdown_add_video_select_tag(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[1]/div[3]/select2[1]/span/span[1]/span")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[1]/div[3]/select2[1]/select")));
		selection.selectByVisibleText(name);	
	}
	
	public static void dropdown_add_video_select_category(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[1]/div[3]/select2[2]/span/span[1]/span")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[1]/div[3]/select2[2]/select")));
		selection.selectByVisibleText(name);	
	}
	
	public static void button_select_video_from_list(WebDriver driver, String video_name) {
		element = driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[3]/div"));
		 //List<WebElement> list = element.findElements(By.xpath("./child::*"));
		
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		 for(int i = 0; i < rows.size(); i++) {
			 System.out.println("Row size: " + rows.size());
			 List<WebElement> collumns = element.findElements(By.tagName("td"));
			 for(int j = 0; j < collumns.size(); j++) {
				 String value = collumns.get(j).getText();
				 System.out.println("Collumn size: " + collumns.size());
				 System.out.println("The cell value is: " + value);
			 }
		}
	}

	//Add Rule functions
	public static String button_new_list_add_rule = "/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[2]/div/button[2]";
	public static String textbox_add_rule_order = "//*[@id=\"ruleModal\"]/div/div/div[2]/div[1]/div[4]/input";
	public static String textbox_add_rule_count = "//*[@id=\"ruleModal\"]/div/div/div[2]/div[2]/div[5]/input";
	public static String textbox_add_rule_keywords = "//*[@id=\"rule_keyword_input\"]";
	public static String button_add_rule_cancel = "//*[@id=\"ruleModal\"]/div/div/div[3]/div/button[1]";
	public static String button_add_rule_save = "//*[@id=\"ruleModal\"]/div/div/div[3]/div/button[2]";

	public static void dropdown_select_rule_filter_type(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[1]/div[1]/select")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[1]/div[1]/select")));
		selection.selectByVisibleText(name);	
	}
	
	public static void dropdown_select_rule_series(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div/div[3]/span/span[1]/span")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div/div[3]/select")));
		selection.selectByVisibleText(name);	
	}
	
	public static void dropdown_select_rule_tag(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[1]/div[3]/span/span[1]/span")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[1]/div[3]/select")));
		selection.selectByVisibleText(name);	
	}
	
	public static void dropdown_select_rule_category(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[1]/div[3]/span/span[1]/span")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[1]/div[3]/select")));
		selection.selectByVisibleText(name);	
	}
	
	public static void dropdown_select_rule_sort_by(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[2]/div[1]/select")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[2]/div[1]/select")));
		selection.selectByVisibleText(name);	
	}
	
	public static void dropdown_select_rule_direction(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[2]/div[3]/select")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[2]/div[3]/select")));
		selection.selectByVisibleText(name);	
	}
	
	public static void dropdown_select_rule_min_year(WebDriver driver, String name) {
		driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[2]/div[4]/select")).click();
		Select selection = new Select(driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[2]/div[4]/select")));
		selection.selectByVisibleText(name);
	}
		
}
