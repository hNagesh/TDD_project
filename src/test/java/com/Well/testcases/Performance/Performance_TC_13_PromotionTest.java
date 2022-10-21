package com.Well.testcases.Performance;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Performance_TC_13_PromotionTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.Performance.Performance_TC_08_ReviewTest.Performance_TC_08_Review" })
	@Parameters({ "SheetName","rowNum" })
	public void Performance_TC_13_Promotion(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
			rc.promotionCardValidation(SheetName, rowNum,"1");
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
