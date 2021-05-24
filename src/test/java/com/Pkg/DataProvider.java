package com.Pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider {
	
	WebDriver driver;
	
	@BeforeMethod
		public void setup()
		{
			
			System.setProperty("webdriver.chrome.driver", "E:\\#SOFTWARE\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("http://www.gmail.com/");
			
		}
	
	
	@org.testng.annotations.DataProvider (name="EmailIDs")
	
	public Object[][] getdata()
	{
		
		Object[][] data = new Object[][]
				{
			
			{"example1@gmail.com"},
			{"example2@gmail.com"},
			{"example3@gmail.com"}
				};
		return data;
		
	}
	
	
	
	@Test(dataProvider ="EmailIDs",dependsOnMethods="DependsOnMethodExample",expectedExceptions=NoSuchElementException.class)
	public void LoginWithEmailID(String EmailID)
	{
		
		WebElement EnterEmailID = driver.findElement(By.xpath("//input[@id='identifierId']"));
		EnterEmailID.sendKeys(EmailID);
		WebElement ClickOnNext = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
		ClickOnNext.click();
		
	}
	
	@Test
	public void DependsOnMethodExample()
	{
		
		System.out.println("This Method is sample method for dependsOnMethod example");
		
	}
	
	@Test
	public void ClickOnForgetEmail()
	{
		
		WebElement ForgetEmailLink = driver.findElement(By.xpath("//button[contains(text(),'Forgot email?')]"));
		ForgetEmailLink.click();
		
	}

	
	
	@Test
	public void ClickOnCreateAccount()
	{
		
		WebElement CreateAccLink = driver.findElement(By.xpath("//span[contains(text(),'Create account')]"));
		CreateAccLink.click();
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
}














