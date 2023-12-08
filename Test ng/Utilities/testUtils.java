package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import common.BaseTest;

public class testUtils extends BaseTest {
	
	public void getScreenshot() throws IOException
	{
		Date currDate = new Date();
		String screenshotFilename = currDate.toString().replace(" ", "-").replace(":", "-");
		System.out.println(screenshotFilename);
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenshotFilename+".png"));
	}

}
