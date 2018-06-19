import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

class LoginTest {
	
	WebDriver driver;
	LoginPage page;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alain\\eclipse-workspace\\3DRTestJava\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://sitescan-staging.3dr.com/auth");		
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void test() {
		page = new LoginPage(driver);
		page.LoginApp("something@test.com", "123Test");
		assertEquals("Incorrect username or password", page.GetDisplayedError());
	}

}
