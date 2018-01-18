package automation_verification.BL_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class prototype {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		String appUrl = "http://toolsqa.com/selenium-webdriver/testng-introduction/";
		//String currentUrl="";
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(appUrl);
		driver.manage().window().maximize();
		String expectedTitle = "http://toolsqa.com/selenium-webdriver/testng-introduction/";
		//Actions actions = new Actions(driver);
		if (expectedTitle.equals(appUrl)) {
		System.out.println("Verification Succesful - The correct title is displayed on the web page");
	}
	else
	{
		System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
	}
}
	}