package com.Pkg;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsHandle {
	
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
			
			driver.get("http://the-internet.herokuapp.com/windows");
			
		}
	

	@Test
	public void TestMultipleWindowHandle() throws IOException
	{
		
		String w1 = driver.getWindowHandle();
		System.out.println(w1);
		
		
		WebElement ClickForWindow = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
		ClickForWindow.click();
		
		
		Set<String> win = driver.getWindowHandles();
		
		Iterator <String> it =win.iterator();
		
		it.hasNext();
		
		String win1= it.next();
		System.out.println(win1);
		System.out.println(driver.getTitle());
		
		String win2 = it.next();
		driver.switchTo().window(win2);
		System.out.println(driver.getTitle());
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("E:\\WorkSpace1\\Training\\ScreenShotsFolder\\image.png");
		
		FileHandler.copy(source, destination);

	}

}








