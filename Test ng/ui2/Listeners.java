package ui2;


import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners  implements ITestListener{
	
	public void	onTestStart​(ITestResult result)
	{
		System.out.println("Test is starting");
	}


}
