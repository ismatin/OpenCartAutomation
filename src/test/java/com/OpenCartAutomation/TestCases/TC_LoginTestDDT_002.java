package com.OpenCartAutomation.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OpenCartAutomation.PageObjects.LoginPage;
import com.OpenCartAutomation.Utilities.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClass {



	@Test(dataProvider="LoginData")
	public void LoginDDTTest(String email, String pwd) throws InterruptedException {

		LoginPage lp=new LoginPage(driver);
		
		lp.clickMyAccount();
		System.out.println("Clicking on My Account");
		logger.info("Clicking on My Account dropdown");
		
		lp.clickLogin();
		System.out.println("Clicking on Login");
		logger.info("Clicking on Login dropdown");
		
		
		
		lp.setEmail(email);
		System.out.println("Entering Email id-->"+email);
		logger.info("Entering Email id-->"+email);
		
		Thread.sleep(2000);
		lp.setPassword(pwd);
		System.out.println("Entering passoword-->"+pwd);
		logger.info("Entering password-->"+pwd);
		
		Thread.sleep(2000);
		
		lp.clickLoginBtn();
		
		if(driver.getTitle().contains("My Account")) {
			
			Assert.assertTrue(true);
			System.out.println("Login test case passed....");
			logger.info("Login test case passed....");

		}
		else {
			
			String errorMessage=driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
			System.out.println(errorMessage);
			Assert.assertTrue(false,"Test case failed" +errorMessage);
		}
		
		//My Account
		lp.clickMyAccount();
		System.out.println("Clicking on My Account to logout");
		logger.info("Clicking on My Account to logout ");
		
		
		// Logout
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Clicking on logout from dropdown");
		logger.info("Clicking on logout from dropdown");
		
		
		Thread.sleep(3000);
		
		// MyAccunt
		lp.clickMyAccount();
		System.out.println("Clicking on My Account to login");
		logger.info("Clicking on My Account to login ");
		
		
		// Login page
		lp.clickLogin();
		System.out.println("Clicking on login from dropdown");
		logger.info("Clicking on login from dropdown");
		
		
		
		

	}


	@DataProvider(name="LoginData")

	public String[][] getData() throws IOException {

		
		// Define testdata sheet path
		String excelPath=System.getProperty("user.dir")+"/src/test/java/com/OpenCartAutomation/TestData/LoginData.xlsx";
		
		// Get no of rows
		int rowCount=XLUtils.getRowCount(excelPath, "Sheet1");
		
		// Get no of columns
		int colCount=XLUtils.getCellCount(excelPath, "Sheet1", 1);

		// Define 2D array
		String logindata[][]=new String[rowCount][colCount];

		//This is for Row
		for(int i=1;i<=rowCount;i++) {

			// This is for column
			for(int j=0;j<colCount;j++) {

				// Store test data from excel to 2D Array
				logindata[i-1][j]=XLUtils.getCellData(excelPath, "Sheet1", i, j);
				
			}


		}

		return logindata;
		


	}














}
