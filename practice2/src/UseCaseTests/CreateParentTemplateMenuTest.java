package UseCaseTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContentMenu;

//tests parent template menu's and their sub menu's
public class CreateParentTemplateMenuTest {
	static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
		ContentMenu.login(driver);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(ContentMenu.menubutton_content)).click();
		driver.findElement(By.xpath(ContentMenu.menubutton_menupage)).click();
	}
	
	@Test
	public static void edit_save_cancel_menu_test() {
		driver.findElement(By.xpath(ContentMenu.button_new_menu_item)).click();
		ContentMenu.edit_parent_template_menu(driver, "New Menu Item", "Alya Menu");
		ContentMenu.edit_submenu(driver, "Alya Menu", "new sub menu", "Alya Sub Menu", "Comedy");
		ContentMenu.button_new_submenu(driver, "Alya Menu", "new sub menu", "Alya Sub Menu 2", "Kids Screen");
		ContentMenu.button_new_submenu(driver, "Alya Menu", "new sub menu", "Alya Sub Menu 3", "Kids Screen");
		ContentMenu.delete_submenu(driver, "Alya Menu", "Alya Sub Menu 2");
	}
	
	@AfterTest
	public static void teardown() {
		//driver.close();
	}
}
