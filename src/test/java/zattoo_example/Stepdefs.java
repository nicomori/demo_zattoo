package zattoo_example;

import java.lang.invoke.MethodHandles;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import zattoo.example.pages.DashboardPanel;
import zattoo.example.pages.LoginPage;
import zattoo.example.pages.SubsectionMovies;

public class Stepdefs {
	
	WebDriver driver;

	private static final String WIN_DRIVER_PATH = "src/test/resources/drivers/win/chromedriver.exe";
	private static final String MAC_DRIVER_PATH = "src/test/resources/drivers/mac/chromedriver";

	protected static Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass());

	@Given("access to the chrome")
	public void access_to_the_chrome() {
		String oS = System.getProperty("os.name").toLowerCase();

		if (oS.contains("windows")) {
			System.setProperty("webdriver.chrome.driver", WIN_DRIVER_PATH);

		} else if (oS.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", MAC_DRIVER_PATH);
		} else {
			logger.info("This is the OS: " + oS);
			logger.info("OS is not compatible, you need define the path of the chromedriver again");
			System.exit(0);
		}

		ChromeOptions options = new ChromeOptions();
		options.addArguments("test-type");
		options.addArguments("start-maximized");
		options.addArguments("--js-flags=--expose-gc");
		options.addArguments("--enable-precise-memory-info");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-default-apps");
		options.addArguments("test-type=browser");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("window-size=1900,1084");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Point point = new Point(500, 4);
		driver.manage().window().setPosition(point);

		logger.info("driver created properly");
	}

	@Then("access to this url {string}")
	public void access_to_this_url(String url) {
		logger.info("access to the url: " + url);
		driver.get(url);
	}
	
	@Then("make the login to access with this user {string} and this password {string}")
	public void make_the_login_to_access_with_this_user_and_this_password(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.makeLoginIntoTheApp(username, password);
		
		
	}
	
	@Then("make click in the sub menu movies")
	public void make_click_in_the_sub_menu_movies() {
		DashboardPanel dashboardPanel = new DashboardPanel(driver); 
		dashboardPanel.accessToTheSubmenuMovies();
		
		
	}

	@Then("make click in the options of the first movie")
	public void make_click_in_the_options_of_the_first_movie() {
		SubsectionMovies subsectionMovies = new SubsectionMovies(driver);
		subsectionMovies.openTheMenuForTheFirstMovie();
	}

	@Then("make click in the option to record the movie and verify the popup")
	public void make_click_in_the_option_to_record_the_movie_and_verify_the_popup() {
		SubsectionMovies subsectionMovies = new SubsectionMovies(driver);
		
		logger.info(subsectionMovies.selectTheOptionMenuRecordAndReturnTheTextOfTheMessage());
	}
	
	@Before
	public void setupBefore() {
		Properties log4jProp = new Properties();
		log4jProp.setProperty("log4j.rootLogger", "WARN");
		PropertyConfigurator.configure(log4jProp);
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/log4j.properties");
	}

	@After
	public void afterMethod() {
		logger.info("Test completed starting closing the driver.");
		driver.close();
	}
}
