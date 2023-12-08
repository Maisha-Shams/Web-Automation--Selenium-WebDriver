package ui2;


import org.testng.SkipException;
import org.testng.annotations.Test;


public class SkipTestDemo {
	
	Boolean datasetup = false;
	
	@Test (enabled = false) // skipping test by using enabled = false 
	public void Test1()
	 {
		
		System.out.println("This test is skipped in the first way- when it is not complete");

	}
	@Test 
	public void Test2()
	 {
		
		System.out.println("This test is skipped in the 2nd way- forcefully");
		throw new SkipException("Skipping this test"); //skipping this test using throw new SkipException. 

	}
	
	@Test 
	public void Test3()
	 {
		
		System.out.println("This test is skipped in the 3rd way- based on condition"); //skipping test based on a condition that a variable is true or false
		if(datasetup==true)
		{
			System.out.println("Execute the test");
		}
		else
		{
			System.out.println("Do not execute further");
			throw new SkipException("Do not execute further");
		}

	}		
}
