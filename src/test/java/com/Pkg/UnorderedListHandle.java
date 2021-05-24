package com.Pkg;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnorderedListHandle {
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
			
			driver.get("http://demo.automationtesting.in/AutoComplete.html");
			
		}
	

	@Test
	public void HandleOrderedList() throws InterruptedException
	{
		
		
		WebElement enterText = driver.findElement(By.xpath("//*[@id=\"searchbox\"]"));
		
		enterText.sendKeys("ind");
		
		Thread.sleep(2000);
		
		List <WebElement> list =driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(WebElement e :list)
		{
			if(e.getText().equalsIgnoreCase("India"))
			{
				e.click();
				break;
			}
		}
		
		
		
		}
	

}
//