package ui2;


import org.testng.annotations.Test;


public class GroupTestDemo {
	
	@Test (priority = 2, groups= "regression") // 
	public void loginTest()
	 {
		
		System.out.println("loginTest");

	}
	@Test (priority = 1, groups= "regression") // 
	public void logoutTest()
	 {
		
		System.out.println("logoutTest");

	}
	
	@Test (priority = 1,  groups= {"regression","bvt"}) 
	public void Test1()
	 {
		
		System.out.println("Test1");

	}
	
	@Test (priority = 1, groups= "bvt") // 
	public void Test2()
	 {
		
		System.out.println("Test2");

	}
}
