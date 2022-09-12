package com.Well.ReusableMethods;

import java.io.IOException;

import org.openqa.selenium.Keys;

import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsHealthSafety extends BaseClass {
	
	public void RegisterHealthSafety(String SheetName,int rowNum) throws IOException, InterruptedException {

	   CommonMethod.click("ProjectNavBar");
	   CommonMethod.click("WELLHealthSafetyNavBar");
	   CommonMethod.click("HsrWellhealthstartprojectbtn");
	   CommonMethod.click("HsrEnrollnowbtn");
	   CommonMethod.click("HsrEnrollbtn");
	   CommonMethod.WaitUntilClickble("HsrenrollName", 30);
	   String erollName = "Automation hsr "+CommonMethod.randomNumber(8000000);
	   CommonMethod.sendKeys("HsrenrollName", erollName);
	   CommonMethod.ClickCheckbox("Hsrenrollcheckbox");
	   CommonMethod.click("OwnerOrgClick");
	   CommonMethod.sendKeys("OwnerOrg", "R");
	   CommonMethod.WaitUntilClickble("SelectOwnerOrg", 10);
	   CommonMethod.click("SelectOwnerOrg");
	   CommonMethod.selectdropdownrandom("HsrorgIndustry");
	   data.setCellData("Hsr", "OrgIndustry", 2, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
	   CommonMethod.selectdropdown("Hsrenrollcountry",  data.getCellData(SheetName, "country", rowNum));
	   CommonMethod.selectdropdown("Hsrenrollstate", data.getCellData(SheetName, "state", rowNum));
       String ProjectAddress = USfaker.address().streetAddress();
	   String ProjectCity = USfaker.address().cityName();
	   String PostalCode = USfaker.address().zipCode();
	   CommonMethod.sendKeys("Hsrenrollstreet", ProjectAddress);
       CommonMethod.sendKeys("Hsrenrollcity", ProjectCity);
       CommonMethod.sendKeys("Hsrenrollpostalcode", PostalCode);
       CommonMethod.ClickCheckbox("Hsrbilladdcheckbox");
       CommonMethod.click("Hsrenrollcontinuebtn");
       CommonMethod.ClickCheckbox("Hsrregcheckbox");
       CommonMethod.selectdropdown("HsrIwbimemberdropdown","No");
       CommonMethod.click("HsrRegcontinuebtn");
       CommonMethod.click("HsrTypeoneEnrollbtn");
       CommonMethod.scrollUp();
       CommonMethod.sendKeys("Hsrlocations", "10");
       CommonMethod.click("HsrlocationsSpacetype");
       Thread.sleep(2000);
       CommonMethod.click("HsrlocationsSpaceOption");
       CommonMethod.clear("Hsrlocationsize");
       CommonMethod.sendKeys("Hsrlocationsize", "10");
	   CommonMethod.click("HsrLocContinuebutton");
	   CommonMethod.WaitUntilClickble("HsrYesMyOrganizationCbx", 30);
	   CommonMethod.ClickCheckbox("HsrYesMyOrganizationCbx");
	   CommonMethod.click("HsrLocContinuebutton");
	   CommonMethod.WaitUntilClickble("HsrProgramFeePublicrbtn", 60);
	   CommonMethod.ClickCheckbox("HsrProgramFeePublicrbtn");
	   CommonMethod.ClickCheckbox("HsrAcknowledecbx");
	   CommonMethod.click("HsrReviewbtn");
	   Thread.sleep(2000);  
	}
	public void StoreIdHealthSafety(String SheetName,int rowNum) throws IOException, InterruptedException {
		  Thread.sleep(10000); 
		CommonMethod.WaitUntilVisibility("StoreId", 300);
		String getId =CommonMethod.getText("StoreId"); 
      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+getId);
      String[] stringArray = getId.split(": ");
      String getHsrId = stringArray[1].trim();
      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+getHsrId);
      data.setCellData("Hsr", "hsrId", 2, getHsrId);

	}
	
	public void SearchHealthSafetyByID (String SheetName,int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.click("ProjectNavBar");
		   CommonMethod.click("WELLHealthSafetyNavBar");
		   CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		   CommonMethod.click("HsrIdSearch");
		   CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "hsrId", rowNum));
		   CommonMethod.click("HsrapplySearch");
		   CommonMethod.WaitUntilVisibility("Hsrprojectidcompare", 300);
		   CommonMethod.click("Hsrprojectidcompare");
	 
	}
	

}

