package ai.hono.devnt8.create.leaverequest.test;


import static ai.hono.devnt8.util.Constants.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ai.hono.devnt8.base.test.BaseHonoLeaveTest;
import ai.hono.devnt8.create.leave.request.pages.CreateLeaveRequestPage;
import ai.hono.devnt8.leave.type.pages.LeaveTypePage;
import ai.hono.devnt8.login.page.HonoLeaveLoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

		@Epic("Hono Leave Request")
		@Feature("cancel leave request test")
		public class CancelleaveRequestTest extends BaseHonoLeaveTest {

			private WebDriver driver = null;
			private WebDriver candidateDriver = null;
			private HonoLeaveLoginPage loginPage = null;
			private LeaveTypePage leaveTypePage = null;
			private CreateLeaveRequestPage createLeaveRequestPage = null;
			
			public String Profile_Status = null;
			public String short_name = null;

			private static final Logger logger = Logger.getLogger(CancelleaveRequestTest.class.getName());

			@BeforeClass
			@Parameters({ "browser","siteURL","username","password" })
			public void initMethodTest(String browser,String siteURL,String userName,String approverPassword) throws Exception {
				logger.info("Starting of initMethodTest method");

				driver = this.getWebDriver(browser, WEB_DRIVER.CREATE_LEAVE_REQUEST);

				loginToHono(browser, siteURL, userName, approverPassword, this.driver);

				loginPage = new HonoLeaveLoginPage(driver);
				leaveTypePage = new LeaveTypePage(driver);
				createLeaveRequestPage = new CreateLeaveRequestPage(driver);

				logger.info("Ending of initMethodTest method");
			}

			@Test(priority = 1, description = "Verify Dashboard Details after giving a valid User Name & password")
			@Description("Test Case #1, Verify Dashboard Details after giving a valid User Name & password")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #1, Verify Dashboard Details after giving a valid User Name & password")
			public void verifyDashboardDetailsAfterLoginWithValidDetails() {
				logger.info("Starting of verifyDashboardDetailsAfterLoginWithValidDetails method");

				try {
					//driver.switchTo().alert().accept();
					//createLeaveRequestPage.clickOnOkButton();
					
					Thread.sleep(5000);
					leaveTypePage.selectRole(testDataProp.getProperty(EMPLOYEE_ROLE_TEXT));

					Thread.sleep(3000);
					// Assert.assertEquals(loginPage.getAnalyticsDashboardText(),
					// expectedAssertionsProp.getProperty(DASHBOARD_TEXT));

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
					createLeaveRequestPage.selectHonoMenu(testDataProp.getProperty(LEAVE_TEXT));
					Thread.sleep(1000);
					
					Assert.assertEquals(createLeaveRequestPage.getLeaveRequestText(),
							expectedAssertionsProp.getProperty(CREATE_LEAVE_REQUEST_TEXT));

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
					createLeaveRequestPage.selectHonoMenuItem(testDataProp.getProperty(CREATE_LEAVE_REQUEST_TEXT));
					Thread.sleep(3000);
					
					Assert.assertEquals(createLeaveRequestPage.getCreateLeaveRequestText(),
							expectedAssertionsProp.getProperty(APPLY_FOR_LEAVE_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyOnboardingBySelectCandidatesProfile : " + e.getMessage());
					logger.error("Error occured while verifyOnboardingBySelectCandidatesProfile " + e);
				}

				logger.info("Starting of verifyOnboardingBySelectCandidatesProfile method");
			}

			@Test(priority = 4, description = "Verify Create Leave Request details by selecting Submit button")
			@Description("Test Case #4, Verify Create Leave Request details by selecting Submit button")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #4, Verify Create Leave Request details by selecting Submit button")
			public void verifyLeaveTypeDetailsBySelectAddLeaveType() {
				logger.info("Starting of verifyLeaveTypeDetailsBySelectAddLeaveType method");

				try {
					Assert.assertTrue(createLeaveRequestPage.isSubmitButtonDisplayed());
					
					//createLeaveRequestPage.clickOnSubmitButton();
					
					//Assert.assertEquals(leaveTypePage.getLeaveSetupText(),
							//(expectedAssertionsProp.getProperty(LEAVE_SETUP_TEXT)));
					
				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyLeaveTypeDetailsBySelectAddLeaveType : " + e.getMessage());
					logger.error("Error occured while verifyLeaveTypeDetailsBySelectAddLeaveType " + e);
				}

				logger.info("Starting of verifyLeaveTypeDetailsBySelectAddLeaveType method");
			}
			
			@Test(priority = 5, description = "Verify Crete Leave Request by giving all valid details")
			@Description("Test Case #5, Verify Crete Leave Request by giving all valid details")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #5, Verify Crete Leave Request by giving all valid details")
			public void verifyCreateLeaveRequestByGivingAllValidDetails() {
				logger.info("Starting of verifyCreateLeaveRequestByGivingAllValidDetails method");

				try {
					Assert.assertEquals(createLeaveRequestPage.getCreateLeaveRequestText(),
							(expectedAssertionsProp.getProperty(APPLY_FOR_LEAVE_TEXT)));

					createLeaveRequestPage.clickOnLeaveTypeButton();
					createLeaveRequestPage.selectLeaveType(testDataProp.getProperty(CASUAL_LEAVE_TEXT));
					
					createLeaveRequestPage.clickOnAvailedUsingDropdown();
					createLeaveRequestPage.selectAvailedUsing(testDataProp.getProperty(AVAILED_USING_DAYS_TEXT));
					
					createLeaveRequestPage.clickOnFromDate();
					createLeaveRequestPage.selectDate(testDataProp.getProperty(LEAVE_FROM_DATE_TEXT));
					
					createLeaveRequestPage.clickOnFromHalfDropdown();
					createLeaveRequestPage.selectFromHalf(testDataProp.getProperty(FROM_HALF_FULL_DAY_TEXT));
					
					createLeaveRequestPage.clickOnToDate();
					createLeaveRequestPage.selectDate(testDataProp.getProperty(LEAVE_TO_DATE_TEXT));
					
					createLeaveRequestPage.clickOnToHalfDropdown();
					createLeaveRequestPage.selectToHalf(testDataProp.getProperty(TO_HALF_FIRST_HALF_TEXT));

					createLeaveRequestPage.setLeaveReason(testDataProp.getProperty(REASON_FOR_LEAVE_TEXT));
					createLeaveRequestPage.clickOnSubmitButton();

					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(LEAVE_HAS_BEEN_SUCCESSFULLY_SUBMITTED_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyCreateLeaveRequestByGivingAllValidDetails : " + e.getMessage());
					logger.error("Error occured while verifyCreateLeaveRequestByGivingAllValidDetails " + e);
				}

				logger.info("Starting of verifyCreateLeaveRequestByGivingAllValidDetails method");
			}
			
			
			@Test(priority = 6, description = "Verify Created Leave Type details by selecting Last page")
			@Description("Test Case #6, Verify Created Leave Type details by selecting Last page")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #6, Verify Created Leave Type details by selecting Last page")
			public void verifyLeaveTypeDetailsBySelectLastPage() {
				logger.info("Starting of verifyLeaveTypeDetailsBySelectLastPage method");

				try {
					//leaveTypePage.clickOnGoToLastPageButton();
					Thread.sleep(2000);
					leaveTypePage.clickOnRowsPerPageButton();
					Thread.sleep(3000);
					leaveTypePage.selectRowsPerPage(testDataProp.getProperty(TWO_ROWS_PER_PAGE_TEXT));
					Thread.sleep(2000);
					createLeaveRequestPage.clickOnScroll();

					Assert.assertTrue(leaveTypePage.isGoToNextPageButtonDisabled());
					
				} catch (Exception e) {
					Assert.fail("Exception occured while testing verifyLeaveTypeDetailsBySelectLastPage : " + e.getMessage());
					logger.error("Error occured while verifyLeaveTypeDetailsBySelectLastPage " + e);
				}

				logger.info("Starting of verifyLeaveTypeDetailsBySelectLastPage method");
			}
			
			@Test(priority = 7, description = "Verify the leave request details by select Leave Transactions")
			@Description("Test Case #6, Verify the leave request details by select pending for approval status transaction")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #6, Verify the leave request details by select pending for approval status transaction")
			public void verifyLeaveRequestTransactionDetails() {
				logger.info("Starting of verifyLeaveRequestTransactionDetails method");

				try {
					createLeaveRequestPage.selectHonoMenu(testDataProp.getProperty(LEAVE_TEXT));
					createLeaveRequestPage.selectHonoMenuItem(testDataProp.getProperty(LEAVE_TRANSACTIONS_TEXT));
					Thread.sleep(3000);



				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyLeaveRequestTransactionDetails : " + e.getMessage());
					logger.error("Error occured while verifyLeaveRequestTransactionDetails " + e);
				}

				logger.info("Starting of verifyLeaveRequestTransactionDetails method");
			}
			
			@Test(priority = 8, description = "Verify the leave type details by selecting the Edit option")
			@Description("Test Case #8, Verify the leave type details by selecting the Edit option")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #8, Verify the leave type details by selecting the Edit option")
			public void verifyLeaveDetailsBySelectEditOption() {
				logger.info("Starting of verifyLeaveDetailsBySelectEditOption method");

				try {
					Assert.assertEquals(leaveTypePage.getLeaveTypeText(),
							expectedAssertionsProp.getProperty(LEAVE_TYPES_TEXT));

					leaveTypePage.clickOnLeaveEditButton();

					Assert.assertEquals(leaveTypePage.getLeaveSetupText(),
							(expectedAssertionsProp.getProperty(LEAVE_SETUP_TEXT)));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyLeaveDetailsBySelectEditOption : " + e.getMessage());
					logger.error("Error occured while verifyLeaveDetailsBySelectEditOption " + e);
				}

				logger.info("Starting of verifyLeaveDetailsBySelectEditOption method");
			}
			
			@Test(priority = 9, description = "Verify the Edit leave type details by selecting the Update option")
			@Description("Test Case #9, Verify the Edit leave type details by selecting the Update option")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #9, Verify the Edit leave type details by selecting the Update option")
			public void verifyEditLeaveDetailsBySelectUpdateButton() {
				logger.info("Starting of verifyEditLeaveDetailsBySelectUpdateButton method");

				try {
					Assert.assertEquals(leaveTypePage.getLeaveSetupText(),
							(expectedAssertionsProp.getProperty(LEAVE_SETUP_TEXT)));

					leaveTypePage.setLeaveName(testDataProp.getProperty(CASUAL_LEAVE_TEXT));
					
					leaveTypePage.clickOnUpdateLeaveButton();

					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(LEAVE_TYPE_UPDATED_SUCCESSFULLY_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyEditLeaveDetailsBySelectUpdateButton : " + e.getMessage());
					logger.error("Error occured while verifyEditLeaveDetailsBySelectUpdateButton " + e);
				}

				logger.info("Starting of verifyEditLeaveDetailsBySelectUpdateButton method");
			}
			
			@Test(priority = 10, description = "Verify leave type details after updating the Leave Name")
			@Description("Test Case #9, Verify leave type details after updating the Leave Name")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #9, Verify leave type details after updating the Leave Name")
			public void verifyUpdatedLeaveDetails() {
				logger.info("Starting of verifyUpdatedLeaveDetails method");

				try {
					Assert.assertEquals(leaveTypePage.getLeaveTypeText(),
							expectedAssertionsProp.getProperty(LEAVE_TYPES_TEXT));
					
					leaveTypePage.clickOnSearchButton();

					leaveTypePage.setSearchByShortName(short_name);

					Assert.assertEquals(leaveTypePage.getLeaveNameText(),
							expectedAssertionsProp.getProperty(CASUAL_LEAVE_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyUpdatedLeaveDetails : " + e.getMessage());
					logger.error("Error occured while verifyUpdatedLeaveDetails " + e);
				}

				logger.info("Starting of verifyUpdatedLeaveDetails method");
			}

}

