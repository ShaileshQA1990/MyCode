package com.Pkg;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrames {
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
			
			driver.get("http://leafground.com/pages/frame.html");
			
		}
	

	@Test
	public void TestNestedFrame() throws AWTException, IOException
	{
		driver.switchTo().frame(1).switchTo().frame("frame2");
		
		WebElement btn = driver.findElement(By.id("Click1"));
		
		btn.click();
		
		
		Robot robot1 = new Robot();
		
		Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
		
		Rectangle rect = new Rectangle(scrn);
		
		BufferedImage Source = robot1.createScreenCapture(rect);
		
		File dest = new File("E:\\WorkSpace1\\Training\\ScreenShotsFolder\\image3.png");
		
		ImageIO.write(Source, "png", dest);
		
	}
}






