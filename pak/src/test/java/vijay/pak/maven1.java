package vijay.pak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class maven1 {
	WebDriver driver;
	String key="webdriver.chrome.driver";
	String path="C:\\Users\\om\\Desktop\\kkd\\selenium\\chromedriver_win32\\chromedriver1.exe";
	@BeforeMethod
	public void LaunchApp()
	{	System.setProperty(key, path);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
	}
	@Test
	public void Tc_1() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='header_user_info']")).click();
		Thread.sleep(3000);
		boolean text=driver.findElement(By.xpath("//form[@id='create-account_form']/h3")).isDisplayed();
		Assert.assertTrue(text);
	}
	
	@Test
	public void Tc_2() throws InterruptedException
	{
		driver.findElement(By.id("search_query_top")).sendKeys("Shirts");
		driver.findElement(By.name("submit_search")).click();
		Thread.sleep(3000);
		String a=driver.findElement(By.id("search_query_top")).getAttribute("value");
		Assert.assertEquals(a,"Shirts");
		
	}
	
	@Test
	public void Tc_3() throws InterruptedException
	{
		driver.findElement(By.linkText("Contact us")).click();
		Thread.sleep(3000);
		boolean b=driver.findElement(By.linkText("Best Sellers")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void CloseApp()
	{
		driver.quit();
	}

}
