package verify_the_login_section;

import java.io.File;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class enter_valid_userid_password_verify_managerid_take_sreenshot {
	public String baseUrl = "http://www.demo.guru99.com/V4/";
	public String user_id = "mngr6669";
	public String password = "tEsYpYt";
	public String manager_id = "Manger Id : mngr6669";
	WebDriver driver = new FirefoxDriver();
	
	
	@Test
	public void valid_userid_password_verify_managerid_take_sreenshot() throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys(user_id);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText(),manager_id);
		this.takeSnapShot(driver, "E://EPAM/Project/Guru99/HomePage.png") ;
	}
	
		public void takeSnapShot(WebDriver driver, String FileWithPath) throws Exception{
		TakesScreenshot screen_shot = ((TakesScreenshot)driver);
		File SrcFile=screen_shot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(FileWithPath);
		org.apache.commons.io.FileUtils.copyFile(SrcFile, DestFile);
	}
	@AfterTest
	public void close_browser(){
		driver.quit();
	}
	
}
