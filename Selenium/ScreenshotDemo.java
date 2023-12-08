package ui;




import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDemo {
	public static String browser = "chrome";
	public static WebDriver driver;


	public static void main(String[] args) throws InterruptedException, IOException {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		
		Date currDate = new Date();
		String screenshotFilename = currDate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotFilename);
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenshotFilename+".png"));
		
		driver.close();

	}

}
