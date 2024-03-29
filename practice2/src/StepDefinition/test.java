package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.DashboardLogin;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.DashboardLogin;
import Pages.ContentMenu;
import Utility.Self;

public class test extends Self{
	private Self self;
	
	public test(Self self) {
		this.self = self;
	}
	
	
	@Before("@launchDashboard")
	public void i_launch_the_dashboard_in_chrome() {
		self.driver = new ChromeDriver();
		self.driver.manage().window().maximize();
		self.driver.get("https://ott.bolt-play.com/login");
	}
	
	/*
    When I am logged in as "inmobly-admin" with the password "support123456"
    Then I validate the login attempt*/
	
	@When("^I am logged in as \"([^\"]*)\" with the password \"([^\"]*)\"$")
	public void i_am_logged_in_as_with_the_password(String arg1, String arg2){
		System.out.println("####beginning of func");
		self.driver.findElement(By.xpath(DashboardLogin.textbox_username)).click();
		self.driver.findElement(By.xpath(DashboardLogin.textbox_username)).sendKeys(arg1);
		self.driver.findElement(By.xpath(DashboardLogin.testbox_password)).click();
		self.driver.findElement(By.xpath(DashboardLogin.testbox_password)).sendKeys(arg2);
		self.driver.findElement(By.xpath(DashboardLogin.button_signin)).click();
	}

    
    @Then("^I validate the login attempt$")
    public void i_validate_the_outcomes() {
    	System.out.println("####proof of validation of login step");
    	self.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		String msg = self.driver.findElement(By.xpath(DashboardLogin.button_inmobly_app)).getText();
		assertEquals(msg, "Inmobly App");
    }

}

