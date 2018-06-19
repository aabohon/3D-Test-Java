import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class LoginPage {
	
	private WebDriver driver;
	
	LoginPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement LoginEmail()
	{
		return driver.findElement(By.cssSelector("input[data-test='login-email']"));
	}
	
	public WebElement LoginPassword()
	{
		 return driver.findElement(By.cssSelector("input[data-test='login-password']"));
	}
	
	public WebElement LoginError()
	{
		return driver.findElement(By.cssSelector("div[data-test='login-error']"));
	}
	
	public void LoginApp(String userName, String password)
	{		
		LoginEmail().sendKeys(userName);
        LoginPassword().sendKeys(password);
        LoginPassword().sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public String GetDisplayedError()
    {
        return LoginError().getText();
    }

}
