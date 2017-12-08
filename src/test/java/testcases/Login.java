package test.java.testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
	private static String OSNAMES = System.getProperty("os.name").toLowerCase();
	String OS = OSNAMES.split(" ")[0];
	static WebDriver driver=null; 
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public Login() {
		//this(driver);
	}
	
	
	@Test
	public void tearUP() {
		System.out.println(OS);
		if (OS.equalsIgnoreCase("windows")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+ File.separator + "src" +  File.separator + "test" + File.separator + "java" + File.separator  + "libs" + File.separator  + "DriverBinaries" + File.separator + "chromedriver.exe");
		} else if (OS.equalsIgnoreCase("linux")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+ File.separator + "src" +  File.separator + "test" + File.separator + "java" + File.separator  + "libs" + File.separator  + "DriverBinaries" + File.separator + "chromedriverLinux");
		} else if (OS.equalsIgnoreCase("mac")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+ File.separator + "src" +  File.separator + "test" + File.separator + "java" + File.separator  + "libs" + File.separator  + "DriverBinaries" + File.separator + "chromedriverMac");
		}
		
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
		
		driver=new ChromeDriver(options);
		driver.get("http://34.233.210.158:7000/#/login");
		driver.manage().window().maximize();
		//driver.
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	
	
	@Test
	public void testMe() {
		By button = By.xpath("//*[@id=\"___signin_0\"]/button");
		WebDriverWait wait= new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(button));
		
		driver.findElement(button).click();
	}
}
