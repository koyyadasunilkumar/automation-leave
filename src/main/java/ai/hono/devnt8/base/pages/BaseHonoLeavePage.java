package ai.hono.devnt8.base.pages;

	import java.time.Duration;
		import java.util.List;
		import java.util.concurrent.TimeUnit;
		import java.io.File;
		import org.apache.log4j.Logger;
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.PageFactory;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.FluentWait;
		import org.openqa.selenium.support.ui.Select;
		import org.openqa.selenium.support.ui.Wait;
		import org.openqa.selenium.support.ui.WebDriverWait;

		import com.google.common.base.Function;

		public class BaseHonoLeavePage {

			protected WebDriver driver = null;

			private static final Logger logger = Logger.getLogger(BaseHonoLeavePage.class.getName());

			public static String TEST_FILE_PATH = null;

			public BaseHonoLeavePage(WebDriver driver) {
				this.driver = driver;

				if (TEST_FILE_PATH == null) {
					TEST_FILE_PATH = getTestFilePath();
					logger.debug("In Constructor " + TEST_FILE_PATH);
				}	
			}	

			public String getTestFilePath() {
				logger.info("Starting of getTestFilePath method");

				String path = "src/main/resources";
				File file = new File(path);

				logger.info("Ending of getTestFilePath method");

				return file.getAbsolutePath();
			}

			protected void selectDropdown(String id, String value) {
				logger.info("Starting of selectDropdown method");

				Select conditions = new Select(driver.findElement(By.id(id)));
				conditions.selectByValue(value);

				logger.info("Ending of selectDropdown method");
			}

			public void clickOnWebElement(WebElement webelement) {
				logger.info("Starting of clickOnWebElement method");

				JavascriptExecutor jsExec = (JavascriptExecutor) driver;
				jsExec.executeScript("arguments[0].click();", webelement);

				logger.info("Ending of clickOnWebElement method");
			}

			public void clickOutside() {
				logger.info("Starting of clickOutside method");

				Actions action = new Actions(driver);
				action.moveByOffset(0, 0).click().build().perform();

				logger.info("Ending of clickOutside method");
			}

			public void scrollDown(int scroll) {
				logger.info("Starting of scrollDown method");

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0, " + scroll + ")");

				logger.info("Ending of scrollDown method");
			}

			public void mouseHoverActions(WebElement webElement) {
				logger.info("Starting of mouseHoverActions method");

				Actions action = new Actions(driver);
				action.moveToElement(webElement).click().build().perform();

				logger.info("Ending of mouseHoverActions method");
			}

			public void refresh() throws InterruptedException {
				logger.info("Starting of refresh method");

				driver.navigate().refresh();
				
				Thread.sleep(5000);
				
				logger.info("Ending of refresh method");
			}
			
			public void implicitWait(Duration duration) {
				logger.info("Starting of implicitWait Method");

				driver.manage().timeouts().implicitlyWait(duration);

				logger.info("Ending of implicitWait Method");
			}

			public void impicitWait() {
				logger.info("Starting of impicitWait method");

				driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

				logger.info("Ending of impicitWait method");
			}

			public void explicitWait(List<WebElement> categoryOptions) {
				logger.info("Starting of explicitWait method");

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfAllElements(categoryOptions));

				logger.info("Ending of explicitWait method");
			}
			
			public void explicitWait(WebElement categoryOptions) {
				logger.info("Starting of explicitWait method");

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
				wait.until(ExpectedConditions.visibilityOf(categoryOptions));

				logger.info("Ending of explicitWait method");
			}
			 
			public void waitForElementToBeClikable(WebElement categoryOptions) {
				logger.info("Starting of explicitWait method");

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(categoryOptions));

				logger.info("Ending of explicitWait method");
			}

			public void pickFromWebElementList(List<WebElement> webElements, String containsText) {
				logger.info("Starting of pickFromWebElemetList method");

				for (WebElement webElement : webElements) {
					if (webElement.getText().contains(containsText)) {
						this.clickOnWebElement(webElement);
						break;
					}
				}
				logger.info("Ending of pickFromWebElemetList method");
			}

			public void slider(WebElement webElement, int xCoordinate) {
				logger.info("Starting of slider method");

				Actions actions = new Actions(driver);
				actions.dragAndDropBy(webElement, xCoordinate, 0).perform();

				logger.info("Ending of slider method");
			}

			public void doubleClick(WebElement webElement) {
				logger.info("Starting of doubleclick method");

				Actions actions = new Actions(driver);
				actions.doubleClick(webElement).perform();

				logger.info("Ending of doubleclick method");
			}

			public void pickFromWebElementList(List<WebElement> webElements, List<WebElement> textWebElements,
					String containsText) {
				logger.info("Starting of pickFromWebElemetList method");

				WebElement webElement = null;
				WebElement textWebElement = null;
				Object[] webElementsArray = webElements.toArray();
				Object[] xPathArray = textWebElements.toArray();

				for (int i = 0; i < webElements.size(); i++) {
					webElement = (WebElement) webElementsArray[i];
					textWebElement = (WebElement) xPathArray[i];
					if (textWebElement.getText().contains(containsText)) {
						this.clickOnWebElement(webElement);
						break;
					}
				}
				logger.info("Ending of pickFromWebElemetList method");
			}

			public void scrollIntoView(WebElement element) {
				logger.info("Starting of scrollIntoView method");

				JavascriptExecutor jsExec = (JavascriptExecutor) driver;
				jsExec.executeScript("arguments[0].scrollIntoView(true);", element);

				logger.info("Ending of scrollIntoView method");
			}
			

			public void fluentWaitForElement(final String xPath) {
				logger.info("Starting of fluentWaitForElement method");
				try {

					// Reference : https://www.guru99.com/implicit-explicit-waits-selenium.html
					Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
							.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class);

					WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
						public WebElement apply(WebDriver driver) {
							return driver.findElement(By.xpath(xPath));
						}
					});

				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				logger.info("Ending of fluentWaitForElement method");
			}
			
			public void waitForPageLoad() {

			    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait.until(new Function<WebDriver, Boolean>() {
			        public Boolean apply(WebDriver driver) {
			            System.out.println("Current Window State       : "
			                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
			            return String
			                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
			                .equals("complete");
			        }
			    });
			}
			
			public void sliders(WebElement webElement, int xCoordinate) {
				
				Actions actions = new Actions(driver);
				//actions.dragAndDropBy(webElement, xCoordinate, 0).perform();
				actions.doubleClick().dragAndDropBy(webElement, xCoordinate,0);
				
			}
		}

