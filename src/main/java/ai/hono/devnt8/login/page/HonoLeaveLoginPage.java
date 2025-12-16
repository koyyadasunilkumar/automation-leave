package ai.hono.devnt8.login.page;


	import java.util.Iterator;
	import java.util.List;
	import org.apache.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
	import org.openqa.selenium.support.PageFactory;

import ai.hono.devnt8.base.pages.BaseHonoLeavePage;


		public class HonoLeaveLoginPage extends BaseHonoLeavePage {
			
			@FindBy(xpath = "//input[contains(@id,'normal_login_username')]")
			private WebElement txtUserName;

			@FindBy(xpath = "//input[@id='normal_login_password']")
			private WebElement txtPassword;
			
			@FindBy(xpath = "//button[contains(@class,'ant-btn-lg login-form-button')]")
			private WebElement btnLogin;

			@FindBy(xpath = "//input[contains(@id,'Usernameid')]")
			private WebElement txtSequelUserName;

			@FindBy(xpath = "//input[@id='password']")
			private WebElement txtSequelPassword;

			@FindBy(xpath = "//button[contains(@class,'login__submit btn new_btn_revamp hover-main_revamp_submit login_centerbtn')]")
			private WebElement btnSequelLogin;

			@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
			private WebElement lblDashboard;
			
			@FindBy(xpath = "//span[@class='ant-menu-title-content' and text()='DashBoard']")
			private WebElement lblDashBoard;
			
			@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
			private WebElement lblAnalyticsDashboard;
			
			@FindBys({ @FindBy(xpath = "//ul[@role='menu']//li//span") })
			private List<WebElement> mnuJobItemList;
			
			@FindBy(xpath = "//div[@id='normal_login_username_help']//div[@class='ant-form-item-explain-error']")
			private WebElement msgPleaseInputYourEmail;
			
			@FindBy(xpath = "//div[@id='normal_login_password_help']//div[@class='ant-form-item-explain-error']")
			private WebElement msgPleaseInputYourPassword;

			@FindBy(xpath = "//a[@class='login-form-forgot']")
			private WebElement btnForgotPassword;
			
			@FindBy(xpath = "//input[@id='normal_login_remember']")
			private WebElement chkRememberMe;
			
			@FindBy(xpath = "//span[@class='anticon anticon-eye ant-input-password-icon']")
			private WebElement imgEyeIconVisibleMode;

			@FindBy(xpath = "//span[@class='anticon anticon-eye-invisible ant-input-password-icon']")
			private WebElement imgEyeIconInVisibleMode;
			
			@FindBy(xpath = "//div[@class='ant-notification-notice-content']//div[@class='ant-notification-notice-description']")
			private WebElement msgLoginErrorToastMessage;
			
			@FindBy(xpath = "//h5[contains(@class,'MuiTypography-root MuiTypography')]")
			private WebElement lblForgotYourPassword;
			
			@FindBy(xpath = "//button[contains(@class,'ant-btn css-1kuana8 ant-btn-primary ant-btn-lg login-form-button')]//span")
			private WebElement btnResetPassword;
			
			@FindBy(xpath = "//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-1i1yl23']//p")
			private WebElement btnBackToLoginPage;
			
			@FindBy(xpath = "//div[@class='Toastify__toast-icon Toastify--animate-icon Toastify__zoom-enter']//following-sibling::div")
			private WebElement msgResetPasswordErrorMessage;

//			@FindBy(xpath = "//span[contains(@class,'ant-avatar ant-avatar-circle ant-avatar-image ant-dropdown-trigger')]")
			
			@FindBy(xpath = "//span[@aria-label='User Profile']")
			private WebElement imgLogoutMenu;
			
			@FindBy(xpath = "//span[@aria-label='User Profile']//button")
			private WebElement btnUserProfile;
			
			@FindBy(xpath = "//input[@id='disable-close-on-select']")
			private WebElement drpRole;
			
			@FindBys({@FindBy(xpath = "//ul[@id='disable-close-on-select-listbox']//li")})
			private List<WebElement> lstRole;
			
			@FindBy(xpath = "//input[@id='disable-close-on-select']")
			private WebElement txtRole;

			@FindBy(xpath = "//span[text()='logout']")
			private WebElement btnUserLogout;
			
			@FindBy(xpath = "//h1[contains(@class,'ant-typography')]")
			private WebElement lblSignin;
			
			@FindBy(xpath = "//span[@class='anticon anticon-eye-invisible ant-input-password-icon']")
			private WebElement btnEyeInvisible;
			
			@FindBy(xpath = "//span[@class='anticon anticon-eye ant-input-password-icon']")
			private WebElement btnEyeVisible;
			
			@FindBy(xpath = "//button[@aria-label='Open']")
			private WebElement btnAdminDropdown;
			
			@FindBys({@FindBy(xpath = "//ul[@id='disable-close-on-select-listbox']//li")})
			private List<WebElement> lstUserRole;
			

			private static final Logger logger = Logger.getLogger(HonoLeaveLoginPage.class.getName());

			public HonoLeaveLoginPage(WebDriver driver) {
				super(driver);
				
				logger.info("Starting of HonoLeaveLoginPage method");

				PageFactory.initElements(driver, this);

				logger.info("Ending of HonoLeaveLoginPage method");
			}
			
			public void setUserName(String strUserName) {
				logger.info("Starting of setUserName method");

				this.txtUserName.sendKeys(strUserName);

				logger.info("Ending of setUserName method");
			}

			public void setPassword(String strPassword) {
				logger.info("Starting of setPassword method");
				
		        this.txtPassword.sendKeys(strPassword);
		        
				logger.info("Ending of setPassword method");
			}
			
			public void clickOnLogInButton() {
				logger.info("Starting of clickOnLogInButton method");

				try {
					explicitWait(btnLogin);
					this.btnLogin.click();
				} catch (Exception e) {
					clickOnWebElement(btnLogin);
				}

				logger.info("Ending of clickOnLogInButton method");
			}
			
			public void setSequelUserName(String strUserName) {
				logger.info("Starting of setSequelUserName method");

				this.txtSequelUserName.sendKeys(strUserName);

				logger.info("Ending of setSequelUserName method");
			}

			public void setSequelPassword(String strPassword) {
				logger.info("Starting of setSequelPassword method");
				
		        this.txtSequelPassword.sendKeys(strPassword);
		        
				logger.info("Ending of setSequelPassword method");
			}
			
			public void clickOnSequelLogInButton() {
				logger.info("Starting of clickOnSequelLogInButton method");

		        this.btnSequelLogin.click();
		        
				logger.info("Ending of clickOnSequelLogInButton method");
			}
			
			public String getDashboardText() throws InterruptedException {
				logger.info("Starting of getDashboardText method");
				Thread.sleep(5000);
				logger.info("Ending of getDashboardText method");
				
				return lblDashBoard.getText();
			}
			
			public String getDashBoardText() throws InterruptedException {
				logger.info("Starting of getDashBoardText method");
				explicitWait(lblDashBoard);
				logger.info("Ending of getDashBoardText method");
				
				return lblDashBoard.getText();
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
			
			public void selectRecruitmentMenu(String strMenuItem) {
				logger.info("Starting of clickOnLogInButton method");

		        for (int i=0;i<=mnuJobItemList.size();i++){
		        	if(mnuJobItemList.get(i).getText().equals(strMenuItem)) {
		        		mnuJobItemList.get(i).click();
		        		break;
		        	}
		        }
				logger.info("Ending of clickOnLogInButton method");
			}
			
			public String getPleaseInputYourEmailText() {
				logger.info("Starting of getPleaseInputYourEmailText method");
				explicitWait(msgPleaseInputYourEmail);
				logger.info("Ending of getPleaseInputYourEmailText method");

				return msgPleaseInputYourEmail.getText();
			}
			
			public String getPleaseInputYourPasswordText() {
				logger.info("Starting of getPleaseInputYourPasswordText method");
				explicitWait(msgPleaseInputYourPassword);
				logger.info("Ending of getPleaseInputYourPasswordText method");

				return msgPleaseInputYourPassword.getText();
			}
			
			public void clickOnForgotPasswordButton() {
				logger.info("Starting of clickOnForgotPasswordButton method");

		        this.btnForgotPassword.click();
		        
				logger.info("Ending of clickOnForgotPasswordButton method");
			}
			
			public void clickOnRememberMeCheckBox() {
				logger.info("Starting of clickOnRememberMeCheckBox method");

		        this.chkRememberMe.click();

				logger.info("Ending of clickOnRememberMeCheckBox method");
			}
			
			public Boolean isPasswordVisibleMode() {
				logger.info("Starting of isPasswordVisibleMode method");
				logger.info("Ending of isPasswordVisibleMode method");
				
		        return imgEyeIconVisibleMode.isDisplayed();
			}
			
			public Boolean isPasswordInVisibleMode() {
				logger.info("Starting of isPasswordInVisibleMode method");
				logger.info("Ending of isPasswordInVisibleMode method");
				
				return imgEyeIconInVisibleMode.isDisplayed();
			}
			
			public String getLoginErrorMessageText() {
				logger.info("Starting of getLoginErrorMessageText method");
				explicitWait(msgLoginErrorToastMessage);
				logger.info("Ending of getLoginErrorMessageText method");

				return msgLoginErrorToastMessage.getText();
			}
			
			public String getForgotYourPasswordText() {
				logger.info("Starting of getForgotYourPasswordText method");
				explicitWait(lblForgotYourPassword);
				logger.info("Ending of getForgotYourPasswordText method");

				return lblForgotYourPassword.getText();
			}
			
			public String getResetYourPasswordText() {
				logger.info("Starting of getResetYourPasswordText method");
				explicitWait(btnResetPassword);
				logger.info("Ending of getResetYourPasswordText method");

				return btnResetPassword.getText();
			}
			
			public String getBackToLoginButtonText() {
				logger.info("Starting of getBackToLoginButtonText method");
				explicitWait(btnBackToLoginPage);
				logger.info("Ending of getBackToLoginButtonText method");

				return btnBackToLoginPage.getText();
			}
			
			public void clickOnResetPasswordButton() {
				logger.info("Starting of clickOnResetPasswordButton method");

		        this.btnResetPassword.click();

				logger.info("Ending of clickOnResetPasswordButton method");
			}
			
			public void clickOnBackToLoginButton() {
				logger.info("Starting of clickOnBackToLoginButton method");

		        this.btnBackToLoginPage.click();

				logger.info("Ending of clickOnBackToLoginButton method");
			}
			
			public String getResetPasswordToastMessage() {
				logger.info("Starting of getResetPasswordToastMessage method");
				explicitWait(msgResetPasswordErrorMessage);
				logger.info("Ending of getResetPasswordToastMessage method");

				return msgResetPasswordErrorMessage.getText();
			}
			
			public void clickOnLogoutButton() {
				logger.info("Starting of clickOnLogoutButton method");

				try {
					explicitWait(imgLogoutMenu);
					imgLogoutMenu.click();
					scrollIntoView(btnUserLogout);
					waitForElementToBeClikable(btnUserLogout);
					btnUserLogout.click();
				} catch (Exception e) {
					waitForElementToBeClikable(imgLogoutMenu);
					clickOnWebElement(imgLogoutMenu);
					waitForElementToBeClikable(btnUserLogout);
					clickOnWebElement(btnUserLogout);
				}

				logger.info("Ending of clickOnLogoutButton method");
			}
			
			public void selectRole(String strRole) {
				logger.info("Starting of selectRole method");

				try {
					
					try {
						waitForElementToBeClikable(btnUserProfile);
						btnUserProfile.click();
					} catch (Exception e) {
						clickOnWebElement(btnUserProfile);
					}
					
					try {
						waitForElementToBeClikable(drpRole);
						drpRole.click();
					} catch (Exception e) {
						clickOnWebElement(drpRole);
					}
					Thread.sleep(3000);
					txtRole.sendKeys(Keys.CONTROL+"A");
					txtRole.sendKeys(strRole);
					Thread.sleep(3000);
					for(int i=0;i<lstRole.size();i++) {
						System.out.println("User Role "+ i +" : "+ lstRole.get(i).getText());
						if(lstRole.get(i).getText().equalsIgnoreCase(strRole)) {
							lstRole.get(i).click();
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
			
			public String getSigninText() {
				logger.info("Starting of getSigninText method");
				explicitWait(lblSignin);
				logger.info("Ending of getSigninText method");

				return lblSignin.getText();
			}
			
			public void clickOnEyeInvisibleButton() {
				logger.info("Starting of clickOnEyeInvisibleButton method");

		        btnEyeInvisible.click();

				logger.info("Ending of clickOnEyeInvisibleButton method");
			}
			
			public void clickOnEyeVisibleButton() {
				logger.info("Starting of clickOnEyeVisibleButton method");

				btnEyeVisible.click();

				logger.info("Ending of clickOnEyeVisibleButton method");
			}
			
			public void selectUserRole(String strRole) throws InterruptedException {

				Thread.sleep(3000);;
				explicitWait(imgLogoutMenu);
				scrollIntoView(imgLogoutMenu);
				imgLogoutMenu.click();
				Thread.sleep(1000);
				btnAdminDropdown.click();
				for (WebElement option : lstUserRole) {
					if(option.getText().equalsIgnoreCase(strRole)) {
						option.click();
						break;
					}
				}
			}
			
		}

