package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllLinks {

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
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize(); // maximizes the window size
		driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();

		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		System.out.println("Total tags are: " + alltags.size()); // print total number of links

		for (int i = 0; i < alltags.size(); i++) {
			System.out.println("Links on the page are: " + alltags.get(i).getAttribute("href"));
			System.out.println("Total tags are: " + alltags.get(i).getText()); //print all links in console
			

		}

	}
}
