package ui;


import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {
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
		driver.get("https://www.salesforce.com/in/?ir=1");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"1682326631687_yaw\"]/div[1]/article/div[2]/div/pbc-button[1]/a")).click();
		try {
			Thread.sleep(2000); //creates a delay of 2 secs
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		
		driver.switchTo().window(childwindow);
		
		
		driver.findElement(By.name("UserFirstName")).sendKeys("Maisha");
		driver.findElement(By.name("UserLastName")).sendKeys("Shams");
		try {
			Thread.sleep(2000); //creates a delay of 2 secs
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().window(parentwindow);

	}

}
