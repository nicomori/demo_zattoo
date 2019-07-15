package zattoo.example.pages;

import java.lang.invoke.MethodHandles;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	protected static Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass());

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Variables section

	// Locator section
	By checkboxQuestion1 = By.xpath("//*[@class='question_option question_option_background_hover ng-scope']/input");
	By buttonNext = By.xpath("(//button)[2]");

	By editfieldEmail = By.xpath("//*[@id='email']");
	By editfieldPassword = By.xpath("//*[@id='password']");
	By buttonLogin = By.xpath("//button[@type='submit']");

	// Method section
	/**
	 * this method make click in the questions and make click in the the button
	 * next.
	 * 
	 */
	public void makeLoginIntoTheApp(String user, String password) {
		logger.info("Starting to make login into the application.");

		@SuppressWarnings("unused")
		WebElement myDynamicElement = (new WebDriverWait(driver, 25))
				.until(ExpectedConditions.presenceOfElementLocated(editfieldEmail));

		driver.findElement(editfieldEmail).sendKeys(user);
		driver.findElement(editfieldPassword).sendKeys(password);
		driver.findElement(buttonLogin).click();
	}
}
