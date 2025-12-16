package ai.hono.devnt8.leavesetup.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ai.hono.devnt8.base.pages.BaseHonoLeavePage;

public class HonoLeaveSetupPage extends BaseHonoLeavePage {

	@FindBy(xpath="//input[@id='track_planned_unplanned_yes']//following-sibling::label")
	private WebElement rdoTrackPlannedUnplannedYesOption;

	private static final Logger logger = Logger.getLogger(HonoLeaveSetupPage.class.getName());

	public HonoLeaveSetupPage(WebDriver driver) {
		super(driver);
		
		logger.info("Starting of HonoLeaveSetupPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of HonoLeaveSetupPage method");
	}

}
