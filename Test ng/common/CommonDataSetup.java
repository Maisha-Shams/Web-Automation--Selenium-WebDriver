package common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonDataSetup {
	
	@BeforeSuite
	public void DataSetup() {
		
		System.out.println("Common Data Setup");
		
	}
	
	@AfterSuite
	public void DataTearDown() {
			
			System.out.println("Common Data Cleanup");
			
		}
	

}
