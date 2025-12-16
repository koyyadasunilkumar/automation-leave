package ai.hono.devnt8.leavetype.test;

	import static ai.hono.devnt8.util.Constants.*;

import java.awt.Toolkit;
	import java.awt.datatransfer.Clipboard;
	import java.awt.datatransfer.DataFlavor;
	import java.net.URISyntaxException;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.springframework.context.annotation.Description;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import ai.hono.devnt8.base.pages.BaseHonoLeavePage;
import ai.hono.devnt8.base.test.BaseHonoLeaveTest;
import ai.hono.devnt8.leave.type.pages.LeaveTypePage;
import ai.hono.devnt8.login.page.HonoLeaveLoginPage;
import io.qameta.allure.Epic;
	import io.qameta.allure.Feature;
	import io.qameta.allure.Severity;
	import io.qameta.allure.SeverityLevel;
	import io.qameta.allure.Story;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;


		@Epic("Hono Leave")
		@Feature("Hono Leave Request")
		public class EditLeaveTypeTest extends BaseHonoLeaveTest {

			private WebDriver driver = null;
			private HonoLeaveLoginPage loginPage = null;
			private LeaveTypePage leaveTypePage = null;
			public String Profile_Status = null;
			public String short_name = null;

			private static final Logger logger = Logger.getLogger(EditLeaveTypeTest.class.getName());

			@BeforeClass
			@Parameters({ "browser","siteURL","employeeUserName","employeepPssword" })
			public void initMethodTest(String browser,String siteURL,String userName,String approverPassword) throws Exception {
				logger.info("Starting of initMethodTest method");

				driver = this.getWebDriver(browser, WEB_DRIVER.EDIT_LEAVE_TYPE);

				loginToHono(browser, siteURL, userName, approverPassword, this.driver);

				loginPage = new HonoLeaveLoginPage(driver);
				leaveTypePage = new LeaveTypePage(driver);			

				logger.info("Ending of initMethodTest method");
			}

			@Test(priority = 1, description = "Verify Dashboard Details after giving a valid User Name & password")
			@Description("Test Case #1, Verify Dashboard Details after giving a valid User Name & password")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #1, Verify Dashboard Details after giving a valid User Name & password")
			public void verifyDashboardDetailsAfterLoginWithValidDetails() {
				logger.info("Starting of verifyDashboardDetailsAfterLoginWithValidDetails method");

				try {
					leaveTypePage.selectRole(testDataProp.getProperty(HR_ROLE_TEXT));

					Thread.sleep(3000);
					Assert.assertEquals(loginPage.getAnalyticsDashboardText(),
							 expectedAssertionsProp.getProperty(ANALYTICS_DASHBOARD_TEXT));

				} catch (Exception e) {
					Assert.fail("Exception occured while testing verifyDashboardDetailsAfterLoginWithValidDetails : "
							+ e.getMessage());
					logger.error("Error occured while verifyDashboardDetailsAfterLoginWithValidDetails " + e);
				}

				logger.info("Starting of verifyDashboardDetailsAfterLoginWithValidDetails method");
			}

			@Test(priority = 2, description = "Verify the Hono dashboard Details by selecting the Leave")
			@Description("Test Case #2, Verify the Hono dashboard Details by selecting the Leave")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #2, Verify the Hono dashboard Details by selecting the Leave")
			public void verifyDashboardBySelectLeave() {
				logger.info("Starting of verifyDashboardBySelectLeave method");

				try {
					Thread.sleep(5000);
					leaveTypePage.selectHonoDasboardMenu(testDataProp.getProperty(LEAVE_TEXT));
					Thread.sleep(1000);
					
					Assert.assertEquals(leaveTypePage.getLeaveTypesText(),
							expectedAssertionsProp.getProperty(LEAVE_TYPES_TEXT));

				} catch (Exception e) {
					Assert.fail("Exception occured while testing verifyDashboardBySelectLeave : " + e.getMessage());
					logger.error("Error occured while verifyDashboardBySelectLeave " + e);
				}

				logger.info("Starting of verifyDashboardBySelectLeave method");
			}
			
			@Test(priority = 3, description = "Verify the Leave details by selecting Leave Types option")
			@Description("Test Case #3, Verify the On Leave by selecting Leave Types option")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #3, Verify the Leave by selecting Leave Types option")
			public void verifyOnboardingBySelectCandidatesProfile() {
				logger.info("Starting of verifyOnboardingBySelectCandidatesProfile method");

				try {
					leaveTypePage.selectHonoMenuItem(testDataProp.getProperty(LEAVE_TYPES_TEXT));
					Thread.sleep(3000);
					
					Assert.assertEquals(leaveTypePage.getLeaveTypeText(),
							expectedAssertionsProp.getProperty(LEAVE_TYPES_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyOnboardingBySelectCandidatesProfile : " + e.getMessage());
					logger.error("Error occured while verifyOnboardingBySelectCandidatesProfile " + e);
				}

				logger.info("Starting of verifyOnboardingBySelectCandidatesProfile method");
			}
			
			@Test(priority = 4, description = "Verify Leave types details by selecting add Leave Type")
			@Description("Test Case #4, Verify Leave types details by selecting add Leave Type")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #4, Verify Leave types details by selecting add Leave Type")
			public void verifyLeaveTypeDetailsBySelectAddLeaveType() {
				logger.info("Starting of verifyLeaveTypeDetailsBySelectAddLeaveType method");

				try {
					Assert.assertTrue(leaveTypePage.isAddLeaveTypeButtonDisplayed());
					leaveTypePage.clickOnAddLeaveTypeButton();
					
					Assert.assertEquals(leaveTypePage.getLeaveSetupText(),
							(expectedAssertionsProp.getProperty(LEAVE_SETUP_TEXT)));
					
				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyLeaveTypeDetailsBySelectAddLeaveType : " + e.getMessage());
					logger.error("Error occured while verifyLeaveTypeDetailsBySelectAddLeaveType " + e);
				}

				logger.info("Starting of verifyLeaveTypeDetailsBySelectAddLeaveType method");
			}
			
			@Test(priority = 5, description = "Verify Add Leave type details by giving all valid details")
			@Description("Test Case #5, Verify Add Leave type details by giving all valid details")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #5, Verify Add Leave type details by giving all valid details")
			public void verifyAddLeaveTypeDetailsByGivingAllValidDetails() {
				logger.info("Starting of verifyAddLeaveTypeDetailsByGivingAllValidDetails method");

				try {
					Assert.assertEquals(leaveTypePage.getLeaveSetupText(),
							(expectedAssertionsProp.getProperty(LEAVE_SETUP_TEXT)));
					
					leaveTypePage.clickOnLeaveTypeButton();
					
					leaveTypePage.selectLeaveType(testDataProp.getProperty(LEAVE_TYPE_SICK_LEAVE_TEXT));
					
					leaveTypePage.setLeaveName(testDataProp.getProperty(LEAVE_NAME_TEXT));
					
					leaveTypePage.setLeaveDescription(testDataProp.getProperty(LEAVE_DESCRIPTION_TEXT));
					
					leaveTypePage.setLeaveShortName(testDataProp.getProperty(LEAVE_SHORT_NAME_TEXT));
					
					short_name = leaveTypePage.getLeaveShortName();
					
					leaveTypePage.setLeaveOrderBy(testDataProp.getProperty(LEAVE_ORDER_BY_TEXT));
					
					leaveTypePage.clickOnLeaveYearDropdown();
					
					leaveTypePage.selectLeaveYear(testDataProp.getProperty(LEAVE_YEAR_TEXT));
					
					leaveTypePage.clickOnLeaveCreditingOfTheMonth();
					
					leaveTypePage.selectLeaveCreditingOfTheMonth(testDataProp.getProperty(LEAVE_CREDITING_OF_THE_MONTH_TEXT));
					
					leaveTypePage.clickOnLeaveCreditingWhen();
					
					leaveTypePage.selectLeaveCreditingWhen(testDataProp.getProperty(LEAVE_CREDITING_WHEN_START_TEXT));
					
					//leaveTypePage.clickOnGlobalApplicabilityCheckbox();
					
					leaveTypePage.clickOnCreateLeaveTypeButton();
					
					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(LEAVE_TYPE_CREATED_SUCCESSFULLY_TEXT));
					
				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyAddLeaveTypeDetailsByGivingAllValidDetails : " + e.getMessage());
					logger.error("Error occured while verifyAddLeaveTypeDetailsByGivingAllValidDetails " + e);
				}

				logger.info("Starting of verifyAddLeaveTypeDetailsByGivingAllValidDetails method");
			}
			
			@Test(priority = 6, description = "Verify Created Leave Type details by selecting Last page")
			@Description("Test Case #6, Verify Created Leave Type details by selecting Last page")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #6, Verify Created Leave Type details by selecting Last page")
			public void verifyLeaveTypeDetailsBySelectLastPage() {
				logger.info("Starting of verifyLeaveTypeDetailsBySelectLastPage method");

				try {
					leaveTypePage.clickOnGoToLastPageButton();
					Thread.sleep(2000);
					leaveTypePage.clickOnRowsPerPageButton();
					Thread.sleep(3000);
					leaveTypePage.selectRowsPerPage(testDataProp.getProperty(FIVE_ROWS_PER_PAGE_TEXT));
					Thread.sleep(2000);

					Assert.assertTrue(leaveTypePage.isGoToNextPageButtonDisabled());
					
				} catch (Exception e) {
					Assert.fail("Exception occured while testing verifyLeaveTypeDetailsBySelectLastPage : " + e.getMessage());
					logger.error("Error occured while verifyLeaveTypeDetailsBySelectLastPage " + e);
				}

				logger.info("Starting of verifyLeaveTypeDetailsBySelectLastPage method");
			}
			
			@Test(priority = 7, description = "Verify the leave type details by selecting the search option and entering the short name")
			@Description("Test Case #7, Verify the leave type details by selecting the search option and entering the short name")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #7, Verify the leave type details by selecting the search option and entering the short name")
			public void verifySearchLeaveTypeDetailsByEnteringShortName() {
				logger.info("Starting of verifySearchLeaveTypeDetailsByEnteringShortName method");

				try {
					Assert.assertEquals(leaveTypePage.getLeaveTypeText(),
							expectedAssertionsProp.getProperty(LEAVE_TYPES_TEXT));

					leaveTypePage.clickOnSearchButton();

					leaveTypePage.setSearchByShortName(short_name);

					Assert.assertEquals(leaveTypePage.getLeaveShortnameText(),
							short_name);

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifySearchLeaveTypeDetailsByEnteringShortName : " + e.getMessage());
					logger.error("Error occured while verifySearchLeaveTypeDetailsByEnteringShortName " + e);
				}

				logger.info("Starting of verifySearchLeaveTypeDetailsByEnteringShortName method");
			}                                                                                           

			@Test(priority = 8, description = "Verify the leave type details by selecting the Edit option")
			@Description("Test Case #8, Verify the leave type details by selecting the Edit option")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #8, Verify the leave type details by selecting the Edit option")
			public void verifyLeaveTypeDetailsBySelectEditOption() {
				logger.info("Starting of verifyLeaveTypeDetailsBySelectEditOption method");

				try {
					Assert.assertEquals(leaveTypePage.getLeaveTypeText(),
							expectedAssertionsProp.getProperty(LEAVE_TYPES_TEXT));

					leaveTypePage.clickOnLeaveEditButton();

					Assert.assertEquals(leaveTypePage.getLeaveSetupText(),
							(expectedAssertionsProp.getProperty(LEAVE_SETUP_TEXT)));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyLeaveTypeDetailsBySelectEditOption : " + e.getMessage());
					logger.error("Error occured while verifyLeaveTypeDetailsBySelectEditOption " + e);
				}

				logger.info("Starting of verifyLeaveTypeDetailsBySelectEditOption method");
			}
			
			@Test(priority = 9, description = "Verify the Edit leave type details by selecting the Update option")
			@Description("Test Case #9, Verify the Edit leave type details by selecting the Update option")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #9, Verify the Edit leave type details by selecting the Update option")
			public void verifyEditLeaveTypeDetailsBySelectUpdateButton() {
				logger.info("Starting of verifyEditLeaveTypeDetailsBySelectUpdateButton method");

				try {
					Assert.assertEquals(leaveTypePage.getLeaveSetupText(),
							(expectedAssertionsProp.getProperty(LEAVE_SETUP_TEXT)));

					leaveTypePage.setLeaveName(testDataProp.getProperty(CASUAL_LEAVE_TEXT));
					
					leaveTypePage.clickOnUpdateLeaveButton();

					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(LEAVE_TYPE_UPDATED_SUCCESSFULLY_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyEditLeaveTypeDetailsBySelectUpdateButton : " + e.getMessage());
					logger.error("Error occured while verifyEditLeaveTypeDetailsBySelectUpdateButton " + e);
				}

				logger.info("Starting of verifyEditLeaveTypeDetailsBySelectUpdateButton method");
			}
			
			@Test(priority = 10, description = "Verify leave type details after updating the Leave Name")
			@Description("Test Case #10, Verify leave type details after updating the Leave Name")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #10, Verify leave type details after updating the Leave Name")
			public void verifyUpdatedLeaveTypeDetails() {
				logger.info("Starting of verifyUpdatedLeaveTypeDetails method");

				try {
					Assert.assertEquals(leaveTypePage.getLeaveTypeText(),
							expectedAssertionsProp.getProperty(LEAVE_TYPES_TEXT));
					
					leaveTypePage.clickOnSearchButton();

					leaveTypePage.setSearchByShortName(short_name);

					Assert.assertEquals(leaveTypePage.getLeaveNameText(),
							expectedAssertionsProp.getProperty(CASUAL_LEAVE_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyUpdatedLeaveTypeDetails : " + e.getMessage());
					logger.error("Error occured while verifyUpdatedLeaveTypeDetails " + e);
				}

				logger.info("Starting of verifyUpdatedLeaveTypeDetails method");
			}


}

