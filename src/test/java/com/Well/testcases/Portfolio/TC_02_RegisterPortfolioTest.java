package com.Well.testcases.Portfolio;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_02_RegisterPortfolioTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.login.TC_01_LoginTest.TC_01_Login" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_02_RegisterPortfolio() throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);

		try {
        portfolio.RegisterPortfolio();
			
		} 
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
