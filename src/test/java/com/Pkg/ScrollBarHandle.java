package com.Pkg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollBarHandle {
	
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
			
			driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
			
		}
	

	@Test
	public void HandleScrollBar(){
		
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"mCSB_8_container\"]/p[13]"));
		
		je.executeScript("arguments[0].scrollIntoView(true)", ele1);
		
		System.out.println(ele1.getText());
				
	}
	
		
		
	

}
