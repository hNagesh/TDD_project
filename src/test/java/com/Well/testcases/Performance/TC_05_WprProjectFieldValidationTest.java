package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_05_WprProjectFieldValidationTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Performance.TC_03_SubscribeAndStoreIdTest.TC_03_SubscribeAndStoreId" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_05_WprProjectFieldValidation(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		performance.WprProjectFieldValidationTest(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}