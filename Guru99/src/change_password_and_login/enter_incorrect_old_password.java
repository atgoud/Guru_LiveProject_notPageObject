package change_password_and_login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class enter_incorrect_old_password {
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
		driver.findElement(By.linkText("Change Password")).click();
		driver.findElement(By.cssSelector("input[name='oldpassword']")).sendKeys("bla-bla");
		driver.findElement(By.cssSelector("input[name='newpassword']")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[name='confirmpassword']")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		try {
			if(driver.switchTo().alert()!=null){
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals(alert.getText(), "Old password is incorrect");
				alert.accept();
			}
		} catch (Exception e){
			
		}
}
	
	@AfterTest
	public void close_browser(){
		driver.quit();
	}

}
