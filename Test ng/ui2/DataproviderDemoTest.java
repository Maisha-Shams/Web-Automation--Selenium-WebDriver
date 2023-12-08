package ui2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderDemoTest {
	
	@Test(dataProvider= "dataSet") //data needs to be provided to this test, so the method name is added to the test
	public void test(String username, String password)
	{
		System.out.println(username+"===="+password);
	}
	
	
	@Test(dataProvider= "dataSet1") //data needs to be provided to this test, so the method name is added to the test
	public void test(String username, String password, String test)
	{
		System.out.println(username+"===="+password+"===="+"test");
	}
	
	@DataProvider
	public Object[][] dataSet1() 
	{
		return new Object[][] 
		{
			{"username1","password1","test1"},
			{"username2","password2","test2"},
			{"username3","password3","test3"},
			{"username4","password4","test4"}
		};		
		
	}
	
	@DataProvider
	public Object[][] dataSet() 
	{
		Object[][] dataset= new Object[4][2]; //reading data from a data set where a multi-dimentional object array is need with [rows][columns]
		
		//first row
		dataset[0][0]= "user1";
		dataset[0][1]= "pass1";
		
		//second row
		dataset[1][0]= "user2";
		dataset[1][1]= "pass2";
		
		//third row
		dataset[2][0]= "user3";
		dataset[2][1]= "pass3";
		
		//fourth row
		dataset[3][0]= "user4";
		dataset[3][1]= "pass4";
					
		return dataset;
		
		
	}

}
