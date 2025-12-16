package ai.hono.devnt8.leave.type.pages;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import ai.hono.devnt8.base.pages.BaseHonoLeavePage;
import ai.hono.devnt8.leavesetup.pages.HonoLeaveSetupPage;

public class LeaveTypePage extends BaseHonoLeavePage {
	public static String random_text = null;

	@FindBys({ @FindBy(xpath = "//span[@class='ant-menu-title-content']") })
	private List<WebElement> mnuHonoDashboard;
	
	@FindBys({@FindBy(xpath = "//ul[@class='ant-menu ant-menu-sub ant-menu-vertical' and contains(@id,'Leave-popup')]//li//span") })
	private List<WebElement> lstLeaveMenuList;
	
	@FindBy(xpath = "//div[@aria-label='User Profile']")
	private WebElement btnUserProfile;
	
	@FindBy(xpath = "//input[@id='disable-close-on-select']")
	private WebElement drpRole;
	
	@FindBys({@FindBy(xpath = "//ul[@id='disable-close-on-select-listbox']//li")})
	private List<WebElement> lstRole;
	
	@FindBy(xpath = "//input[@id='disable-close-on-select']")
	private WebElement txtRole;

	@FindBy(xpath = "//span[contains(@class,'MuiTypography-root MuiTypography-pageHeading')]")
	private WebElement lblLeaveType;
	
	@FindBy(xpath = "//button[@aria-label='Add Leave Type']")
	private WebElement btnAddLeaveType;

	@FindBy(xpath = "//button[@aria-label='Changed History']")
	private WebElement btnChangedHostory;

	@FindBy(xpath = "//button[@aria-label='Export to Excel']")
	private WebElement btnExportToExcel;

	@FindBy(xpath = "//button[@role='switch']")
	private WebElement btnLeaveStatus;

	@FindBy(xpath = "//button[@aria-label='Edit']")
	private WebElement btnEdit;
	
	@FindBy(xpath = "//button[@aria-label='Show/Hide search']")
	private WebElement btnSearch;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement txtSearch;
	
	@FindBy(xpath = "//button[@aria-label='Clear search']")
	private WebElement txtClearSearch;
	
	@FindBy(xpath = "//h6[contains(@class,'MuiTypography-root MuiTypography-h6')]")
	private WebElement lblChangeStatus;

	@FindBy(xpath = "//button[@aria-label='Cancel']")
	private WebElement btnCancel;
	
	@FindBy(xpath = "//button[@aria-label='Deactivate']")
	private WebElement btnDeActivate;
	
	@FindBy(xpath = "//span[contains(@class,'MuiTypography-root MuiTypography')]")
	private WebElement lblLeaveSetup;
	
	@FindBy(xpath = "//div[@id='leave_master_id']")
	private WebElement drpLeaveType;
	
	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li")})
	private List<WebElement> lstLeaveType;
	
	@FindBy(xpath = "//input[@id='LvDesc']")
	private WebElement txtLeaveName;
	
	@FindBy(xpath = "//input[@id='LvDescriptions']")
	private WebElement txtLeaveDescription;
	
	@FindBy(xpath = "//input[@id='short_name']")
	private WebElement txtShortName;
	
	@FindBy(xpath = "//input[@id='lvorder']")
	private WebElement txtLeaveOrderBy;
	
	@FindBy(xpath = "//div[text()='Select Leave Year']")
	private WebElement drpSelectLeaveYear;
	
	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li")})
	private List<WebElement> lstLeaveYear;
	
	@FindBy(xpath = "//div[@aria-label='Of The']")
	private WebElement drpLeaveCreditingOfTheMonth;
	
	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li")})
	private List<WebElement> lstLeaveCreditingOfTheMonth;
	
	@FindBy(xpath = "//div[@aria-label='When']")
	private WebElement drpLeaveCreditingWhen;
	
	@FindBys({@FindBy(xpath = "//ul[@role='listbox']//li")})
	private List<WebElement> lstLeaveCreditingWhen;
	
	@FindBy(xpath = "(//span[text()='GLOBAL APPLICABILITY']//parent::div//following::input)[1]")
	private WebElement chkGlobalApplicability;
	
	@FindBy(xpath = "//button[@aria-label='Create']")
	private WebElement btnCreateLeaveType;
	
	@FindBy(xpath = "//button[@aria-label='Cancel']")
	private WebElement btnCancelLeaveType;
	
	@FindBy(xpath = "//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']//following-sibling::div")
	private WebElement btnLeaveToastMeassage;
	
	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	private WebElement lblAnalyticsDashboard;
	
	@FindBy(xpath = "//ul[@class='ant-menu-item-group-list']//following::li//span[@class='ant-menu-title-content' and text()='Leave Types']")
	private WebElement lstLeaveTypes;

	@FindBy(xpath = "//button[@aria-label='Go to last page']")
	private WebElement btnGoToLastPage;

	@FindBy(xpath = "//div[@aria-label='Rows per page']")
	private WebElement drpRowsPerPage;

	@FindBys({ @FindBy(xpath = "//ul[@role='listbox']//li") })
	private List<WebElement> lstRowsPerPage;
	
	@FindBy(xpath = "//button[@aria-label='Go to next page' and @disabled]")
	private WebElement btnGoToNextPageDisabled;
	
	@FindBy(xpath = "//span[@role='note']//span")
	private WebElement txtLeaveShortName;
	
	@FindBy(xpath = "//button[@aria-label='Update']")
	private WebElement txtUpdateLeaveType;
	
	@FindBy(xpath = "//td[@data-index='0']")
	private WebElement lblLeaveName;


	private static final Logger logger = Logger.getLogger(LeaveTypePage.class.getName());

	public LeaveTypePage(WebDriver driver) {
		super(driver);
		
		logger.info("Starting of LeaveTypePage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of LeaveTypePage method");
	}
	
	public void selectHonoMenuItem(String strMenuItem) throws InterruptedException {
		logger.info("Starting of selectOnBoardingMenuItem method");

		Thread.sleep(3000);
		for (int i = 0; i < lstLeaveMenuList.size(); i++) {
			if (lstLeaveMenuList.get(i).getText().equals(strMenuItem)) {
				lstLeaveMenuList.get(i).click();
				break;
			}
		}

		logger.info("Ending of selectOnBoardingMenuItem method");
	}
	
	public void selectHonoDasboardMenu(String strDashboardMenuItem) throws InterruptedException {
		logger.info("Starting of selectHonoDasboardMenu method");
		
		Thread.sleep(5000);
		scrollDown(100);

        for (int i=0 ;i < mnuHonoDashboard.size(); i++){
        	if(mnuHonoDashboard.get(i).getText().equalsIgnoreCase(strDashboardMenuItem)) {
        		
        		try {
        			mouseHoverActions(mnuHonoDashboard.get(i));
        			//mnuHonoDashboard.get(i).click();
				} catch (Exception e) {
					mouseHoverActions(mnuHonoDashboard.get(i));
					//clickOnWebElement(mnuHonoDashboard.get(i));
				}
        		break;
        	}
        }
        
		logger.info("Ending of selectHonotMenu method");
	}
	
	public void selectRole(String strRole) {
		logger.info("Starting of selectRole method");

		try {
			
			try {
				//driver.navigate().
				//waitForElementToBeClikable(btnUserProfile);
				
				clickOnWebElement(btnUserProfile);
			} catch (Exception e) {
				btnUserProfile.click();
			}
			
			try {
				//waitForElementToBeClikable(drpRole);
				drpRole.click();
			} catch (Exception e) {
				clickOnWebElement(drpRole);
			}
			Thread.sleep(3000);
			//txtRole.sendKeys(Keys.CONTROL+"A",Keys.DELETE);
			//txtRole.sendKeys(strRole);
			txtRole.click();
			Thread.sleep(3000);
			for(int i=0;i<lstRole.size();i++) {
				System.out.println("User Role "+ i +" : "+ lstRole.get(i).getText());
				if(lstRole.get(i).getText().equalsIgnoreCase(strRole)) {
					try {
						lstRole.get(i).click();
					} catch (Exception e) {
						clickOnWebElement(lstRole.get(i));
					}
					
					break;
				}
			}
		} catch (Exception e) {
			
			clickOnWebElement(btnUserProfile);
			clickOnWebElement(drpRole);
			
			for(int i=0;i<lstRole.size();i++) {
				System.out.println("User Role catch "+lstRole.get(i) +" : "+ lstRole.get(i).getText());
				if(lstRole.get(i).getText().equalsIgnoreCase(strRole)) {
					lstRole.get(i).click();
					break;
				}
			}
		}

		logger.info("Ending of selectRole method");
	}
	
	public String getLeaveTypeText() {
		logger.info("Starting of getLeaveTypeText method");
		explicitWait(lblLeaveType);
		logger.info("Ending of get getLeaveTypeText method");
		
		return lblLeaveType.getText();
	}
	
	public void clickOnAddLeaveTypeButton() {
		logger.info("Starting of clickOnAddLeaveTypeButton button");
		
		explicitWait(btnAddLeaveType);
		btnAddLeaveType.click();
		
		logger.info("Ending of clickOnAddLeaveTypeButton button");
	}
	
	public Boolean isAddLeaveTypeButtonDisplayed() {
		logger.info("Starting of isAddLeaveTypeButtonDisplayed button");
		explicitWait(btnAddLeaveType);
		logger.info("Ending of isAddLeaveTypeButtonDisplayed button");
		
		return btnAddLeaveType.isDisplayed();
	}
	
	
	
	public void clickOnChangeHistoryButton() {
		logger.info("Starting of clickOnChangeHistoryButton button");

		explicitWait(btnChangedHostory);
		btnChangedHostory.click();

		logger.info("Ending of clickOnChangeHistoryButton button");
	}
	
	public void clickOnExportToExcelButton() {
		logger.info("Starting of clickOnExportToExcelButton button");

		explicitWait(btnExportToExcel);
		btnExportToExcel.click();

		logger.info("Ending of clickOnExportToExcelButton button");
	}
	
	public void clickOnLeaveStatusButton() {
		logger.info("Starting of clickOnLeaveStatusButton button");

		explicitWait(btnLeaveStatus);
		btnLeaveStatus.click();

		logger.info("Ending of clickOnLeaveStatusButton button");
	}
	
	public void clickOnLeaveEditButton() {
		logger.info("Starting of clickOnLeaveEditButton button");

		explicitWait(btnEdit);
		btnEdit.click();

		logger.info("Ending of clickOnLeaveEditButton button");
	}

	public void clickOnSearchButton() {
		logger.info("Starting of clickOnSearchButton button");

		try {
			explicitWait(btnSearch);
			btnSearch.click();
		} catch (Exception e) {
			clickOnWebElement(btnSearch);
		}

		logger.info("Ending of clickOnSearchButton button");
	}
	
	public void setSearchByShortName(String strShortName) {
		logger.info("Starting of setSearchByShortName button");

		explicitWait(txtSearch);
		txtSearch.sendKeys(strShortName);

		logger.info("Ending of setSearchByShortName button");
	}

	public void clickOnClearSearchButton() {
		logger.info("Starting of clickOnClearSearchButton button");

		explicitWait(txtClearSearch);
		txtClearSearch.click();

		logger.info("Ending of clickOnClearSearchButton button");
	}
	
	public String getChangeStatusText() {
		logger.info("Starting of getChangeStatusText method");
		explicitWait(lblChangeStatus);
		logger.info("Ending of get getChangeStatusText method");
		
		return lblChangeStatus.getText();
	}
	
	public void clickOnCancelButton() {
		logger.info("Starting of clickOnCancelButton button");

		explicitWait(btnCancel);
		btnCancel.click();

		logger.info("Ending of clickOnCancelButton button");
	}

	public void clickOnDeActivateButton() {
		logger.info("Starting of clickOnDeActivateButton button");

		explicitWait(btnDeActivate);
		btnDeActivate.click();

		logger.info("Ending of clickOnDeActivateButton button");
	}
	
	public void clickOnLeaveTypeButton() {
		logger.info("Starting of clickOnLeaveTypeButton button");

		explicitWait(drpLeaveType);
		drpLeaveType.click();

		logger.info("Ending of clickOnLeaveTypeButton button");
	}
	
	public void selectLeaveType(String strLeaveType) throws InterruptedException {
		logger.info("Starting of selectLeaveType method");

        for (int i=0 ;i < lstLeaveType.size(); i++){
        	if(lstLeaveType.get(i).getText().equals(strLeaveType)) {
        		lstLeaveType.get(i).click();
        		break;
        	}
        }

		logger.info("Ending of selectLeaveType method");
	}
	
	public void setLeaveName(String strLeaveName) {
		logger.info("Starting of setLeaveName method");
		
		explicitWait(txtLeaveName);
		txtLeaveName.sendKeys(Keys.CONTROL+"A",Keys.DELETE);
		txtLeaveName.sendKeys(strLeaveName);
		
		logger.info("Ending of setLeaveName method");
	}
	
	public void setLeaveDescription(String strLeaveDescription) {
		logger.info("Starting of setLeaveDescription method");

		explicitWait(txtLeaveDescription);
		txtLeaveDescription.sendKeys(strLeaveDescription);

		logger.info("Ending of setLeaveDescription method");
	}
	
	public String generateRandomString() {

		int length = 3; // Change length to 7
		String characters = "ABCDRFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			sb.append(randomChar);
		}

		random_text = sb.toString();
		return random_text;
	}
	
	public void setLeaveShortName(String strLeaveShortName) {
		logger.info("Starting of setLeaveShortName method");
		
		random_text=generateRandomString();
		random_text = strLeaveShortName + random_text ;
		explicitWait(txtShortName);
		txtShortName.sendKeys(random_text);

		logger.info("Ending of setLeaveShortName method");
	}
	
	public String getLeaveShortName() {
		logger.info("Starting of getLeaveShortName method");
		explicitWait(txtShortName);
		logger.info("Ending of getLeaveShortName method");
		
		return txtShortName.getAttribute("value");
	}
	
	public void setLeaveOrderBy(String strLeaveOrderBy) {
		logger.info("Starting of setLeaveOrderBy method");

		explicitWait(txtLeaveOrderBy);
		txtLeaveOrderBy.sendKeys(strLeaveOrderBy);

		logger.info("Ending of setLeaveOrderBy method");
	}
	
	public void clickOnLeaveYearDropdown() {
		logger.info("Starting of clickOnLeaveYearDropdown button");

		explicitWait(drpSelectLeaveYear);
		drpSelectLeaveYear.click();

		logger.info("Ending of clickOnLeaveYearDropdown button");
	}
	
	public void selectLeaveYear(String strLeaveYear) throws InterruptedException {
		logger.info("Starting of selectLeaveYear method");

        for (int i=0 ;i < lstLeaveYear.size(); i++){
        	if(lstLeaveYear.get(i).getText().equals(strLeaveYear)) {
        		lstLeaveYear.get(i).click();
        		break;
        	}
        }

		logger.info("Ending of selectLeaveYear method");
	}
	
	public void clickOnLeaveCreditingOfTheMonth() {
		logger.info("Starting of clickOndrpLeaveCreditingOfTheMonth button");

		explicitWait(drpLeaveCreditingOfTheMonth);
		drpLeaveCreditingOfTheMonth.click();

		logger.info("Ending of clickOndrpLeaveCreditingOfTheMonth button");
	}
	
	public void selectLeaveCreditingOfTheMonth(String strMonth) throws InterruptedException {
		logger.info("Starting of selectLeaveCreditingOfTheMonth method");

        for (int i=0 ;i < lstLeaveCreditingOfTheMonth.size(); i++){
        	if(lstLeaveCreditingOfTheMonth.get(i).getText().equals(strMonth)) {
        		lstLeaveCreditingOfTheMonth.get(i).click();
        		break;
        	}
        }

		logger.info("Ending of selectLeaveCreditingOfTheMonth method");
	}
	
	public void clickOnLeaveCreditingWhen() {
		logger.info("Starting of clickOndrpLeaveCreditingWhen button");

		explicitWait(drpLeaveCreditingWhen);
		drpLeaveCreditingWhen.click();

		logger.info("Ending of clickOndrpLeaveCreditingWhen button");
	}
	
	public void selectLeaveCreditingWhen(String strMonth) throws InterruptedException {
		logger.info("Starting of selectLeaveCreditingWhen method");

        for (int i=0 ;i < lstLeaveCreditingWhen.size(); i++){
        	if(lstLeaveCreditingWhen.get(i).getText().equals(strMonth)) {
        		lstLeaveCreditingWhen.get(i).click();
        		break;
        	}
        }

		logger.info("Ending of selectLeaveCreditingWhen method");
	}
	
	public void clickOnGlobalApplicabilityCheckbox() throws InterruptedException {
		logger.info("Starting of clickOnGlobalApplicabilityCheckbox button");
		
		Thread.sleep(3000);
		explicitWait(chkGlobalApplicability);
		
		try {
			chkGlobalApplicability.click();
		} catch (Exception e) {
			clickOnWebElement(chkGlobalApplicability);
		}

		logger.info("Ending of clickOnGlobalApplicabilityCheckbox button");
	}

	public void clickOnCreateLeaveTypeButton() {
		logger.info("Starting of clickOnCreateLeaveTypeButton button");

		scrollIntoView(btnCreateLeaveType);
		explicitWait(btnCreateLeaveType);
		
		try {
			btnCreateLeaveType.click();
		} catch (Exception e) {
			clickOnWebElement(btnCreateLeaveType);
		}

		logger.info("Ending of clickOnCreateLeaveTypeButton button");
	}
	
	public void clickOnCancelLeaveTypeButton() {
		logger.info("Starting of clickOnCancelLeaveTypeButton button");

		explicitWait(btnCancelLeaveType);
		btnCancelLeaveType.click();

		logger.info("Ending of clickOnCancelLeaveTypeButton button");
	}

	public String getLeaveToastMessage() {
		logger.info("Staring of getLeaveToastMessage method");
		explicitWait(btnLeaveToastMeassage);
		logger.info("Ending of getLeaveToastMessage method");
		
		return btnLeaveToastMeassage.getText();
	}

	public String getLeaveCreatedSuccessfullyToastMessage() {
		logger.info("Staring of getLeaveCreatedSuccessfullyToastMessage method");
		explicitWait(btnLeaveToastMeassage);
		String leaveSuccess="has been successfully submitted";
		logger.info("Ending of getLeaveCreatedSuccessfullyToastMessage method");
		
		if(btnLeaveToastMeassage.getText().contains(leaveSuccess)) {
			return leaveSuccess;
		}

		return leaveSuccess;
	}
	
	public String getAnalyticsDashboardText() throws InterruptedException {
		logger.info("Starting of getAnalyticsDashboardText method");
		Thread.sleep(5000);
		explicitWait(lblAnalyticsDashboard);
		logger.info("Ending of getAnalyticsDashboardText method");
		
		if(lblAnalyticsDashboard.getText().equals("Analytics Dashboard")) {
		return lblAnalyticsDashboard.getText().replace("Analytics", "").trim();
		}else if(lblAnalyticsDashboard.getText().equals("Talent Acquisition Dashboard")) {
			return lblAnalyticsDashboard.getText().replace("Talent Acquisition", "").trim();
			}else {
			return lblAnalyticsDashboard.getText();
		}
	}
	
	public String getLeaveTypesText() throws InterruptedException {
		logger.info("Starting of getLeaveTypesText method");
		explicitWait(lstLeaveTypes);
		logger.info("Ending of getLeaveTypesText method");

		return lstLeaveTypes.getText();
	}
	
	public String getLeaveSetupText() throws InterruptedException {
		logger.info("Starting of getLeaveSetupText method");
		Thread.sleep(3000);
		explicitWait(lblLeaveSetup);
		logger.info("Ending of getLeaveSetupText method");

		return lblLeaveSetup.getText();
	}
	
	public void clickOnGoToLastPageButton() throws InterruptedException {
		logger.info("Starting of clickOnGoToLastPageButton method");

		try {
			scrollIntoView(btnGoToLastPage);
			explicitWait(btnGoToLastPage);
			btnGoToLastPage.click();
		} catch (Exception e) {
			clickOnWebElement(btnGoToLastPage);
		}

		logger.info("Ending of clickOnGoToLastPageButton method");
	}

	public void clickOnRowsPerPageButton() throws InterruptedException {
		logger.info("Starting of clickOnRowsPerPageButton method");

		try {
			scrollDown(100);
			waitForElementToBeClikable(drpRowsPerPage);
			drpRowsPerPage.click();
		} catch (Exception e) {
			clickOnWebElement(drpRowsPerPage);
		}

		logger.info("Ending of clickOnRowsPerPageButton method");
	}

	public void selectRowsPerPage(String strRowsPerPage) throws InterruptedException {
		logger.info("Starting of selectRowsPerPage method");

		for (int i = 0; i < lstRowsPerPage.size(); i++) {
			if (lstRowsPerPage.get(i).getText().equalsIgnoreCase(strRowsPerPage)) {
				lstRowsPerPage.get(i).click();
				break;
			}
		}

		logger.info("Ending of selectRowsPerPage method");
	}

	public Boolean isGoToNextPageButtonDisabled() {
		logger.info("Starting of isGoToNextPageButtonDisabled method");
		explicitWait(btnGoToNextPageDisabled);
		logger.info("Starting of isGoToNextPageButtonDisabled method");

		return btnGoToNextPageDisabled.isDisplayed();
	}
	
	public String getLeaveShortnameText() throws InterruptedException {
		logger.info("Starting of getLeaveShortnameText method");
		explicitWait(txtLeaveShortName);
		logger.info("Ending of getLeaveShortnameText method");

		return txtLeaveShortName.getText();
	}
	
	public void clickOnUpdateLeaveButton() throws InterruptedException {
		logger.info("Starting of clickOnUpdateLeaveButton method");

		try {
			waitForElementToBeClikable(txtUpdateLeaveType);
			txtUpdateLeaveType.click();
		} catch (Exception e) {
			clickOnWebElement(txtUpdateLeaveType);
		}

		logger.info("Ending of clickOnUpdateLeaveButton method");
	}
	
	public String getLeaveNameText() throws InterruptedException {
		logger.info("Starting of getLeaveNameText method");
		Thread.sleep(3000);;
		explicitWait(lblLeaveName);
		logger.info("Ending of getLeaveNameText method");

		return lblLeaveName.getText();
	}	
}




