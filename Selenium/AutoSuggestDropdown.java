package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {
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
		driver.get("https://www.expedia.com/");
		driver.manage().window().maximize();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//*[@id=\"destination_form_field-menu\"]/div/div/div[1]/button")).click();

		WebElement to = driver.findElement(By.xpath("//*[@id=\"destination_form_field\"]"));

		to.sendKeys("Dhaka");
		try {
			Thread.sleep(3000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		to.sendKeys(Keys.ARROW_DOWN);
		try {
			Thread.sleep(3000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		to.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				

	}

}
