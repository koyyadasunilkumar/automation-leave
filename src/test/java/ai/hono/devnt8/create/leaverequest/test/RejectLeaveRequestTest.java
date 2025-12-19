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

	@Epic("Hono Leave")
	@Feature("Reject leave request test")
	public class RejectLeaveRequestTest extends BaseHonoLeaveTest {

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

		private static final Logger logger = Logger.getLogger(RejectLeaveRequestTest.class.getName());

		@BeforeClass
		@Parameters({ "browser", "siteURL", "employeeUserName", "employeePassword" })
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
				// leaveTypePage.selectRole(testDataProp.getProperty(MY_ACCESS_ROLE_TEXT));

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

				// createLeaveRequestPage.clickOnUploadDocumentButton(testDataProp.getProperty(UPLOAD_LEAVE_REQUEST_FILE_TEXT));

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
		public void verifyDashboardDetailsByGivingValidCredentials(String browser, String siteURL, String approverUserName,
				String approverPassword) {
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
				Assert.fail("Exception occured while testing verifyLeaveTransactionDetailsFromLevelOneManger : "
						+ e.getMessage());
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
				Assert.fail(
						"Exception occured while testing verifyPendingForApprovalTransactionDetails : " + e.getMessage());
				logger.error("Error occured while verifyPendingForApprovalTransactionDetails " + e);
			}

			logger.info("Starting of verifyPendingForApprovalTransactionDetails method");
		}

		@Test(priority = 12, description = "Verify the Leave Transaction details by selecting the Reject option without entering Reason text")
		@Description("Test Case #12, Verify the Leave Transaction details by selecting the Reject option without entering Reason text")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #12, Verify the Leave Transaction details by selecting the Reject option without entering Reason text")
		public void verifyRejectLeaveRequestByWithoutEnteringReason() throws Exception {
			logger.info("Starting of verifyRejectLeaveRequestByWithoutEnteringReason method");

			try {
				Assert.assertEquals(approverOneCreateLeaveRequestPage.getApproveLeaveRequestText(),
						(expectedAssertionsProp.getProperty(APPROVE_LEAVE_REQUEST_TEXT)));

				approverOneCreateLeaveRequestPage.clickOnApproveButton();

				Assert.assertEquals(approverOneLeaveTypePage.getLeaveToastMessage(),
						expectedAssertionsProp.getProperty(PLEASE_ENTER_REMARKS_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyRejectLeaveRequestByWithoutEnteringReason : "
						+ e.getMessage());
				logger.error("Error occured while verifyRejectLeaveRequestByWithoutEnteringReason " + e);
			}

			logger.info("Ending of verifyRejectLeaveRequestByWithoutEnteringReason method");
		}

		@Test(priority = 13, description = "Verify the Leave Transaction details by selecting the Approve option and entering Reason text")
		@Description("Test Case #13, Verify the Leave Transaction details by selecting the Approve option and entering Reason text")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #13, Verify the Leave Transaction details by selecting the Approve option and entering Reason text")
		public void verifyApproveLeaveRequestBySelectApproveOption() {
			logger.info("Starting of verifyApproveLeaveRequestBySelectApproveOption method");

			try {
				approverOneCreateLeaveRequestPage.clickOnCloseButton();
				Thread.sleep(5000);
				Assert.assertEquals(approverOneCreateLeaveRequestPage.getApproveLeaveRequestText(),
						(expectedAssertionsProp.getProperty(APPROVE_LEAVE_REQUEST_TEXT)));

				approverOneCreateLeaveRequestPage.setRemarks(testDataProp.getProperty(APPROVE_REMARKS_TEXT));
				approverOneCreateLeaveRequestPage.clickOnApproveButton();

				Assert.assertEquals(approverOneLeaveTypePage.getLeaveToastMessage(),
						expectedAssertionsProp.getProperty(LEAVE_REQUEST_APPROVED_SUCCESSFULLY_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyApproveLeaveRequestBySelectApproveOption : "
						+ e.getMessage());
				logger.error("Error occured while verifyApproveLeaveRequestBySelectApproveOption " + e);
			}

			logger.info("Starting of verifyApproveLeaveRequestBySelectApproveOption method");
		}

		@Test(priority = 14, description = "Verify the Leave Transaction Status details after approved by Level one manager")
		@Description("Test Case #14, Verify the Leave Transaction Status details after approved by Level one manager")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #14, Verify the Leave Transaction Status details after approved by Level one manager")
		public void VerifyLeaveRequestStatusAfterApprovedByLevelOneManager() {
			logger.info("Starting of VerifyLeaveRequestStatusAfterApprovedByLevelOneManager method");

			try {
				approverOneCreateLeaveRequestPage.clickOnApprovedButton();

				Assert.assertEquals(approverOneCreateLeaveRequestPage.getLevelOneManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_APPROVED_TEXT));

				Assert.assertEquals(approverOneCreateLeaveRequestPage.getLevelTwoManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_PENDING_FOR_APPROVAL_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing VerifyLeaveRequestStatusAfterApprovedByLevelOneManager : "
						+ e.getMessage());
				logger.error("Error occured while VerifyLeaveRequestStatusAfterApprovedByLevelOneManager " + e);
			}

			logger.info("Starting of VerifyLeaveRequestStatusAfterApprovedByLevelOneManager method");
		}

		@Parameters({ "browser", "siteURL", "levelTwoManagerUserName", "LevelTwoManagerPassword" })
		@Test(priority = 15, description = "Verify Dashboard Details after giving a valid User Name & password for Level two manager")
		@Description("Test Case #15, Verify Dashboard Details after giving a valid User Name & password for Level two manager")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #15, Verify Dashboard Details after giving a valid User Name & Password for Level two manager")
		public void verifyLevelTwoApprovalDashboardDetailsByGivingValidCredentials(String browser, String siteURL,
				String approverUserName, String approverPassword) {
			logger.info("Starting of verifyLevelTwoApprovalDashboardDetailsByGivingValidCredentials method");

			try {
				approverTwoDriver = this.getWebDriver(browser, WEB_DRIVER.APPROVE_LEAVE_REQUEST);
				loginToHono(browser, siteURL, approverUserName, approverPassword, this.approverTwoDriver);

				approverTwoLoginPage = new HonoLeaveLoginPage(approverTwoDriver);
				approverTwoLeaveTypePage = new LeaveTypePage(approverTwoDriver);
				approverTwoCreateLeaveRequestPage = new CreateLeaveRequestPage(approverTwoDriver);

				Thread.sleep(3000);
				Assert.assertEquals(approverTwoLoginPage.getDashboardText(),
						expectedAssertionsProp.getProperty(DASHBOARD_TEXT));

			} catch (Exception e) {
				Assert.fail(
						"Exception occured while testing verifyLevelTwoApprovalDashboardDetailsByGivingValidCredentials : "
								+ e.getMessage());
				logger.error("Error occured while verifyLevelTwoApprovalDashboardDetailsByGivingValidCredentials " + e);
			}

			logger.info("Starting of verifyLevelTwoApprovalDashboardDetailsByGivingValidCredentials method");
		}

		@Test(priority = 16, description = "Verify the leave request details by select Leave Transactions from level two manager")
		@Description("Test Case #16, Verify the leave request details by select Leave Transactions from level two manager")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #16, Verify the leave request details by select Leave Transactions from level two manager")
		public void verifyLeaveTransactionDetailsFromLevelTwoManger() {
			logger.info("Starting of verifyLeaveTransactionDetailsFromLevelTwoManger method");

			try {
				approverTwoCreateLeaveRequestPage.selectHonoMenu(testDataProp.getProperty(LEAVE_TEXT));
				approverTwoCreateLeaveRequestPage.clickOnLeaveTransactions();

				Assert.assertEquals(approverTwoCreateLeaveRequestPage.getLeaveTransactionsText(),
						expectedAssertionsProp.getProperty(LEAVE_TRANSACTIONS_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyLeaveTransactionDetailsFromLevelTwoManger : "
						+ e.getMessage());
				logger.error("Error occured while verifyLeaveTransactionDetailsFromLevelTwoManger " + e);
			}

			logger.info("Starting of verifyLeaveTransactionDetailsFromLevelTwoManger method");
		}

		@Test(priority = 17, description = "Verify the leave transactions details by selecting the leave transaction status as Pending for approval ")
		@Description("Test Case #17, Verify the leave transactions details by selecting the leave transaction status as Pending for approval ")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #17, Verify the leave transactions details by selecting the leave transaction status as Pending for approval ")
		public void verifyLeaveTransactionDetailsAfterLevelOneApproval() {
			logger.info("Starting of verifyLeaveTransactionDetailsAfterLevelOneApproval method");

			try {
				approverTwoCreateLeaveRequestPage.clickOnPendingForApprovalButton();
				Thread.sleep(5000);

				Assert.assertEquals(approverTwoCreateLeaveRequestPage.getApproveLeaveRequestText(),
						(expectedAssertionsProp.getProperty(APPROVE_LEAVE_REQUEST_TEXT)));

				Assert.assertEquals(approverTwoCreateLeaveRequestPage.getLevelOneManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_APPROVED_TEXT));

				Assert.assertEquals(approverTwoCreateLeaveRequestPage.getLevelTwoManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_PENDING_FOR_APPROVAL_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyLeaveTransactionDetailsAfterLevelOneApproval : "
						+ e.getMessage());
				logger.error("Error occured while verifyLeaveTransactionDetailsAfterLevelOneApproval " + e);
			}

			logger.info("Starting of verifyLeaveTransactionDetailsAfterLevelOneApproval method");
		}

		@Test(priority = 18, description = "Verify the Leave Transaction details by selecting the Reject option without entering Reason text")
		@Description("Test Case #18, Verify the Leave Transaction details by selecting the Reject option without entering Reason text")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #18, Verify the Leave Transaction details by selecting the Reject option without entering Reason text")
		public void verifyRejectLeaveWithoutReason() throws Exception {
			logger.info("Starting of verifyRejectLeaveWithoutReason method");

			try {
				Assert.assertEquals(approverTwoCreateLeaveRequestPage.getApproveLeaveRequestText(),
						(expectedAssertionsProp.getProperty(APPROVE_LEAVE_REQUEST_TEXT)));

				approverTwoCreateLeaveRequestPage.clickOnRejectButton();

				Assert.assertEquals(approverTwoLeaveTypePage.getLeaveToastMessage(),
						expectedAssertionsProp.getProperty(PLEASE_ENTER_REMARKS_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyRejectLeaveWithoutReason : " + e.getMessage());
				logger.error("Error occured while verifyRejectLeaveWithoutReason " + e);
			}

			logger.info("Ending of verifyRejectLeaveWithoutReason method");
		}

		@Test(priority = 19, description = "Verify the Leave Transaction details by selecting the Reject option and entering Reason text")
		@Description("Test Case #19, Verify the Leave Transaction details by selecting the Reject option and entering Reason text")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #19, Verify the Leave Transaction details by selecting the Reject option and entering Reason text")
		public void verifyRejectLeaveRequestByGivingReason() {
			logger.info("Starting of verifyRejectLeaveRequestByGivingReason method");

			try {
				approverTwoCreateLeaveRequestPage.clickOnCloseButton();
				Thread.sleep(5000);
				Assert.assertEquals(approverTwoCreateLeaveRequestPage.getApproveLeaveRequestText(),
						(expectedAssertionsProp.getProperty(APPROVE_LEAVE_REQUEST_TEXT)));

				approverTwoCreateLeaveRequestPage.setRemarks(testDataProp.getProperty(REJECT_REMARKS_TEXT));
				approverTwoCreateLeaveRequestPage.clickOnRejectButton();

				Assert.assertEquals(approverTwoLeaveTypePage.getLeaveToastMessage(),
						expectedAssertionsProp.getProperty(LEAVE_REQUEST_REJECTED_SUCCESSFULLY_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing verifyRejectLeaveRequestByGivingReason : "
						+ e.getMessage());
				logger.error("Error occured while verifyRejectLeaveRequestByGivingReason " + e);
			}

			logger.info("Starting of verifyRejectLeaveRequestByGivingReason method");
		}

		@Test(priority = 20, description = "Verify the Leave Transaction Status details after Rejected by Level two manager")
		@Description("Test Case #20, Verify the Leave Transaction Status details after Rejected by Level two manager")
		@Severity(SeverityLevel.CRITICAL)
		@Story("Test Case #20, Verify the Leave Transaction Status details after Rejected by Level two manager")
		public void VerifyLeaveRequestStatusAfterRejectedByLevelTwoManager() {
			logger.info("Starting of VerifyLeaveRequestStatusAfterRejectedByLevelTwoManager method");

			try {
				approverTwoCreateLeaveRequestPage.clickOnRejectedButton();

				Assert.assertEquals(approverTwoCreateLeaveRequestPage.getLevelOneManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_APPROVED_TEXT));

				Assert.assertEquals(approverTwoCreateLeaveRequestPage.getLevelTwoManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(LEAVE_APPROVAL_STATUS_REJECTED_TEXT));

			} catch (Exception e) {
				Assert.fail("Exception occured while testing VerifyLeaveRequestStatusAfterRejectedByLevelTwoManager : "
						+ e.getMessage());
				logger.error("Error occured while VerifyLeaveRequestStatusAfterRejectedByLevelTwoManager " + e);
			}

			logger.info("Starting of VerifyLeaveRequestStatusAfterRejectedByLevelTwoManager method");
		}

		@Test(priority = 21, description = "Verify the recently rejected  Leave Transaction details by employee")
		@Description("Test Case #21, Verify the Recently rejected  Leave Transaction details by employee")
		@Severity(SeverityLevel.NORMAL)
		@Story("Test Case #21, Verify the Recently rejected  Leave Transaction details by employee")
		public void verifyRejectedLeaveTransactionStatusByEmployee() {
			logger.info("Starting of verifyRejectedLeaveTransactionStatusByEmployee method");

			try {
				createLeaveRequestPage.clickOnMenuOpenButton();
				createLeaveRequestPage.selectHonoMenu(testDataProp.getProperty(LEAVE_TEXT));
				createLeaveRequestPage.clickOnLeaveTransactions();

				Assert.assertEquals(createLeaveRequestPage.getLeaveTransactionsText(),
						expectedAssertionsProp.getProperty(LEAVE_TRANSACTIONS_TEXT));

				createLeaveRequestPage.clickOnRejectedButton();

				Assert.assertEquals(createLeaveRequestPage.getLevelOneManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_APPROVED_TEXT));

				Assert.assertEquals(createLeaveRequestPage.getLevelTwoManagerApprovalLeaveRequestStatus(),
						expectedAssertionsProp.getProperty(LEAVE_APPROVAL_STATUS_REJECTED_TEXT));

			} catch (Exception e) {
				Assert.fail(
						"Exception occured while testing verifyRejectedLeaveTransactionStatusByEmployee : " + e.getMessage());
				logger.error("Error occured while verifyRejectedLeaveTransactionStatusByEmployee " + e);
			}

			logger.info("Starting of verifyRejectedLeaveTransactionStatusByEmployee method");
		}
	}


