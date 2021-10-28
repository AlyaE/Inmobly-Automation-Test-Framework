package UseCaseTests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.DashboardLogin;
import Pages.ContentSeriesAndSeasons;

public class CreateNewSeriesTest {
private static WebDriver driver = null;
	
	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//navigate to Screens page
		ContentSeriesAndSeasons.login(driver);
		driver.findElement(By.xpath(ContentSeriesAndSeasons.menubutton_content)).click();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.menubutton_series_and_seasons)).click();
	}
	
	
	@Test
	public static void add_new_series_test() {
		driver.findElement(By.xpath(ContentSeriesAndSeasons.button_new_series)).click();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_title)).click();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_title)).clear();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_title)).sendKeys("Series Name");

		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_short_description)).click();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_short_description)).clear();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_short_description)).sendKeys("Short description of the series goes here. describe the plot, characters, etc...");

		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_description)).click();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_description)).clear();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_description)).sendKeys("More detailed description here \nAnother detail \nAnother detail\n");

		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_tag)).click();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_tag)).clear();
		driver.findElement(By.xpath(ContentSeriesAndSeasons.textbox_new_series_tag)).sendKeys("Comedy");
		
		//Saves the Series
		//driver.findElement(By.xpath(ContentSeriesAndSeasons.button_new_series_save)).click();
	}
	
	@AfterSuite
	public static void teardown() {
		//driver.close();
	}
}
