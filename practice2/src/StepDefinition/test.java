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

public class test{
	private Self self;
	
	public test(Self self) {
		this.self = self;
	}
	
	/*
    When I am logged in as "inmobly-admin" with the password "support123456"
    Then I validate the login attempt*/
	
	@When("^I am logged in as \"([^\"]*)\" with the password \"([^\"]*)\"$")
	public void i_am_logged_in_as_with_the_password(String arg1, String arg2) throws Throwable {
		System.out.println("####beginning of func");
		self.driver.findElement(By.xpath(DashboardLogin.textbox_username)).click();
		self.driver.findElement(By.xpath(DashboardLogin.textbox_username)).sendKeys(arg1);
		self.driver.findElement(By.xpath(DashboardLogin.testbox_password)).click();
		self.driver.findElement(By.xpath(DashboardLogin.testbox_password)).sendKeys(arg2);
		self.driver.findElement(By.xpath(DashboardLogin.button_signin)).click();
		System.out.println("####before assert");
		self.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		String msg = self.driver.findElement(By.xpath(DashboardLogin.button_inmobly_app)).getText();
		assertEquals(msg, "Inmobly App");
	    throw new PendingException();
	}

    
    @Then("^I validate the login attempt$")
    public void i_validate_the_outcomes() throws Throwable {
    	System.out.println("########## This step validates the automation logged in properly #########");
    	self.driver.findElement(By.xpath(ContentMenu.menubutton_content)).click();
    	self.driver.findElement(By.xpath(ContentMenu.menubutton_menupage)).click();
        throw new PendingException();
    }

}

