package ui;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo {
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
		driver.get("http://test.aqualinkhr.com/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("client@aqualinkbd.xyz");
		driver.findElement(By.id("password")).sendKeys("12345678");
		
		driver.findElement(By.id("submit-login")).click();
		driver.findElement(By.xpath("//*[@id=\"sideMenuScroll\"]/ul/li[17]/a")).click();
		WebElement element = driver.findElement(By.xpath("//*[@id=\"settingsMenu\"]/li[22]/a"));
		Actions action = new Actions(driver); //action class 
		action.scrollToElement(element).perform();//the scroll to method scrolls to the required location
		element.click();
		
	

		
	}

}
