package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.DashboardLogin;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import Pages.ContentMenu;
import Pages.ContentNotification;
import Pages.ContentSeriesAndSeasons;
import Pages.ContentLists;
import Utility.Self;

public class dashboardContent extends Self{
	private Self self;
	
	public dashboardContent(Self self) {
		this.self = self;
	}
	

	@When("^I navigate to the \"([^\"]*)\" page$")
	public void i_navigate_to_the_page(String pageName) {
		self.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		self.driver.findElement(By.xpath(ContentMenu.menubutton_content)).click();
	    switch(pageName.toLowerCase()) {
	    case "list":
	    	System.out.println("##### navigating to Lists page");
			self.driver.findElement(By.xpath(ContentLists.menubutton_lists)).click();
	    	break;
	    case "menu":
	    	System.out.println("##### navigating to Menu page");
			self.driver.findElement(By.xpath(ContentMenu.menubutton_menupage)).click();
	    	break;
	    case "metadata":
	    	break;
	    case "notification":
			self.driver.findElement(By.xpath(ContentNotification.menubutton_notification)).click();
	    	break;
	    case "profiles":
	    	break;
	    case "screens":
	    	break;
	    case "series and seasons":
			self.driver.findElement(By.xpath(ContentSeriesAndSeasons.menubutton_series_and_seasons)).click();
	    	break;
	    }
	}
	
	//Functions for validating the Lists Page
	@When("^I change the preset list named \"([^\"]*)\" to the name \"([^\"]*)\"$")
	public void i_change_the_preset_list_named_to_the_name(String listName, String newName) {
		ContentLists.button_view_preset_list(self.driver, listName);
		self.driver.findElement(By.xpath(ContentLists.textbox_preset_list_name)).click();
		self.driver.findElement(By.xpath(ContentLists.textbox_preset_list_name)).clear();
		self.driver.findElement(By.xpath(ContentLists.textbox_preset_list_name)).sendKeys(newName);
	}
	
	@Then("^I validate that the preset list name is \"([^\"]*)\"$")
	public void i_validate_that_the_preset_list_name_is(String listName) {
		boolean listExists = ContentLists.button_view_preset_list(self.driver, listName);
		assert listExists;
	}
	
	@When("I view a custom list named {string}")
	public void i_view_a_custom_list_named(String listName) {
		ContentLists.button_view_custom_list(self.driver, listName);
		
	}
	
	@Then("I validate that the custom list named {string} loads the list details")
	public void i_validate_that_the_custom_list_named_loads_the_list_details(String listName) {
		String msg = self.driver.findElement(By.xpath(ContentLists.text_list_name)).getText();
		assertEquals(listName, msg);
	}
	
	@When("I add a new list named {string}")
	public void i_add_a_new_list_named(String listName) {
		self.driver.findElement(By.xpath(ContentLists.button_new_list)).click();
		self.driver.findElement(By.xpath(ContentLists.button_new_list_name)).click();
		
		//Renaming the new list to listName
		self.driver.findElement(By.xpath(ContentLists.textbox_new_list_name)).click();
		self.driver.findElement(By.xpath(ContentLists.textbox_new_list_name)).clear();
		self.driver.findElement(By.xpath(ContentLists.textbox_new_list_name)).sendKeys(listName);
		self.driver.findElement(By.xpath(ContentLists.button_new_list_save_name)).click();
	}
	
	@When("I add a new rule by Category:")
	public void i_add_a_new_rule_by_category(DataTable dataTable) {
		self.driver.findElement(By.xpath(ContentLists.button_new_list_add_rule)).click();
		ContentLists.dropdown_select_rule_filter_type(self.driver, "Category");
		List<List<String>> data = dataTable.asLists(String.class);
		String str = data.get(1).get(0);
		int i = 1;
		
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "filter":
				i++;
				break;
			case "category":
				ContentLists.dropdown_select_rule_category(self.driver, data.get(i).get(1));
				i++;
				break;
			case "sortby":
				ContentLists.dropdown_select_rule_sort_by(self.driver, data.get(i).get(1));
				i++;
				break;
			case "order":
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).click();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).clear();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).sendKeys(data.get(i).get(1));
				i++;
				break;
			case "direction":
				ContentLists.dropdown_select_rule_direction(self.driver, data.get(i).get(1));
				i++;
				break;
			case "minyear":
				ContentLists.dropdown_select_rule_min_year(self.driver, data.get(i).get(1));
				i++;
				break;
			case "count":
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).click();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).clear();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).sendKeys(data.get(i).get(1));
				i++;
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
		self.driver.findElement(By.xpath(ContentLists.button_add_rule_save)).click();
	}
	
	@When("I add a new rule by Tag:")
	public void i_add_a_new_rule_by_tag(DataTable dataTable) {
		self.driver.findElement(By.xpath(ContentLists.button_new_list_add_rule)).click();
		ContentLists.dropdown_select_rule_filter_type(self.driver, "Tag");
		List<List<String>> data = dataTable.asLists(String.class);
		String str = data.get(1).get(0);
		int i = 1;
		
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "filter":
				i++;
				break;
			case "tag":
				ContentLists.dropdown_select_rule_category(self.driver, data.get(i).get(1));
				i++;
				break;
			case "sortby":
				ContentLists.dropdown_select_rule_sort_by(self.driver, data.get(i).get(1));
				i++;
				break;
			case "order":
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).click();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).clear();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).sendKeys(data.get(i).get(1));
				i++;
				break;
			case "direction":
				ContentLists.dropdown_select_rule_direction(self.driver, data.get(i).get(1));
				i++;
				break;
			case "minyear":
				ContentLists.dropdown_select_rule_min_year(self.driver, data.get(i).get(1));
				i++;
				break;
			case "count":
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).click();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).clear();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_count)).sendKeys(data.get(i).get(1));
				i++;
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
		self.driver.findElement(By.xpath(ContentLists.button_add_rule_save)).click();
	}
	
	@When("I add a new rule by Series:")
	public void i_add_a_new_rule_by_series(DataTable dataTable) {
		self.driver.findElement(By.xpath(ContentLists.button_new_list_add_rule)).click();
		ContentLists.dropdown_select_rule_filter_type(self.driver, "Series");
		List<List<String>> data = dataTable.asLists(String.class);
		String str = data.get(1).get(0);
		int i = 1;
		
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "filter":
				i++;
				break;
			case "series":
				ContentLists.dropdown_select_rule_category(self.driver, data.get(i).get(1));
				i++;
				break;
			case "order":
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).click();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).clear();
				self.driver.findElement(By.xpath(ContentLists.textbox_add_rule_order)).sendKeys(data.get(i).get(1));
				i++;
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
		self.driver.findElement(By.xpath(ContentLists.button_add_rule_save)).click();
	}
	
	@When("I add a new video named {string}")
	public void i_add_a_new_video_named(String videoname) {
		self.driver.findElement(By.xpath(ContentLists.button_new_list_add_video)).click();
		ContentLists.button_select_video_from_list(self.driver, videoname);
	}
	
	
	@Then("I validate that the list name is {string}")
	public void i_validate_that_the_list_name_is(String listName) {
	    String msg = self.driver.findElement(By.xpath(ContentLists.text_validate_list_name)).getText();
	    if(msg.contains(listName))
	    	assert true;
	    else
	    	assert false;
	}
	
	@Then("I validate that a rule is added by category:")
	public void i_validate_that_the_rule_is_added_by_category(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		String str = data.get(1).get(0);
		String msg = "";
		int i = 1;
		
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "filter":
				if(data.get(i).get(1).contains("Category")) 
					i++;
				else
					assert(false);
				break;
			case "category":
				msg = ContentLists.dropdown_get_rule_category(self.driver);
				//System.out.println(data.get(i).get(1) + " msg: " + msg);
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "sortby":
				//System.out.println(" sortby ");
				msg = ContentLists.dropdown_get_rule_sort_by(self.driver);
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "order":
				msg = self.driver.findElement(By.xpath(ContentLists.textbox_get_rule_order)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "direction":
				msg = ContentLists.dropdown_get_rule_direction(self.driver);
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "minyear":
				msg = self.driver.findElement(By.xpath(ContentLists.textbox_get_min_year)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "count":
				msg = self.driver.findElement(By.xpath(ContentLists.textbox_get_rule_count)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
	}
	
	@Then("I validate that a rule is added by tag:")
	public void i_validate_that_the_rule_is_added_by_tag(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		String str = data.get(1).get(0);
		String msg = "";
		int i = 1;
		
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "filter":
				if(data.get(i).get(1).contains("Tag")) 
					i++;
				else
					assert(false);
				break;
			case "tag":
				msg = ContentLists.dropdown_get_rule_category(self.driver);
				//System.out.println(data.get(i).get(1) + " msg: " + msg);
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "sortby":
				//System.out.println(" sortby ");
				msg = ContentLists.dropdown_get_rule_sort_by(self.driver);
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "order":
				msg = self.driver.findElement(By.xpath(ContentLists.textbox_get_rule_order)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "direction":
				msg = ContentLists.dropdown_get_rule_direction(self.driver);
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "minyear":
				msg = self.driver.findElement(By.xpath(ContentLists.textbox_get_min_year)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "count":
				msg = self.driver.findElement(By.xpath(ContentLists.textbox_get_rule_count)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
	}
	
	@Then("I validate that a rule is added by series:")
	public void i_validate_that_the_rule_is_added_by_series(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		String str = data.get(1).get(0);
		String msg = "";
		int i = 1;
		
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "filter":
				if(data.get(i).get(1).contains("Series")) 
					i++;
				else
					assert(false);
				break;
			case "series":
				msg = ContentLists.dropdown_get_rule_category(self.driver);
				//System.out.println(data.get(i).get(1) + " msg: " + msg);
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "order":
				msg = self.driver.findElement(By.xpath(ContentLists.textbox_get_rule_order)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
	}
	
	
	//Functions for validating the Menu Page
	@When("I add a new template menu item named {string} for the {string} screen")
	public void i_add_a_new_template_menu_item_named_for_the_screen(String menuName, String screenName) {
		self.driver.findElement(By.xpath(ContentMenu.button_new_menu_item)).click();
		ContentMenu.edit_template_menu(self.driver, "New Menu Item", "Alya Menu", "TEST");
	}

	@Then("I validate that the template menu item named {string} for the {string} screen exists")
	public void i_validate_that_the_template_menu_item_named_for_the_screen_exists(String menu_name, String screen_name) {
		System.out.println("####Validate the template menu");
		ContentMenu.validate_template_menu(self.driver, menu_name, screen_name);
	}
	
	@When("I add a new parent template menu item named {string}")
	public void i_add_a_new_parent_template_menu_item_named(String name) {
		self.driver.findElement(By.xpath(ContentMenu.button_new_menu_item)).click();
		ContentMenu.edit_parent_template_menu(self.driver, "New Menu Item", name);
	}

	@When("I edit a sub menu named {string} for the {string} screen to the parent template named {string}")
	public void i_edit_a_sub_menu_named_for_the_screen_to_the_parent_template_named(String menuName, String screenName, String templateName) {
		ContentMenu.edit_submenu(self.driver, templateName, "new sub menu", menuName, screenName);
	}
	
	@When("I add a sub menu named {string} for the {string} screen to the parent template named {string}")
	public void i_add_a_sub_menu_named_for_the_screen_to_the_parent_template_named(String menuName, String screenName, String templateName) {
		ContentMenu.button_new_submenu(self.driver, templateName, "new sub menu", menuName, screenName);
	}

	@Then("I validate that the parent template menu item named {string} exists")
	public void i_validate_that_the_parent_template_menu_item_named_exists(String name) {
	    ContentMenu.validate_parent_template_menu(self.driver, name);
	}
	
	//functions for validating the Notifications page
	@When("I create a new text notification:")
	public void i_create_a_new_text_notification(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		self.driver.findElement(By.xpath(ContentNotification.button_text_notification)).click();
		String str = data.get(1).get(0);
		int i = 1;
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "profile":
				ContentNotification.dropdown_select_text_profile(self.driver, data.get(i).get(1));
				i++;
				break;
			case "title":
				self.driver.findElement(By.xpath(ContentNotification.textbox_text_title)).click();
				self.driver.findElement(By.xpath(ContentNotification.textbox_text_title)).clear();
				self.driver.findElement(By.xpath(ContentNotification.textbox_text_title)).sendKeys(data.get(i).get(1));
				i++;
				break;
			case "description":
				self.driver.findElement(By.xpath(ContentNotification.textbox_text_description)).click();
				self.driver.findElement(By.xpath(ContentNotification.textbox_text_description)).clear();
				self.driver.findElement(By.xpath(ContentNotification.textbox_text_description)).sendKeys(data.get(i).get(1));
				i++;
				break;
			case "link":
				//System.out.println(data.get(i).get(0) + " second get " + data.get(i).get(1));
				self.driver.findElement(By.xpath(ContentNotification.textbox_text_link)).click();
				self.driver.findElement(By.xpath(ContentNotification.textbox_text_link)).clear();
				self.driver.findElement(By.xpath(ContentNotification.textbox_text_link)).sendKeys(data.get(i).get(1));
				i++;
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
	}
	
	@Then("I validate that the text notification information is correct:")
	public void i_validate_that_the_text_notification_information_is_correct(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		self.driver.findElement(By.xpath(ContentNotification.button_text_notification)).click();
		String str = data.get(1).get(0);
		String msg = "";
		int i = 1;
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "profile":
				msg = ContentNotification.dropdown_get_text_profile(self.driver, data.get(i).get(1));
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "title":
				msg = self.driver.findElement(By.xpath(ContentNotification.textbox_text_title)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "description":
				msg = self.driver.findElement(By.xpath(ContentNotification.textbox_text_description)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "link":
				//System.out.println(data.get(i).get(0) + " second get " + data.get(i).get(1));
				msg = self.driver.findElement(By.xpath(ContentNotification.textbox_text_link)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
		assert(true);
	}
	
	//functions for validating the Series and Seasons page
	@When("I add a new series")
	public void i_add_a_new_series(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		self.driver.findElement(By.xpath(ContentSeriesAndSeasons.button_new_series)).click();
		String str = data.get(1).get(0);
		int i = 1;
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "title":
				//System.out.println(data.get(i).get(1));
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_title)).click();
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_title)).clear();
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_title)).sendKeys(data.get(i).get(1));
				i++;
				break;
			case "shortdescription":
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_short_description)).click();
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_short_description)).clear();
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_short_description)).sendKeys(data.get(i).get(1));
				i++;
				break;
			case "description":
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_description)).click();
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_description)).clear();
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_description)).sendKeys(data.get(i).get(1));
				i++;
				break;
			case "tags":
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_tag)).click();
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_tag)).clear();
				self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_tag)).sendKeys(data.get(i).get(1));
				i++;
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
	}
	
	@Then("I validate that the series information is correct")
	public void i_validate_that_the_series_information_is_correct(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		//ContentSeriesAndSeasons.button_view_series(self.driver, data.get(1).get(1));
		String str = data.get(1).get(0);
		String msg = "";
		int i = 1;
		while (i <= (data.size()-1)) {
			switch(str.toLowerCase()) {
			case "title":
				msg = self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_title)).getAttribute("value");
				//System.out.println(data.get(i).get(1) + " msg: " +msg);
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "shortdescription":
				msg = self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_short_description)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "description":
				msg = self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_description)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			case "tags":
				msg = self.driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_tag)).getAttribute("value");
				if(data.get(i).get(1).contains(msg)) 
					i++;
				else
					assert(false);
				break;
			}
			if (i <= (data.size()-1))
				str = data.get(i).get(0);
		}
		assert(true);
	}
	

}
