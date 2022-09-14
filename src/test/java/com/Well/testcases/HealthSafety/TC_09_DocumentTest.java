package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_09_DocumentTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.HealthSafety.TC_08_ReviewTest.tc_08_ReviewTest" })
	@Parameters({ "SheetName","rowNum" })
	public void tc_09_DocumentTest(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		hsr.UploadDocumentHsr();	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}