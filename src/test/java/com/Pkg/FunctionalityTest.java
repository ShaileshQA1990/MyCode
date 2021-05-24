package com.Pkg;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FunctionalityTest {
	
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
	public void TestRegistrationForm() throws InterruptedException
	{

		WebElement EnterFirstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		EnterFirstName.sendKeys("Shailesh");
		
		WebElement EnterLastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		EnterLastName.sendKeys("Khobragade");
		
		WebElement EnterAddress = driver.findElement(By.xpath("//textarea[@class='form-control ng-pristine ng-untouched ng-valid']"));
		EnterAddress.sendKeys("Address Text");
		
		WebElement EnterEmail = driver.findElement(By.xpath("//input[@type='email']"));
		EnterEmail.sendKeys("shailesh@xyz.com");

		WebElement EnterPhone = driver.findElement(By.xpath("//input[@type='tel']"));
		EnterPhone.sendKeys("9999999999");
		
		WebElement SelectGenderMale = driver.findElement(By.xpath("//input[@value='Male']"));
		SelectGenderMale.click();
		
		WebElement SelectHobbies1 = driver.findElement(By.id("checkbox1"));
		SelectHobbies1.click();
		
		WebElement SelectHobbies2 = driver.findElement(By.id("checkbox2"));
		SelectHobbies2.click();
		
		WebElement SelectHobbies3 = driver.findElement(By.id("checkbox3"));
		SelectHobbies3.click();
		
		
		WebElement languages = driver.findElement(By.xpath("//div[@id='msdd']"));
		languages.click();
		Thread.sleep(2000);
		
		
		List<WebElement> languageList = driver.findElements(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li"));
		for (WebElement li : languageList) {
			WebElement a = li.findElement(By.tagName("a"));
			if (a.getAttribute("innerHTML").equalsIgnoreCase("English")) {
				li.click();
				break;
			}
		}

		
		
		WebElement clickonSpace = driver.findElement(By.xpath("//label[normalize-space()='Skills']"));
		clickonSpace.click();
		
		Thread.sleep(2000);
		
		Select selskill = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
		selskill.selectByVisibleText("C");
		
		Select selcountry = new Select(driver.findElement(By.xpath("//select[@id='countries']")));
		selcountry.selectByVisibleText("India");
		
		
		WebElement selcountry2 = driver.findElement(By.xpath("//span[@role='combobox']"));
		selcountry2.click();
			
			
			String country2 = "India";
			
			List<WebElement> countryList2 = driver.findElements(By.xpath("//li[@class='select2-results__option']"));
			for (WebElement li : countryList2) {
				if (li.getText().equalsIgnoreCase(country2)) {
					li.click();
					break;
				}
			}
		
		
			
			Select Selyear = new Select(driver.findElement(By.xpath("//select[@id='yearbox']")));
			Selyear.selectByVisibleText("1990");
			
			
			Select selmonth = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
			selmonth.selectByVisibleText("June");
			
			
			Select selday = new Select(driver.findElement(By.xpath("//select[@id='daybox']")));
			selday.selectByVisibleText("3");
			
			
			
			WebElement EnterPW1 = driver.findElement(By.xpath("//input[@id='firstpassword']"));
			EnterPW1.sendKeys("Aa@123456");
			
			WebElement EnterPW2 = driver.findElement(By.xpath("//input[@id='secondpassword']"));
			EnterPW2.sendKeys("Aa@123456");
			
			WebElement UploadImg = driver.findElement(By.xpath("//input[@id='imagesrc']"));
			UploadImg.sendKeys("C:\\Users\\NISHA\\Desktop\\Test.png");
			
			
			
			WebElement submit = driver.findElement(By.name("signup"));
			submit.click();
			
			
	}
	
	@AfterClass
	public void TearDown()
	{
		driver.close();
	}

}













