package ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demoiframe {
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
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
		//driver.switchTo().frame(0); //this is the first frame on the page to click on
		WebElement frame1 = driver.findElement(By.id("iframeResult"));// selecting frame by its ID
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("/html/body/button")).click(); //click the ok button 
		Alert alertonpage = driver.switchTo().alert(); 
		
//		String alertText = driver.switchTo().alert().getText();
//		System.out.println(alertText);
//		try {
//			Thread.sleep(1000); //creates a delay of 1 secs
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		driver.switchTo().alert().accept();
//		driver.switchTo().parentFrame();
//		System.out.println(driver.getTitle());
		alertonpage.sendKeys("Maisha Rocks");
		alertonpage.accept();

	}

}
