package ui2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitleAndTextTest {
	@Test
	public void TitleTest() throws InterruptedException {
		
		SoftAssert softassert = new SoftAssert();
		
		String expectedText = "submit-login"; //wrong input given
		String expectedtitle = "HR Automation Solution";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://test.aqualinkhr.com/login");
		driver.manage().window().maximize();
		
		String actualtitle = driver.getTitle();
		
		softassert.assertEquals(actualtitle, expectedtitle, "Title verification failed"); // Assert class is used to verify in the text are equal to each other
		
		String actualText = driver.findElement(By.xpath("//*[@id=\"submit-login\"]")).getAttribute("id");
		softassert.assertEquals(actualText, expectedText, "Text verification failed");
		
		//softassert.assertEquals(actualtitle, expectedtitle, "Text Verification Failed"); // soft assert allows for all lines to be executed even if some test in the middle does 
		driver.findElement(By.name("email")).sendKeys("george@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345678");
		driver.findElement(By.xpath("//*[@id=\"submit-login\"]")).click();
		Thread.sleep(2000);
		driver.close();
		
		softassert.assertAll(); // needed to report any failures that might have taken place in between the code. This should be placed below the entire code
		
		
	

}
}
