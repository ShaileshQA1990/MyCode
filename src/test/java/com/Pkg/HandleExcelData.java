package com.Pkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleExcelData {
	
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
			
			driver.get("http://demo.automationtesting.in/SignIn.html");
			
		}
	

	@Test
	public void loginwithExcelData() throws IOException
	{
		
		FileInputStream ip = new FileInputStream("E:\\WorkSpace1\\Training\\src\\test\\java\\com\\Pkg\\Book1.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(ip);
		Sheet Sheet = wb.getSheetAt(0);
		int rowcount = Sheet.getLastRowNum()+1;
		
		
		for(int i=1;i<=rowcount;i++)
		{
		
			Row row = Sheet.getRow(i);
			
			for(int j=0;j<=row.getLastCellNum();j++)
			{

				WebElement uid = driver.findElement(By.xpath("/html/body/div/div/div[2]/input"));
				uid.sendKeys(row.getCell(j).getStringCellValue());
				
				WebElement pw = driver.findElement(By.xpath("/html/body/div/div/div[3]/input"));
				pw.sendKeys(row.getCell(j+1).getStringCellValue());
				
				
			}
			
		}
		

		
	}

}
