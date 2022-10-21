package com.Well.testcases.HealthSafety;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class Healthsafey_TC_11_TeamTest extends BaseClass {

	@Test//(dependsOnMethods = { "com.Well.testcases.HealthSafety.Healthsafey_TC_08_ReviewTest.Healthsafey_TC_08_Review" })
	@Parameters({ "SheetName","rowNum" })
	public void Healthsafey_TC_11_Team(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName,"Adding Inviting Team member for Project Functionality");
		try {
			rc.team(SheetName, rowNum);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
