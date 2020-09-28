package Yahoo.com.Selenium.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
	
	ChromeDriver driver; 
	
	@BeforeTest
	public void openURL()
	{
		
		String ChromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://login.yahoo.com/");
	}
	
	@Test(priority=1)
	public void Userlogin() throws InterruptedException
	{
		  WebElement username=driver.findElement(By.id("login-username"));
		  Thread.sleep(2000);
		  username.sendKeys("goldguy_91");
		  WebElement Next=driver.findElement(By.id("login-signin")); 
		  Next.click(); 
		  WebDriverWait wait = new WebDriverWait(driver,30);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
		  driver.findElement(By.id("login-passwd")).sendKeys("zama4343197");
		  WebElement login=driver.findElement(By.id("login-signin")); 
		  Thread.sleep(2000);
		  login.click();
		  
	}
	
	@Test(priority=2)
	public void verifyTitle()
	{
	
	String ActualTitle = driver.getTitle();
	String ExpectedTitle = "Yahoo";
	Assert.assertEquals(ActualTitle, ExpectedTitle);
	System.out.println("Assert passed");
	}
	

	@AfterTest
	public void Exit()
	{
	  driver.close();     
	}
	
}
