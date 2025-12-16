package ai.hono.devnt8.util;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseTest {
	    public WebDriver driver;


	    public WebDriver getDriver() {
	        return driver;
	    }

	    @BeforeClass
	    public void classLevelSetup() {
	        Log.info("Tests are starting!");
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    }

	    @AfterClass
	    public void teardown() {
	        Log.info("Tests are ending!");
	        driver.quit();
	    }
	}