package zattoo.example.pages;

import java.lang.invoke.MethodHandles;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPanel {
	
	WebDriver driver;
	protected static Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass());

	public DashboardPanel(WebDriver driver) {
		this.driver = driver;
	}

	// Variables section
	// Locator section
	
	By buttonCarrouselNext = By.xpath("(//button[@data-soul='SLIDE_CONTROL_NEXT'])[1]");
	By textSubmenue = By.xpath("//*[@data-context-element-id='b_categories_en_movies_no_recall_no_user_lang']/div[1]/a");
	

	// Method section
	/**
	 * this method make click in the questions and make click in the the button
	 * next.
	 * 
	 */
	public void accessToTheSubmenuMovies() {
		logger.info("Starting to make click in the checkbox of the first page.");
		
		@SuppressWarnings("unused")
		WebElement myDynamicElement = (new WebDriverWait(driver, 50))
				.until(ExpectedConditions.elementToBeClickable(textSubmenue));
		
		logger.info("Starting to make click in the checkbox of the first page.");
		driver.findElement(textSubmenue).click();
		
	}
}
