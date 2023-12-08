package ui;




import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizeDemo {
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
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")); 
		// if the web element is inside a frame, it first needs to switch to that frame to find the web element.		
		driver.switchTo().frame(frame);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]")); //locating which element to resize

		
		Actions action = new Actions(driver);
		try {
			Thread.sleep(2000); //creates a delay of 2 secs
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		action.dragAndDropBy(element, 200, 230).perform();// method for drag and drop to resize under action class 
		

	}

}
