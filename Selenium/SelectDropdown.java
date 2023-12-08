package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {
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
		driver.get("https://www.sugarcrm.com/au/request-demo/");
		driver.manage().window().maximize(); //maximizes the window size
		driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();

		WebElement dropdown = driver.findElement(By.name("awareness_source_c")); //selecting the dropdown using the select class
		Select select = new Select(dropdown);
		
		WebElement firstOption = select.getFirstSelectedOption();
		System.out.println(firstOption.getText()); //first selected option of the dropdown that was already there

		select.selectByValue("Podcast"); //selects from dd using the value attribute
		try {
			Thread.sleep(2000); //creates a delay of 2 secs
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		select.selectByIndex(4); // selects from the dropdown using the index of options available
		try {
			Thread.sleep(2000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		select.selectByVisibleText("Word of Mouth/Referral"); //selects from the dropdown using the visible list shown in the list
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
