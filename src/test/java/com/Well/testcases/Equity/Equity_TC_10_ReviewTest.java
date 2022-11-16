package com.Well.testcases.Equity;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Equity_TC_10_ReviewTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Equity.Equity_TC_09_DocumentTest.Equity_TC_09_03_FeatureDocument" })
	@Parameters({ "SheetName","rowNum" })
	public void Equity_TC_10_Review(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName, "Equity Review Submit Functionality");
		try {
			equity.WERReview(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
