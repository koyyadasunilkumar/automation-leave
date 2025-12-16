package ai.hono.devnt8.create.leave.request.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import ai.hono.devnt8.base.pages.BaseHonoLeavePage;

public class CreateLeaveRequestPage extends BaseHonoLeavePage {
	public static String random_text = null;

	@FindBys({ @FindBy(xpath = "//span[@class='ant-menu-title-content']") })
	private List<WebElement> mnuHonoDashboard;

	@FindBys({@FindBy(xpath = "//ul[@class='ant-menu ant-menu-sub ant-menu-vertical' and contains(@id,'Leave-popup')]//li//span") })
	private List<WebElement> lstLeaveMenuList;

	@FindBy(xpath = "//ul[@class='ant-menu ant-menu-sub ant-menu-vertical' and contains(@id,'Leave-popup')]//li//span[text()='Create Leave Request']")
	private WebElement lnkCreateLeaveRequest;
	
	@FindBy(xpath = "//ul[@class='ant-menu ant-menu-sub ant-menu-vertical' and contains(@id,'Leave-popup')]//li//span[text()='Leave Transactions']")
	private WebElement lnkLeaveTransactions;

	@FindBy(xpath = "//label[text()='Select Leave Type']//parent::div")
	private WebElement drpLeaveType;
	
	@FindBy(xpath = "//ul[@class='ant-menu-item-group-list']//following::li//span[@class='ant-menu-title-content' and text()='Create Leave Request']")
	private WebElement lstCreateLeaveRequest;

	@FindBys({ @FindBy(xpath = "//ul[@role='listbox']//li") })
	private List<WebElement> lstLeaveType;

	@FindBy(xpath = "//label[text()='From Date']//parent::div//div//div//child::button")
	private WebElement btnFromDate;

	@FindBys({@FindBy(xpath = "//button[@role='gridcell']")})
	private List<WebElement> lstDate;

	@FindBy(xpath = "//label[text()='To Date']//parent::div//div//div//child::button")
	private WebElement btnToDate;

	@FindBy(xpath = "//label[text()='From Half']//parent::div//div")
	private WebElement drpFromHalf;

	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li")})
	private List<WebElement> lstFromHalf;

	@FindBy(xpath = "//label[text()='To Half']//parent::div//div")
	private WebElement drpToHalf;

	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li")})
	private List<WebElement> lstToHalf;

	@FindBy(xpath = "//textarea[@name='text']")
	private WebElement txtReason;

	@FindBy(xpath = "//button[@aria-label='Submit']")
	private WebElement btnSubmit;
	
	@FindBy(xpath = "//h5[contains(@class,'MuiTypography-root MuiTypography-h5')]")
	private WebElement lblCreateLeaveRequest;
	
	@FindBy(xpath = "//label[text()='From Half']//parent::div//div")
	private WebElement drpAvailedUsing;

	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li")})
	private List<WebElement> lstAvailedUsing;
	
	@FindBy(xpath = "//tfoot[@class='MuiTableFooter-root css-1mfh5ci']")
	private WebElement btnScroll;
	
	@FindBy(xpath = "//span[contains(@class,'MuiChip-label MuiChip-labelSmall')]")
	private WebElement lblLeaveRequestStatus;
	
	@FindBy(xpath = "//button[@aria-label='Pending for Approval']")
	private WebElement btnPendingForApprovalStatus;
	
	@FindBy(xpath = "//button[@aria-label='Approve']")
	private WebElement btnApprove;
	
	@FindBy(xpath = "//button[@aria-label='Reject']")
	private WebElement btnReject;
	
	@FindBy(xpath = "//button[@aria-label='Reconsider']")
	private WebElement btnReconsider;
	
	@FindBy(xpath = "//div[contains(@class,'ant-layout site-layout no-scrollbars')]//span[contains(@class,'MuiTypography-root MuiTypography-pageHeading')]")
	private WebElement lblApproveLeaveRequest;
	
	@FindBy(xpath = "//button[@aria-label='Cancellation Approval Pending']")
	private WebElement btnCancellationApprovalPending;
	
	@FindBy(xpath = "//div[contains(@class,'MuiChip-root MuiChip-outlined MuiChip-sizeSmall MuiChip-colorPrimary MuiChip')]//span")
	private WebElement lblTransactionStatus;
	
	@FindBy(xpath = "//div[contains(@class,'ant-layout')]//span[text()='Leave Transactions']")
	private WebElement lblTransactions;
	
	@FindBy(xpath = "//button[@aria-label='Approved']")
	private WebElement btnApproved;
	
	@FindBy(xpath = "//button[@aria-label='Cancelled']")
	private WebElement btnCancelled;
	
	@FindBy(xpath = "//button[@aria-label='Rejected']")
	private WebElement btnRejected;
	
	@FindBy(xpath = "//button[@aria-label='Cancel Request']")
	private WebElement btnCancelRequest;
	
	@FindBy(xpath = "//button[@aria-label='Cancellation Approved']")
	private WebElement btnCancellationApproved;
	
	@FindBy(xpath = "//button[@aria-label='Cancellation Rejected']")
	private WebElement btnCancellationRejected;
	
	@FindBy(xpath = "//input[@aria-label='Toggle select all']")
	private WebElement chkSelectAll;
	
	@FindBy(xpath = "//h6[text()='Action']//parent::div//div[@aria-haspopup='listbox']")
	private WebElement drpAction;
	
	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li")})
	private List<WebElement> lstActions;
	
	@FindBy(xpath = "//button[@aria-label='Submit']")
	private WebElement btnActionSubmit;
	
	@FindBy(xpath = "//button[contains(text(),'Clear selection')]")
	private WebElement btnClearSelection;
	
	@FindBy(xpath = "//input[@aria-label='Toggle select row']")
	private WebElement btnSelectRow;
	
	@FindBy(xpath = "//span[contains(@class,'MuiChip-label MuiChip-labelSmall')]")
	private WebElement btnLevelOneManagerApprovalStatus;
	
	@FindBy(xpath = "(//span[contains(@class,'MuiChip-label MuiChip-labelSmall')])[2]")
	private WebElement btnLevelTwoManagerApprovalStatus;
	
	@FindBy(xpath = "//span[@class='ant-upload']//input")
	private WebElement btnUpload;
	
	@FindBy(xpath = "//a[@class='ant-upload-list-item-name']")
	private WebElement lnkAttachmentFile;
	
	@FindBys({@FindBy(xpath = "//tbody[contains(@class,'MuiTableBody-root')]//tr")})
	private List<WebElement> lblTransactionList;
	
	@FindBy(xpath = "//h2[@id='draggable-dialog-title']//h6")
	private WebElement lblConfirm;
	
	@FindBy(xpath = "//button[@aria-label='Proceed']")
	private WebElement btnProceed;
	
	@FindBy(xpath = "//button[@aria-label='Update']")
	private WebElement btnUpdate;
	
	@FindBy(xpath = "//button[@aria-label='Next month']")
	private WebElement btnNextMonth;
	
	@FindBy(xpath = "//*[local-name()='svg' and @data-testid='MenuOpenIcon']")
	private WebElement btnMenuOpenIon;
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement btnClose;
	
	@FindBy(xpath = "//h4[contains(@class,'MuiTypography-root MuiTypography-h4')]")
	private WebElement lblApplyForLeave;
	
	@FindBys({@FindBy(xpath = "//div[@role='radiogroup']//span[contains(@class,'MuiTypography-root MuiTypography-body1 MuiFormControlLabel-label')]")})
	private List<WebElement> rdoLeaveRequestFor;
	
	@FindBy(xpath = "//input[@id='empCode']")
	private WebElement txtEmployeeCode;
	
	@FindBys({@FindBy(xpath = "//ul[@id='empCode-listbox']//li")})
	private List<WebElement> lstEmployees;
	
	@FindBy(xpath = "//span[contains(@class,'MuiChip-label MuiChip-labelSmall')]")
	private WebElement lblNumberOfDaysApplied;
	
	
	@FindBy(xpath = "//label[contains(@class,'MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd')]//following-sibling::span[text()='Planned Leave']")
	private WebElement rdoPlannedLeave;
	
	@FindBy(xpath = "//label[contains(@class,'MuiFormControlLabel-root MuiFormControlLabel-labelPlacementEnd')]//following-sibling::span[text()='Unplanned Leave']")
	private WebElement rdoUnPlannedLeave;


	@FindBy(xpath = "//div[contains(@label,'Reasons')]")
	private WebElement lblSelectPlannedReasons;

	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li") })
	private List<WebElement> lstPlanned;


	@FindBy(xpath = "//div[contains(@label,'Select Leave Reason')]")
	private WebElement lblSelectLeaveReason;
	
	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li") })
	private List<WebElement> lstSelectLeaveReason;
	
	
	
	
	


	private static final Logger logger = Logger.getLogger(CreateLeaveRequestPage.class.getName());

	private static final int String = 0;

	public CreateLeaveRequestPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of CreateLeaveRequestPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of CreateLeaveRequestPage method");
	}
	
	public void selectHonoMenu(String strDashboardMenu) throws InterruptedException {
		logger.info("Starting of selectHonoMenu method");

		Thread.sleep(3000);
		for (int i = 0; i < mnuHonoDashboard.size(); i++) {
			if (mnuHonoDashboard.get(i).getText().equals(strDashboardMenu)) {
				mnuHonoDashboard.get(i).click();
				break;
			}
		}

		logger.info("Ending of selectHonoMenu method");
	}
	
	public void clickOnOkButton() {
		logger.info("Starting of clickOnOkButton method");
		
		driver.switchTo().alert().accept();
		
		logger.info("Ending of clickOnOkButton method");

	}

	public void selectHonoMenuItem(String strDashboardMenuItem) throws InterruptedException {
		logger.info("Starting of selectHonoMenuItem method");
		//scrollDown(100);
        for (int i=0 ;i < lstLeaveMenuList.size(); i++){
        	scrollIntoView(lstLeaveMenuList.get(i));
        	
        	System.out.println("@@@@@@Leave sub menu list@@@@ " +lstLeaveMenuList.get(i));
        	if(lstLeaveMenuList.get(i).getText().contains(strDashboardMenuItem)) {
        		System.out.println("#####Leave sub menu list After matching with expected #######  " +lstLeaveMenuList.get(i));
        		try {
        			lstLeaveMenuList.get(i).click();
				} catch (Exception e) {
					clickOnWebElement(lstLeaveMenuList.get(i));
				}
        		break;
        	}
        }
        
		logger.info("Ending of selectHonoMenuItem method");
	}

	public String getCreateLeaveRequestText() {
		logger.info("Starting of getCreateLeaveRequestText method");
		explicitWait(lblCreateLeaveRequest);
		logger.info("Ending of getCreateLeaveRequestText method");
		
		return lblCreateLeaveRequest.getText();
	}

	public String getLeaveRequestText() throws InterruptedException {
		logger.info("Starting of getLeaveRequestText method");
		explicitWait(lstCreateLeaveRequest);
		logger.info("Ending of getLeaveRequestText method");

		return lstCreateLeaveRequest.getText();
	}
	
	public Boolean isSubmitButtonDisplayed() {
		logger.info("Starting of isSubmitButtonDisplayed button");
		explicitWait(btnSubmit);
		logger.info("Ending of isSubmitButtonDisplayed button");
		
		return btnSubmit.isDisplayed();
	}
	
	public void clickOnLeaveTypeButton() {
		logger.info("Starting of clickOnLeaveTypeButton method");

		try {
			explicitWait(drpLeaveType);
			drpLeaveType.click();
		} catch (Exception e) {
			clickOnWebElement(drpLeaveType);
		}

		logger.info("Starting of clickOnLeaveTypeButton method");
	}
	
	public void selectLeaveType(String strLeaveType) throws InterruptedException {
		logger.info("Starting of selectLeaveType method");

		Thread.sleep(3000);
		for (int i = 0; i < lstLeaveType.size(); i++) {
			System.out.println("############### Expected "+ strLeaveType);
	
			if(lstLeaveType.get(i).getText().contains(strLeaveType)) {
				System.out.println("@@@@@@@@@@@@@@Actual @@@@@@@@@@@@@@@@@@@@ "+lstLeaveType.get(i).getText());
				lstLeaveType.get(i).click();
				break;
			}
		}

		logger.info("Starting of selectLeaveType method");
	}
	
	public void clickOnFromDate() {
		logger.info("Starting of clickOnFromDate method");

		try {
			explicitWait(btnFromDate);
			btnFromDate.click();
		} catch (Exception e) {
			clickOnWebElement(btnFromDate);
		}

		logger.info("Starting of clickOnFromDate method");
	}
	
	public void selectDate(String strDate) {
		logger.info("Starting of selectDate method");

		for (int i = 0; i < lstDate.size(); i++) {
			if(lstDate.get(i).getText().equalsIgnoreCase(strDate)) {
				lstDate.get(i).click();
				break;
			}
		}

		logger.info("Starting of selectDate method");
	}
	
	public void clickOnToDate() {
		logger.info("Starting of clickOnToDate method");

		try {
			Thread.sleep(2000);
			explicitWait(btnToDate);
			btnToDate.click();
		} catch (Exception e) {
			clickOnWebElement(btnToDate);
		}

		logger.info("Starting of clickOnToDate method");
	}
	
	public void clickOnFromHalfDropdown() {
		logger.info("Starting of clickOnFromHalfDropdown method");

		try {
			Thread.sleep(2000);
			explicitWait(drpFromHalf);
			drpFromHalf.click();
		} catch (Exception e) {
			clickOnWebElement(drpFromHalf);
		}

		logger.info("Starting of clickOnFromHalfDropdown method");
	}
	
	public void selectFromHalf(String strFromHalf) {
		logger.info("Starting of selectFromHalf method");

		for (int i = 0; i < lstFromHalf.size(); i++) {
			if(lstFromHalf.get(i).getText().equalsIgnoreCase(strFromHalf)) {
				lstFromHalf.get(i).click();
				break;
			}
		}

		logger.info("Starting of selectFromHalf method");
	}
	
	public void clickOnToHalfDropdown() {
		logger.info("Starting of clickOnToHalfDropdown method");

		try {
			explicitWait(drpToHalf);
			drpToHalf.click();
		} catch (Exception e) {
			clickOnWebElement(drpToHalf);
		}

		logger.info("Starting of clickOnToHalfDropdown method");
	}
	
	public void selectToHalf(String strToHalf) {
		logger.info("Starting of selectToHalf method");

		for (int i = 0; i < lstToHalf.size(); i++) {
			if(lstToHalf.get(i).getText().equalsIgnoreCase(strToHalf)) {
				lstToHalf.get(i).click();
				break;
			}
		}

		logger.info("Starting of selectToHalf method");
	}
	
	public void setLeaveReason(String strReason) {
		logger.info("Starting of setLeaveReason method");

			explicitWait(txtReason);
			txtReason.click();
			scrollIntoView(txtReason);
			txtReason.sendKeys(Keys.CONTROL+"A",Keys.DELETE);
			txtReason.sendKeys(strReason);

		logger.info("Starting of setLeaveReason method");
	}
	
	public void setRemarks(String strRemarks) {
		logger.info("Starting of setRemarks method");

			explicitWait(txtReason);
			txtReason.sendKeys(strRemarks);

		logger.info("Starting of setRemarks method");
	}

	public void clickOnSubmitButton() {
		logger.info("Starting of clickOnSubmitButton method");

		try {
			explicitWait(btnSubmit);
			btnSubmit.click();
		} catch (Exception e) {
			clickOnWebElement(btnSubmit);
		}

		logger.info("Starting of clickOnSubmitButton method");
	}
	
	public void clickOnAvailedUsingDropdown() {
		logger.info("Starting of clickOnAvailedUsingDropdown method");

		try {
			Thread.sleep(3000);
			explicitWait(drpAvailedUsing);
			drpAvailedUsing.click();
		} catch (Exception e) {
			clickOnWebElement(drpAvailedUsing);
		}

		logger.info("Starting of clickOnAvailedUsingDropdown method");
	}
	
	public void selectAvailedUsing(String strAvailedUsing) {
		logger.info("Starting of selectAvailedUsing method");

		for (int i = 0; i < lstAvailedUsing.size(); i++) {
			if(lstAvailedUsing.get(i).getText().equalsIgnoreCase(strAvailedUsing)) {
				lstAvailedUsing.get(i).click();
				break;
			}
		}

		logger.info("Starting of selectAvailedUsing method");
	}

	public void clickOnScroll() {
		logger.info("Starting of clickOnScroll method");
		
		//scrollIntoView(btnPendingForApprovalStatus);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 500;", btnScroll);

		logger.info("Starting of clickOnScroll method");
	}
	
	public String getPendingForApprovalStatus() {
		logger.info("Starting of getPendingForApprovalStatus method");
		explicitWait(lblLeaveRequestStatus);
		logger.info("Ending of getPendingForApprovalStatus method");
		
		return	lblLeaveRequestStatus.getText();
	}
	
	public void clickOnPendingForApprovalButton() {
		logger.info("Starting of clickOnPendingForApprovalButton method");

		try {
			Thread.sleep(3000);
			explicitWait(btnPendingForApprovalStatus);
			btnPendingForApprovalStatus.click();
		} catch (Exception e) {
			clickOnWebElement(btnPendingForApprovalStatus);
		}

		logger.info("Starting of clickOnPendingForApprovalButton method");
	}
	
	public void clickOnApproveButton() {
		logger.info("Starting of clickOnApproveButton method");

		try {
			explicitWait(btnApprove);
			btnApprove.click();
		} catch (Exception e) {
			clickOnWebElement(btnApprove);
		}

		logger.info("Starting of clickOnApproveButton method");
	}
	
	public void clickOnRejectButton() {
		logger.info("Starting of clickOnRejectButton method");

		try {
			explicitWait(btnReject);
			btnReject.click();
		} catch (Exception e) {
			clickOnWebElement(btnReject);
		}

		logger.info("Starting of clickOnRejectButton method");
	}
	
	public void clickOnReconsiderButton() {
		logger.info("Starting of clickOnReconsiderButton method");

		try {
			explicitWait(btnReconsider);
			btnReconsider.click();
		} catch (Exception e) {
			clickOnWebElement(btnReconsider);
		}

		logger.info("Starting of clickOnReconsiderButton method");
	}
	
	public String getApproveLeaveRequestText() throws InterruptedException {
		logger.info("Starting of getApproveLeaveRequestText method");
		Thread.sleep(2000);
		explicitWait(lblApproveLeaveRequest);
		logger.info("Ending of getApproveLeaveRequestText method");
		
		return	lblApproveLeaveRequest.getText();
	}
	
	public void clickOnCancellationApprovalPendingButton() {
		logger.info("Starting of clickOnCancellationApprovalPendingButton method");

		try {
			explicitWait(btnCancellationApprovalPending);
			btnCancellationApprovalPending.click();
		} catch (Exception e) {
			clickOnWebElement(btnCancellationApprovalPending);
		}

		logger.info("Starting of clickOnCancellationApprovalPendingButton method");
	}
	
	public String getLeaveTransactionStatusText() {
		logger.info("Starting of getLeaveTransactionStatusText method");
		explicitWait(lblTransactionStatus);
		logger.info("Ending of getLeaveTransactionStatusText method");
		
		return	lblTransactionStatus.getText();
	}
	
	public void clickOnApprovedButton() {
		logger.info("Starting of clickOnApprovedButton method");

		try {
			explicitWait(btnApproved);
			btnApproved.click();
		} catch (Exception e) {
			clickOnWebElement(btnApproved);
		}

		logger.info("Starting of clickOnApprovedButton method");
	}
	
	public void clickOnCancelledButton() {
		logger.info("Starting of clickOnCancelledButton method");

		try {
			explicitWait(btnCancelled);
			btnCancelled.click();
		} catch (Exception e) {
			clickOnWebElement(btnCancelled);
		}

		logger.info("Starting of clickOnCancelledButton method");
	}
	
	public void clickOnRejectedButton() {
		logger.info("Starting of clickOnRejectedButton method");

		try {
			explicitWait(btnRejected);
			btnRejected.click();
		} catch (Exception e) {
			clickOnWebElement(btnRejected);
		}

		logger.info("Starting of clickOnRejectedButton method");
	}
	
	public void clickOnCancelRequestButton() {
		logger.info("Starting of clickOnCancelRequestButton method");

		try {
			Thread.sleep(3000);
			explicitWait(btnCancelRequest);
			btnCancelRequest.click();
		} catch (Exception e) {
			clickOnWebElement(btnCancelRequest);
		}

		logger.info("Starting of clickOnCancelRequestButton method");
	}

	public void clickOnCancellationApprovedButton() {
		logger.info("Starting of clickOnCancellationApprovedButton method");

		try {
			explicitWait(btnCancellationApproved);
			btnCancellationApproved.click();
		} catch (Exception e) {
			clickOnWebElement(btnCancellationApproved);
		}

		logger.info("Starting of clickOnCancellationApprovedButton method");
	}

	public void clickOnCancellationRejectedButton() {
		logger.info("Starting of clickOnCancellationRejectedButton method");

		try {
			explicitWait(btnCancellationRejected);
			btnCancellationRejected.click();
		} catch (Exception e) {
			clickOnWebElement(btnCancellationRejected);
		}

		logger.info("Starting of clickOnCancellationRejectedButton method");
	}

	public String getLeaveTransactionsText() {
		logger.info("Starting of getLeaveTransactionsText method");
		explicitWait(lblTransactions);
		logger.info("Ending of getLeaveTransactionsText method");
		
		return	lblTransactions.getText();
	}

	public void clickOnSelectAllTransactionsCheckBox() {
		logger.info("Starting of clickOnSelectAllTransactionsCheckBox method");

		try {
			explicitWait(chkSelectAll);
			chkSelectAll.click();
		} catch (Exception e) {
			clickOnWebElement(chkSelectAll);
		}

		logger.info("Starting of clickOnSelectAllTransactionsCheckBox method");
	}
	
	public void selectAction(String strAction) {
		logger.info("Starting of selectAction method");

		for(int i=0;i<lstActions.size();i++){
			if(lstActions.get(i).getText().equalsIgnoreCase(strAction)) {
				lstActions.get(i).click();
				break;
			}
		}
	
		logger.info("Starting of selectAction method");
	}
	
	public void clickOnActionSubmitButton() {
		logger.info("Starting of clickOnActionSubmitButton method");

		try {
			explicitWait(btnActionSubmit);
			btnActionSubmit.click();
		} catch (Exception e) {
			clickOnWebElement(btnActionSubmit);
		}

		logger.info("Starting of clickOnActionSubmitButton method");
	}
	
	public void clickOnClearSelectionButton() {
		logger.info("Starting of clickOnClearSelectionButton method");

		try {
			explicitWait(btnClearSelection);
			btnClearSelection.click();
		} catch (Exception e) {
			clickOnWebElement(btnClearSelection);
		}

		logger.info("Starting of clickOnClearSelectionButton method");
	}
	
	public void selectPendingForApprovalTransactionCheckBox() {
		logger.info("Starting of selectPendingForApprovalTransactionCheckBox method");

		try {
			explicitWait(btnSelectRow);
			btnSelectRow.click();
		} catch (Exception e) {
			clickOnWebElement(btnSelectRow);
		}

		logger.info("Starting of selectPendingForApprovalTransactionCheckBox method");
	}
	
	public boolean isClearSelectionButtonDisplayed() {
		logger.info("Starting of isClearSelectionButtonDisplayed method");
		explicitWait(btnClearSelection);
		logger.info("Starting of isClearSelectionButtonDisplayed method");
		
		return btnClearSelection.isDisplayed();

	}
	
	public String getLevelOneManagerApprovalLeaveRequestStatus() throws InterruptedException {
		logger.info("Starting of getLevelOneManagerApprovalLeaveRequestStatus method");
		Thread.sleep(2000);
		explicitWait(btnLevelOneManagerApprovalStatus);
		scrollIntoView(btnLevelOneManagerApprovalStatus);
		logger.info("Starting of getLevelOneManagerApprovalLeaveRequestStatus method");
		
		return btnLevelOneManagerApprovalStatus.getText();

	}
	
	public String getLevelTwoManagerApprovalLeaveRequestStatus() {
		logger.info("Starting of getLevelTwoManagerApprovalLeaveRequestStatus method");
		explicitWait(btnLevelTwoManagerApprovalStatus);
		logger.info("Starting of getLevelTwoManagerApprovalLeaveRequestStatus method");
		
		return btnLevelTwoManagerApprovalStatus.getText();
	}
	
	public void clickOnUploadDocumentButton(String strUploadDocument) throws InterruptedException {
		logger.info("Starting of clickOnUploadDocumentButton method");
	   
			List<String> list = Arrays.asList(strUploadDocument.toString().split(","));

		for(String fileName : list ) {
			System.out.println("File name..................."+fileName);
			String osPath = System.getProperty("os.name");
			if (osPath.contains("Linux")) {
				btnUpload.sendKeys(TEST_FILE_PATH + "/data/" + fileName);
			} else {

				System.out.println("Image path:::" + TEST_FILE_PATH + File.separator + "data" + File.separator
						+ strUploadDocument);

				btnUpload.sendKeys(TEST_FILE_PATH + File.separator + "data" + File.separator + fileName);
			}
		}
              Thread.sleep(5000);
              logger.info("Ending of clickOnUploadDocumentButton method");
	}
	
	public Boolean isAttachmentFileDisplayed() {
	    logger.info("Starting of isAttachmentFileDisplayed method");
	    explicitWait(lnkAttachmentFile);
	    logger.info("Ending of isAttachmentFileDisplayed meyhod");
	    
	  return lnkAttachmentFile.isDisplayed();
	}

	public String getLeaveTransactionSize() {
	    logger.info("Starting of getLeaveTransactionSize method");

	    explicitWait(lblTransactionList);
	    int size = lblTransactionList.size();
	    
	    logger.info("Leave transaction list size: " + size);
	    
	  return Integer.toString(size);
	}
	
	public String getConfirmText() {
	    logger.info("Starting of getConfirmText method");
	    explicitWait(lblConfirm);
	    logger.info("Ending of getConfirmText meyhod");
	    
	  return lblConfirm.getText();
	}
	
	public void clickOnProceedButton() {
		logger.info("Starting of clickOnProceedButton method");

		try {
			explicitWait(btnProceed);
			btnProceed.click();
		} catch (Exception e) {
			clickOnWebElement(btnProceed);
		}

		logger.info("Starting of clickOnProceedButton method");
	}
	
	public void clickOnUpdateButton() {
		logger.info("Starting of clickOnUpdateButton method");

		try {
			explicitWait(btnUpdate);
			btnUpdate.click();
		} catch (Exception e) {
			clickOnWebElement(btnUpdate);
		}

		logger.info("Starting of clickOnUpdateButton method");
	}
	
	public void clickOnNextMonthButton() {
		logger.info("Starting of clickOnNextMonthButton method");

		try {
			explicitWait(btnNextMonth);
			btnNextMonth.click();
		} catch (Exception e) {
			clickOnWebElement(btnNextMonth);
		}

		logger.info("Starting of clickOnNextMonthButton method");
	}
	
	public void clickOnMenuOpenButton() {
		logger.info("Starting of clickOnMenuOpenButton method");

		try {
			explicitWait(btnMenuOpenIon);
			btnMenuOpenIon.click();
		} catch (Exception e) {
			clickOnWebElement(btnMenuOpenIon);
		}

		logger.info("Starting of clickOnMenuOpenButton method");
	}
	
	public void clickOnCloseButton() {
		logger.info("Starting of clickOnCloseButton method");

		try {
			explicitWait(btnClose);
			btnClose.click();
		} catch (Exception e) {
			clickOnWebElement(btnClose);
		}

		logger.info("Starting of clickOnCloseButton method");
	}
	
	public String getApplyForLeaveText() throws InterruptedException {
	    logger.info("Starting of getApplyForLeaveText method");
	    Thread.sleep(3000);
	    explicitWait(lblApplyForLeave);
	    logger.info("Ending of getApplyForLeaveText meyhod");
	    
	  return lblApplyForLeave.getText();
	}
	
	public void selectLeaveRequestFor(String userType) {
		logger.info("Starting of selectLeaveRequestFor method");

		for(WebElement user : rdoLeaveRequestFor) {
			if(user.getText().equalsIgnoreCase(userType)) {
				user.click();
				break;
			}
		}

		logger.info("Starting of selectLeaveRequestFor method");
	}
	
	public Boolean isEmployeeSearchTextFieldDisplayed() throws InterruptedException {
	    logger.info("Starting of isEmployeeSearchTextFieldDisplayed method");
	    Thread.sleep(3000);
	    explicitWait(lblNumberOfDaysApplied);
	    logger.info("Ending of isEmployeeSearchTextFieldDisplayed meyhod");
	    
	  return lblNumberOfDaysApplied.isDisplayed();
	}
	
	public void setEmployeeName(String employeeName) {
		logger.info("Starting of setEmployeeName method");

		explicitWait(txtEmployeeCode);
		txtEmployeeCode.click();
		txtEmployeeCode.sendKeys(employeeName);

		logger.info("Starting of setEmployeeName method");
	}
		
	public void selectEmployee(String employeeName) {
		logger.info("Starting of selectEmployee method");

		for(WebElement employee : lstEmployees) {
			if(employee.getText().contains(employeeName)) {
				employee.click();
				break;
			}
		}

		logger.info("Starting of selectEmployee method");
	}

	public String getNumberOfAppliedText() throws InterruptedException {
	    logger.info("Starting of getNumberOfAppliedText method");
	    explicitWait(lblNumberOfDaysApplied);
	    logger.info("Ending of getNumberOfAppliedText meyhod");
	    
	  return lblNumberOfDaysApplied.getText();
	}
	
	public void clickOnCreateLeaveRequest() {
		logger.info("Starting of clickOnCreateLeaveRequest method");

		try {
			scrollIntoView(lnkCreateLeaveRequest);
			lnkCreateLeaveRequest.click();
		} catch (Exception e) {
			clickOnWebElement(lnkCreateLeaveRequest);
		}
		

		logger.info("Starting of clickOnCreateLeaveRequest method");
	}
	
	public void clickOnLeaveTransactions() {
		logger.info("Starting of clickOnLeaveTransactions method");

		try {
			scrollIntoView(lnkLeaveTransactions);
			lnkLeaveTransactions.click();
		} catch (Exception e) {
			clickOnWebElement(lnkLeaveTransactions);
		}
		

		logger.info("Starting of clickOnLeaveTransactions method");
	}
	
	public void clickOnPlannedLeave() {
		logger.info("Starting of clickOnPlannedLeave method");

		try {
			scrollIntoView(rdoPlannedLeave);
			rdoPlannedLeave.click();
		} catch (Exception e) {
			clickOnWebElement(rdoPlannedLeave);
		}
		
		logger.info("Starting of clickOnPlannedLeave method");
	}

	public void clickOnUnPlannedLeave() {
		logger.info("Starting of clickOnUnPlannedLeave method");

		try {
			scrollIntoView(rdoUnPlannedLeave);
			rdoUnPlannedLeave.click();
		} catch (Exception e) {
			clickOnWebElement(rdoUnPlannedLeave);
		}
		
		logger.info("Starting of clickOnUnPlannedLeave method");
	}

	public void clickOnSelectPlannedReasonsDropdown() {
		logger.info("Starting of clickOnSelectPlannedReasonsDropdown method");

		try {
			scrollIntoView(lblSelectPlannedReasons);
			lblSelectPlannedReasons.click();
		} catch (Exception e) {
			clickOnWebElement(lblSelectPlannedReasons);
		}
		
		logger.info("Starting of clickOnSelectPlannedReasonsDropdown method");
	}
	
	public void SelectPlannedReasons(String strReasons) {
		logger.info("Starting of SelectPlannedReasons method");

		for(int i=0;i<lstPlanned.size();i++) {
			if(lstPlanned.get(i).getText().equalsIgnoreCase(strReasons)) {
				lstPlanned.get(i).click();
				break;
			}
		}
		
		logger.info("Starting of SelectPlannedReasons method");
	}
	
	public void clickOnSelectLeaveReasonDropdown() {
		logger.info("Starting of clickOnSelectLeaveReasonDropdown method");

		try {
			scrollIntoView(lblSelectLeaveReason);
			lblSelectLeaveReason.click();
		} catch (Exception e) {
			clickOnWebElement(lblSelectLeaveReason);
		}
		
		logger.info("Starting of clickOnSelectLeaveReasonDropdown method");
	}

	public void SelectLeaveReason(String strReasons) {
		logger.info("Starting of SelectLeaveReason method");

		for(int i=0;i<lstSelectLeaveReason.size();i++) {
			if(lstSelectLeaveReason.get(i).getText().equalsIgnoreCase(strReasons)) {
				lstSelectLeaveReason.get(i).click();
				break;
			}
		}

		logger.info("Starting of SelectLeaveReason method");
	}


	
	





}