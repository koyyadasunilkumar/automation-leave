package ai.hono.devnt8.base.test;


	import java.io.FileReader;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Hashtable;
	import java.util.List;
	import java.util.Map;
	import java.util.Properties;

	import org.apache.log4j.Logger;
	import org.apache.poi.util.SystemOutLogger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.PageLoadStrategy;
	import org.openqa.selenium.Proxy;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.edge.EdgeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.firefox.FirefoxOptions;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Wait;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Parameters;

	import com.google.common.base.Function;

import ai.hono.devnt8.login.page.HonoLeaveLoginPage;
import ai.hono.devnt8.util.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;

		@Listeners(TestListener.class)
		public class BaseHonoLeaveTest {
			
			protected static String browserDriverPath = null;
			protected WebDriver driver = null;
			protected String batchCode = null;
			protected String loginURL = null;
			protected String orgCode = null;
			protected String password = null;
			protected String username = null;
			protected String documentUploadLink = null;

			protected WebDriver childWebDriver = null;
			protected static Map<String, String> chromeDriverMap = new HashMap<String, String>();

			private static final Logger logger = Logger.getLogger(BaseHonoLeaveTest.class.getName());

			protected static Properties testDataProp = null;
			protected static Properties expectedAssertionsProp = null;
			protected static String osPath = null;
			protected List<WebDriver> lstDriver = new ArrayList<WebDriver>();

			private HonoLeaveLoginPage loginPage = null;
			private static Map<WEB_DRIVER, WebDriver> webDriverPool = new Hashtable<WEB_DRIVER, WebDriver>();
			public static final String BASE_DIR=System.getProperty("user.dir");

			protected String MobileNumber = null;
			protected String candidateEmail = null;

			protected static String siteURL = null;
			protected static String userName = null;
			protected static String approverPassword = null;
			
			public enum WEB_DRIVER {
				LEAVE_TYPE,CREATE_LEAVE_TYPE,EDIT_LEAVE_TYPE,CREATE_LEAVE_REQUEST,APPROVE_LEAVE_REQUEST,REJECT_LEAVE_REQUEST,RECONSIDER_LEAVE_REQUEST,
				CANCEL_LEAVE_REQUEST,MULTIPLE_LEAVE_APPROVAL,RECONSIDER_LEVEL_TWO,RECONSIDER_LEVEL_ONE,LEVEL_TWO_APPROVER,LEVEL_ONE_APPROVER,
				LEVEL_TWO_RECONSIDER,REJECT_LEVEL_TWO_MANAGER,CANCEL_AFTER_LEAVEL_TWO,MY_TEAM_LEAVE_REQUEST,CREATE_SICK_LEAVE_REQUEST
			}
			
			@BeforeSuite
			public synchronized void initTestData() {

				if (testDataProp == null) {
					osPath = System.getProperty("os.name");
					
					siteURL = System.getenv("hono_site_url");
					userName = System.getenv("hono_approver_username");
					approverPassword = System.getenv("hono_approver_password");

					FileReader testDataReader = null;
					FileReader assertionsReader = null;

					try {
						testDataReader = new FileReader("src/main/resources/testdata.properties");
						assertionsReader = new FileReader("src/main/resources/expectedassertions.properties");

						testDataProp = new Properties();
						testDataProp.load(testDataReader);

						expectedAssertionsProp = new Properties();
						expectedAssertionsProp.load(assertionsReader);

					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							testDataReader.close();
							assertionsReader.close();

						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			}

			protected synchronized void quitDriver(WebDriver driver, WEB_DRIVER webDriver) {
				logger.info("Starting of method quitDriver in BaseRecruitmentTest ");

				try {
					if (driver != null) {
						driver.quit();
						driver = null;
						webDriverPool.remove(webDriver);
						logger.debug(webDriver + " Web driver quit successfully in BaseRecruitmentTest ");
					}
				} catch (Exception ex) {
					logger.error(ex.getMessage());
					driver = null;
				}
				logger.info("Ending of method quitDriver in BaseRecruitmentTest");
			}

			public void fluentWaitForElement(WebDriver childDriver, final String xPath) {

				try {

					// Reference : https://www.guru99.com/implicit-explicit-waits-selenium.html
					Wait<WebDriver> wait = new FluentWait<WebDriver>(childDriver).withTimeout(Duration.ofSeconds(60))
							.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class);

					WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath(xPath));
						}
					});

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			protected synchronized WebDriver getWebDriver(String browser,WEB_DRIVER webDriver) {
				logger.info("Starting of method getWebDriver");
				
				WebDriver driver = webDriverPool.get(webDriver);
				String osPath = System.getProperty("os.name");

				if (osPath.contains("Linux")) {
					System.out.println("=================================================================================== in linux block");
		
					if (browser.equalsIgnoreCase("Firefox")) {
						WebDriverManager.firefoxdriver().setup();
						FirefoxOptions firefoxOptions = new FirefoxOptions();
						firefoxOptions.setHeadless(true);
						// chromeOptions.addArguments("--no-sandbox");
						firefoxOptions.addArguments("allow-file-access-from-files");
						firefoxOptions.addArguments("use-fake-device-for-media-stream");
						firefoxOptions.addArguments("use-fake-ui-for-media-stream");
						driver = new FirefoxDriver(firefoxOptions);
					} else if (browser.equalsIgnoreCase("Chrome")) {
						System.out.println("=================================================================================== in linux chrome block");

						WebDriverManager.chromedriver().setup();
						ChromeOptions chromeOptions = new ChromeOptions();
						
						chromeOptions.addArguments("--remote-allow-origins=*");
						chromeOptions.addArguments("--headless");
						chromeOptions.addArguments("--no-sandbox");
						chromeOptions.addArguments("allow-file-access-from-files");
						chromeOptions.addArguments("use-fake-device-for-media-stream");
						chromeOptions.addArguments("use-fake-ui-for-media-stream");
						chromeOptions.addArguments("--disable-dev-shm-usage");
						chromeOptions.addArguments("--incognito");

						driver = new ChromeDriver(chromeOptions);
					}else if (browser.equalsIgnoreCase("edgeDriver")) {
						System.out.println("Browserrrrrrrrrrrr: " + browser);
						System.out.println("=================================================================================== in linux Edge block");
						//System.setProperty("webdriver.edge.driver", "/var/jenkins_home/.m2/repository/edgedriver/msedgedriver.exe");
						//WebDriverManager.edgedriver().driverVersion("latest").setup();
						WebDriverManager.edgedriver().setup();
						EdgeOptions options=new EdgeOptions();
						options.addArguments("--disable-notifications");
						options.addArguments("--remote-allow-origins=*");
						options.addArguments("--headless");
					    options.addArguments("--disable-gpu");
					    options.addArguments("--no-sandbox");
				        options.addArguments("--disable-dev-shm-usage");
						driver = new EdgeDriver(options);
						System.out.println("Driver instance: " + driver);
						System.out.println("Browser: " + browser);
					}
					
				} else if (osPath.contains("Mac OS X")) {
					browserDriverPath = "/usr/bin/chromedriver";

					if (browserDriverPath.contains("safaridriver")) {
						System.setProperty("webdriver.safari.driver", browserDriverPath);
						ChromeOptions chromeOptions = new ChromeOptions();
						chromeOptions.addArguments("allow-file-access-from-files");
						chromeOptions.addArguments("use-default-device-for-media-stream");
						chromeOptions.addArguments("use-default-ui-for-media-stream");
						chromeOptions.addArguments("--headless=new");
						driver = new ChromeDriver(chromeOptions);

						logger.debug("Safari driver path " + browserDriverPath);
					} else if (browser.equalsIgnoreCase("chrome")) {

						WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
					}

				} else {

					if (browser.equalsIgnoreCase("chrome")) {
						WebDriverManager.chromedriver().setup();
							//System.setProperty("webdriver.chrome.driver", BASE_DIR+"\\src\\test\\resources\\drivers\\chromedriver.exe");
						
						//Map<String, Object> prefs = new HashMap<>();
				     //   prefs.put("credentials_enable_service", false);
				      //  prefs.put("profile.password_manager_enabled", false);
				        
						ChromeOptions chromeOptions = new ChromeOptions();
						
						chromeOptions.addArguments("--remote-allow-origins=*");
						//chromeOptions.addArguments("--headless");
						chromeOptions.addArguments("allow-file-access-from-files");
						chromeOptions.addArguments("use-fake-device-for-media-stream");
						chromeOptions.addArguments("use-fake-ui-for-media-stream");
						
						//chromeOptions.setExperimentalOption("prefs", prefs);

					        // Other recommended flags to suppress automation detection
						 chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
						 chromeOptions.addArguments("--disable-infobars");
						 chromeOptions.addArguments("--disable-notifications");
						 chromeOptions.addArguments("--no-default-browser-check");
						 chromeOptions.addArguments("--disable-save-password-bubble");
						 chromeOptions.addArguments("--disable-features=AutofillServerCommunication");
						 chromeOptions.addArguments("--start-maximized");
					
						chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
						
						
			
						
						//chromeOptions.addArguments("incognito");
						//this.disableImageChrome(chromeOptions);
						driver = new ChromeDriver(chromeOptions);
						
				

					} else if (browser.equalsIgnoreCase("Firefox")) {
						WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
					} else if (browser.equalsIgnoreCase("Chromium")) {
						WebDriverManager.chromiumdriver().setup();
						driver = new EdgeDriver();
					} else if (browser.equalsIgnoreCase("IEDriverServer")) {
						WebDriverManager.iedriver().setup();
						driver = new InternetExplorerDriver();
					} else if (browser.equalsIgnoreCase("edgeDriver")) {
						/*
						 * Proxy proxy = new Proxy(); proxy.setHttpProxy("your_proxy_address:port");
						 * proxy.setSslProxy("your_proxy_address:port");
						 */

						WebDriverManager.edgedriver().driverVersion("latest").setup();
						//System.setProperty("webdriver.edge.driver", BASE_DIR+"\\src\\test\\resources\\driver\\msedgedriver.exe");
						EdgeOptions options=new EdgeOptions();
						options.addArguments("--disable-notifications");
						options.addArguments("--remote-allow-origins=*");
						//options.addArguments("--headless=new"); // Headless for Jenkins
					    options.addArguments("--disable-gpu");
					//	options.setExperimentalOption("useAutomationExtension", false); // Disable automation extension
					//	options.addArguments("--disable-blink-features=AutomationControlled");// Disables WebDriver detection
						driver = new EdgeDriver(options);
					}
				}

				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

				logger.info("********** Driver Successfully Created ********* " + driver.getTitle());

				logger.info("End of method getWebDriver");

				return driver;
			}

			public synchronized void loginToHono(String browser, String siteURL, String emailAddress, String password,
					WebDriver driver) throws InterruptedException {
				logger.info("Starting of loginToHono method");

				this.childWebDriver = driver;
				loginPage = new HonoLeaveLoginPage(driver);
				driver.get(siteURL);
				Thread.sleep(5000);
				this.login(emailAddress, password);

				logger.info("Ending of loginToHono method");
			}
			
			public synchronized void login(String emailAddress, String password) {
				logger.info("Starting of login method");

				this.loginPage.setUserName(emailAddress);
				this.loginPage.setPassword(password);
				this.loginPage.clickOnLogInButton();

				logger.info("Ending of login method");
			}

			public synchronized void goToSite(String siteURL, WebDriver driver) {
				logger.info("starting of method goToSite");

				logger.debug("Login URL is" + siteURL);
				this.childWebDriver = driver;
				driver.get(siteURL);

				logger.info("Ending of method goToSite");
			}

			public WebDriver getChildWebDriver() {
				return this.childWebDriver;
			}

			public WebDriver getDriver() {
				logger.info("Starting of WebDriver method ");
				logger.info("Ending of WebDriver method ");

				return childWebDriver;
			}

			public List<WebDriver> getDriversList() {
				return lstDriver;
			}
			
			public void disableImageChrome(ChromeOptions options) {

				HashMap<String, Object> images = new HashMap<String, Object>();

				images.put("images", 2);

				HashMap<String, Object> prefs = new HashMap<String, Object>();

				prefs.put("profile.default_content_setting_values", images);

				options.setExperimentalOption("prefs", prefs);

			}
			
			
		}
