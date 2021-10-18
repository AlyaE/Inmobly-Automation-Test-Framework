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
		DashboardLogin.testbox_username(driver).click();
		DashboardLogin.testbox_username(driver).sendKeys("inmobly-admin");
		DashboardLogin.testbox_password(driver).click();
		DashboardLogin.testbox_password(driver).sendKeys("support123456");
		DashboardLogin.button_signin(driver).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String msg = DashboardLogin.button_inmobly_app(driver).getText();
		assertEquals(msg, "Inmobly App");
	}
	
	public static WebElement menubutton_content(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"contentMenu\"]/a"));
		return element;
	}
	
	public static WebElement menubutton_lists(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"contentMenu\"]/ul/li[2]/a"));
		return element;
	}
	
	//Customizable lists functions
	public static String find_list_id(WebDriver driver, String list_name) {
		element = driver.findElement(By.xpath("//*[@id=\"381\"]/div/h6"));
		String id = "381"; //temp hardcoded value for testing next step, FIX THIS
		return id;
	}
	
	//FINISH THIS: NEEDS MORE WORK
	public static WebElement find_list(WebDriver driver, String list_name) {
		By child_locator = new ByChained(By.xpath("/html/body/app-root/div/div/div[2]/div/app-templates/app-template-list/div/div[2]/div/div/div"), By.partialLinkText(list_name));
		element = driver.findElement(child_locator);
		System.out.print(element.getText() +"\n");
		
		/* element = driver.findElement(By.xpath("//*[@id=\"rowContainer\"]"));
		List<WebElement> children = driver.findElements(By.xpath("./child::*"));
		for (WebElement child: children) {
			System.out.print(child.getText() + " actual: " + list_name +"\n");
		}*/
		
		/*int id = 381;
		element = driver.findElement(By.xpath("//*[@id=\""+ id + "\"]"));
		while (!element.getText().contains(list_name)) {
			if (element.getText().isEmpty()) {
				id++;
			}
			else {
				element = driver.findElement(By.xpath("//*[@id=\""+ id + "\"]"));
				System.out.print("element text: " + element.getText() + " list name needed: " + list_name + "\n");
				List<WebElement> children = driver.findElements(By.xpath("./child::*"));
				for (WebElement child: children) {
					System.out.print("child text: " + element.getText()+ "\n");
				}
				id++;
			}
		}
		System.out.print("element text: " + element.getText() + " list name needed: " + list_name + "\n");*/
		
		return element;
		// //*[@id="381"]/div/div/button[1]
	}
	
	public static WebElement button_view_list(WebDriver driver, String list_name) {
		String id = find_list_id(driver, "Feature");
		element = driver.findElement(By.xpath("//*[@id=\"" + id + "\"]/div/div/button[2]/i"));
		return element;
	}
	
	public static WebElement button_delete_list(WebDriver driver, String list_namer) {
		String id = find_list_id(driver, "Feature");
		element = driver.findElement(By.xpath("//*[@id=\"" + id + "\"]/div/div/button[1]/img"));
		return element;
	}
	
	//New List functions
	public static WebElement button_new_list(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-lists/app-list-list/div[1]/button"));
		return element;
	}
	
	public static WebElement button_new_list_name(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[1]/div/div[1]/div/h4/button/img"));
		return element;
	}
	
	public static WebElement textbox_new_list_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[2]/div/div/div/input"));
		return element;
	}
	
	public static WebElement button_new_list_save_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/button[2]"));
		return element;
	}
	
	public static WebElement button_new_list_cancel_name(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/button[1]"));
		return element;
	}
	
	public static WebElement button_new_list_save(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[1]/div/div/button[2]"));
		return element;
	}
	
	public static WebElement button_new_list_cancel(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[1]/div/div/button[1]"));
		return element;
	}
	
	//ADD FUNCTION to traverse all videos in the list to find specific one to test video specific buttons/fields
//	/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/div/div[1]
//  /html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/div/div[2]
//	/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[3]/div/div[2]/div[2]/div[1]/div/div
	
	//Add Video functions
	public static WebElement button_new_list_add_video(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[2]/div/button[1]"));
		return element;
	}
	
	public static WebElement dropdown_add_video_video_type(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-f1ph-container\"]"));
		return element;
	}
	
	public static WebElement dropdown_add_video_filter_type(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"select2-k3o9-container\"]"));
		return element;
	}
	
	public static WebElement button_add_video_keywords(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[2]/div[1]/input"));
		return element;
	}
	
	public static WebElement textbox_add_video_filter(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[2]/div[2]/input"));
		return element;
	}
	
	public static WebElement button_add_video_cancel(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[4]/div/button[1]"));
		return element;
	}
	
	public static WebElement button_add_video_select(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"modal_default\"]/div/div/div[2]/form/div[4]/div/button[2]"));
		return element;
	}
	
	
	//Add Rule functions
	public static WebElement button_new_list_add_rule(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/app-root/div/div/div[2]/div/app-lists/app-list-detail/div[1]/div[2]/div/button[2]"));
		return element;
	}
		
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
	
	public static WebElement textbox_add_rule_order(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[1]/div[4]/input"));
		return element;
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
	
	public static WebElement textbox_add_rule_count(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[2]/div[2]/div[5]/input"));
		return element;
	}
	
	public static WebElement textbox_add_rule_keywords(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"rule_keyword_input\"]"));
		return element;
	}
	
	public static WebElement button_add_rule_cancel(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[3]/div/button[1]"));
		return element;
	}
	
	public static WebElement button_add_rule_save(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"ruleModal\"]/div/div/div[3]/div/button[2]"));
		return element;
	}
	
	
}
