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
import UseCaseTests.DasboardLoginTest;

public class Steps {
	private Self self;
	
	public Steps(Self self) {
		this.self = self;
	}
	
	@Before("@launchDashboard")
	public void i_launch_the_dashboard_in_chrome() {
		self.driver = new ChromeDriver();
		self.driver.manage().window().maximize();
		self.driver.get("https://ott.bolt-play.com/login");
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("^I am logged in as \"([^\"]*)\" with the password \"([^\"]*)\"$")
	public void i_am_logged_in_as_with_the_password(String arg1, String arg2) throws Throwable {
		System.out.println("beginning of func");
		self.driver.findElement(By.xpath(DashboardLogin.textbox_uername)).click();
		self.driver.findElement(By.xpath(DashboardLogin.textbox_uername)).sendKeys("inmobly-admin");
		self.driver.findElement(By.xpath(DashboardLogin.testbox_password)).click();
		self.driver.findElement(By.xpath(DashboardLogin.testbox_password)).sendKeys("support123456");
		self.driver.findElement(By.xpath(DashboardLogin.button_signin)).click();
		System.out.println("before assert");
		self.driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		String msg = self.driver.findElement(By.xpath(DashboardLogin.button_inmobly_app)).getText();
		assertEquals(msg, "Inmobly App");
	    throw new PendingException();
	}
        
	
    @When("^Enter the Username and Password$")
    public void enter_the_Username_and_Password() throws Throwable
    {
       System.out.println("This step enter the Username and Password on the login page.");
    }

    @Then("^Reset the credential$")
    public void Reset_the_credential() throws Throwable 							
    {
        System.out.println("This step click on the Reset button.");
    }

}
