package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo {
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
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.manage().window().maximize();
	    
		JavascriptExecutor jesexec = (JavascriptExecutor) driver; //object created for imported package of JSEXEC		
		
		//print the title of the page 
		String script = "return document.title;";
		String title = (String) jesexec.executeScript(script); //executes the script
		System.out.println(title);
		  
		//click button 
		driver.switchTo().frame("iframeResult"); //switches to the next frame
		jesexec.executeScript("myFunction()"); // executes the myFunction function to click the button 
		Thread.sleep(2000);
		driver.switchTo().alert().accept(); // clicks the cancel prompt when the alert appears and if accept() is used, then clicks ok button on alert.
		  
		//highlight button 
		WebElement button = driver.findElement(By.xpath("/html/body/button"));
		jesexec.executeScript("arguments[0].style.border='5px solid green'", button); // finds the button and highlights it according to the argument
		  
		//scroll using JSEXEC 
		driver.navigate().to("https://www.w3schools.com/");
		WebElement browsetemplatebutton = driver.findElement(By.xpath("//*[@id=\"getdiploma\"]/div/a"));
	    jesexec.executeScript("arguments[0].scrollIntoView(true);", browsetemplatebutton);

			/*
			 * //Generate Alert window
			 * jesexec.executeScript("alert('Welcome to Sotware Testing Help');");
			 */
		
		driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox");
		driver.switchTo().frame("iframeResult"); //switching frames as the checkbox is in another frame
		jesexec.executeScript("document.getElementById('vehicle2').click();"); //finds the checkbox by Id and clicks it
		Thread.sleep(2000);
		WebElement submitbtn = driver.findElement(By.xpath("//input[@value='Submit']")); 
		submitbtn.click();
		

	}

}
