package test.test;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class first {

WebDriver driver;

@BeforeMethod
public void beforeMethod() throws InterruptedException 
{
System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");
ChromeOptions options = new ChromeOptions ();
options.addExtensions (new File("C:\\Users\\Mgupta\\Desktop\\se3\\csc510-project-master\\csc510-project-master\\src.crx"));
DesiredCapabilities capabilities = new DesiredCapabilities ();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
driver = new ChromeDriver(capabilities);
driver.manage().window().maximize();
driver.get("chrome-extension://gpcjfddmbjnplgihogfbhbabdnhclhkm/popup.html");
}

 @Test(priority=1)
 public void TestCase1() throws InterruptedException {
      driver.findElement(By.id("gitHubToken")).sendKeys("Invalid_Github_Token");
	  driver.manage().timeouts().implicitlyWait(12,TimeUnit.SECONDS) ;
	  driver.findElement(By.id("setGitToken")).click();
 }
 
 
 
  @Test(priority=2)
  public void TestCase2() throws InterruptedException {
	  driver.findElement(By.id("gitHubToken")).sendKeys("Actual-Github-Token");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.findElement(By.id("setGitToken")).click();
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  WebElement link1;
	  link1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#notification_list > li > a")));
	  String s1 = driver.findElement(By.cssSelector("#notification_list > li > a")).getText();
      WebElement link;
	  link= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id='notification_list']/li[2]/a")));
	  link.click();
 	  ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tabHandles.get(2));
	  link= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field"))); 
	  driver.findElement(By.id("login_field")).sendKeys("User ID");
	  Thread.sleep(2000);
	  driver.findElement(By.id("password")).sendKeys("User Password");
	  driver.findElement(By.xpath("//*[@id='login']/form/div[4]/input[3]")).click();
	  String s2=driver.findElement(By.xpath("//*[@id='partial-discussion-header']/div[1]/h1/span[1]")).getText();
}
  
  @Test(priority=3)
  public void TestCase3() throws InterruptedException {
        driver.findElement(By.id("gitHubToken")).sendKeys("Actual github token");
	    WebElement link;
	    WebDriverWait wait=new WebDriverWait(driver, 10);
	    link= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id( "setGitToken")));
		link.click();
	    driver.findElement(By.id("setGitToken")).click();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.findElement(By.id("mark_all_read")).click();
	} 
  

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  driver.close();
}

}
