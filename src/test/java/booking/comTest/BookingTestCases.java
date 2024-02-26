package booking.comTest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import booking.comPages.SearchPage;

public class BookingTestCases {
	
	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void setUp() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
	//LoginPage loginpage = new LoginPage(driver);
	String URL = "https://www.booking.com/";
	driver.get(URL);
	driver.manage().window().maximize();
//	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Thread.sleep(2000);
	} 

	@Test
	public void test1() throws Exception {
		SearchPage sp = new SearchPage(driver);
		sp.search();
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();

	}

}
