package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class V2_TC_09_ReviewV2ProjectTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.V2_TC_07_ScorecardV2ProjectTest.V2_TC_07_03_UploadAuditDocV2ProjectInsideScorecard" })
	@Parameters({ "SheetName","rowNum" })
	public void V2_TC_09_ReviewV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"V2Project Review Submit Functionality");
		try {
		v2project.ReviewV2Project(SheetName, rowNum);	
	
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
