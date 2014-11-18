package verify_the_login_section;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class enter_valid_userid_password {
	public String baseUrl = "http://www.demo.guru99.com/V4/";
	public String user_id = "mngr6669";
	public String password = "tEsYpYt";
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest	
	public void launch_browser(){
		driver.get(baseUrl);
	}
	
	@Test
	public void valid_userid_password() throws InterruptedException{
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(user_id);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage");
	}
	
	@AfterTest
	
	public void close_browser(){
		driver.quit();
	}
	

}
