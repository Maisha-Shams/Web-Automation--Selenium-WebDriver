package ui;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative_Locators {
	public static String browser = "chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();

		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);

		String title = driver.getTitle();
		System.out.println(title);

		String pagesource = driver.getPageSource();
		System.out.println(pagesource);

		WebElement password = driver.findElement(By.id("password"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(password)).sendKeys("standard_user");

		WebElement username = driver.findElement(By.id("user-name"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(username)).sendKeys("secret_sauce");
		
		//driver.navigate().to("http://google.com");
    	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
//		List<WebElement> webelements = driver.findElements(By.xpath("//div[@class='inventory_list']/div"));
//		System.out.println(webelements);
		
		driver.navigate().to("https://www.aiub.edu/"); //moving from saucedemo to aiub home
		String windowhandle = driver.getWindowHandle();
		System.out.println(windowhandle);
		
		
		driver.findElement(By.xpath("//*[@id=\"top-header\"]/div[2]/div[1]/div[2]/div/ul/li[1]/a/span")).click();
		Set<String> windowhandles= driver.getWindowHandles();
		System.out.println(windowhandles);
	}

}
