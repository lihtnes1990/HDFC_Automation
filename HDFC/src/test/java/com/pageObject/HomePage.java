package com.pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.GenericFun;

import io.appium.java_client.AppiumDriver;

public class HomePage {

	protected AppiumDriver driver;
	public ExtentTest test;
	
	By menuPanal= By.className("android.widget.ListView");
	By menuList=By.className("android.view.View");
	By userDetails=By.className("android.view.View");
	By NEFTTRC=By.name("To Other Bank - NEFT ");
	By NEFTSpinner=By.className("android.widget.Spinner");
	By BeneficiaryListView=By.className("android.widget.ListView");
	By Beneficiaryindexvalues=By.className("android.widget.CheckedTextView");
	
	public HomePage(AppiumDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public boolean dashboardpage_Redirection(){
		boolean status=false;
		try{
			menulist_Click(3);
			test.log(LogStatus.INFO, "Dashboard page redirection is done");
			status=true;
		}catch(Exception e){
			status=false;
			System.out.println("Not able to re-directed to Dashboard page");
		}
		return status;
	}
	
	public boolean fundTransferpage_Redirection(){
		boolean status=false;
		try{
		menulist_Click(4);
		test.log(LogStatus.INFO, "Fund transfer page redirection is done");
		status=true;
		}catch(Exception e){
			status=false;
			System.out.println("Not able to tab on FundTransperoption");
		}
		return status;
	}
	
	public void menulist_Click(int list){
		try{
			   WebElement mPanal=driver.findElement(menuPanal);
			   List<WebElement> mList=mPanal.findElements(menuList);
			   mList.get(list).click();
			   test.log(LogStatus.INFO, "Menupanel click event is done");
			}catch(Exception e){
			   System.out.println("Menulist not available" + e);
			}
	}
	
	public String getuserAccount_No_Deatils() throws InterruptedException{
		String AC_No = null;
		Thread.sleep(2000);
		try{
		AC_No=getUserDeatils(12,"name");
		test.log(LogStatus.INFO, "Get User Account Number detail is done");
		}catch(Exception e){
			System.out.println("Not able to get the user A/C number from dashboard" + e);
		}
		return AC_No;
	}
	
	public String getuserAccount_Balance_Details() throws InterruptedException{
		String Balance=null;
		String bal[] = null;
		Thread.sleep(2000);
		try{
			Balance=getUserDeatils(17,"name");
			bal=Balance.split("\\s+");
			test.log(LogStatus.INFO, "Get User Account Balance details is done");
		}catch(Exception e){
			System.out.println("Not able to get the user A/C balance from dashboard" + e);
		}
		return bal[1];
	}
	
	public String getUserDeatils(int plc,String atttype){
		  String attribute = null;
		  List<WebElement> acdetails=driver.findElements(userDetails);
		  attribute=acdetails.get(plc).getAttribute(atttype);
		  test.log(LogStatus.INFO, "Get user is done");
		  return attribute;
	}
	
	public boolean tap_onNEFT_Transactionoption() throws InterruptedException{
		boolean status=false;
		try{
		  Thread.sleep(3000);
		  driver.findElement(NEFTTRC).click();
		  test.log(LogStatus.INFO,"Tapping on NEFT transaction link is done");
		  status=true;
		}catch(Exception e){
			status=false;
			System.out.println("Not able to tap on NEFT transaction option");
		}
		return status;
	}
	
	public boolean tap_onBeneficaryDrpDown(){
		boolean status=false;
		try{
		Thread.sleep(2000);
		  List<WebElement> drp=driver.findElement(menuList).findElements(NEFTSpinner);
		  drp.get(1).click();
		  test.log(LogStatus.INFO, "Tapping on Beneficiary drop down is done");
		  status=true;
		}catch(Exception e){
			status=false;
			System.out.println("Not able to tap on Beneficary Dropdown");
		}
		return status;
	}
	
	public boolean getBeneficaryNames() throws IOException{
		ArrayList<String> eles=new ArrayList<String>();
		boolean status = false;
		List<WebElement> beneficaryDetails=driver.findElement(BeneficiaryListView).findElements(Beneficiaryindexvalues);
		
		 for(WebElement ele:beneficaryDetails){
			 eles.add(ele.getAttribute("name"));
			  //System.out.println(ele.getAttribute("name"));  
	      }
		 test.log(LogStatus.INFO, "Comparing Beneficiary details is Starting");
		 
		 ArrayList<String> li=new ArrayList<String>();
			li=GenericFun.readExceldata();
			test.log(LogStatus.INFO, "Reading Beneficiary details from excel is done");
			if(eles != null && li != null && (eles.size() == li.size())){
	            eles.removeAll(li);
	            if(eles.isEmpty()){
	               // System.out.println("Both list are same.");
	                status=true;
	            }else{
	                //System.out.println("Both list are not same");
	                status=false;
	            }
			}
			return status;
	}
	
	
}
