package verify_the_login_section;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class enter_invalid_userid_valid_password {
	public String baseUrl = "http://www.demo.guru99.com/V4/";
	public String user_id = "mngr666";
	public String password = "tEsYpYt";
	public String invalid = "User or Password is not valid";
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void launch_browser(){
		driver.get(baseUrl);
	}
	
	@Test
	public void invalid_userid_valid_password() throws InterruptedException{
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(user_id);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		try {
			if(driver.switchTo().alert() != null){
				Alert alert = driver.switchTo().alert();
				alert.getText().equals(invalid);
				Thread.sleep(3000);
				alert.accept();
			}
			
		} catch (Exception e) {
			System.err.close();
		}
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(),"Guru99 Bank Home Page");
	}
	
	@AfterTest
	public void close_browser(){
		driver.quit();
	}

}
