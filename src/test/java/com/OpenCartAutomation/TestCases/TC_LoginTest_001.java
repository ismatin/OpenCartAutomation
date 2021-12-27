package com.OpenCartAutomation.TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCartAutomation.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{



	@Test

	public void loginTest() throws InterruptedException {


		LoginPage loginpage=new LoginPage(driver);


		loginpage.clickMyAccount();
		System.out.println("Clicking on My Account");
		logger.info("Clicking on My Account dropdown");
		Thread.sleep(3000);

		loginpage.clickLogin();
		System.out.println("Clicking on Login");
		logger.info("Clicking on Login dropdown");
		
		Thread.sleep(3000);



		boolean emailPresent=driver.findElement(By.id("input-email")).isDisplayed();

		if(emailPresent==true) {

			Assert.assertTrue(true);
			System.out.println("Email text box is present on the login page");
			logger.info("Email text box is present on the login page");
		}
		else {

			Assert.assertTrue(false);
			System.out.println("Email text box is not present on the login page");
			logger.info("Email text box is not present on the login page");

		}

		loginpage.setEmail(config.getProperty("email"));
		System.out.println("Entering email address");
		logger.info("Entering email address");
		
		Thread.sleep(3000);




		boolean passwordPresent=driver.findElement(By.id("input-password")).isDisplayed();
		if(passwordPresent==true) {

			Assert.assertTrue(true);
			System.out.println("Password text box is present on the login page");
			logger.info("Password text box is present on the login page");


		}
		else {

			Assert.assertTrue(false);
			System.out.println("Password text box is not present on the login page");
			logger.info("Password text box is not present on the login page");
		}

		loginpage.setPassword(config.getProperty("password"));
		System.out.println("Entering password");
		logger.info("Entering password");
		
		Thread.sleep(3000);

		
		
		boolean loginBtnPresent=driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed();
		
		if(loginBtnPresent==true) {
			
			Assert.assertTrue(true);
			System.out.println("Login button is present on the login page, Test case passed");
			logger.info("Login button is present on the login page, Test case passed");

		}
		
		else {

			Assert.assertTrue(false);
			System.out.println("Login button is not present on the login page, Test case failed");
			logger.info("Login button is not present on the login page, Test case failed");

		}

		
		
		
		
		
		
		loginpage.clickLoginBtn();
		System.out.println("Clicking on Login button");
		logger.info("Clicking on Login button");
		
		Thread.sleep(3000);

		String expectedTitle="My Account";
		boolean actualTitle=driver.getPageSource().contains("My Account");
		if(actualTitle==true) {

			Assert.assertTrue(true);
			System.out.println("Actual Title-->"+actualTitle +" " +"Expected Title-->"+expectedTitle+ ","+" "+ "Login test case passed....");
			logger.info("Actual Title-->"+actualTitle +" " +"Expected Title-->"+expectedTitle+ ","+" "+ "Login test case passed....");

		}

		else{

			Assert.assertTrue(false);

			System.out.println("Actual Title-->"+actualTitle +" " +"Expected Title-->"+expectedTitle+ ","+" "+ "Login test case failed....");
			logger.info("Actual Title-->"+actualTitle +" " +"Expected Title-->"+expectedTitle+ ","+" "+ "Login test case failed....");


		}

	}



}
