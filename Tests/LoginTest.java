
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

class LoginTest {
	
	WebDriver driver;
	LoginPage page;

	@BeforeMethod
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alain\\eclipse-workspace\\3DRTestJava\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://sitescan-staging.3dr.com/auth");		
		driver.manage().window().maximize();
	}

	@AfterMethod
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void test() {
		page = new LoginPage(driver);
		page.LoginApp("something@test.com", "123Test");
		AssertJUnit.assertEquals("Incorrect username or password", page.GetDisplayedError());
	}

}
