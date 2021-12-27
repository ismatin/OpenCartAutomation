package com.OpenCartAutomation.TestCases_Registration;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OpenCartAutomation.PageObjects.RegistrationPage;
import com.OpenCartAutomation.TestCases.BaseClass;

public class TC_Subscription_005 extends BaseClass{


	@Test
	public void Validate_Subscription() {

		RegistrationPage reg=new RegistrationPage(driver);

		reg.click_MyAccount();
		System.out.println("Clicking My Account from dropdown");
		
		
		reg.click_Register();
		System.out.println("Clicking Register from dropdown");
		
		// Validate title-> Register Account
		
		System.out.println("********************Validating title--> Register Account********************");
		String title_RegsisterAccount=driver.getTitle();

		if(title_RegsisterAccount.contains("Register Account")) {

			Assert.assertTrue(true);
			System.out.println("Register Account title is matched...Test case passed");


		}
		else {

			Assert.assertTrue(false,"Register Account title is matched...Test case failed");


		}

		reg.set_FirstName("Test");
		System.out.println("Entering firstname");
		
		
		reg.set_Lastname("Test");
		System.out.println("Entering lastname");
		
		// Generate random email

		String randomEmail=generateRandomEmail()+"@gmail.com";
		reg.set_Email(randomEmail);
		System.out.println("Entering email");
		
		reg.set_Telephone("989979798");
		System.out.println("Entering telephone");
		
		reg.set_Password("Test@123");
		System.out.println("Entering password");
		
		reg.set_ConfirmPassword("Test@123");
		System.out.println("Entering confirm password");
		
		reg.click_SubscriptionRegisterAccount();
		System.out.println("Clicking on subscription YES");
		
		reg.click_PrivacyPolicy();
		System.out.println("Clicking on privacy policy");
		
		reg.click_ContinueBtn();
		System.out.println("Clicking on continue button of the Registration page");
		

		// Validate registration success title

		System.out.println("********************Validating title--> Registration success title********************");
		
		String titleRegisterSuccess=driver.getTitle();
		if(titleRegisterSuccess.contains("Your Account Has Been Created!")) {

			Assert.assertTrue(true);
			System.out.println("Registration successed...Test case passed");
		}
		else {

			Assert.assertTrue(false, "Registration is not successed.. Test case failed");
		}

		// Validate details1
		System.out.println("********************Validating Info Details1-->********************");
		
		boolean flag=reg.Validate_Details1();
		if(flag==true) {

			Assert.assertTrue(true);
			System.out.println("Details 1 is present on the registration success page..Test case passed");

		}
		else {

			Assert.assertTrue(false,"Details 1 is not present on the registration success page..Test case failed");
		}


		// Validate details2
		System.out.println("********************Validating Info Details2-->********************");
		
		

		boolean res=reg.Validate_Details2();
		if(res==true) {


			Assert.assertTrue(true);
			System.out.println("Details 2 is present on the registration success page..Test case passed");


		}
		else {

			Assert.assertTrue(false,"Details 2 is not present on the registration success page..Test case failed");
		}


		// Validate details3
		System.out.println("********************Validating Info Details3-->********************");
		
		

		boolean res3=reg.Validate_Details3();
		if(res3==true) {


			Assert.assertTrue(true);
			System.out.println("Details 3 is present on the registration success page..Test case passed");


		}
		else {

			Assert.assertTrue(false,"Details 3 is not present on the registration success page..Test case failed");
		}


		// Validate details4
		System.out.println("********************Validating Info Details4-->********************");
		
		
		boolean res4=reg.Validate_Details4();
		if(res4==true) {


			Assert.assertTrue(true);
			System.out.println("Details 4 is present on the registration success page..Test case passed");


		}
		else {

			Assert.assertTrue(false,"Details 4 is not present on the registration success page..Test case failed");
		}



		// click_btnContinueRegistrationPage

		reg.click_btnContinueRegistrationPage();
		System.out.println("Clicking on the continue button of the registration page ");

		// Validate Title My Account
		System.out.println("********************Validating title-->My Account********************");
		
		String title_MyAccount=driver.getTitle();
		
		if(title_MyAccount.contains("My Account")) {
			
			Assert.assertTrue(true);
			System.out.println("Title My Account is matched---Test Case passed");
		}
		else {
			
			Assert.assertTrue(false, "Title My Account is not matched---Test Case failed");
		}

		
		// Click subscribe
		reg.click_subscriptionLink();
		System.out.println("Clicking on the subscription link");
		
		
		// Validate Title Newsletter Subscription
		System.out.println("********************Validating title-->Newsletter Subscription********************");
		
		String title_NewsLetter=driver.getTitle();
		if(title_NewsLetter.contains("Newsletter Subscription")) {
			
			Assert.assertTrue(true);
			System.out.println("Title Newsletter Subscription is matched---Test case passed");
			
		}
		else {
			
			Assert.assertTrue(false,"Title Newsletter Subscription is not matched---Test case failed");
		}
		
		
		// Validate subscription Yes
		System.out.println("********************Validating Subscription -->YES********************");
		
	boolean resSubscription=reg.Validate_SubscriptionYes();
		
		if(resSubscription==true) {
			
			Assert.assertTrue(true);
			System.out.println("Subscription YES is selected---Test case passed");
		}

		else {
			
			Assert.assertTrue(false,"Subscription YES is not selected---Test case failed");
			
		}
		
		// click_continueBtn_NewsletterSub
		reg.click_continueBtn_NewsletterSub();
		System.out.println("Clicking on Continue button of the newsletter subscription");
		
		
		// Validate titleSuccess
		System.out.println("********************Validating Title succee -->********************");
		
		if(driver.getPageSource().contains(" Success: Your newsletter subscription has been successfully updated!")) {
			
			Assert.assertTrue(true);
			System.out.println(" Success: Your newsletter subscription has been successfully updated!---Test case passed");
		}
		else {
			
			Assert.assertTrue(false," Failed: Your newsletter subscription has not been successfully updated!---Test case failed");
		}
		
		
		
	}







}
