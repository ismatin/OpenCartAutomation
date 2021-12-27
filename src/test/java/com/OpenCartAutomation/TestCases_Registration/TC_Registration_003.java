package com.OpenCartAutomation.TestCases_Registration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCartAutomation.PageObjects.RegistrationPage;
import com.OpenCartAutomation.TestCases.BaseClass;



public class TC_Registration_003 extends BaseClass

{


	@Test
	public void Validate_Registration() throws InterruptedException {

		RegistrationPage register=new RegistrationPage(driver);
		register.click_MyAccount();
		System.out.println("Clicking on My Account");
		logger.info("Clicking on My Account");

		register.click_Register();
		System.out.println("Clicking on Register");
		logger.info("Clicking on Register");

		Thread.sleep(4000);
		// Validate register bread crumb
		String accountBreadcrumb=driver.findElement(By.xpath("//ul[@class='breadcrumb']//li[2]//a[contains(text(),'Account')]")).getText();
		System.out.println("Getting Account breadcrumb text-->"+accountBreadcrumb);
		logger.info("Getting Account breadcrumb text-->"+accountBreadcrumb);

		String registerBreadcrumb=driver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[3]/a")).getText();
		System.out.println("Getting Register breadcrumb text-->"+registerBreadcrumb);
		logger.info("Getting Register breadcrumb text-->"+registerBreadcrumb);

		if(accountBreadcrumb.contains("Account")) {

			Assert.assertTrue(true);
			System.out.println("Account breadcrumb is present on the web page");
			logger.info("Account breadcrumb is present on the web page");

		}
		else {

			Assert.assertTrue(false,"Account breadcrumb is not present on the web page");
			logger.info("Account breadcrumb is not present on the web page");

		}




		register.set_FirstName("Test");
		System.out.println("Entering firstname");
		logger.info("Entering firstname");

		register.set_Lastname("Test");
		System.out.println("Entering lastname");
		logger.info("Entering lastname");

		register.set_Telephone("988798797");
		System.out.println("Entering telephone number");
		logger.info("Entering telephone number");


		//Random Email Generation

		String RandomEmail="Test"+randomEmail()+"@gmail.com";

		System.out.println("RandomEmail-->"+RandomEmail);
		register.set_Email(RandomEmail);
		System.out.println("Entering email");
		logger.info("Entering email-->"+RandomEmail);

		register.set_Password("Test@123");
		System.out.println("Entering password");
		logger.info("Entering password");

		register.set_ConfirmPassword("Test@123");
		System.out.println("Entering confirm password");
		logger.info("Entering confirm password");

		register.click_PrivacyPolicy();
		System.out.println("Clicking on privacy policy");
		logger.info("Clicking on privacy policy");

		register.click_ContinueBtn();
		System.out.println("Clicking on continue button");
		logger.info("Clicking on continue button");

		Thread.sleep(8000);


		// Validate successful regostration

		if(driver.getTitle().contains("Your Account Has Been Created!")) {

			Assert.assertTrue(true);
			System.out.println("Registration successed...Test case passed");
			logger.info("Registration successed...Test case passed");
		}
		else {

			// Validate email is already registered 
			String warningMsg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
			System.out.println("Registration Test failed reason-->"+warningMsg);
			logger.info("Registration Test failed reason-->"+warningMsg);

			Assert.assertTrue(false);	


		}




	}



	public String randomEmail() {

		String numbers=RandomStringUtils.randomNumeric(3);
		
		// Or we can use this type of email-
		//String alphabets=RandomStringUtils.randomAlphabetic(3);  // it will return A-Z 


		return numbers;
	}



}
