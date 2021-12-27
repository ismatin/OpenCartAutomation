package com.OpenCartAutomation.TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateReportTimestamp {
	
	
	public static void main(String[] args) {
		
		
		String timestamp=new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());
		System.out.println("Automation_Report"+timestamp+".html");
		
	
	}

}
