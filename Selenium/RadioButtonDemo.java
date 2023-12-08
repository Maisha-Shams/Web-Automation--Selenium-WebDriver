package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonDemo {
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
		driver.get("https://flightexpert.com/?gad=1&gclid=CjwKCAjwseSoBhBXEiwA9iZtxp1ha2VbfnjD-SzoBSS088R3FmAYQuLDnCabqssqdjHbgqriqQknXBoCC90QAvD_BwE");
		driver.manage().window().maximize();
		
		WebElement radio3 = driver.findElement(By.id("inline-3")); // find the element by its unique Id and storing it in a web element.
		WebElement radio1 = driver.findElement(By.id("inline-1"));
		try {
			Thread.sleep(2000); //creates a delay of 2 secs
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		radio3.click(); // click the radio button
		System.out.println(radio3.isSelected());// to understand that the radio button3 is selected	
		System.out.println(radio1.isSelected()); // to understand that the radio button1 is selected 
		System.out.println(driver.findElements(By.xpath("//*[@type='radio']")).size()); //finding the total no. of radio buttons on a particular page.
		
		try {
			Thread.sleep(1000); //creates a delay of 1 secs
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();

	}

}
