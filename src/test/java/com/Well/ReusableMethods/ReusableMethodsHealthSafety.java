package com.Well.ReusableMethods;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.Well.Engine.BaseClass;
import com.Well.Engine.CommonMethod;

public class ReusableMethodsHealthSafety extends BaseClass {

	public void RegisterHealthSafety(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLHealthSafetyNavBar");
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar","HsrWellhealthstartprojectbtn");
		CommonMethod.RobustclickElementVisible("HsrWellhealthstartprojectbtn","HsrEnrollnowbtn");
		CommonMethod.RobustclickElementVisible("HsrEnrollnowbtn", "HsrEnrollbtn");
		CommonMethod.RobustclickElementVisible("HsrEnrollbtn", "Hsrenrollcontinuebtn");
		CommonMethod.WaitUntilClickble("HsrenrollName", 30);
		String erollName = "Automation HSR Project " + CommonMethod.randomNumber(8000000);
		CommonMethod.sendKeys("HsrenrollName", erollName);
		data.setCellData(SheetName, "HsrName", rowNum, CommonMethod.getattributeValue("HsrenrollName"));
		testlog.info("HsrName: " + data.getCellData(SheetName, "HsrName", rowNum));
		CommonMethod.ClickCheckbox("Hsrenrollcheckbox");
		rc.SelectOwnerOrg(SheetName, rowNum);
		CommonMethod.selectdropdownrandom("OrgIndustry");
		data.setCellData(SheetName, "OrgIndustry", rowNum, CommonMethod.getSelectedDropdownValue("OrgIndustry"));
		CommonMethod.selectdropdownValue("Hsrenrollcountry", "US");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("Hsrenrollcountry"));
		data.setCellData(SheetName, "Country", rowNum, CommonMethod.getSelectedDropdownAttribute("Hsrenrollcountry"));
		CommonMethod.selectdropdownrandom("Hsrenrollstate");
		testlog.info("State: " + CommonMethod.getSelectedDropdownAttribute("Hsrenrollstate"));
		data.setCellData(SheetName, "State", rowNum, CommonMethod.getSelectedDropdownValue("Hsrenrollstate"));
		String ProjectAddress = USfaker.address().streetAddress();
		String ProjectCity = USfaker.address().cityName();
		String PostalCode = USfaker.address().zipCode();
		CommonMethod.sendKeys("Hsrenrollstreet", ProjectAddress);
		data.setCellData(SheetName, "Street", rowNum, CommonMethod.getattributeValue("Hsrenrollstreet"));
		testlog.info("Hsrenrollstreet: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.sendKeys("Hsrenrollcity", ProjectCity);
		data.setCellData(SheetName, "City", rowNum, CommonMethod.getattributeValue("Hsrenrollcity"));
		testlog.info("City: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.sendKeys("Hsrenrollpostalcode", PostalCode);
		data.setCellData(SheetName, "PostalCode", rowNum, CommonMethod.getattributeValue("Hsrenrollpostalcode"));
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.ClickCheckbox("Hsrbilladdcheckbox");
		CommonMethod.RobustclickElementVisible("Hsrenrollcontinuebtn", "HsrRegcontinuebtn");
		CommonMethod.ClickCheckbox("Hsrregcheckbox");
		CommonMethod.selectdropdownVisibletext("HsrIwbimemberdropdown", "No");
		CommonMethod.RobustclickElementVisible("HsrRegcontinuebtn", "HsrTypeoneEnrollbtn");
		CommonMethod.RobustclickElementVisible("HsrTypeoneEnrollbtn", "HsrLocContinuebutton");
		CommonMethod.scrollUp();
		CommonMethod.sendKeys("Hsrlocations", "10");
		data.setCellData(SheetName, "Location", rowNum, CommonMethod.getattributeValue("Hsrlocations"));
		testlog.info("Hsrlocations: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpacetype","HsrWPRlocationsSpaceOption");
		Thread.sleep(2000);
		CommonMethod.RobustclickElementVisible("HsrWPRlocationsSpaceOption","Hsrlocationsize");
		String Area = CommonMethod.randomNumberBetweenRanges(100, 50000);
		CommonMethod.clearAndSendKey("Hsrlocationsize", Area);
		data.setCellData(SheetName, "Area", rowNum, CommonMethod.getattributeValue("Hsrlocationsize"));
		testlog.info("Hsrlocations: " + data.getCellData(SheetName, "Area", rowNum));
		CommonMethod.WaitUntilVisibility("HsrLocContinuebutton", 120);
		CommonMethod.RobustclickElementVisible("HsrLocContinuebutton", "HSRApplyButton");
		if (CommonMethod.isElementsExist("HsrWPRYesMyOrganizationCbx", 20)) {
			CommonMethod.WaitUntilClickble("HsrWPRYesMyOrganizationCbx", 60);
			CommonMethod.ClickCheckbox("HsrWPRYesMyOrganizationCbx");
		}

		CommonMethod.RobustclickElementVisible("HsrLocContinuebutton", "HsrReviewbtn");
		CommonMethod.WaitUntilClickble("HsrProgramFeePublicrbtn", 60);
		CommonMethod.ClickCheckbox("HsrProgramFeePublicrbtn");
		CommonMethod.WaitUntilVisibility("HsrAcknowledecbx", 60);
		CommonMethod.ClickCheckbox("HsrAcknowledecbx");
		CommonMethod.RobustclickElementVisible("HsrReviewbtn", "BillingLanding");
		CommonMethod.WaitUntilVisibility("BillingLanding", 60);
		testlog.pass("**Verifies the Registration successful**");
	}

	public void StoreIdHealthSafety(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilPresence("HsrIframe", 180);
		CommonMethod.switchToFrame("HsrIframe");
		CommonMethod.WaitUntilPresence("HsrCloseCard", 60);
		CommonMethod.Robustclick("HsrCloseCard");
		CommonMethod.switchToParentFrame();	
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		CommonMethod.WaitUntilVisibility("StoreId", 300);
		String getId = CommonMethod.getText("StoreId");
		String[] stringArray = getId.split(": ");
		String getHsrId = stringArray[1].trim();
		data.setCellData(SheetName, "ProjectID", rowNum, getHsrId);
		testlog.info("HealthSafety Id:" + getHsrId);
		testlog.pass("**Stored the Registered id  in excel successfully**");
	}

	public void SearchHealthSafetyByID(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrIdSearch","HsrIdSearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","HealthSafety Search failed");
		CommonMethod.assertcontainsmessage("HSRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("HSRIdClick","WPRHsrPortfolioDashboard");
		CommonMethod.WaitUntilVisibility("WPRHsrPortfolioDashboard", 60);
		testlog.pass("**Verifies the Search HealthSafety ByID successfully**");
	}

	public void ScorecardfillHSRWPR(int YesEnd, int NoStart, int NoEnd, int DifferencePlusOne)
			throws IOException, InterruptedException {
		List<WebElement> YesButton;
		List<WebElement> NoButton;
		NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
		int j = DifferencePlusOne;
		for (int i = NoStart; i <= NoEnd; i++) {
			int RemainingNo = NoButton.size();
			do {
				CommonMethod.click(NoButton.get(RemainingNo - j));
				Thread.sleep(1000);
				NoButton = CommonMethod.findElements("V2ProjectHsrPurseNo");
			} while (NoButton.size() == RemainingNo);
			RemainingNo--;
			j--;
		}
		CommonMethod.scrolldowntoElement("HsrScorecard");
		YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
		for (int i = 1; i <= YesEnd; i++) {
			int RemainingYes = YesButton.size();
			do {
				CommonMethod.WaitUntilClickble("V2ProjectHsrPurseYes", 60);
				CommonMethod.click("V2ProjectHsrPurseYes");
				Thread.sleep(1000);
				YesButton = CommonMethod.findElements("V2ProjectHsrPurseYes");
			} while (YesButton.size() == RemainingYes);
			RemainingYes--;
		}

	}

	public void CompleteScorecardHsrById(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ScorecardTab", 300);
		CommonMethod.RobustclickElementVisible("ScorecardTab","HsrScorecard");
		CommonMethod.WaitUntilVisibility("HsrScorecard", 300);
		ScorecardfillHSRWPR(15, 1, 27, 27);
		testlog.pass("**Verifies the 15 Purse Yes Scorecard HealthSafety in V2Project successfully**");
	}

	public void uploadDocumentInFeature(int LastFeatureNumber) throws IOException, InterruptedException {
		List<WebElement> Feature;
		Feature = CommonMethod.findElements("V2ProjectWPRPFeature");
		Feature = Feature.subList(0, LastFeatureNumber);
		CommonMethod.scrolldowntoElement("HsrScorecard");
		for (WebElement f : Feature) {
			CommonMethod.WaitUntilClickble(f, 30).click();
			CommonMethod.WaitUntilPresence("V2ProjectWPRPDocIcon", 60);
			CommonMethod.RobustclickElementVisible("V2ProjectWPRPDocIcon", "HsrSelectTypeDoc");
			CommonMethod.WaitUntilVisibility("HsrSelectTypeDoc", 60);
			CommonMethod.selectdropdownIndex("HsrSelectTypeDoc", 1);
			if (CommonMethod.isElementsExist("HsrLocationrtn", 3)) {
				CommonMethod.WaitUntilClickble("HsrLocationrtn", 10);
				CommonMethod.ClickCheckbox("HsrLocationrtn");
			}
			CommonMethod.WaitUntilVisibility("V2ProjectWPRVerificationMethod", 60);
			CommonMethod.selectdropdownIndex("V2ProjectWPRVerificationMethod", 1);
			CommonMethod.scrolldowntoElement("V2ProjectWPRVerificationMethod");
			if (CommonMethod.isElementsExist("HsrSelectLoc", 3)) {
				CommonMethod.WaitUntilClickble("HsrSelectLoc", 10);
				CommonMethod.selectdropdownIndex("HsrSelectLoc", 1);
			}
			CommonMethod.uploadFile("V2ProjectDocUpload", FeaturefileUpload);
			Thread.sleep(2000);
			CommonMethod.Robustclick("HsrUploadDocFeature");
			CommonMethod.scrolldowntoElement("HsrScorecard");
			CommonMethod.click(f);
		}
	}

	public void UploadHsrDocForFeature() throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("HsrScorecard", 300);
		uploadDocumentInFeature(15);
		testlog.pass("**Upload 15 Scorecard Documents successfully**");
	}

	public void ReviewHsr(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ReviewTab", 60);
		CommonMethod.RobustclickElementVisible("ReviewTab","Reviewlanding");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 20);
		CommonMethod.WaitUntilVisibility("HsrSubmitReview", 60);
		CommonMethod.RobustclickElementVisible("HsrSubmitReview","HsrSubmitDocReview");
		CommonMethod.WaitUntilVisibility("HsrSubmitDocReview", 60);
		CommonMethod.WaitUntilVisibility("HsrCommentReview", 60).sendKeys("Preliminary Health-Safety Review");
		CommonMethod.WaitUntilPresence("HsrSelectedProjectPhaseReview", 60);
		CommonMethod.selectdropdownVisibletext("HsrSelectedProjectPhaseReview", "Preliminary Health-Safety Review");
		CommonMethod.WaitUntilClickble("HsrSubmitDocReview", 60);
		CommonMethod.RobustclickElementVisible("HsrSubmitDocReview","ReviewViewButton");
		CommonMethod.WaitUntilVisibility("Reviewlanding", 60);
		testlog.pass("**Submitted Preliminary Health-Safety Review successfully**");
		/*
		 * Admin Review
		 */
		CommonMethod.WaitUntilVisibility("AdminNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminNavBar","AdminWELLHealthsafetyNavBar");
		CommonMethod.WaitUntilVisibility("AdminWELLHealthsafetyNavBar", 60);
		CommonMethod.RobustclickElementVisible("AdminWELLHealthsafetyNavBar", "HsrAdminIdSearch");
		CommonMethod.WaitUntilVisibility("HsrAdminIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrAdminIdSearch","HsrAdminApplybtn");
		CommonMethod.sendKeys("HsrAdminIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrAdminApplybtn","HsrAdminIdClick");
		Thread.sleep(2000);
		CommonMethod.assertcontainsmessage("HsrAdminIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		CommonMethod.RobustclickElementVisible("HsrAdminIdClick","ReviewTab");
		CommonMethod.WaitUntilVisibility("ReviewTab", 300);
		CommonMethod.RobustclickElementVisible("ReviewTab","ReviewViewButton");
		CommonMethod.WaitUntilVisibility("ReviewViewButton", 60);
		CommonMethod.RobustclickElementVisible("ReviewViewButton","ReviewReturnButton");
		CommonMethod.WaitUntilVisibility("ReviewReturnButton", 60);
		CommonMethod.RobustclickElementVisible("ReviewReturnButton", "ReviewReturnSubmit");
		CommonMethod.WaitUntilClickble("ReturnComment", 60).sendKeys("Preliminary Precertification Review");
		CommonMethod.RobustclickElementVisible("DatePickerButton", "DatePickerOkButton");
		CommonMethod.Robustclick("DatePickerOkButton");
		CommonMethod.scrollDown();
		Thread.sleep(1000);
		CommonMethod.ClickCheckbox("ReviewPaymentstatusRadio");
		CommonMethod.Robustclick("ReviewReturnSubmit");
		Thread.sleep(2000);
		CommonMethod.WaitUntilClickble("ReviewedStatus", 60);
		CommonMethod.assertcontainsmessage("ReviewedStatus", "REVIEWED", "Verified Review status");
		testlog.pass("**Completed Reviewed Preliminary Health-Safety Review successfully**");
	}

	public void HsrProjectFieldValidationTest(String SheetName, int rowNum) throws Exception {
		CommonMethod.WaitUntilVisibility("EditTab", 120);
		CommonMethod.RobustclickElementVisible("EditTab", "HsrWprOrganizationInformation");
		CommonMethod.WaitUntilVisibility("HsrWprOrganizationInformation", 60);
		CommonMethod.RobustclickElementVisible("HsrWprOrganizationInformation", "HsrWprEditProjectName");
		CommonMethod.WaitUntilVisibility("HsrWprEditProjectName", 30);
		testlog.info("HsrName: " + data.getCellData(SheetName, "HsrName", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditProjectName"),
				data.getCellData(SheetName, "HsrName", rowNum), "Project Name doesn't match");
		testlog.info("Area: " + data.getCellData(SheetName, "Area", rowNum));
		CommonMethod.softAssertEqualsMessage(
				CommonMethod.getattributeValue("HsrWprEditArea").replace("sq ft", "").replace(",", "").trim(),
				data.getCellData(SheetName, "Area", rowNum), "Area doesn't match");
		testlog.info("Location: " + data.getCellData(SheetName, "Location", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditLocation"),
				data.getCellData(SheetName, "Location", rowNum), "Location count doesn't match");
		testlog.info("OrgName: " + data.getCellData(SheetName, "OrgName", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getText("OrgName"),
				data.getCellData(SheetName, "OrgName", rowNum), "OrgName doesn't match");
		testlog.info("OrgIndustry: " + data.getCellData(SheetName, "OrgIndustry", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownValue("HsrWprEditOrgIndustry"),
				data.getCellData(SheetName, "OrgIndustry", rowNum), "OrgIndustry doesn't match");
		testlog.info("Country: " + CommonMethod.getSelectedDropdownAttribute("HsrWprEditCountry"));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getSelectedDropdownAttribute("HsrWprEditCountry"),
				data.getCellData(SheetName, "Country", rowNum), "Country doesn't match");
		testlog.info("State: " + data.getCellData(SheetName, "State", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditState"),
				data.getCellData(SheetName, "State", rowNum), "State Name doesn't match");
		testlog.info("Street: " + data.getCellData(SheetName, "Street", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditStreet"),
				data.getCellData(SheetName, "Street", rowNum), "Street Name doesn't match");
		testlog.info("City: " + data.getCellData(SheetName, "City", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprEditCity"),
				data.getCellData(SheetName, "City", rowNum), "City doesn't match");
		testlog.info("PostalCode: " + data.getCellData(SheetName, "PostalCode", rowNum));
		CommonMethod.softAssertEqualsMessage(CommonMethod.getattributeValue("HsrWprPostalCode"),
				data.getCellData(SheetName, "PostalCode", rowNum), "PostalCode doesn't match");
		softAssert.assertAll();
		testlog.pass("**Verifies the Hsr Field Validation successfully**");
	}
	public void validateTeamsHSR(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("ProjectNavBar", 300);
		CommonMethod.RobustclickElementVisible("ProjectNavBar","WELLHealthSafetyNavBar");
		CommonMethod.WaitUntilVisibility("WELLHealthSafetyNavBar", 300);
		CommonMethod.RobustclickElementVisible("WELLHealthSafetyNavBar", "HsrIdSearch");
		CommonMethod.WaitUntilVisibility("HsrIdSearch", 300);
		CommonMethod.RobustclickElementVisible("HsrIdSearch","HsrapplySearch");
		testlog.info("HealthSafety ID:" + data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.sendKeys("HsrIdSearch", data.getCellData(SheetName, "ProjectID", rowNum));
		CommonMethod.RobustclickElementVisible("HsrapplySearch","V2ProjectSearchResultIDVerify");
		int var = CommonMethod.WaitUntilNumberOfElementToBePresent("V2ProjectSearchResultIDVerify", 1, 60).size();
		CommonMethod.assertExpectedContainsActual(String.valueOf(var),"1","HealthSafety Search failed");
		CommonMethod.assertcontainsmessage("HSRIdClick", data.getCellData(SheetName, "projectID", rowNum),
				"Project name doesn't matches in search");
		testlog.pass("**Verifies user able to access the invited project**");
	}
	public void clikOnDocumentLibrary() throws InterruptedException, IOException {
		CommonMethod.WaitUntilPresence("WPRHSRDocumentTab", 300);
		CommonMethod.RobustclickElementVisible("WPRHSRDocumentTab","HsrAddDoc");
	}
	public void validateGeneralUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 120);
		CommonMethod.RobustclickElementVisible("HsrAddDoc","HsrDocType");
		CommonMethod.WaitUntilVisibility("HsrDocType", 60);
		CommonMethod.selectdropdownValue("HsrDocType", "general");
		CommonMethod.selectdropdownValue("HsrType","Project overview");
		CommonMethod.uploadFile("WPRDocUpload", GeneralfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("HsrReasonnarration", "Submitting Document");
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn","HsrGeneralLink");
		CommonMethod.WaitUntilPresence("HsrGeneralLink", 120);
		CommonMethod.RobustclickElementVisible("HsrGeneralLink", "HsrGeneralTable");
		CommonMethod.WaitUntilPresence("HsrGeneralTable", 120);
		CommonMethod.scrolldowntoElement("HsrGeneralTable");
		List<String> val = CommonMethod.fetchTableData("HsrGeneralTable");
		CommonMethod.softAssertContainsMessage(val.get(0), "PROJECT OVERVIEW", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload General Document successfully**");	
	}
	public void validateLegalUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 120);
		CommonMethod.RobustclickElementVisible("HsrAddDoc","HsrDocType");
		CommonMethod.WaitUntilVisibility("HsrDocType", 60);
		CommonMethod.selectdropdownValue("HsrDocType", "legal");
		CommonMethod.selectdropdownValue("HsrType","Signed certification agreement");
		CommonMethod.uploadFile("WPRDocUpload", LegalfileUpload);
		Thread.sleep(2000);
		CommonMethod.sendKeys("HsrReasonnarration", "Submitting Document");
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn","HsrGeneralLink");
		CommonMethod.WaitUntilPresence("HsrGeneralLink", 120);
		CommonMethod.RobustclickElementVisible("HsrGeneralLink", "HsrGeneralTable");
		CommonMethod.WaitUntilPresence("HsrGeneralTable", 120);
		CommonMethod.scrolldowntoElement("HsrGeneralTable");
		List<String> val = CommonMethod.fetchTableData("HsrGeneralTable");
		CommonMethod.softAssertContainsMessage(val.get(0), "SIGNED CERTIFICATION AGREEMENT", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Legal Document successfully**");	
	}
	public void validateAuditUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 60);
		CommonMethod.RobustclickElementVisible("HsrAddDoc","HsrDocType");
		CommonMethod.WaitUntilVisibility("HsrDocType", 60);
		CommonMethod.selectdropdownValue("HsrDocType", "audit");
		CommonMethod.ClickCheckbox("HsrLocationRadiobutton");
		CommonMethod.selectdropdownValue("HsrType","2");
		CommonMethod.scrolldowntoElement("HsrType");
		CommonMethod.RobustclickElementVisible("HsrContainedDocument","HsrContainedDocumentOption");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick","OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 2).click();
		CommonMethod.selectdropdownrandom("HsrLocationVerificationDoc");
	    CommonMethod.uploadFile("WPRDocUpload", AuditfileUpload, "UploadFileVerifyScorecard");
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn","HsrAddDoc");
		CommonMethod.scrolldowntoElement("HsrAddDoc");
		CommonMethod.WaitUntilPresence("HsrAuditLinkTab", 120);
    	CommonMethod.RobustclickElementVisible("HsrAuditLinkTab", "HsrAuditTable");
		CommonMethod.WaitUntilPresence("HsrAddDoc", 120);
		CommonMethod.scrolldowntoElement("HsrAuditTable");
		List<String> val = CommonMethod.fetchTableData("HsrAuditTable");
		CommonMethod.softAssertContainsMessage(val.get(3), "Audit Document", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Audit Document successfully**");	
	}
	
	public void validateFeatureUploadDocument(String SheetName, int rowNum) throws IOException, InterruptedException {		
		CommonMethod.refreshBrowser();
		CommonMethod.WaitUntilVisibility("HsrAddDoc", 60);
		CommonMethod.RobustclickElementVisible("HsrAddDoc","HsrDocType");
		CommonMethod.WaitUntilVisibility("HsrDocType", 60);
		CommonMethod.selectdropdownValue("HsrDocType", "feature");
		CommonMethod.ClickCheckbox("HsrLocationRadiobutton");
		CommonMethod.selectdropdownValue("HsrType","2");
		CommonMethod.scrolldowntoElement("HsrType");
		CommonMethod.RobustclickElementVisible("HsrContainedDocument","HsrContainedDocumentOption");
		CommonMethod.WaitUntilClickble("OwnerOrgClick", 10);
		CommonMethod.RobustclickElementVisible("OwnerOrgClick","OwnerOrg");
		CommonMethod.sendKeys("OwnerOrg", "R");
		CommonMethod.WaitUntilClickble("SelectOwnerOrgDyn", 10);
		CommonMethod.SelectRandomfromList("SelectOwnerOrgDyn", 1, 2).click();
		CommonMethod.selectdropdownrandom("HsrLocationVerificationDoc");
	    CommonMethod.uploadFile("WPRDocUpload", FeaturefileUpload, "UploadFileVerifyScorecard");
		CommonMethod.RobustclickElementVisible("HsrDocumentUploadbtn","HsrAddDoc");
		CommonMethod.scrolldowntoElement("HsrAddDoc");
		CommonMethod.WaitUntilPresence("HsrAuditLinkTab", 120);
		CommonMethod.WaitUntilPresence("HsrAddDoc", 120);
		CommonMethod.scrolldowntoElement("HsrAuditTable");
		List<String> val = CommonMethod.fetchTableData("HsrAuditTable");
		CommonMethod.softAssertContainsMessage(val.get(3), "On-site Photographs", "Document table data mismatch");
		softAssert.assertAll();
		testlog.pass("**Upload Audit Document successfully**");	
		
	}

}
