package com.OpenCartAutomation.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;




public class BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	public static Properties config;
	public static FileInputStream file;
	
	@Parameters("browser")
	@BeforeClass
	
	public void setup(String browser) throws IOException {
		
		config=new Properties();
		file=new FileInputStream("./"+"\\Configuration\\config.properties");
		config.load(file);
		
		logger=Logger.getLogger("OpenCartAutomation");
		PropertyConfigurator.configure("log4j.properties");
		
	
		if(browser.equalsIgnoreCase("chrome")) {
			
			logger.info("************** Executing on chrome browser ***************");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			
			logger.info("************** Executing on firefox browser ***************");
			
			System.setProperty("webdriver.gecko.driver", "./Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("ie")) {
			
			logger.info("************** Executing on IE browser ***************");
			
			System.setProperty("webdriver.ie.driver", "./Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else {
			
			System.out.println("Browser is not availabel to launch the application");
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//String AppURL="https://demo.opencart.com/index.php?route=common/home";
		driver.get(config.getProperty("application_url"));
		System.out.println("Entered the application URL :"+config.getProperty("application_url"));
		logger.info("Entered the application URL :"+config.getProperty("application_url"));
	
	
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		logger.info("Closing the browser");
	}
	
	
	public static boolean isElementPresentByAnyLocaters(By by) {
		
		try {
			
			driver.findElement(by).isDisplayed();
			return true;
			
		}catch(Throwable t) {
			
			return false;
			
		}
		
	}
	
	
	
	public static String generateRandomEmail() {
		
		
		String randomAlphabets=RandomStringUtils.randomAlphabetic(3);
		return randomAlphabets;
		
	}
	

}
