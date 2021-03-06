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
public class blankpass {


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
				  Thread.sleep(1000);
				  WebElement login=driver.findElement(By.id("login-signin")); 
				  login.click();
				  Thread.sleep(2000);
				  
			}
			
			@Test(priority=2)
			public void verifyTitle()
			{
			WebElement Error=driver.findElement(By.className("error-msg"));
			String Text = Error.getText();
			String ExpectedTitle = "Please provide password.";
			Assert.assertEquals(Text, ExpectedTitle);
			System.out.println("Assert passed");
			}

			@AfterTest
			public void Exit()
			{
			  driver.close();     
			}
			
		}
