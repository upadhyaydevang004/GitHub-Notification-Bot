package test.test;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.util.ArrayList;

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
driver.get("chrome-extension://cpfmmgnpgpcnnjodbnlpcpcopncdignb/popup.html");


}

 @Test(priority=1)
 public void TestCase1() throws InterruptedException {
  
	  driver.findElement(By.id("gitHubToken")).sendKeys("Wrong_Password");
	  Thread.sleep(1000);
	  driver.findElement(By.id("setGitToken")).click();
 }
 
 
 
  @Test(priority=2)
  public void TestCase2() throws InterruptedException {
   
	  driver.findElement(By.id("gitHubToken")).sendKeys("123456");
	  Thread.sleep(1000);
	  driver.findElement(By.id("setGitToken")).click();
	  
	  Thread.sleep(1000);
	
	 // Alert alert = driver.switchTo().alert();
	  //alert.accept();	
	  //Thread.sleep(2000);
	  
	  //ArrayList<String> tabHandles1 = new ArrayList<String>(driver.getWindowHandles());
	  //WebDriver driver1 =  driver.switchTo().window(tabHandles1.get(0));
	  //driver1.get("chrome-extension://dfponcgkihdjocehlmhomjeladlnfkma/popup.html");
	  
	  Thread.sleep(2000);
	  Thread.sleep(3000);
	  String s1 = driver.findElement(By.cssSelector("#notification_list > li > a")).getText();
	    WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99seleniumlink;
		guru99seleniumlink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id='notification_list']/li[2]/a")));
		guru99seleniumlink.click();
		
	  
	  //driver.findElement(By.cssSelector("#notification_list > li > a")).click();
	  
	  ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
	  
	
	 driver.switchTo().window(tabHandles.get(2));
	 Thread.sleep(2000);  
	  driver.findElement(By.id("login_field")).sendKeys("mgupta6");
	  Thread.sleep(2000);
	  driver.findElement(By.id("password")).sendKeys("My_password");
	  driver.findElement(By.xpath("//*[@id='login']/form/div[4]/input[3]")).click();
	  String s2=driver.findElement(By.xpath("//*[@id='partial-discussion-header']/div[1]/h1/span[1]")).getText();
}
  
  @Test(priority=3)
  public void TestCase3() throws InterruptedException {
   
	  driver.findElement(By.id("gitHubToken")).sendKeys("123456");
	  Thread.sleep(2000);
	  driver.findElement(By.id("setGitToken")).click();
	  //Alert alert = driver.switchTo().alert();
	  //alert.accept();	
	 // Thread.sleep(2000);
	 
	  //ArrayList<String> tabHandles1 = new ArrayList<String>(driver.getWindowHandles());
	  //WebDriver driver1 =  driver.switchTo().window(tabHandles1.get(0));
	  //Thread.sleep(2000);
	 // driver.get("chrome-extension://dfponcgkihdjocehlmhomjeladlnfkma/popup.html");
	  Thread.sleep(2000);
	  driver.findElement(By.id("mark_all_read")).click();
	  
	 
} 
  

  @AfterMethod
  public void afterMethod() throws InterruptedException {
    

  }

 }