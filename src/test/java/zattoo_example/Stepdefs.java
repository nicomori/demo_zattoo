package zattoo_example;

import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
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
	
	@Then("make this happen")
	public void make_this_happen() {
		
		
		System.out.println("1111111111111111111111aaaaaa");
		
		String packageApp = "com.sbc.wambotv.mobiletv.beta";

//		SubsectionMovies subsectionMovies = new SubsectionMovies(driver);
//		
//		logger.info(subsectionMovies.selectTheOptionMenuRecordAndReturnTheTextOfTheMessage());

		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(MobileCapabilityType.DEVICE_NAME, uuid);
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, packageApp);
		// cap.setCapability(MobileCapabilityType.APP_ACTIVITY,
		// "com.wggesucht.android.WG_Gesucht");
		// cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.APP, "nig.apk");

		//
//		cap.setCapability("noReset", true);
		cap.setCapability("deviceName", "25cbb130000d7ece");
		// cap.setCapability("fullReset", true);
		// cap.setCapability("fastReset", true);
		cap.setCapability("appActivity", "com.zattoo.mobile.MobileActivity");

		AndroidDriver driver1 = null;
		
		try {
			 driver1 = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (Exception e) {
			System.out.println("Exception at the moment to generate the driver = " + e);
		}
		
		System.out.println("111111111111111111111bbbbbbb");
		
		try {
			Thread.sleep(5555);
		} catch (Exception e) {
			// TODO: handle exception
		}

//		buttonLogin
//		id
		
		
		driver1.findElementByXPath("//android.widget.TextView").click();
		
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

//		LoginPage

//		editFieldEmail
		driver1.findElementByXPath("//*[contains(@resource-id,'login_email')]").sendKeys("zattoo1");

//		editFieldPass
		driver1.findElementByXPath("//*[contains(@resource-id,'login_password')]").sendKeys("zattoo1234");

//		buttonLogin
		driver1.findElementByXPath("//*[contains(@resource-id,'login_button')]").click();

		
		System.out.println("222222222222222222");
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// WelcomeAfterLoginPage
		//
		// buttonNext
		driver1.findElementByXPath("//*[contains(@resource-id,'okButton')]").click();
		//
		//

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// buttonGotIt
		// id
		driver1.findElementByXPath("//*[contains(@resource-id,'okButton')]").click();

		
		System.out.println("3333333333333333");
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		// BurgerMenuPage
		//
		// optionMenuHighlights
		// xpath
		driver1.findElementByXPath("(//androidx.appcompat.widget.LinearLayoutCompat[1])[1]").click();
		
		
		

		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("44444444444444444444");

		// HighlightsPage
		//
		// titleSports
		driver1.findElementByXPath("(//*[@resource-id='com.sbc.wambotv.mobiletv.beta:id/carrouselHeaderTextView'])[1]")
				.click();
		
		System.out.println("FFFFFFFFFFFFFFFF");
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
//		driver.close();
	}
}
