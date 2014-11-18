package customized_statement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verify_customized_statement {
	public String baseUrl = "http://www.demo.guru99.com/V4/";
	public String user_id = "mngr6669";
	public String password = "tEsYpYt";
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest	
	public void launch_browser(){
		driver.get(baseUrl);
	}
	@Test
	public void verify_system() throws InterruptedException{
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(user_id);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage");
		driver.findElement(By.linkText("Customised Statement")).click();
		driver.findElement(By.cssSelector("input[name='fdate']")).sendKeys("17112014");
		driver.findElement(By.cssSelector("input[name='tdate']")).sendKeys("18112014");
		driver.findElement(By.cssSelector("input[name='amountlowerlimit']")).sendKeys("500");
		driver.findElement(By.cssSelector("input[name='numtransaction']")).sendKeys("10");
		driver.findElement(By.cssSelector("input[name='AccSubmit']")).click();
		try {
			if(driver.switchTo().alert()!=null){
				Alert alert = driver.switchTo().alert();
				Assert.assertEquals(alert.getText(), "Please fill all fields");
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
