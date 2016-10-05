package com.pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.utilities.GenericFun;

import io.appium.java_client.AppiumDriver;

public class Signinpage {

	protected AppiumDriver driver;
	public ExtentTest test;
	
	By myAccount= By.name("My Account");
	By customerID=By.name("Customer Id:");
	By customerid_Textbox=By.className("android.widget.EditText");
	By continuebutton=By.name("Continue");
	By passwordField=By.className("android.widget.EditText");
	By imageconfirmchkbox=By.xpath("//android.view.View[@index='2']");
	By Login_bt=By.name("Login");
	
	public Signinpage(AppiumDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public boolean taponScreen() throws InterruptedException
	{
		boolean status=false;
		try{
			Thread.sleep(5000);
			driver.findElement(myAccount).click();
			status=true;
		}catch(Exception e){
			System.out.println("Not able to tapping on the screen" +e);
			status=false;
		}
		return status;
	}
	
	public boolean taponCustomerID() throws InterruptedException{
		
		boolean status=false;
		try{
		Thread.sleep(2000);
		driver.findElement(customerID).click();
		status=true;
		}catch(Exception e){
			System.out.println("Not able to tap on Customer ID" +e);
			status=false;
		}
		return status;
		
	}
	
	public boolean typeCustomerID() throws InterruptedException, IOException{
		boolean status=false;
		try{
		Thread.sleep(2000);
		List<WebElement> eles=driver.findElements(customerid_Textbox);
		eles.get(4).sendKeys(GenericFun.getProperty("UserID"));
		status=true;
		}catch(Exception e){
			status=false;
			System.out.println("Not able to type the cusotmerID");
		}
		return status;
	}
	
	public boolean taponcontinuebutton() throws InterruptedException{
		boolean status=false;
		try{
		Thread.sleep(2000);
		driver.findElement(continuebutton).click();
		status=true;
		}catch(Exception e){
			status=false;
			System.out.println("Not able to tap on continuebutton "+e);
		}
		return status;
	}
	
	public boolean type_userPassword() throws InterruptedException, IOException{
		boolean status=false;
		try{
		Thread.sleep(2000);
		driver.findElement(passwordField).sendKeys(GenericFun.getProperty("Password"));
		status=true;
		}catch(Exception e){
			status=false;
			System.out.println("Not able to type the password "+e);
		}
		return status;
	}
	
	public boolean check_imagechkbox() throws InterruptedException{
		boolean status=false;
		try{
		Thread.sleep(2000);
		driver.findElement(imageconfirmchkbox).click();
		status=true;
		}catch(Exception e){
			status=false;
			System.out.println("Not able to check the image checkbox button");
		}
		return status;
	}
	
	public boolean taponLoginbutton() throws InterruptedException{
		boolean status=false;
		try{
		Thread.sleep(2000);
		driver.findElement(Login_bt).click();
		status=true;
		}catch(Exception e){
			status=false;
			System.out.println("Not able to tap on login button");
		}
		return status;
		}
	
	public boolean imageCheckbox_isvisble(){
		boolean status=false;
		try{
		Thread.sleep(3000);
		status=driver.findElement(By.name("Please confirm your Secure Access Image and Message to login")).isDisplayed();
		}catch(Exception e){
			status=false;
			System.out.println("Not a valid credentials");
			driver.quit();
		}
		return status;
	}
	
	public boolean accountSummary_isvisible() throws InterruptedException{
		boolean status=false;
		try{
		Thread.sleep(3000);
		status=driver.findElement(By.name("Account Summary")).isDisplayed();
		}catch(Exception e){
			status=false;
			System.out.println("Not a valid credentials");
			driver.quit();
		}
		return status;
	}
	
}
