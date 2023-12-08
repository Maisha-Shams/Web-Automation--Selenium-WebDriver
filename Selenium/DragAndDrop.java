package ui;




import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
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
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe")); 
		// if the web element is inside a frame, it first needs to switch to that frame to find the web element.		
		driver.switchTo().frame(frame);
		WebElement drag = driver.findElement(By.id("draggable")); //locating which element to drag
		WebElement drop = driver.findElement(By.id("droppable")); // locating on which element to drop on
		
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).perform(); // method for drag and drop under the Actions class
		

	}

}
