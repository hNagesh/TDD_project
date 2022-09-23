package com.Well.testcases.Exam;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_06_CancelExamByIdTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Exam.TC_05_StoreExamIdTest.TC_05_StoreExamId" })
	@Parameters({ "SheetName","rowNum" })
	public void TC_06_CancelExamById(String SheetName,int rowNum) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		exam.CancelExam(SheetName, rowNum);	
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
