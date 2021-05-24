package com.Pkg;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicCommands {

	
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
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
	}
	
	@Test
	public void TestBesicCommands() 
	{
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		
		String pagesource = driver.getPageSource();
		System.out.println(pagesource);
		
		
		driver.navigate().to(URL);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to(driver.getCurrentUrl());
		driver.navigate().refresh();
		
		
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.close();
	}

	
}

