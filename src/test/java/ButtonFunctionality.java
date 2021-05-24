import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonFunctionality {
	
static WebDriver driver;
	



@BeforeMethod
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\#SOFTWARE\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://leafground.com/");
		
	}

	
	
	@Test
	
	public static void ClickOnButton()
	{
		WebElement button_link = driver.findElement(By.xpath("//img[@alt='Buttons']"));
		button_link.click();
		assertEquals(driver.getTitle(), "TestLeaf - Interact with Buttons");
	}
	
	@Test
	
	public void CheckHomeButton()
	{
		
		WebElement button_link = driver.findElement(By.xpath("//img[@alt='Buttons']"));
		button_link.click();
		WebElement HomePagebutton = driver.findElement(By.xpath("//button[@id='home']"));
		HomePagebutton.click();
		assertEquals(driver.getTitle(), "TestLeaf - Selenium Playground");
		
	}
	

	@Test
	
	public void CheckGetPositionOfButton()
	{
		WebElement button_link = driver.findElement(By.xpath("//img[@alt='Buttons']"));
		button_link.click();
		
		WebElement GetPositionebutton= driver.findElement(By.xpath("//button[@id='position']"));
		System.out.println(GetPositionebutton.getLocation());
		
		
		
	}

 
	@Test

	public void GetColorOfButton()
		{
		
		WebElement button_link = driver.findElement(By.xpath("//img[@alt='Buttons']"));
		button_link.click();
		
			WebElement GetButtonColor = driver.findElement(By.xpath("//button[@id='color']"));
			GetButtonColor.getAttribute("style");
			assertEquals(GetButtonColor.getAttribute("style"), "background-color:lightgreen");
	
	
		}

	@Test

	public void CheckSizeOfButton()
		{
		WebElement button_link = driver.findElement(By.xpath("//img[@alt='Buttons']"));
		button_link.click();
		WebElement ButtonSize = driver.findElement(By.xpath("//button[@id='size']"));

		System.out.println(ButtonSize.getSize());
	
	
		}


	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}










