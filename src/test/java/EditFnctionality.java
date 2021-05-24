import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditFnctionality {
	
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
		
		driver.get("http://leafground.com/");
		
	}

	
	
	@Test
	
	public void ClickOnEdit()
	{
		WebElement edit_link = driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']"));
		edit_link.click();
		assertEquals(driver.getTitle(), "TestLeaf - Interact with Edit Fields");
	}
	
	@Test
	public void EnterEmailAddress()
	{
		WebElement edit_link = driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']"));
		edit_link.click();
		WebElement EnterEmail = driver.findElement(By.xpath("//input[@id='email']"));
		EnterEmail.sendKeys("shailesh.khobragade@hcl.com");
	}
	
	@Test
	public void AppendTextTest()
	{
		WebElement edit_link = driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']"));
		edit_link.click();
		WebElement AppendText = driver.findElement(By.xpath("//input[@value='Append ']"));
		AppendText.sendKeys("TestText");
		AppendText.sendKeys(Keys.TAB);
		
	}
	
	
	
	@Test
	public void GetDefaultTextTest()
	{
		WebElement edit_link = driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']"));
		edit_link.click();
	
	WebElement DefaultText = driver.findElement(By.xpath("//input[@value='TestLeaf']"));
	System.out.println(DefaultText.getAttribute("value"));
	
	}
	
	@Test
	public void ClearTextTest()
	{
		WebElement edit_link = driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']"));
		edit_link.click();
	WebElement ClearText = driver.findElement(By.xpath("//input[@value='Clear me!!']"));
	ClearText.clear();
	}
	
	@Test
	public void checkTextFieldStatus()
	{
		WebElement edit_link = driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']"));
		edit_link.click();
		WebElement DisabledTextField = driver.findElement(By.xpath("//input[@disabled='true']"));
		System.out.println(DisabledTextField.isEnabled());
		boolean status = DisabledTextField.isEnabled();

		if(status==true)
		{
			System.out.println("Text Field is Enabled");
		}
		else if(status==false)
		{
			System.out.println("Text Field is Disabled");
		}
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
	
}
