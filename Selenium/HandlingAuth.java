package ui;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAuth {
	public static String browser = "chrome";
	public static WebDriver driver;
	
	public static String username = "admin"; //this is the username that will be read from a file and stored in a variable
	public static String password = "admin"; //this is the username that will be read from a file and stored in a variable


	public static void main(String[] args)  {
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth"); // here the username and password are sent in the url to handle the Auth popup
		
		driver.manage().window().maximize();
		
		// The actual url : https://the-internet.herokuapp.com/basic_auth
		

	}

}
