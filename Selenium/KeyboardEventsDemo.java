package ui;




import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEventsDemo {
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
		driver.get("https://extendsclass.com/text-compare.html");
		driver.manage().window().maximize();
		
		WebElement sourcetextarea = driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]//div[4]/pre/span")); //selecting which area to select to select text.
		
		
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.keyDown(sourcetextarea, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform(); //the keydown method is used to select which key to press
		                                                                                            //after the control key, ctrl+a to select all
		                         																	//then ctrl+c to copy all text
																									//build function is used as multiple tasks are performed here
		WebElement destinationtextarea = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]//div[5]/div[5]/pre/span"));
		Thread.sleep(2000);
		action.keyDown(destinationtextarea, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform(); //pasting the text in the destination area
	}

}
