package com.Well.testcases.Membership;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Well.Engine.BaseClass;

public class TC_04_BillingTest extends BaseClass {

	@Test(dependsOnMethods = { "com.Well.testcases.Membership.TC_03_EnrollTest.TC_03_Enroll" })
	@Parameters({ "SheetName","rowNum","MembershipName"  })
	public void TC_04_Billing(String SheetName,int rowNum, String MembershipName) throws IOException {

		TestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();

		StartTest(TestCaseName);
		try {
		membership.BillingMembership(SheetName, rowNum,MembershipName);
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
}
