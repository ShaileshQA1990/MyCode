package com.Pkg;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PopUpsHandle {
	
WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\#SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
	}
	
	@Test
	public void HandlePopUps() 
	{
		WebElement popup1 = driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]"));
		popup1.click();
		
		driver.switchTo().alert().accept();
		
		
		WebElement OKCANCLELINK = driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
		OKCANCLELINK.click();
		
		
		WebElement popup2 = driver.findElement(By.xpath("//button[normalize-space()='click the button to display a confirm box']"));
		popup2.click();
		
		driver.switchTo().alert().dismiss();
		
		
		WebElement AlertwithTextboxLINK = driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']"));
		AlertwithTextboxLINK.click();
		
		
		
		WebElement popup3 = driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']"));
		popup3.click();
		
		driver.switchTo().alert().sendKeys("Test Text");
		driver.switchTo().alert().accept();
		
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.close();
	}


}







