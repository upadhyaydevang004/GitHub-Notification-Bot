package test.test;
import java.io.IOException;
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

public class Automate {

WebDriver driver;

@BeforeMethod
public void beforeMethod() throws InterruptedException 
{

System.setProperty("webdriver.chrome.driver","F:\\chromedriver.exe");	
driver=new ChromeDriver();
driver.manage().window().maximize();
}

 @Test(priority=1)
 public void TestCase1() throws InterruptedException, IOException {
	 
	  driver.get("https://accounts.google.com/signin/v2/identifier?service=chromewebstore&passive=1209600&continue=https%3A%2F%2Fchrome.google.com%2Fwebstore%2Fdeveloper%2Fdashboard&followup=https%3A%2F%2Fchrome.google.com%2Fwebstore%2Fdeveloper%2Fdashboard&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	  Thread.sleep(1000); 
      driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("Your Gmail's Account");
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("Your Gmail's Password");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id='cx-dev-dash']/div[2]/table/tbody/tr/td[6]/a[2]")).click();
	  
	  Thread.sleep(1000);
	  
	  driver.findElement(By.xpath("//*[@id='cx-detail-pane']/div[1]/div[1]/div[2]/div/div/div[2]/input")).click();
	  Thread.sleep(1000);
	 
	  
	    String filename = "F:\\src.crx";
	    File file = new File(filename);
	    String path = file.getAbsolutePath();
	    driver.findElement(By.xpath("//*[@id='browse-btn']")).sendKeys(path);
	  
	  
	  driver.findElement(By.xpath("//*[@id='browse-btn']")).click();
	  Thread.sleep(1000);
	  
	  Runtime.getRuntime().exec("First.exe");
	  
	  driver.findElement(By.xpath("//*[@id='browse-btn']")).sendKeys("src.zip");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.id("upload-btn")).click();
	 
	  Thread.sleep(4000);
	  //driver.findElement(By.xpath("//*[@id='cx-dev-edit-desc']")).sendKeys("Its new version Github Bot");;
	  driver.findElement(By.xpath("//*[@id='cx-dev-edit-submit-btns']/div/div[2]/input[2]")).click();
	  driver.findElement(By.xpath("//*[@id='cx-confirm-publish']/tbody/tr/td/div[2]/div/input[2]")).click();
 }
 

 
 

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}

}