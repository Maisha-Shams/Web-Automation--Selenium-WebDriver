package ui;




import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingSSLerrors {
	public static String browser = "chrome";
	public static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.setAcceptInsecureCerts(true);
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		
		WebDriver driver = new ChromeDriver(options);
		
		
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		
	

	}

}
