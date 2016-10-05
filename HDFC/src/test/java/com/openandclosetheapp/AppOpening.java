package com.openandclosetheapp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class AppOpening {
 protected AndroidDriver driver;
 public static ExtentReports extent;
 public static ExtentTest test;
 @BeforeClass
 public void config() throws MalformedURLException{
	 try{
	 extent = new ExtentReports("/Users/unagase/Documents/Maven Demo/HDFC/testData/HDFCapps_Report.html",true);
	 test = extent.startTest("Verify Open & close app", "Verify the App open function");
 	  DesiredCapabilities capabilities = new DesiredCapabilities();
 	  capabilities.setCapability("deviceName", "ZX1D63NJB6");
 	  capabilities.setCapability("platformName","Android");
 	  capabilities.setCapability("platformVersion","6.0");
 	  capabilities.setCapability("appPackage","com.snapwork.hdfc");  
 	  capabilities.setCapability("appActivity","com.snapwork.hdfc.HDFCBank");
 	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
 	  test.log(LogStatus.PASS, "App is opened");
	  extent.endTest(test);
 	  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	 }catch(Exception e){
		 System.out.println("App Configuration getting problem while opening the app");
	 }
 }
 @AfterClass
 public void closeTheApp(){
	 driver.quit();
 }
}
