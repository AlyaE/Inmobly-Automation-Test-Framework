package Utility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import managers.PageObjectManager;

public class Self {
	public ChromeDriver driver;
	
	public Self(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ott.bolt-play.com/login");
	}
	
	public ChromeDriver getChromeDriver() {
		return driver;
	}


}
