package zattoo.example.pages;

import java.lang.invoke.MethodHandles;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubsectionMovies {

	WebDriver driver;
	protected static Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass());

	public SubsectionMovies(WebDriver driver) {
		this.driver = driver;
	}

	// Variables section
	// Locator section
	By buttonOptionsFirstMovie = By.xpath("(//section)[1]//button");
	By buttonOptionFirstMovieRecord = By.xpath("//button[@data-soul='OVERFLOW_RECORD_EPISODE']");
	By popupMessageTextAddingMovieToRecord = By
			.xpath("//li[@data-soul='SUCCESS_NOTIFICATION']/div/div/p[contains(text(),'added to your recordings')]");
	By popupMessageTextRemovedFromYourRecords = By
			.xpath("//li[@data-soul='INFO_NOTIFICATION']/div/div/p[contains(text(),'removed from your recordings')]");
	By buttonListView = By.xpath("//*[@data-context-editorial-id='b_categories_en_movies_no_recall_no_user_lang']/div[1]//button");
	
	
	// Method section
	/**
	 * this method make click in the questions and make click in the the button
	 * next.
	 * 
	 */
	public void openTheMenuForTheFirstMovie() {
		logger.info("Starting to make click in the checkbox of the first page.");
		@SuppressWarnings("unused")
		WebElement myDynamicElement3 = (new WebDriverWait(driver, 50))
				.until(ExpectedConditions.elementToBeClickable(buttonListView));

		logger.info("Starting to make click in the checkbox of the first page.");
		driver.findElement(buttonListView).click();
		

		@SuppressWarnings("unused")
		WebElement myDynamicElement = (new WebDriverWait(driver, 50))
				.until(ExpectedConditions.elementToBeClickable(buttonOptionsFirstMovie));

		logger.info("Starting to make click in the checkbox of the first page.");
		driver.findElement(buttonOptionsFirstMovie).click();
	}

	/**
	 * this method make click in the questions and make click in the the button
	 * next.
	 * 
	 */
	public String selectTheOptionMenuRecordAndReturnTheTextOfTheMessage() {
		logger.info("Starting to make click in the checkbox of the first page.");

		@SuppressWarnings("unused")
		WebElement myDynamicElement = (new WebDriverWait(driver, 50))
				.until(ExpectedConditions.elementToBeClickable(buttonOptionFirstMovieRecord));
		
		try {
			Thread.sleep(3333);
		} catch (Exception e) {
			// TODO: handle exception
		}

		logger.info("Starting to make click in the checkbox of the first page.");
		driver.findElement(buttonOptionFirstMovieRecord).click();
		
		
		logger.info("button to record pressed.");
		
		try {
			@SuppressWarnings("unused")
			WebElement myDynamicElement22 = (new WebDriverWait(driver, 5))
					.until(ExpectedConditions.visibilityOf(driver.findElement(popupMessageTextAddingMovieToRecord)));

			return driver.findElement(popupMessageTextAddingMovieToRecord).getText();
		} catch (Exception e) {
			
			return null;
		}

		
	}
}
