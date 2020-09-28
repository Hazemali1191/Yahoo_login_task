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

public class invaliduser {

		
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
			  username.sendKeys("goldguy7263");
			  WebElement Next=driver.findElement(By.id("login-signin")); 
			  Next.click(); 
			  Thread.sleep(3000);
		
		}
		
		@Test(priority=2)
		public void verifyTitle()
		{
		WebElement Error=driver.findElement(By.id("username-error"));
		String Text = Error.getText();
		String ExpectedTitle = "Sorry, we don't recognize this email.";
		Assert.assertEquals(Text, ExpectedTitle);
		System.out.println("Assert passed");
		}
		

		@AfterTest
		public void Exit()
		{
		  driver.close();     
		}
		
	}

