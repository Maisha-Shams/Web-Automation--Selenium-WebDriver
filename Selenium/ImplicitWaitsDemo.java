package ui;




import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitsDemo {
	public static String browser = "chrome";
	public static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
		Actions action = new Actions(driver); //action class is used to mouse hover 
		action.moveToElement(element).perform(); //the move to element method is the method to move to the element hover.
//		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// this is an old version of using implicit wait which is deprecated in selenium 4
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // this implicit wait is more recent
		driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a")).click(); //it will work only when synchronization is right
		//waits can be used to fix the synchronization
		
		

	}

}
