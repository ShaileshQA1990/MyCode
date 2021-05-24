package com.Pkg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;



public class ConfigPropAndCookieshandling {

	
	static WebDriver driver;
	static Properties prop;



	@Test
		public void PropAndCookies() throws IOException
		{
		
		FileInputStream ip = new FileInputStream("E:\\WorkSpace1\\Training\\src\\test\\java\\com\\Pkg\\config.properties");
			prop = new Properties();
			prop.load(ip);
			
			
			if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriver"));
				driver = new ChromeDriver();
			}else
			{
				System.out.println("Other Browser Code");
			}
			
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
			
			WebElement UID = driver.findElement(By.xpath("//input[@id='ap_email']"));
			UID.sendKeys(prop.getProperty("UID"));
			WebElement signinbtn = driver.findElement(By.xpath("//input[@id='continue']"));
			signinbtn.click();
			
			File file = new File("E:\\WorkSpace1\\Training\\src\\test\\java\\com\\Pkg\\cookie.data");
			
			try		
	        {	  
	            
				file.delete();		
	            file.createNewFile();	
	            
	            FileWriter fileWrite = new FileWriter(file);							
	            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
	       		
	            for(Cookie ck : driver.manage().getCookies())							
	            {			
	                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
	                Bwrite.newLine();             
	            }			
	            Bwrite.close();			
	            fileWrite.close();	
	            
	            driver.manage().deleteAllCookies();
	        }
	        catch(Exception ex)					
	        {		
	            ex.printStackTrace();			
	        }		
	    	
			
			
			Set<Cookie> cookieslist = driver.manage().getCookies();
			
			for(Cookie c:cookieslist)
			{
				System.out.println(c.getDomain()+"  "+c.getName()+"  "+c.getPath()+"  "+c.getValue());
				System.out.println();
				
				
			}
			

		}
	
}
