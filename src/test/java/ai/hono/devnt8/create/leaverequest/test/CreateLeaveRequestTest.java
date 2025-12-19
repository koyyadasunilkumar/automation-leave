package ai.hono.devnt8.create.leaverequest.test;

	import static ai.hono.devnt8.util.Constants.*;

import java.awt.Toolkit;
	import java.awt.datatransfer.Clipboard;
	import java.awt.datatransfer.DataFlavor;
	import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.springframework.context.annotation.Description;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

import ai.hono.devnt8.base.pages.BaseHonoLeavePage;
import ai.hono.devnt8.base.test.BaseHonoLeaveTest;
import ai.hono.devnt8.create.leave.request.pages.CreateLeaveRequestPage;
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

		@Epic("Hono Leave Request")
		@Feature("Hono Create Leave Request test")
		public class CreateLeaveRequestTest extends BaseHonoLeaveTest {

			private WebDriver driver = null;
			private WebDriver candidateDriver = null;
			private HonoLeaveLoginPage loginPage = null;
			private LeaveTypePage leaveTypePage = null;
			private CreateLeaveRequestPage createLeaveRequestPage = null;
			
			public String Profile_Status = null;
			public String short_name = null;

			private static final Logger logger = Logger.getLogger(CreateLeaveRequestTest.class.getName());

			@BeforeClass
			@Parameters({ "browser","siteURL","employeeUserName","employeePassword" })
			public void initMethodTest(String browser,String siteURL,String userName,String approverPassword) throws Exception {
				logger.info("Starting of initMethodTest method");

				driver = this.getWebDriver(browser, WEB_DRIVER.CREATE_LEAVE_TYPE);

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
					Thread.sleep(5000);
					leaveTypePage.selectRole(testDataProp.getProperty(MY_ACCESS_ROLE_TEXT));

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

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyLeaveTypeDetailsBySelectAddLeaveType : " + e.getMessage());
					logger.error("Error occured while verifyLeaveTypeDetailsBySelectAddLeaveType " + e);
				}

				logger.info("Starting of verifyLeaveTypeDetailsBySelectAddLeaveType method");
			}
			
			@Test(priority = 5, description = "Verify Crete Leave Request Without Uploading any file")
			@Description("Test Case #5, Verify Crete Leave Request Without Uploading any file")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #5, Verify Crete Leave Request Without Uploading any file")
			public void verifyCreateLeaveRequestWithoutUploadingFile() {
				logger.info("Starting of verifyCreateLeaveRequestWithoutUploadingFile method");

				try {
					Assert.assertEquals(createLeaveRequestPage.getCreateLeaveRequestText(),
							(expectedAssertionsProp.getProperty(APPLY_FOR_LEAVE_TEXT)));

					createLeaveRequestPage.clickOnLeaveTypeButton();
					createLeaveRequestPage.selectLeaveType(testDataProp.getProperty(LEAVE_TYPE_SICK_LEAVE_AG_P_TEXT));
					createLeaveRequestPage.clickOnFromDate();
					createLeaveRequestPage.selectDate(testDataProp.getProperty(LEAVE_FROM_DATE_TEXT));
					createLeaveRequestPage.setLeaveReason(testDataProp.getProperty(REASON_FOR_LEAVE_TEXT));
					createLeaveRequestPage.clickOnSubmitButton();
					
					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(DOCUMENTS_REQUIRED_FOR_APPLYING_LEAVE_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyCreateLeaveRequestWithoutUploadingFile : " + e.getMessage());
					logger.error("Error occured while verifyCreateLeaveRequestWithoutUploadingFile " + e);
				}

				logger.info("Starting of verifyCreateLeaveRequestWithoutUploadingFile method");
			}
			
			@Test(priority = 6, description = "Verify Crete Leave Request by Upload Large files")
			@Description("Test Case #6, Verify Crete Leave Request by Upload Large file")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #6, Verify Crete Leave Request by Upload Large file")
			public void verifyCreateLeaveRequestWithLargeFileUpload() {
				logger.info("Starting of verifyCreateLeaveRequestWithLargeFileUpload method");

				try {
					Assert.assertEquals(createLeaveRequestPage.getCreateLeaveRequestText(),
							(expectedAssertionsProp.getProperty(APPLY_FOR_LEAVE_TEXT)));

					createLeaveRequestPage.clickOnLeaveTypeButton();
					createLeaveRequestPage.selectLeaveType(testDataProp.getProperty(LEAVE_TYPE_SICK_LEAVE_AG_P_TEXT));
					createLeaveRequestPage.clickOnUploadDocumentButton(testDataProp.getProperty(UPLOAD_MORE_THAN_TWO_MB_FILE_TEXT));

					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(FILE_MUST_BE_SMALLER_THAN_TWO_MB_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyCreateLeaveRequestWithLargeFileUpload : " + e.getMessage());
					logger.error("Error occured while verifyCreateLeaveRequestWithLargeFileUpload " + e);
				}

				logger.info("Starting of verifyCreateLeaveRequestWithLargeFileUpload method");
			}
			
			@Test(priority = 7, description = "Verify Crete Leave Request by Upload Empty files")
			@Description("Test Case #7, Verify Crete Leave Request by Upload More Empty file")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #7, Verify Crete Leave Request by Upload More Empty file")
			public void verifyCreateLeaveRequestWithEmptyFileUpload() {
				logger.info("Starting of verifyCreateLeaveRequestWithEmptyFileUpload method");

				try {
					Assert.assertEquals(createLeaveRequestPage.getCreateLeaveRequestText(),
							(expectedAssertionsProp.getProperty(APPLY_FOR_LEAVE_TEXT)));

					createLeaveRequestPage.clickOnLeaveTypeButton();
					createLeaveRequestPage.selectLeaveType(testDataProp.getProperty(LEAVE_TYPE_SICK_LEAVE_AG_P_TEXT));
					createLeaveRequestPage.clickOnUploadDocumentButton(testDataProp.getProperty(UPLOAD_EMPTY_TEXT_FILE_TEXT));

					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(FILE_IS_EMPTY_AND_CANNOT_UPLOADED_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyCreateLeaveRequestWithEmptyFileUpload : " + e.getMessage());
					logger.error("Error occured while verifyCreateLeaveRequestWithEmptyFileUpload " + e);
				}

				logger.info("Starting of verifyCreateLeaveRequestWithEmptyFileUpload method");
			}
			
			@Test(priority = 8, description = "Verify Crete Leave Request by uploading the same file more than once")
			@Description("Test Case #8, Verify Crete Leave Request by uploading the same file more than once")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #8, Verify Crete Leave Request by uploading the same file more than once")
			public void verifyCreateLeaveRequestByUploadingDuplicateFile() {
				logger.info("Starting of verifyCreateLeaveRequestByUploadingDuplicateFile method");

				try {
					Assert.assertEquals(createLeaveRequestPage.getCreateLeaveRequestText(),
							(expectedAssertionsProp.getProperty(APPLY_FOR_LEAVE_TEXT)));

					createLeaveRequestPage.clickOnLeaveTypeButton();
					createLeaveRequestPage.selectLeaveType(testDataProp.getProperty(LEAVE_TYPE_SICK_LEAVE_AG_P_TEXT));
					createLeaveRequestPage.clickOnUploadDocumentButton(testDataProp.getProperty(UPLOAD_SAME_FILE_TYPES_LIST_TEXT));
					//createLeaveRequestPage.clickOnUploadDocumentButton(testDataProp.getProperty(UPLOAD_DUPLICATE_FILE_TEXT));

					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(DOCUMENT_IS_ALREADY_UPLOADED_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyCreateLeaveRequestByUploadingDuplicateFile : " + e.getMessage());
					logger.error("Error occured while verifyCreateLeaveRequestByUploadingDuplicateFile " + e);
				}

				logger.info("Starting of verifyCreateLeaveRequestByUploadingDuplicateFile method");
			}
			
			@Test(priority = 9, description = "Verify Crete Leave Request by uploading the more than Four different file types")
			@Description("Test Case #9, Verify Crete Leave Request by uploading the more than Four different file types")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #9, Verify Crete Leave Request by uploading the more than Four different file types")
			public void verifyCreateLeaveRequestByUploadingMoreThanFourFiles() {
				logger.info("Starting of verifyCreateLeaveRequestByUploadingMoreThanFourFiles method");

				try {
					createLeaveRequestPage.refresh();
					Assert.assertEquals(createLeaveRequestPage.getCreateLeaveRequestText(),
							(expectedAssertionsProp.getProperty(APPLY_FOR_LEAVE_TEXT)));

					createLeaveRequestPage.clickOnLeaveTypeButton();
					createLeaveRequestPage.selectLeaveType(testDataProp.getProperty(LEAVE_TYPE_SICK_LEAVE_AG_P_TEXT));
					createLeaveRequestPage.clickOnUploadDocumentButton(testDataProp.getProperty(UPLOAD_FIVE_DIFFERENT_FILE_TYPES_LIST_TEXT));

					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(YOU_CAN_UPLOAD_MAXIMUM_OF_FOUR_FILES_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyCreateLeaveRequestByUploadingMoreThanFourFiles : " + e.getMessage());
					logger.error("Error occured while verifyCreateLeaveRequestByUploadingMoreThanFourFiles " + e);
				}

				logger.info("Starting of verifyCreateLeaveRequestByUploadingMoreThanFourFiles method");
			}

			@Test(priority = 10, description = "Verify Crete Leave Request by giving all valid details")
			@Description("Test Case #10, Verify Crete Leave Request by giving all valid details")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #10, Verify Crete Leave Request by giving all valid details")
			public void verifyCreateLeaveRequestByGivingAllValidDetails() {
				logger.info("Starting of verifyCreateLeaveRequestByGivingAllValidDetails method");

				try {
					createLeaveRequestPage.refresh();
					Assert.assertEquals(createLeaveRequestPage.getCreateLeaveRequestText(),
							(expectedAssertionsProp.getProperty(APPLY_FOR_LEAVE_TEXT)));

					createLeaveRequestPage.clickOnLeaveTypeButton();
					createLeaveRequestPage.selectLeaveType(testDataProp.getProperty(LEAVE_TYPE_SICK_LEAVE_AG_P_TEXT));

					//createLeaveRequestPage.clickOnAvailedUsingDropdown();
					//createLeaveRequestPage.selectAvailedUsing(testDataProp.getProperty(AVAILED_USING_DAYS_TEXT));

					createLeaveRequestPage.clickOnFromDate();
					createLeaveRequestPage.selectDate(testDataProp.getProperty(LEAVE_FROM_DATE_TEXT));

					createLeaveRequestPage.clickOnFromHalfDropdown();
					createLeaveRequestPage.selectFromHalf(testDataProp.getProperty(FROM_HALF_FULL_DAY_TEXT));

					createLeaveRequestPage.clickOnToDate();
					createLeaveRequestPage.selectDate(testDataProp.getProperty(LEAVE_TO_DATE_TEXT));

				//	createLeaveRequestPage.clickOnToHalfDropdown();
				//	createLeaveRequestPage.selectToHalf(testDataProp.getProperty(TO_HALF_FIRST_HALF_TEXT));

					createLeaveRequestPage.setLeaveReason(testDataProp.getProperty(REASON_FOR_LEAVE_TEXT));

					createLeaveRequestPage.clickOnUploadDocumentButton(testDataProp.getProperty(UPLOAD_LEAVE_REQUEST_LIST_TEXT));

					createLeaveRequestPage.clickOnSubmitButton();

					Assert.assertEquals(leaveTypePage.getLeaveToastMessage(),
							expectedAssertionsProp.getProperty(LEAVE_REQUEST_SUBMITTED_SUCCESSFULLY_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyCreateLeaveRequestByGivingAllValidDetails : " + e.getMessage());
					logger.error("Error occured while verifyCreateLeaveRequestByGivingAllValidDetails " + e);
				}

				logger.info("Starting of verifyCreateLeaveRequestByGivingAllValidDetails method");
			}
			
			@Test(priority = 11, description = "Verify Created Leave Type details by selecting Last page")
			@Description("Test Case #11, Verify Created Leave Type details by selecting Last page")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #11, Verify Created Leave Type details by selecting Last page")
			public void verifyLeaveTypeDetailsBySelectLastPage() {
				logger.info("Starting of verifyLeaveTypeDetailsBySelectLastPage method");

				try {
					Assert.assertEquals(createLeaveRequestPage.getLeaveTransactionsText(),
							expectedAssertionsProp.getProperty(LEAVE_TRANSACTIONS_TEXT));

					Thread.sleep(2000);
					leaveTypePage.clickOnRowsPerPageButton();
					Thread.sleep(3000);
					leaveTypePage.selectRowsPerPage(testDataProp.getProperty(TWO_ROWS_PER_PAGE_TEXT));
					Thread.sleep(2000);
					createLeaveRequestPage.clickOnScroll();

					Assert.assertEquals(createLeaveRequestPage.getLeaveTransactionSize(),
							expectedAssertionsProp.getProperty(LEAVE_TRANSACTIONS_SIZE_TEXT));

				} catch (Exception e) {
					Assert.fail("Exception occured while testing verifyLeaveTypeDetailsBySelectLastPage : " + e.getMessage());
					logger.error("Error occured while verifyLeaveTypeDetailsBySelectLastPage " + e);
				}

				logger.info("Starting of verifyLeaveTypeDetailsBySelectLastPage method");
			}

			@Test(priority = 12, description = "Verify the leave request status by selecting Pending for approval")
			@Description("Test Case #12, Verify the leave request status by selecting Pending for approval")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #12, Verify the leave request status by selecting Pending for approval")
			public void verifyLeaveRequestTransactionDetails() {
				logger.info("Starting of verifyLeaveRequestTransactionDetails method");

				try {
					Assert.assertEquals(createLeaveRequestPage.getLeaveTransactionsText(),
							expectedAssertionsProp.getProperty(LEAVE_TRANSACTIONS_TEXT));

					createLeaveRequestPage.clickOnPendingForApprovalButton();

					Assert.assertEquals(createLeaveRequestPage.getLevelOneManagerApprovalLeaveRequestStatus(),
							expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_PENDING_FOR_APPROVAL_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyLeaveRequestTransactionDetails : " + e.getMessage());
					logger.error("Error occured while verifyLeaveRequestTransactionDetails " + e);
				}

				logger.info("Starting of verifyLeaveRequestTransactionDetails method");
			}

			@Test(priority = 13, description = "Verify the Cancel Leave Request")
			@Description("Test Case #13, Verify the Cancel Leave Request")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #13, Verify the Cancel Leave Request")
			public void verifyCancelLeaveRequest() throws InterruptedException {
				logger.info("Starting of verifyCancelLeaveRequest method");

				try {
					        RestAssured.baseURI = "https://devapp.honohr.com/api/graphql";

					        // GraphQL mutation query
					        String query = "mutation CancelLeaveRequest("
					                + "$empCode: String "
					                + "$fromDate: String "
					                + "$toDate: String) {"
					                + " cancelLeaveRequest(empCode: $empCode, fromDate: $fromDate, toDate: $toDate) {"
					                + " success "
					                + " message "
					                + " }"
					                + "}";
					        
					        JavascriptExecutor js = (JavascriptExecutor) driver;
						       // js.executeScript("window.localStorage.clear();");
						        String token = (String) js.executeScript("return window.localStorage.getItem('token');");

						        System.out.println("@@@@@@@@@@@@@@@@@@@@Token:@@@@@@@@@@@@@@@@@@@@@@@ " + token);

						        // Prepare variables dynamically
						        Map<String, Object> variables = new HashMap<>();
						        variables.put("empCode", testDataProp.getProperty(EMPLOYEE_CODE_TEXT));
						        variables.put("fromDate", testDataProp.getProperty(CANCEL_LEAVE_FROM_DATE_TEXT));
						        variables.put("toDate", testDataProp.getProperty(CANCEL_LEAVE_TO_DATE_TEXT));

						        // Construct the JSON request
						        JSONObject jsonBody = new JSONObject();
						        jsonBody.put("query", query);
						        jsonBody.put("variables", variables);

					        // Send POST request
					        Response response = RestAssured.given().contentType(ContentType.JSON).header("authorization", token).body(jsonBody).log().all().when().post("https://devapp.honohr.com/api/graphql");

					        // Output full response
					        response.prettyPrint();
					        //System.out.println("REQUEST PARAMETERS" + jsonBody);
					        int status = response.getStatusCode();
					        System.out.println("$$$$$$$STATUS CODE $$$$$$$" + status);
							System.out.println("***************RESPONSE BODY**********" + response.body().asString());
				
				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyCancelLeaveRequest : " + e.getMessage());
					logger.error("Error occured while verifyCancelLeaveRequest " + e);
				}

				logger.info("Starting of verifyCancelLeaveRequest method");
			}
			
			@Test(priority = 14, description = "Verify the leave request status by selecting the Cancel")
			@Description("Test Case #14, Verify the leave request status by selecting the Cancel")
			@Severity(SeverityLevel.CRITICAL)
			@Story("Test Case #14, Verify the leave request status by selecting the Cancel")
			public void verifyCancelledLeaveRequestTransactionStatus() {
				logger.info("Starting of verifyCancelledLeaveRequestTransactionStatus method");

				try {
					createLeaveRequestPage.refresh();
					Thread.sleep(5000);

					Assert.assertEquals(createLeaveRequestPage.getLevelOneManagerApprovalLeaveRequestStatus(),
							expectedAssertionsProp.getProperty(lEAVE_APPROVAL_STATUS_CANCELLED_TEXT));

				} catch (Exception e) {
					Assert.fail(
							"Exception occured while testing verifyCancelledLeaveRequestTransactionStatus : " + e.getMessage());
					logger.error("Error occured while verifyCancelledLeaveRequestTransactionStatus " + e);
				}

				logger.info("Starting of verifyCancelledLeaveRequestTransactionStatus method");
			}


}
