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
	@Feature("Cancel leave request before approval test")
	public class CancelLeaveRequestBeforeApprovalTest extends BaseHonoLeaveTest {

		private WebDriver driver = null;
		private WebDriver approverOneDriver = null;
		private WebDriver approverTwoDriver = null;
		
		private WebDriver candidateDriver = null;
		private HonoLeaveLoginPage loginPage = null;
		private LeaveTypePage leaveTypePage = null;
		private CreateLeaveRequestPage createLeaveRequestPage = null;
		
		private HonoLeaveLoginPage approverOneLoginPage = null;
		private LeaveTypePage approverOneLeaveTypePage = null;
		private CreateLeaveRequestPage approverOneCreateLeaveRequestPage = null;
		
		private HonoLeaveLoginPage approverTwoLoginPage = null;
		private LeaveTypePage approverTwoLeaveTypePage = null;
		private CreateLeaveRequestPage approverTwoCreateLeaveRequestPage = null;

		public String Profile_Status = null;
		public String short_name = null;

		private static final Logger logger = Logger
				.getLogger(CancelLeaveRequestBeforeApprovalTest.class.getName());

		@BeforeClass
		@Parameters({ "browser", "siteURL", "employeeUserName", "employeepPssword" })
		public void initMethodTest(String browser, String siteURL, String userName, String approverPassword)
				throws Exception {
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
				//leaveTypePage.selectRole(testDataProp.getProperty(MY_ACCESS_ROLE_TEXT));

				Thread.sleep(3000);
				Assert.assertEquals(loginPage.getDashboardText(),
						expectedAssertionsProp.getProperty(DASHBOARD_TEXT));

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
				createLeaveRequestPage.selectHonoMenu(testDataProp.getProperty(LEAVE_TEXT));
				createLeaveRequestPage.clickOnCreateLeaveRequest();
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
		public void verifyLeaveTypeDetailsBySelectSubmitButton() {
			logger.info("Starting of verifyLeaveTypeDetailsBySelectSubmitButton method");

			try {
				Assert.assertTrue(createLeaveRequestPage.isSubmitButtonDisplayed());

			} catch (Exception e) {
				Assert.fail(
						"Exception occured while testing verifyLeaveTypeDetailsBySelectSubmitButton : " + e.getMessage());
				logger.error("Error occured while verifyLeaveTypeDetailsBySelectSubmitButton " + e);
			}

			logger.info("Starting of verifyLeaveTypeDetailsBySelectSubmitButton method");
		}

		@Test(priority = 5, description = "Verify Crete Leave Request by giving all valid details")
		@Description("Test Case #5, Verify Crete Leave Request by giving all valid details")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #5, Verify Crete Leave Request by giving all valid details")
		public void verifyCreateLeaveRequestByGivingAllValidDetails() {
			logger.info("Starting of verifyCreateLeaveRequestByGivingAllValidDetails method");

			try {
				createLeaveRequestPage.clickOnLeaveTypeButton();
				
				createLeaveRequestPage.selectLeaveType(testDataProp.getProperty(LEAVE_TYPE_CASUAL_LEAVE_TEST_TEXT));

				createLeaveRequestPage.clickOnSelectPlannedReasonsDropdown();
				
				createLeaveRequestPage.SelectPlannedReasons(testDataProp.getProperty(PLANNED_REASON_TEST_ONE_TEXT));

				createLeaveRequestPage.clickOnFromDate();
				
				createLeaveRequestPage.clickOnNextMonthButton();
				
				createLeaveRequestPage.selectDate(testDataProp.getProperty(LEAVE_FROM_DATE_TEXT));

				createLeaveRequestPage.clickOnFromHalfDropdown();
				
				createLeaveRequestPage.selectFromHalf(testDataProp.getProperty(FROM_HALF_FULL_DAY_TEXT));
				
				createLeaveRequestPage.clickOnToDate();
				
				createLeaveRequestPage.selectDate(testDataProp.getProperty(LEAVE_TO_DATE_TEXT));
				
				createLeaveRequestPage.clickOnToHalfDropdown();
				
				createLeaveRequestPage.selectToHalf(testDataProp.getProperty(TO_HALF_FIRST_HALF_TEXT));

				createLeaveRequestPage.clickOnSelectLeaveReasonDropdown();
				
				createLeaveRequestPage.SelectLeaveReason(testDataProp.getProperty(LEAVE_REASON_TEST_ONE_TEXT));

				createLeaveRequestPage.setLeaveReason(testDataProp.getProperty(REASON_FOR_LEAVE_TEXT));
				
				//createLeaveRequestPage.clickOnUploadDocumentButton(testDataProp.getProperty(UPLOAD_LEAVE_REQUEST_FILE_TEXT));
				
				createLeaveRequestPage.clickOnSubmitButton();

				Assert.assertEquals(leaveTypePage.getLeaveCreatedSuccessfullyToastMessage(),
						expectedAssertionsProp.getProperty(LEAVE_HAS_BEEN_SUCCESSFULLY_SUBMITTED_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyCreateLeaveRequestByGivingAllValidDetails : "
						+ e.getMessage());
				logger.error("Error occured while verifyCreateLeaveRequestByGivingAllValidDetails " + e);
			}

			logger.info("Starting of verifyCreateLeaveRequestByGivingAllValidDetails method");
		}

		@Test(priority = 6, description = "Verify the leave request details by select Leave Transactions")
		@Description("Test Case #6, Verify the leave request details by select Leave Transactions")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #6, Verify the leave request details by select pending for approval status transaction")
		public void verifyLeaveRequestTransactionDetails() {
			logger.info("Starting of verifyLeaveRequestTransactionDetails method");

			try {
				createLeaveRequestPage.clickOnMenuOpenButton();
				createLeaveRequestPage.selectHonoMenu(testDataProp.getProperty(LEAVE_TEXT));
				createLeaveRequestPage.selectHonoMenuItem(testDataProp.getProperty(LEAVE_TRANSACTIONS_TEXT));

				Assert.assertEquals(createLeaveRequestPage.getLeaveTransactionsText(),
						expectedAssertionsProp.getProperty(LEAVE_TRANSACTIONS_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyLeaveRequestTransactionDetails : " + e.getMessage());
				logger.error("Error occured while verifyLeaveRequestTransactionDetails " + e);
			}

			logger.info("Starting of verifyLeaveRequestTransactionDetails method");
		}

		@Test(priority = 7, description = "Verify Created Leave Request details by selecting Rows per page")
		@Description("Test Case #7, Verify Created Leave Request details by selecting Rows per page")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #7, Verify Created Leave Request details by selecting Rows per page")
		public void verifyLeaveRequestDetailsBySelectRowsPerPage() {
			logger.info("Starting of verifyLeaveRequestDetailsBySelectRowsPerPage method");

			try {
				Thread.sleep(2000);
				leaveTypePage.clickOnRowsPerPageButton();
				Thread.sleep(3000);
				leaveTypePage.selectRowsPerPage(testDataProp.getProperty(TWO_ROWS_PER_PAGE_TEXT));
				Thread.sleep(2000);
				createLeaveRequestPage.clickOnScroll();

			} catch (Exception e) {
				Assert.fail(
						"Exception occured while testing verifyLeaveRequestDetailsBySelectRowsPerPage : " + e.getMessage());
				logger.error("Error occured while verifyLeaveRequestDetailsBySelectRowsPerPage " + e);
			}

			logger.info("Starting of verifyLeaveRequestDetailsBySelectRowsPerPage method");
		}

		@Test(priority = 8, description = "Verify the leave transactions details by selecting the leave transaction status as Pending for approval ")
		@Description("Test Case #8, Verify the leave transactions details by selecting the leave transaction status as Pending for approval ")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #8, Verify the leave transactions details by selecting the leave transaction status as Pending for approval ")
		public void verifyLeaveTransactionDetailsBySelectPendingForApproval() {
			logger.info("Starting of verifyLeaveTransactionDetailsBySelectPendingForApproval method");

			try {
				createLeaveRequestPage.clickOnPendingForApprovalButton();
				Thread.sleep(5000);

				Assert.assertEquals(createLeaveRequestPage.getApproveLeaveRequestText(),
						(expectedAssertionsProp.getProperty(APPROVE_LEAVE_REQUEST_TEXT)));

				Assert.assertEquals(createLeaveRequestPage.getLevelOneManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_PENDING_FOR_APPROVAL_TEXT));

				Assert.assertEquals(createLeaveRequestPage.getLevelTwoManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_PENDING_FOR_APPROVAL_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyLeaveTransactionDetailsBySelectPendingForApproval : "
						+ e.getMessage());
				logger.error("Error occured while verifyLeaveTransactionDetailsBySelectPendingForApproval " + e);
			}

			logger.info("Starting of verifyLeaveTransactionDetailsBySelectPendingForApproval method");
		}
		
		@Parameters({ "browser", "siteURL", "levelOneManagerUserName", "LevelOneManagerPassword" })
		@Test(priority = 9, description = "Verify Dashboard Details after giving a valid User Name & password for Level one manager")
		@Description("Test Case #9, Verify Dashboard Details after giving a valid User Name & password for Level one manager")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #9, Verify Dashboard Details after giving a valid User Name & Password for Level one manager")
		public void verifyDashboardDetailsByGivingValidCredentials(String browser, String siteURL, String approverUserName, String approverPassword) {
			logger.info("Starting of verifyDashboardDetailsByGivingValidCredentials method");

			try {
				approverOneDriver = this.getWebDriver(browser, WEB_DRIVER.APPROVE_LEAVE_REQUEST);
				loginToHono(browser, siteURL, approverUserName, approverPassword, this.approverOneDriver);

				approverOneLoginPage = new HonoLeaveLoginPage(approverOneDriver);
				approverOneLeaveTypePage = new LeaveTypePage(approverOneDriver);
				approverOneCreateLeaveRequestPage = new CreateLeaveRequestPage(approverOneDriver);

				Thread.sleep(3000);
				Assert.assertEquals(approverOneLoginPage.getDashboardText(),
						expectedAssertionsProp.getProperty(DASHBOARD_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyDashboardDetailsByGivingValidCredentials : "
						+ e.getMessage());
				logger.error("Error occured while verifyDashboardDetailsByGivingValidCredentials " + e);
			}

			logger.info("Starting of verifyDashboardDetailsByGivingValidCredentials method");
		}
		
		@Test(priority = 10, description = "Verify the leave request details by select Leave Transactions from level one manager")
		@Description("Test Case #10, Verify the leave request details by select Leave Transactions from level one manager")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #10, Verify the leave request details by select Leave Transactions from level one manager")
		public void verifyLeaveTransactionDetailsFromLevelOneManger() {
			logger.info("Starting of verifyLeaveTransactionDetailsFromLevelOneManger method");

			try {
				approverOneCreateLeaveRequestPage.selectHonoMenu(testDataProp.getProperty(LEAVE_TEXT));
				approverOneCreateLeaveRequestPage.clickOnLeaveTransactions();

				Assert.assertEquals(approverOneCreateLeaveRequestPage.getLeaveTransactionsText(),
						expectedAssertionsProp.getProperty(LEAVE_TRANSACTIONS_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyLeaveTransactionDetailsFromLevelOneManger : " + e.getMessage());
				logger.error("Error occured while verifyLeaveTransactionDetailsFromLevelOneManger " + e);
			}

			logger.info("Starting of verifyLeaveTransactionDetailsFromLevelOneManger method");
		}
		
		@Test(priority = 11, description = "Verify the leave transactions details by selecting the leave transaction status as Pending for approval ")
		@Description("Test Case #11, Verify the leave transactions details by selecting the leave transaction status as Pending for approval ")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #11, Verify the leave transactions details by selecting the leave transaction status as Pending for approval ")
		public void verifyPendingForApprovalTransactionDetails() {
			logger.info("Starting of verifyPendingForApprovalTransactionDetails method");

			try {
				Thread.sleep(2000);
				approverOneLeaveTypePage.clickOnRowsPerPageButton();
				Thread.sleep(3000);
				approverOneLeaveTypePage.selectRowsPerPage(testDataProp.getProperty(TWO_ROWS_PER_PAGE_TEXT));
				Thread.sleep(2000);
				approverOneCreateLeaveRequestPage.clickOnScroll();
				
				approverOneCreateLeaveRequestPage.clickOnPendingForApprovalButton();
				Thread.sleep(5000);

				Assert.assertEquals(approverOneCreateLeaveRequestPage.getApproveLeaveRequestText(),
						(expectedAssertionsProp.getProperty(APPROVE_LEAVE_REQUEST_TEXT)));

				Assert.assertEquals(approverOneCreateLeaveRequestPage.getLevelOneManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_PENDING_FOR_APPROVAL_TEXT));

				Assert.assertEquals(approverOneCreateLeaveRequestPage.getLevelTwoManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_PENDING_FOR_APPROVAL_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyPendingForApprovalTransactionDetails : "
						+ e.getMessage());
				logger.error("Error occured while verifyPendingForApprovalTransactionDetails " + e);
			}

			logger.info("Starting of verifyPendingForApprovalTransactionDetails method");
		}
		
		@Test(priority = 12, description = "Verify the Leave Transaction details by selecting the Cancel option without entering Reason text by Employee")
		@Description("Test Case #12, Verify the Leave Transaction details by selecting the Cancel option without entering Reason text by Employee")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #12, Verify the Leave Transaction details by selecting the Cancel option without entering Reason text by Employee")
		public void verifyCancelLeaveRequestByWithoutEnteringReason() {
			logger.info("Starting of verifyCanvcelLeaveRequestByWithoutEnteringReason method");

			try {
				createLeaveRequestPage.clickOnPendingForApprovalButton();
				
				Assert.assertEquals(createLeaveRequestPage.getApproveLeaveRequestText(),
						(expectedAssertionsProp.getProperty(APPROVE_LEAVE_REQUEST_TEXT)));

				createLeaveRequestPage.clickOnCancelRequestButton();

				Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
						expectedAssertionsProp.getProperty(PLEASE_ENTER_REMARKS_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyCanvcelLeaveRequestByWithoutEnteringReason : "
						+ e.getMessage());
				logger.error("Error occured while verifyCanvcelLeaveRequestByWithoutEnteringReason " + e);
			}

			logger.info("Starting of verifyCanvcelLeaveRequestByWithoutEnteringReason method");
		}

		@Test(priority = 13, description = "Verify that the leave transaction details are accurately updated when the employee selects the Cancel option and enters a reason for cancellation")
		@Description("Test Case #13, Verify that the leave transaction details are accurately updated when the employee selects the Cancel option and enters a reason for cancellation")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #13, Verify that the leave transaction details are accurately updated when the employee selects the Cancel option and enters a reason for cancellation")
		public void verifyCancelLeaveRequestByEmployee() {
			logger.info("Starting of verifyCancelLeaveRequestByEmployee method");

			try {
				createLeaveRequestPage.clickOnCloseButton();
				
				Assert.assertEquals(createLeaveRequestPage.getApproveLeaveRequestText(),
						(expectedAssertionsProp.getProperty(APPROVE_LEAVE_REQUEST_TEXT)));

				createLeaveRequestPage.setLeaveReason(testDataProp.getProperty(REASON_FOR_CANCEL_LEAVE_TEXT));
				createLeaveRequestPage.clickOnCancelRequestButton();

				Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_CANCELLED_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyCancelLeaveRequestByEmployee : " + e.getMessage());
				logger.error("Error occured while verifyCancelLeaveRequestByEmployee " + e);
			}

			logger.info("Starting of verifyCancelLeaveRequestByEmployee method");
		}
		
		@Test(priority = 14, description = "Verify the Recently cancelled Leave Transaction details by employee")
		@Description("Test Case #14, Verify the Recently cancelled Leave Transaction details by employee")
		@Severity(SeverityLevel.NORMAL)
		@Story("Test Case #14, Verify the Recently cancelled Leave Transaction details by employee")
		public void verifyCancelledLeaveTransactionStatusByEmployee() {
			logger.info("Starting of verifyCancelledLeaveTransactionStatusByEmployee method");

			try {
				createLeaveRequestPage.clickOnMenuOpenButton();
				createLeaveRequestPage.selectHonoMenu(testDataProp.getProperty(LEAVE_TEXT));
				createLeaveRequestPage.clickOnLeaveTransactions();

				Assert.assertEquals(createLeaveRequestPage.getLeaveTransactionsText(),
						expectedAssertionsProp.getProperty(LEAVE_TRANSACTIONS_TEXT));

				createLeaveRequestPage.clickOnCancelledButton();

				Assert.assertEquals(createLeaveRequestPage.getLevelOneManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(LEAVE_CANCELLED_STATUS_TEXT));

				Assert.assertEquals(createLeaveRequestPage.getLevelTwoManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(LEAVE_CANCELLED_STATUS_TEXT));

			} catch (Exception e) {
				Assert.fail(
						"Exception occured while testing verifyCancelledLeaveTransactionStatusByEmployee : " + e.getMessage());
				logger.error("Error occured while verifyCancelledLeaveTransactionStatusByEmployee " + e);
			}

			logger.info("Starting of verifyCancelledLeaveTransactionStatusByEmployee method");
		}

		// @AfterClass
		public void quitDriver() {
			// quitDriver(driver, WEB_DRIVER.EMPLOYEE_CREATE_LEAVE_REQUEST);
			logger.debug("Driver quit successfully");
		}

	}

