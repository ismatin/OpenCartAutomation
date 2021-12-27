package com.OpenCartAutomation.TestCases_Registration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCartAutomation.PageObjects.RegistrationPage;
import com.OpenCartAutomation.TestCases.BaseClass;

public class TC_Registration_004 extends BaseClass{

	// Test case-: validate warning messages 

	@Test
	public void ValidateMessages() throws InterruptedException {

		RegistrationPage reg=new RegistrationPage(driver);

		reg.click_MyAccount();
		System.out.println("Clicking on My Account");
		logger.info("Clicking on My Account");
		reg.click_Register();
		System.out.println("Clicking on Register");
		logger.info("Clicking on Register");

		Thread.sleep(4000);
		
		reg.click_ContinueBtn();
		Thread.sleep(3000);
		
		System.out.println("Clicking on continue button");
		logger.info("Clicking on continue button");

		
		// First name validation
		
		System.out.println("*********************FirstName warning message validation******************************");
		logger.info("*********************FirstName warning message validation******************************");
		String msg_Firstname=driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).getText();
		System.out.println("First name warning message-->"+msg_Firstname);
		logger.info("First name warning message-->"+msg_Firstname);
		
		if(msg_Firstname.contains("First Name must be between 1 and 32 characters!")) {
			
			Assert.assertTrue(true);
			System.out.println("Warning message is displayed on FirstName field");
			logger.info("Warning message is displayed on FirstName field");
		}
		else {
			
			Assert.assertTrue(false, "Warning message is not displayed on LastName field");
			logger.info("Warning message is not displayed on LastName field");
						
		}
	

		// Last name Validations--------------------------
		System.out.println("*********************LastName warning message validation******************************");
		logger.info("*********************LastName warning message validation******************************");
		

		String msg_Lastname=driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div[@class='text-danger']")).getText();
		System.out.println("Last name warning message-->"+msg_Lastname);	
		logger.info("Last name warning message-->"+msg_Lastname);

		if(msg_Lastname.contains("Last Name must be between 1 and 32 characters!")) {

			Assert.assertTrue(true);
			System.out.println("Warning message is displayed on LastName field");
			logger.info("Warning message is displayed on LastName field");
		}
		else {


			Assert.assertTrue(false, "Warning message is not displayed on LastName field");
			logger.info( "Warning message is not displayed on LastName field");

		}


		// Email Validation
		System.out.println("*********************Email warning message validation******************************");
		logger.info("*********************Email warning message validation******************************");
		
		String msg_Email=driver.findElement(By.xpath("//input[@id='input-email']//following-sibling::div[@class='text-danger']")).getText();
		System.out.println("Email warning message-->"+msg_Email);
		logger.info("Email warning message-->"+msg_Email);
		
		if(msg_Email.contains("E-Mail Address does not appear to be valid!")) {
			
			Assert.assertTrue(true);
			System.out.println("Warning message is displayed on Email field");
			logger.info("Warning message is displayed on Email field");
		}

		else {


			Assert.assertTrue(false, "Warning message is not displayed on Email field");
			logger.info("Warning message is not displayed on Email field");

		}
		
		//Telephone validation
		System.out.println("*********************Telephone warning message validation******************************");
		logger.info("*********************Telephone warning message validation******************************");
		
		String msg_Telephone=driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText();
		System.out.println("Telephone warning message-->"+msg_Telephone);
		logger.info("Telephone warning message-->"+msg_Telephone);
		
		if(msg_Telephone.contains("Telephone must be between 3 and 32 characters!")) {
			
			Assert.assertTrue(true);
			System.out.println("Warning message is displayed on Telephone field");
			logger.info("Warning message is displayed on Telephone field");
		}
		
		else {
			
			Assert.assertTrue(false,"Warning message is not displayed on Telephone field");
			logger.info("Warning message is not displayed on Telephone field");
			
		}
		
		
		// Password Validation
		
		System.out.println("*********************Password warning message validation******************************");
		logger.info("*********************Password warning message validation******************************");
		
		String msg_Password=driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		System.out.println("Password warning message-->"+msg_Password);
		logger.info("Password warning message-->"+msg_Password);
		
		
		if(msg_Password.contains("Password must be between 4 and 20 characters!")) {
			
			Assert.assertTrue(true);
			System.out.println("Warning message is displayed on Password field");
			logger.info("Warning message is displayed on Password field");
		}
		
		else {
			
			Assert.assertTrue(false,"Warning message is not displayed on Password field");
			logger.info("Warning message is not displayed on Password field");
		}
		
		// Privacy Policy
		
		System.out.println("*********************Privacy Policy warning message validation******************************");
		logger.info("*********************Privacy Policy warning message validation******************************");
		
		String msg_PrivacyPolicy=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println("Privacy policy warning message-->"+msg_PrivacyPolicy);
		logger.info("Privacy policy warning message-->"+msg_PrivacyPolicy);
		
		Thread.sleep(3000);
		
		if(msg_PrivacyPolicy.contains("Warning: You must agree to the Privacy Policy!")) {
			
			Assert.assertTrue(true);
			System.out.println("Warning message is displayed on policy field");
			logger.info("Warning message is displayed on policy field");
			
		}
		else {
			
			Assert.assertTrue(false, "Warning message is not displayed on policy field");
			logger.info("Warning message is not displayed on policy field");
			
		}
		

	}
	
	






}
