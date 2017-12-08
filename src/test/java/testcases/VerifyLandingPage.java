package test.java.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class VerifyLandingPage {

	static WebDriver driver=null; 
	Login log=new Login();
	
	public VerifyLandingPage() {
		
	}
	
	@Test
	public void checkTitle() {
	try {
		System.out.println();
		driver=log.driver;
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("Rotimatic Web Console")) {
			System.out.println("Title verified");
		}
		else {
			System.out.println("Found Title as = "+title);
		}
		
	}
	catch(Exception ex) {
		System.out.println(ex.getMessage());
		ex.printStackTrace();
	}
	}
}
