package com.Pkg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderedUnorderedListHandle {

	
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
			
			driver.get("http://demo.automationtesting.in/Selectable.html");
			
		}
	

	@Test
	public void HandleOrderedList()
	{
		
		driver.findElement(By.xpath("//a[contains(text(),'Serialize')]")).click();
		
		List <WebElement>	 List = driver.findElements(By.xpath("//*[@id=\"Serialize\"]/ul/li"));
		
		System.out.println(List.size());
		
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL)
		.click(List.get(0))
		.click(List.get(3))
		.build().perform();
		
		
		
	}
	
}
