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

public class DropDownHandle {

	
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
		
		driver.get("http://leafground.com/pages/Dropdown.html");
		
	}
	
	@Test
	public void HandleDropDown() 
	{
		
		Select ByIndex = new Select(driver.findElement(By.xpath("//select[@id='dropdown1']")));
		ByIndex.selectByIndex(1);
		
		
		
		Select ByText = new Select(driver.findElement(By.xpath("//select[@name='dropdown2']")));
		ByText.selectByVisibleText("Appium");
		
		
		Select ByValue = new Select(driver.findElement(By.xpath("//select[@id='dropdown3']")));
		ByValue.selectByValue("3");
		
		
		WebElement bysendkeys = driver.findElement(By.xpath("//div[5]//select[1]"));
		bysendkeys.sendKeys("Loadrunner");
		
		
		Select options = new Select(driver.findElement(By.xpath("//select[@class='dropdown']")));
		
		List <WebElement> op = options.getOptions();
		int size = op.size();
		
		System.out.println("Number of options in this dropdown are " + (size-1));
	     for(int i =1; i<size ; i++)
	     {
	         String opt = op.get(i).getText();
	         System.out.println(opt);
	      }
		
	     
	  Select sl = new Select(driver.findElement(By.xpath("//div[6]//select[1]")));
	  List <WebElement> op1 = sl.getOptions();
		int sizeL2 = op1.size();
		
	
	     for(int i =1; i<sizeL2 ; i++)
	     {
	    	 if(op1.get(i).getText().equalsIgnoreCase("Selenium"))
	    	 {
	    		 op1.get(i).click();
	    	 }
	         String opt = op1.get(i).getText();
	         System.out.println(opt);
	      }
	  
		
	}
	
	
	
	
	@AfterClass
	public void TearDown()
	{
		//driver.close();
	}

	
}
