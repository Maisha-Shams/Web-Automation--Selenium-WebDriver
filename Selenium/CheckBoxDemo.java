package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxDemo {
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
		driver.findElement(By.name("add-flight-switch")).click();
		try {
			Thread.sleep(2000); //creates a delay of 2 secs
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.name("add-flight-switch")).click();
		

		
				

	}

}
