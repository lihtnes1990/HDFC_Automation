package com.automation.myapps;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class app_config {
	protected static AppiumDriver driver;
@BeforeTest
public void config() throws MalformedURLException{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("deviceName", "ZX1D63NJB6");
	  capabilities.setCapability("platformName","Android");
	  capabilities.setCapability("platformVersion","");
	  //capabilities.setCapability("app", app.getAbsolutePath());
	  capabilities.setCapability("appPackage","com.snapwork.hdfc"); 
	  //capabilities.setCapability("appActivity","com.mobifusion.android.ldoce5.Activity.WelcomeActivity"); 
	  capabilities.setCapability("appActivity","com.snapwork.hdfc.HDFCBank");
	  //capabilities.setCapability("noReset", false);
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
}
  @Test
  public void f() throws InterruptedException {
	  System.out.println("pass");
	  Thread.sleep(8000);
	  
	  driver.findElement(By.name("My Account")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.name("Customer Id:")).click();
	  List<WebElement> eles=driver.findElements(By.className("android.widget.EditText"));
	  //System.out.println(eles.size());
	  
	  eles.get(4).sendKeys("56229216");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.name("Continue")).click();
	  Thread.sleep(5000);
	  
	  List<WebElement> chkbox=driver.findElements(By.className("android.view.View"));
	  //chkbox.get(index)
	  
	  //send the password to password field
	  driver.findElement(By.className("android.widget.EditText")).sendKeys("gethisyal@88");
	  Thread.sleep(2000);
	  
	  //to check the checkbox
	  driver.findElement(By.xpath("//android.view.View[@index='2']")).click();
	  driver.findElement(By.name("Login")).click();
	  Thread.sleep(8000);
	  
	  //to go the dashboard page, click on my account option from bottom of the app
	  WebElement menupanal=driver.findElement(By.className("android.widget.ListView"));
	  List<WebElement> menulist=menupanal.findElements(By.className("android.view.View"));
	  //System.out.println(menulist.size());
	  menulist.get(3).click();
	  
	  //to get the account and balance details from dashboard
	  Thread.sleep(2000);
	  List<WebElement> acdetails=driver.findElements(By.className("android.view.View"));
	  acdetails.removeAll(Collections.singleton(null));
	  System.out.println(acdetails.size());
	  System.out.println("A/C No:" +acdetails.get(12).getAttribute("name"));
	  System.out.println("Avaliable Balance:" +acdetails.get(17).getAttribute("name"));
	  
	  //to go to the fund transfer option
	  menulist.get(4).click();
	  
	  //to clicking on "to-otherbank-NEFT transaction options
	  Thread.sleep(3000);
	  driver.findElement(By.name("To Other Bank - NEFT ")).click();
	  
	  //after switching to neft fund transfer page,click on beneficiary details dropdown
	  Thread.sleep(2000);
	  List<WebElement> drp=driver.findElement(By.className("android.view.View")).findElements(By.className("android.widget.Spinner"));
	  drp.get(1).click();
	  
	  //getting beneficary details from popup
	  List<WebElement> beneficaryDetails=driver.findElement(By.className("android.widget.ListView")).findElements(By.className("android.widget.CheckedTextView"));
	  for(WebElement ele:beneficaryDetails){
		  System.out.println(ele.getAttribute("name"));
	  }
  }
  
	public static void switchToWebView() throws InterruptedException{
		Set<String> contextNames = driver.getContextHandles();
		String webView = (String) contextNames.toArray()[1];
		driver.context(webView).switchTo();
		
	}
	
	public static void readPropertiesfromExcel(){
		
	}
}
