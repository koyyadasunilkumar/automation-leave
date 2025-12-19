package ai.hono.devnt8.compensatoryoff.leave.pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.hono.leave.base.pages.BaseHonoLeaveAutomationPage;

public class CreateCompensatoryLeaveRequestPage extends BaseHonoLeaveAutomationPage{

	@FindBy(xpath="//div[@class='md-radio col-sm-3']//following::label[@for='3']")
	private WebElement rdoCompensatoryLeave;
	
    @FindBy(xpath="//input[@id='comp_off_avail_max_yes']//following-sibling::label")
	private WebElement rdoYes;
	
	@FindBy(xpath="//label[text()='Maximum days to avail compensatory off balance']")
	private WebElement lblMaximumDays;
	
	@FindBy(xpath="//label[text()='Maximum days to allowed in a month for compensatory off']")
	private WebElement lblMaximuDaysAllowedInAMonth;
	
	@FindBy(xpath="//input[@id='credit_comp_off_auto_no']//following-sibling::label")
	private WebElement rdoNo;
	
	@FindBy(xpath="//label[text()='Maximum days to credit compensatory off balance']")
	private WebElement lblMaximumDaysCredit;
	
	@FindBy(xpath="//input[@id='lapse_by_wd_date']//following-sibling::label")
	private WebElement rdoWorkDoneDate;
	
	@FindBy(xpath="//input[@id='lapse_by_approval_date']//following-sibling::label")
	private WebElement rdoApprovalDate;
	
	@FindBy(xpath="//input[@id='comp_off_earning_extra']//following-sibling::label")
	private WebElement chkWorkingExtraHours;
	
	@FindBy(xpath="//input[@id='allow_variable_day_credit_yes']//following-sibling::label")
	private WebElement rdoAllowVariableDayCreditYes;
	
	@FindBy(xpath="//input[@id='allow_variable_day_credit_no']//following-sibling::label")
	private WebElement rdoAllowVariableDayCreditNo;
	
	@FindBy(xpath="//input[@id='comp_off_max_credit_no']//following-sibling::label")
	private WebElement rdoCompOffMaxCreditNo;
	
	@FindBy(xpath="//input[@id='allow_variable_day_credit_yes']//preceding::label[text()='Allow variable day credit ']")
	private WebElement lblAllowVariableDayCredit;
	
	@FindBy(xpath="//div[@class='col-sm-12 form-group form-md-line-input']//following::label[text()='Min hours required to get full day credit']")
	private WebElement lblminHoursRequiredToGetFullDayCredit;
	
	@FindBy(xpath="//input[@id='allow_half_day_credit_yes']//preceding::label[text()='Allow half day credit']")
	private WebElement lblAllowHalfDayCredit;
	
	@FindBy(xpath="//div[@id='variable_credit_byextra_box']//following::label[text()='Min hours required']")
	private WebElement lblMinHoursRequired;
	
	@FindBy(xpath="//div[@id='variable_credit_byextra_box']//following::label[text()='Credit day(s)']")
	private WebElement lblCreaditDays;
	
	@FindBy(xpath="//input[@id='allow_variable_day_credit_no']//following-sibling::label")
	private WebElement rdoAllowvariabledayCreditNo;
	
	@FindBy(xpath="//div[@class='time_pick']")
	private WebElement btnTimePicker;
	
	@FindBy(xpath="//label[text()='Min hours required to get half day credit']")
	private WebElement lblMinHoursRequiredToGetHalfDayCredit;
	
	@FindBy(xpath="//input[@id='allow_half_day_credit_yes']//following-sibling::label")
	private WebElement rdoAllowHalfdayCreditYes;
	
	@FindBy(xpath="//input[@id='allow_half_day_credit_no']//following-sibling::label")
	private WebElement rdoAllowHalfDayCreditNo;
	
	@FindBy(xpath="//input[@id='encashment_yes']//following-sibling::label")
	private WebElement rdoBalanceCanBeEncashment;
	
	@FindBy(xpath="//label[text()='Minimum allowed at one time']")
	private WebElement lblMinimumAllowedAtOneTime;
	
	@FindBy(xpath="//label[text()='Maximum allowed at one time']")
	private WebElement lblMaximumAllowedAtOneTime;
	
	@FindBy(xpath="//label[text()='Maximum allowed in a Year']")
	private WebElement lblMaximumAllowedInAYear;
	
	@FindBy(xpath="//label[text()='Maximum no of times allowed in year']")
	private WebElement lblMaximumNoOfTimesAllowedInYear;
	
	@FindBy(xpath="//label[text()='Minimum balance to be maintained after encashment']")
	private WebElement lblMinimumBalanceToBeMaintainedAfterEncashment;
	
	@FindBy(xpath="//input[@id='encashment_min_onetime']")
	private WebElement txtMinOneTime;
	
	@FindBy(xpath="//input[@id='encashment_max_onetime']")
	private WebElement txtMaxOneTime;
	
	@FindBy(xpath="//input[@id='encashment_max_in_year']")
	private WebElement txtMaxInYear;
	
	@FindBy(xpath="//input[@id='encashment_max_times_in_year']")
	private WebElement txtMaxTimesInYear;
	
	@FindBy(xpath="//input[@id='encashment_min_maintain']")
	private WebElement txtMinMaintain;
	
//	@FindBy(xpath="(//a[text()='Create Comp Off Request'])[last()]")
//	private WebElement lstCreateCompOffRequest;
	
	@FindBy(xpath="(//a[text()='CompOff Approval-Transactions'])[last()]")
	private WebElement lstCompOffApprovalTransaction;
	
	@FindBy(xpath="//span[contains(@class,'caption-subject ')]")
	private WebElement lblCompOffTransaction;
	
	@FindBy(xpath="//div[@class='portlet card-box cardboxwhitebgcls leavetransactionpgcls']//p[@id='messeage']")
	private WebElement msgValidation;

	@FindBy(xpath="//p[@class='alert alert-success']")
	private WebElement msgYourCompOffAppliedSuccessfully;
	
	@FindBy(xpath="//div[@class='input-group custompyrolldateinputgroupcls']")
	private WebElement dtpWorkDoneDate;
	
	@FindBy(xpath="//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']/following::td")
	private WebElement dtpFuture;

	@FindBy(xpath="//td[contains(@class,'ui-datepicker-today')]")
	private WebElement dtpTodayDate;

	@FindBy(xpath="//label[@class='commonlabelpayrollcls']//label[text()='Reason']//following::textarea")
	private WebElement txtReason;

//	@FindBy(xpath="//input[@class='btn default new_btn_revamp cancel_pp']")
	
	@FindBy(xpath="//button[@id='Cancel']")
	private WebElement btnCancel;
	   
	@FindBy(xpath="//input[@class='new_btn_revamp submit_new_hover']")
	private WebElement btnSubmit;

	@FindBy(xpath="//button[@id='submit']")
	private WebElement btnCompensatorySubmit;

	@FindBy(xpath="//p[@class='alert alert-danger text-center ']")
	private WebElement msgSelectTransactions;

	@FindBy(xpath="//span[@class='help-block help-block-error']")
	private WebElement msgRemarksField;
	
	@FindBy(xpath="//p[text()='The Action field is required.']")
	private WebElement msgActionField;
		
	@FindBy(xpath="//input[@class='form-control hasDatepicker']")
	private WebElement dtpToDate;
	
	@FindBy(xpath="//td[@class='ui-datepicker-today']//preceding::td")
	private WebElement dtpPastDate;
	
	@FindBy(xpath="//input[@id='search']")
	private WebElement txtSearch;
	
	@FindBy(xpath="//textarea[@id='remarks']")
	private WebElement txtRemarks;
	
	@FindBy(xpath="//option[contains(text(),'compensatory leave type')]")
	private WebElement lstCompensatoryLeaveType;
	
	@FindBy(xpath = "//select[@id='leaveType']")
	private WebElement drpLeaveType;
	
	@FindBy(xpath = "//input[@id='comp_off_max_credit_yes']//following-sibling::label")
	private WebElement rdoCompOffMaxCreditYes;
	
	@FindBy(xpath = "//td[contains(@class,'ui-datepicker-today')]//following::td[contains(@class,'unselectable ui-state-disabled ')]")
	private WebElement dtpDisableStateFutureDate;

	@FindBy(xpath = "//span[@class='appMan blue-bg']//span[text()='Pending for Approval']")
	private WebElement lblPendingForApproval;
	
	@FindBy(xpath = "//span[@class='appMan blue-bg']//span[text()='Rejected']")
	private WebElement lblRejected;
	
//New Webelements	
	
	@FindBy(xpath = "//label[text()='Work Done Date']")
	private WebElement drpWorkDoneDate;
	
	@FindBy(xpath = "//button[@aria-label='Choose date']")
	private WebElement btnWorkDoneDate;
	
	@FindBys({@FindBy(xpath = "//button[@role='gridcell']")})
	private List<WebElement> lstWorkDoneDate;
	
	@FindBy(xpath = "//label[text()='Reason']//parent::div//textarea[@name='text']")
	private WebElement txtCompOffReason;
	
	@FindBy(xpath = "//span[text()='Create']")
	private WebElement btnCreate;
	
	@FindBy(xpath = "//div[@class='Toastify__toast-body']//div//following-sibling::div")
	private WebElement btnCompOffToast;
	
	@FindBy(xpath = "//ul[@class='ant-menu-item-group-list']//following::li//span[@class='ant-menu-title-content' and text()='Create Comp Off Request']")
	private WebElement lstCreateCompOffRequest;
	
	@FindBy(xpath = "//span[text()='Compensatory Off Request']")
	private WebElement lblCompensatoryOffRequest;
	
	

	
   private static final Logger logger = Logger.getLogger(CreateCompensatoryLeaveRequestPage.class.getName());
	
	public CreateCompensatoryLeaveRequestPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of CreateCompensatoryLeaveRequest method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of CreateCompensatoryLeaveRequest method");
	}

	public void uploadEmployeeAttendance(String excelNamePath,String attendanceDate,String cardNumber,String employeeCode,
			String inPunchDateTime,String outPunchDateTime,String lateComing) {

        String csvFile = super.getTestFilePath() + excelNamePath;

        try (FileWriter writer = new FileWriter(csvFile)) {
            // Write header
        	writer.append("Date(dd-mmm-yy),Card No,Emp Code,In Punch(dd-mmm-yyyy hh:mm:ss),Out Punch(dd-mmm-yyyy hh:mm:ss),Latecoming\n");
        	//write data
        	writer.append(attendanceDate + "," + cardNumber + "," + employeeCode + "," + inPunchDateTime + "," + outPunchDateTime + "," + lateComing + "\n");
            // Add more data as needed
            System.out.println("CSV file has been created successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
		
	@SuppressWarnings("null")
	public void readExcelData(String excelNamePath,String sheetName, int rowNumber, int columnNumber,String data)
			throws IOException {

		String cellData;

		File file = new File(super.getTestFilePath()+excelNamePath);

		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		//XSSFSheet sheet = wb.getSheetAt(sheetNumber);
		XSSFSheet sheet=wb.getSheet(sheetName);

		XSSFRow row = sheet.getRow(rowNumber);

		XSSFCell cell = row.getCell(columnNumber);
		
		if(cell==null) {
			
			row.createCell(columnNumber);
			
			cell.setCellValue(data);
		
		}else {
			
			cell.setCellValue(data);
		}

		cellData = cell.getStringCellValue();
		
		System.out.println("@@@@@@@@@@@@New Cell value Inserted in to excell@@@@@@@@@@@@ " + cellData );
		wb.close();
	}
	
	public boolean isDisabledFutureDateDisplayed() {
		logger.info("Starting of isDisabledFutureDateDisplayed Method");
		logger.info("Ending of isDisabledFutureDateDisplayed Method");
		
		return dtpDisableStateFutureDate.isDisplayed();
	}

	public void clickOnCompensatoryLeaveRadioButton() throws InterruptedException {
		logger.info("Starting of clickOnCompensatoryLeaveRadioButton method");
		
		try {
			explicitWait(rdoCompensatoryLeave);
			rdoCompensatoryLeave.click();
		} catch (Exception e) {
			clickOnWebElement(rdoCompensatoryLeave);
		}
		
		logger.info("Ending of clickOnCompensatoryLeaveRadioButton method");
	}
	
	public void clickOncompOffAvailableMaximumYesRadioButton() {
		logger.info("Starting of clickOncompOffAvailableMaximumYesRadioButton Method");
		
		this.rdoYes.click();
		
		logger.info("Ending of clickOncompOffAvailableMaximumYesRadioButton Method");
	}
	
	public void clickOncompOffAvailableMaximumNoRadioButton() {
		logger.info("Starting of clickOncompOffAvailableMaximumNoRadioButton Method");
		
		this.rdoNo.click();
		
		logger.info("Ending of clickOncompOffAvailableMaximumNoRadioButton Method");
	}
	
	public String getmaximumDayslabelText() {
		logger.info("Starting Of getmaximumDayslabelText Method");
		logger.info("Ending Of getmaximumDayslabelText Metod");
		
		return lblMaximumDays.getText();
	
	}
	
	public boolean isMaximumDaysLabelTextDisplayed() {
		logger.info("Starting of isMaximumDaysLabelTextDisplayed Method");
		logger.info("Ending of isMaximumDaysLabelTextDisplayed Method");
		
		return lblMaximumDays.isDisplayed();
	
	}
	
	public String getmaximumDaysAlloedInAMonthlabelText() {
		logger.info("Starting Of getmaximumDaysAlloedInAMonthlabelText Method");
		logger.info("Ending Of getmaximumDaysAlloedInAMonthlabelText Metod");
		
		return lblMaximuDaysAllowedInAMonth.getText();
	
	}
	
	public boolean isMaximumDaysAllowedInAMonthText() {
		logger.info("Starting Of isMaximumDaysAllowedInAMonthText Method");
		logger.info("Ending Of isMaximumDaysAllowedInAMonthText Method");
		
		return lblMaximuDaysAllowedInAMonth.isDisplayed();
			
	}
	
	public void clickOnCompOffMaxCreditNoRadioButton() {
		logger.info("Starting Of clickOnCompOffMaxCreditNoRadioButton Method");

		try {
			rdoCompOffMaxCreditNo.click();
		} catch (Exception e) {
			clickOnWebElement(rdoCompOffMaxCreditNo);
		}

		logger.info("Ending Of clickOnCompOffMaxCreditNoRadioButton Method");
	}
	
	public void clickOnMaximumPeriodToCreditCompOffBalanceYesRadioButton() {
		logger.info("Starting Of clickOnCompOffMaxCreditYesRadioButton Method");

		try {
			rdoCompOffMaxCreditYes.click();
		} catch (Exception e) {
			clickOnWebElement(rdoCompOffMaxCreditYes);
		}

		logger.info("Ending Of clickOnCompOffMaxCreditYesRadioButton Method");
	}
	
	public String getMaximumDaysCreditCompensatoryOffBalance() {
		logger.info("Starting Of getMaximumdaysCreditCompensatoryOffBalance Method");
		logger.info("Ending Of getMaximumdaysCreditCompensatoryOffBalance Method");
		
		return lblMaximumDaysCredit.getText();
		
	}
	
	public boolean isMaximumdaysCreditCompensatoryOffBalancedisplayed() {
		logger.info("Starting Of isMaximumdaysCreditCompensatoryOffBalancedisplayed Method");
		logger.info("Ending Of isMaximumdaysCreditCompensatoryOffBalancedisplayed Method");
		
		return lblMaximumDaysCredit.isDisplayed();
			
	}
	
	public String getWorkDoneDateRadioButton() {
		logger.info("Starting Of getWorkDoneDateRadioButton Method");
		logger.info("Ending Of getWorkDoneDateRadioButton Method");
		
		return rdoWorkDoneDate.getText();
			
	}
	
	public boolean isWorkDoneDateRadioButtonDisplayed() {
		logger.info("Starting Of isWorkDoneDateRadioButtonDisplayed Method");
		logger.info("Ending Of isWorkDoneDateRadioButtonDisplayed Method");
		
		return rdoWorkDoneDate.isDisplayed();
			
	}
	
	public String getApprovalDateRadioButton() {
		logger.info("Starting Of getApprovalDateRadioButton Method");
		logger.info("Ending Of getApprovalDateRadioButton Method");
		
		return rdoApprovalDate.getText();
			
	}
	
	public boolean isApprovalDateRadioButtonDisplayed() {
		logger.info("Starting Of isApprovalDateRadioButtonDisplayed Method");
		logger.info("Ending Of isApprovalDateRadioButtonDisplayed Method");
		
		return rdoApprovalDate.isDisplayed();
			
	}
	
	public void clickOnWorkingExtraHoursOnWorkingDayCheckBox() {
		logger.info("Starting Of clickOnWorkingExtraHoursOnWorkingDayCheckBox Method");
		
		this.chkWorkingExtraHours.click();
		
		logger.info("Ending Of clickOnWorkingExtraHoursOnWorkingDayCheckBox Method");
	}
	
	public String getAllowVariableDayCredit() {
		logger.info("Starting Of getAllowVariableDayCredit Method");
		logger.info("Ending Of getAllowVariableDayCredit Method");
		
		return lblAllowVariableDayCredit.getText();
	}
	
	public String getMinHoursRequiredToGetFullDayCreditLabelText() {
		logger.info("Starting Of getMinHoursRequiredToGetFullDayCreditLabelText Method");
		logger.info("Ending Of getMinHoursRequiredToGetFullDayCreditLabelText Method");
		
		return lblminHoursRequiredToGetFullDayCredit.getText();
				
	}
	
	public String getAllowHalfDayCreditLabelText() {
		logger.info("Starting Of getAllowHalfDayCreditLabelText Method");
		logger.info("Ending Of getAllowHalfDayCreditLabelText Method");
		
		return lblAllowHalfDayCredit.getText();
			
	}
	
	public void clickOnAllowVariableDayCreditYesRadioButton() {
		logger.info("Starting Of clickOnAllowVariableDayCreditRadioButton Method");
		
		try {
			this.rdoAllowVariableDayCreditYes.click();
		} catch (Exception e) {
			clickOnWebElement(rdoAllowVariableDayCreditYes);
		}
		
		logger.info("Ending Of clickOnAllowVariableDayCreditRadioButton Method");
	}
	
	public void clickOnAllowVariableDayCreditNoRadioButton() {
		logger.info("Starting Of clickOnAllowVariableDayCreditNoRadioButton Method");
		
		this.rdoAllowVariableDayCreditNo.click();
		
		logger.info("Ending Of clickOnAllowVariableDayCreditNoRadioButton Method");
	}
	
	public String getMinHoursRequiredLabelText() {
		logger.info("Starting Of getMinHoursRequiredLabelText Method");
		logger.info("Ending Of getMinHoursRequiredLabelText Method");
		
		return lblMinHoursRequired.getText();
			
	}
	
	public boolean isMinHoursRequiredLabelTextDisplayed() {
		logger.info("Starting Of isMinHoursRequiredLabelTextDisplayed Method");
		logger.info("Ending Of isMinHoursRequiredLabelTextDisplayed Method");
		
		return lblMinHoursRequired.isDisplayed();
		
	}
	
	public String getCreditsDayLabelText() {
		logger.info("Starting Of getCreditsDayLabelText Method");
		logger.info("Ending Of getCreditsDayLabelText Method");
		
		return lblCreaditDays.getText();
			
	}
	
	public boolean isCreditDaysLabelTextDisplayed() {
		logger.info("Starting Of isCreditDaysLabelTextDisplayed Method");
		logger.info("Ending Of isCreditDaysLabelTextDisplayed Method");
		
		return lblCreaditDays.isDisplayed();
		
	}
	public void clickOnAllowvariabledayCreditNoRadioButton() {
		logger.info("Starting Of clickOnAllowvariabledayCreditNoRadioButton Method");
		
		this.rdoAllowVariableDayCreditNo.click();
		
		logger.info("Ending Of clickOnAllowvariabledayCreditNoRadioButton Method");
	}
	
	public boolean isTimePickerButtonDisplayed() {
		logger.info("Starting Of isTimePickerButtonDisplayed Method");
		logger.info("Ending Of isTimePickerButtonDisplayed Method");
		
		return btnTimePicker.isDisplayed();
	}
	
	public String getMinHoursRequiredToGetHalfDayCreditLabelText() {
		logger.info("Starting Of getMinHoursRequiredToGetHalfDayCreditLabelText Method");
		logger.info("Ending Of getMinHoursRequiredToGetHalfDayCreditLabelText Method");
		
		return lblMinHoursRequiredToGetHalfDayCredit.getText();
		
	}
	
	public boolean isMinimumHoursRequiredHalfDayCreditLabelTextDisplayed() {
		logger.info("Starting Of isMinHoursRequiredhalfDaycreditlabeltextDisplayed Method");
		logger.info("Ending Of isMinHoursRequiredhalfDaycreditlabeltextDisplayed Method");
		
		return lblMinHoursRequiredToGetHalfDayCredit.isDisplayed();
	}
	
	public void clickOnAllowHalfdayCreditYesOptionRadioButton() {
		logger.info("Starting Of clickOnAllowHalfdayCreditYesOptionradioButton Method");
		
		this.rdoAllowHalfdayCreditYes.click();
		
		logger.info("Ending Of clickOnAllowHalfdayCreditYesOptionradioButton Method");
	}
	
	public void clickOnAllowHalfDayCreditNoOption() {
		logger.info("Starting Of clickOnAllowHalfDayCreditNoOption Method");
		
		try {
			scrollIntoView(rdoAllowHalfDayCreditNo);
			rdoAllowHalfDayCreditNo.click();
		} catch (Exception e) {
			clickOnWebElement(rdoAllowHalfDayCreditNo);
		}
		
		logger.info("Ending Of clickOnAllowHalfDayCreditNoOption Method");
	}
	
	public void clickOnBalanceCanBeEncashmentRadioButton() {
		logger.info("Starting Of clickOnBalanceCanBeEncashmentRadioButton Method");
		
		this.rdoBalanceCanBeEncashment.click();
		
		logger.info("Ending Of clickOnBalanceCanBeEncashmentRadioButton Method");
	}
		
	public void clickOnCreateCompOffRequest() throws InterruptedException {
		logger.info("Starting of clickOnCreateCompOffRequest method");
        
        this.scrollIntoView(lstCreateCompOffRequest);
        this.lstCreateCompOffRequest.click();
        
		logger.info("Ending of clickOnCreateCompOffRequest method");
	}
	
	public String getCompOffLeaveRequestText() throws InterruptedException {
		logger.info("Starting of getCompOffLeaveRequestText method");
		explicitWait(lstCreateCompOffRequest);
		logger.info("Ending of getCompOffLeaveRequestText method");

		return lstCreateCompOffRequest.getText();
	}
	
	public void clickOnCompOffApprovalTransaction() throws InterruptedException {
		logger.info("Starting of clickOnCompOffApprovalTransaction method");
        
        this.scrollIntoView(lstCompOffApprovalTransaction);
        this.lstCompOffApprovalTransaction.click();
        
		logger.info("Ending of clickOnCompOffApprovalTransaction method");
	}
	
	public String getCompensatoryOffRequestLabelText() {
		logger.info("Starting Of getCompensatoryOffRequestLabelText Method");
		logger.info("Ending Of getCompensatoryOffRequestLabelText Method");
		
		return lblCompensatoryOffRequest.getText();
	}
	
	public String getCompOffTransactionsText() {
		logger.info("Starting Of getCompOffTransactionsText Method");
		logger.info("Ending Of getCompOffTransactionsText Method");
		
		return lblCompOffTransaction.getText();
	}
	
	public String getValidationMessage() {
		logger.info("Starting Of getValidationMessage Method");
		explicitWait(msgValidation);
		logger.info("Ending Of getValidationMessage Method");
		
		return msgValidation.getText();
	}
	
	public String getYourCompOffAppliedSuccessfullyMessage() {
		logger.info("Starting Of getYourCompOffAppliedSuccessfullyMessage Method");
		explicitWait(msgYourCompOffAppliedSuccessfully);
		logger.info("Ending Of getYourCompOffAppliedSuccessfullyMessage Method");

		return msgYourCompOffAppliedSuccessfully.getText();
	}

	public void clickOnWorkDoneDateDatePicker() throws InterruptedException {
		logger.info("Starting of clickOnWorkDoneDateDatePicker method");
        	
        	 try {
	        	 waitForElementToBeClikable(dtpWorkDoneDate);
	        	 this.dtpWorkDoneDate.click();

			} catch (Exception e) {
				clickOnWebElement(dtpWorkDoneDate);
			}
        
		logger.info("Ending of clickOnWorkDoneDateDatePicker method");
	}

	public void clickOnFutureDate() throws InterruptedException {
		logger.info("Starting of clickOnFutureDate method");

        try {
 	       this.dtpFuture.click();
		} catch (Exception e) {
		clickOnWebElement(dtpFuture);
		}
        
		logger.info("Ending of clickOnFutureDate method");
	}

	public void clickOnPresentDate() throws InterruptedException {
		logger.info("Starting of clickOnPresentDate method");

        try {
 	       this.dtpTodayDate.click();
		} catch (Exception e) {
		clickOnWebElement(dtpTodayDate);
		}

		logger.info("Ending of clickOnPresentDate method");
	}

	public void setReason(String strReason){
		logger.info("Starting Of setReason Method");

		try {
			Thread.sleep(10000);
			txtReason.click();
			Thread.sleep(3000);
			explicitWait(txtReason);
			txtReason.sendKeys(strReason);
		} catch (Exception e) {
			clickOnWebElement(txtReason);
			txtReason.sendKeys(strReason);
		}

		logger.info("Ending Of setReason Method");
	}

	public void clickOnCancelButton() {
		logger.info("Starting Of clickOnCancelButton Method");
		
		try {
			scrollIntoView(btnCancel);
			this.btnCancel.click();
		} catch (Exception e) {
			clickOnWebElement(btnCancel);
		}
		
		logger.info("Ending Of clickOnCancelButton Method");
	}

	public void clickOnSubmitButton() {
		logger.info("Starting Of clickOnSubmitButton Method");
		
		try {
			this.btnSubmit.click();
		} catch (Exception e) {
			clickOnWebElement(btnSubmit);
		}

		logger.info("Ending Of clickOnSubmitButton Method");
	}
	
	public String getSelectTrasnactionMessage() {
		logger.info("Starting Of getSelectTrasnactionMessage Method");
		logger.info("Ending Of getSelectTrasnactionMessage Method");
		
		return msgSelectTransactions.getText();
	}
	
	public String getRemarksFieldsRequiredMessage() {
		logger.info("Starting Of getRemarksFieldsRequiredMessage Method");
		logger.info("Ending Of getRemarksFieldsRequiredMessage Method");
		
		return msgRemarksField.getText();
	}
	
	public String getActionFieldsRequiredMessage() {
		logger.info("Starting Of getActionFieldsRequiredMessage Method");
		logger.info("Ending Of getActionFieldsRequiredMessage Method");
		
		return msgActionField.getText();
	}
	
	public void clickOnToDateDatePicker() throws InterruptedException {
		logger.info("Starting of clickOnToDateDatePicker method");
        	 Thread.sleep(3000);
        	 try {
        		 //this.scrollIntoView(dtpFromDate);
	        	 explicitWait(dtpToDate);
	        	 //this.dtpFromDate.click();
	        	 
	        	 Actions ac = new Actions(driver);
					ac.click(dtpToDate).build().perform();

			} catch (Exception e) {
				clickOnWebElement(dtpToDate);
			}
        
		logger.info("Ending of clickOnToDateDatePicker method");
	}
	
	public void clickOnToDate() throws InterruptedException {
		logger.info("Starting of clickOnToDate method");
		Thread.sleep(3000);
		try {
			this.dtpPastDate.click();
		} catch (Exception e) {
			clickOnWebElement(dtpPastDate);
		}

		logger.info("Ending of clickOnToDate method");
	}
	
	public void setSearchEmployee(String strSearchEmployee) {
		logger.info("Starting Of setSearchEmployee Method");
		
		txtSearch.sendKeys(strSearchEmployee);
		
		logger.info("Ending Of setSearchEmployee Method");
	}
	
	public void setRemarks(String strreason){
		logger.info("Starting Of setRemarks Method");
		
		txtRemarks .sendKeys(strreason);
		
		logger.info("Ending Of setRemarks Method");
	}
	
	public void clickOnCompensatoryLeaveType() throws InterruptedException {
		logger.info("Starting of clickOnShortLeaveType method");

		try {
			Thread.sleep(3000);

			Actions ac = new Actions(driver);
			ac.click(drpLeaveType).build().perform();

			this.lstCompensatoryLeaveType.click();

		} catch (Exception e) {
			clickOnWebElement(drpLeaveType);
			clickOnWebElement(lstCompensatoryLeaveType);
		}

		logger.info("Ending of clickOnShortLeaveType method");
	}
	
	public void clickOnCompensatorySubmitButton() throws InterruptedException {
		logger.info("Starting of clickOnCompensatorySubmitButton method");
		
		try {
			this.btnCompensatorySubmit.click();
		} catch (Exception e) {
			clickOnWebElement(btnCompensatorySubmit);
		}

		logger.info("Ending of clickOnCompensatorySubmitButton method");
	}
	
	public String getPendingForApprovalMessage() {
		logger.info("Starting Of getPendingForApprovalMessage Method");
		logger.info("Ending Of getPendingForApprovalMessage Method");
		
		return lblPendingForApproval.getText();
	}
	
	public String getRejectedCompOffStatusMessage() {
		logger.info("Starting Of getRejectedCompOffStatusMessage Method");
		logger.info("Ending Of getRejectedCompOffStatusMessage Method");
		
		return lblRejected.getText();
	}
	
	public void clickOnWorkDoneDateDropdown() throws InterruptedException {
		logger.info("Starting of clickOnWorkDoneDateDropdown method");
		
		try {
			this.drpWorkDoneDate.click();
		} catch (Exception e) {
			clickOnWebElement(drpWorkDoneDate);
		}

		logger.info("Ending of clickOnWorkDoneDateDropdown method");
	}
	
	public void clickOnWorkDoneDateButton() throws InterruptedException {
		logger.info("Starting of clickOnWorkDoneDateButton method");
		
		try {
			this.btnWorkDoneDate.click();
		} catch (Exception e) {
			clickOnWebElement(btnWorkDoneDate);
		}

		logger.info("Ending of clickOnWorkDoneDateButton method");
	}
	
	public void selectWorkDoneDate(String strDate) throws InterruptedException {
		logger.info("Starting of selectWorkDoneDate method");

		for (int i = 0; i < lstWorkDoneDate.size(); i++) {
			if (lstWorkDoneDate.get(i).getText().equalsIgnoreCase(strDate)) {
				lstWorkDoneDate.get(i).click();
				break;
			}
		}
		logger.info("Ending of selectWorkDoneDate method");
	}
	
	public void setCompOffReason(String strReason) throws InterruptedException {
		logger.info("Starting of setCompOffReason method");
		
			explicitWait(txtCompOffReason);
			this.txtCompOffReason.sendKeys(strReason);

		logger.info("Ending of clickOnWorkDoneDateButton method");
	}
	
	public void clickOnCreateCompOffButton() throws InterruptedException {
		logger.info("Starting of clickOnCreateCompOffButton method");
		
		try {
			this.btnCreate.click();
		} catch (Exception e) {
			clickOnWebElement(btnCreate);
		}

		logger.info("Ending of clickOnCreateCompOffButton method");
	}
	
	public String getCompOffToastMessage() {
		logger.info("Starting Of getCompOffToastMessage Method");
		explicitWait(btnCompOffToast);
		logger.info("Ending Of getCompOffToastMessage Method");
		
		return btnCompOffToast.getText();
	}

}


