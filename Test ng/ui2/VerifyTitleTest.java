package ui2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleTest {
	@Test
	public void TitleTest() {
		
		String expectedtitle = "HR Automation Solution";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://test.aqualinkhr.com/login");
		driver.manage().window().maximize();
		
		String actualtitle = driver.getTitle();
		
		Assert.assertEquals(actualtitle, expectedtitle); // Assert class is used to verify in the text are equal to each other
		driver.close();
	

}
}
