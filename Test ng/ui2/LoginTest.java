package ui2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest { //no main method needed as in Webdriver, the methods here are our test cases 

	@BeforeTest 
	public void LogintoApp()
	{
		System.out.println("Login to Application");
	}
	
	
	@AfterTest
	public void LogouttoApp()
	{
		System.out.println("Logout from Application");
	}
	@BeforeMethod // the methods will be executed before all Tests
	public void ConnecttoDB()
	{
		System.out.println("Db connected");
	}
	
	@AfterMethod
	public void DisconnectfromDB()
	{
		System.out.println("Disconnect DB");
	}
	
	@Test (priority = 2, description = "This is log in Test") // setting priority means that this test will run 2nd and desc gives desc for the method
	public void loginTest()
	 {
		
		System.out.println("Test1");

	}
	@Test (priority = 1,  description = "This is log out Test") // setting priority means that this test will run 1st and desc gives desc for the method
	public void logoutTest()
	 {
		
		System.out.println("Test2");

	}

}
