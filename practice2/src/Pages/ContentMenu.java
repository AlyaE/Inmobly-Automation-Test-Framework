package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContentMenu {
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
	public static String menubutton_menupage = "//*[@id=\"contentMenu\"]/ul/li[4]/a";
	public static String button_new_menu_item = "/html/body/app-root/div/div/div[2]/div/app-menu/app-menu-detail/div[1]/button";
	
	public static void button_edit_and_save_menu(WebDriver driver, String menu_name) {
		boolean element_exists = true;
		int i = 0;
		while (element_exists) {
			if(element_exists) {
			if(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[1]/h4")).getText().contains(menu_name)) {
				driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[2]/button[2]")).click();
				break;
			}
			element_exists = driver.findElement(By.xpath("//*[@id=\""+(i+1)+"\"]/div/div[1]/div[2]/button[2]")).isDisplayed();
			i++;
			} else {
				break;
			}
		}
	}
	
	public static void button_delete_and_cancel_edit_menu(WebDriver driver, String menu_name) {
		boolean element_exists = true;
		int i = 0;
		while (element_exists) {
			if(element_exists) {
			if(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[1]/h4")).getText().contains(menu_name)) {
				driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[2]/button[1]")).click();
				break;
			}
			element_exists = driver.findElement(By.xpath("//*[@id=\""+(i+1)+"\"]/div/div[1]/div[2]/button[1]")).isDisplayed();
			i++;
			} else {
				break;
			}
		}
	}
	
	public static void edit_template_menu(WebDriver driver, String current_menu_name, String new_menu_name, String screen_name) {
		boolean element_exists = true;
		int i = 0;
		while (element_exists) {
			if(element_exists) {
				if(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[1]/h4")).getText().contains(current_menu_name)) {
					
					//change name of the menu
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[2]/div/input")).click();
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[2]/div/input")).clear();
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[2]/div/input")).sendKeys(new_menu_name);
					
					//Set type to "Template"
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[3]/div/select")).click();
					Select template_select = new Select(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[3]/div/select")));
					template_select.selectByVisibleText("Template");
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[3]/div/select")).click();
					
					//select screen name
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[4]/div/select")).click();
					Select screen_select = new Select(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[4]/div/select")));
					screen_select.selectByVisibleText(screen_name);
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[4]/div/select")).click();
					
					//cancel the menu
					//driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[2]/button[1]")).click();
					
					//save the menu
					//driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[2]/button[2]")).click();
					break;
				}else 
					element_exists = driver.findElement(By.xpath("//*[@id=\""+(i+1)+"\"]/div/div[1]/div[2]/button[1]")).isDisplayed();
				i++;
			} else {
				System.out.print("ERROR: Menu Not Found: "+current_menu_name+"\n");
				break;
			}
		}
	}
	
	public static void edit_parent_template_menu(WebDriver driver, String current_menu_name, String new_menu_name) {
		boolean element_exists = true;
		int i = 0;
		while (element_exists) {
			if(element_exists) {
				System.out.print(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[1]/h4")).getText() + " End Text Parent Template\n");
				if(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[1]/h4")).getText().contains(current_menu_name)) {
					System.out.print(" in element if\n");
					
					//change name of the menu
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[2]/div/input")).click();
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[2]/div/input")).clear();
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[2]/div/input")).sendKeys(new_menu_name);
					
					//Set type to "Template"
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[3]/div/select")).click();
					Select template_select = new Select(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[3]/div/select")));
					template_select.selectByVisibleText("Parent Template");
					driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[2]/div/div/div/div[3]/div/select")).click();

					//cancel the menu
					//driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[2]/button[1]")).click();
					break;
				}else {
					System.out.print(" in element else\n");
					element_exists = driver.findElement(By.xpath("//*[@id=\""+(i+1)+"\"]/div/div[1]/div[2]/button[1]")).isDisplayed();
					i++;
				}
			} else {
				System.out.print("ERROR: Menu Not Found: "+current_menu_name+"\n");
				break;
			} 
		}
	}
	
	public static void edit_submenu(WebDriver driver, String parent_menu_name, String current_submenu_name, String new_submenu_name, String screen_name) {
		boolean element_exists= true;
		boolean submenu_element_exists = true;
		int i = 0;
		int j = 1;
		while (element_exists) {
			if(element_exists) {
			if(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[1]/h4")).getText().contains(parent_menu_name)) {
				while (submenu_element_exists) {
					if(element_exists) {
						//System.out.print(driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[2]/input")).getAttribute("value") +" End OF Text 2\n");
						if (driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[2]/input")).getAttribute("value").contains(current_submenu_name)) {
							
							//change the sub menu name
							driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[2]/input")).click();
							driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[2]/input")).clear();
							driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[2]/input")).sendKeys(new_submenu_name);
							
							//select sub menu screen
							driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[3]/select")).click();
							Select template_select = new Select(driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[3]/select")));
							template_select.selectByVisibleText(screen_name);
							driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[3]/select")).click();
							element_exists = false;
							break;
						}
					}else
						submenu_element_exists = driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+(j+1)+"]/div[2]/input")).isDisplayed();
					j++;
				}
			}else
				element_exists = driver.findElement(By.xpath("//*[@id=\""+(i+1)+"\"]/div/div[1]/div[1]/h4")).isDisplayed();
			i++;
			} else
				break;
		}
	}
	
	public static void button_new_submenu(WebDriver driver, String parent_menu_name, String current_submenu_name, String new_submenu_name, String screen_name) {
		System.out.print(" in new submenu button function 2\n");
		boolean element_exists= true;
		int i = 0;
		while (element_exists) {
			//System.out.print(" in while loop 2\n");
			if(element_exists) {
				//System.out.print(" in bool if 2\n");
				//System.out.print(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[1]/h4")).getText() + " End OF h4 Text 2\n");
				if(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[1]/h4")).getText().contains(parent_menu_name)) {
					if(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[3]/div[2]/div[1]/button")).getText().contains("New Submenu")) {
						driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[3]/div[2]/div[1]/button")).click();
						edit_submenu(driver, parent_menu_name, current_submenu_name, new_submenu_name, screen_name);
					}
					break;

				}
				i++;
			} else
				element_exists = driver.findElement(By.xpath("//*[@id=\""+(i+1)+"\"]/div/div[1]/div[1]/h4")).isDisplayed();
		}
	}
	
	public static void delete_submenu(WebDriver driver, String parent_menu_name, String submenu_name) {
		boolean element_exists= true;
		boolean submenu_element_exists = true;
		int i = 0;
		int j = 1;
		while (element_exists) {
			if(element_exists) {
			if(driver.findElement(By.xpath("//*[@id=\""+i+"\"]/div/div[1]/div[1]/h4")).getText().contains(parent_menu_name)) {
				while (submenu_element_exists) {
					if(element_exists) {
						//System.out.print(driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[2]/input")).getAttribute("value") +" End OF Text 2\n");
						if (driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[2]/input")).getAttribute("value").contains(submenu_name)) {
							//change the sub menu name
							driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+j+"]/div[4]/button")).click();
							element_exists = false;
							break;
						}
					}else
						submenu_element_exists = driver.findElement(By.xpath("//*[@id=\"subMenuContainer\"]/div["+(j+1)+"]/div[2]/input")).isDisplayed();
					j++;
				}
			}else
				element_exists = driver.findElement(By.xpath("//*[@id=\""+(i+1)+"\"]/div/div[1]/div[1]/h4")).isDisplayed();
			i++;
			} else
				break;
		}
	}
	
}
