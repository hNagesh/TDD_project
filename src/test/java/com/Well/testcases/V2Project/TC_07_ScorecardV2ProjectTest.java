package com.Well.testcases.V2Project;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_07_ScorecardV2ProjectTest extends BaseClass {


	@Test(dependsOnMethods = { "com.Well.testcases.V2Project.TC_06_AgreementV2ProjectTest.TC_06_AgreementV2Project" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_07_ScorecardV2Project(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		v2project.BuildScorecardV2ProjectById(SheetName, rowNum);	
		v2project.CompleteScorecardV2ProjectById(SheetName, rowNum);
		v2project.UploadFeatureDocV2ProjectInsideScorecard(SheetName, rowNum);
		v2project.UploadAuditDocV2ProjectInsideScorecard(SheetName, rowNum);

		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
