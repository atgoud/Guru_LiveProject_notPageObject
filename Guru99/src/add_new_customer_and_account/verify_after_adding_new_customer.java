package add_new_customer_and_account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verify_after_adding_new_customer {
	public String baseUrl = "http://www.demo.guru99.com/V4/";
	public String user_id = "mngr6669";
	public String password = "tEsYpYt";
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void lauch_browser(){
		driver.get(baseUrl);
	}
	
	@Test
	public void incorrect_old_password() throws InterruptedException{
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(user_id);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage");
		driver.findElement(By.linkText("New Customer")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Denys");
		driver.findElement(By.cssSelector("input[name='rad1']")).click();
		driver.findElement(By.xpath(".//*[@id='dob']")).sendKeys("25081992");
		driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")).sendKeys("Kiev");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Kiev");
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Kiev");
		driver.findElement(By.cssSelector("input[name='pinno']")).sendKeys("567321");
		driver.findElement(By.cssSelector("input[name='telephoneno']")).sendKeys("380951428617");
		driver.findElement(By.cssSelector("input[name='emailid']")).sendKeys("Aleksdenkoval@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Aleksandra");
		driver.findElement(By.cssSelector("input[type='Submit']")).click();		
		}
	}
