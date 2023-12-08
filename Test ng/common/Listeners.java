package common;

import java.io.IOException;


import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.testUtils;

public class Listeners extends testUtils implements ITestListener{
	

	public void	onTestStart​(ITestResult result)
	{
		System.out.println("Test is starting");
	}
	
	public void	onTestFailure​(ITestResult result)
	{
		System.out.println("Test failed- Ss captured");
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
