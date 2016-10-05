package com.appModule;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.interfaces.HDFC_RTM;
import com.openandclosetheapp.AppOpening;
import com.pageObject.HomePage;
import com.pageObject.Signinpage;
import com.relevantcodes.extentreports.LogStatus;
import com.utilities.GenericFun;



public class Signin_Test extends AppOpening implements HDFC_RTM {

	@Test(priority=0)
	public void verify_tapon_myAccount() throws InterruptedException{
		test = extent.startTest("verify_tapon_myAccount", "verify_tapon_myAccount started");
		Signinpage SI=new Signinpage(driver,test);
		Assert.assertTrue(SI.taponScreen());
		test.log(LogStatus.PASS, "verify_tapon_myAccount case Passed");
		extent.endTest(test);
	}
	
	@Test(priority=1)
	public void verify_tapon_customerID() throws InterruptedException{
		test = extent.startTest("verify_tapon_customerID","verify_tapon_customerID action started");
		Signinpage SI=new Signinpage(driver,test);
		Assert.assertTrue(SI.taponCustomerID());
		test.log(LogStatus.PASS, "verify_tapon_customerID case Passed");
		extent.endTest(test);
	}
	@Test(priority=2)
	public void verify_enter_customerID() throws InterruptedException, IOException{
		test = extent.startTest("verify_enter_customerID","verify_enter_customerID action started");
		Signinpage SI=new Signinpage(driver,test);
		Assert.assertTrue(SI.typeCustomerID());
		test.log(LogStatus.PASS, "verify_enter_customerID case Passed");
		extent.endTest(test);
	}
	@Test(priority=3)
	public void verify_tapon_continueButton() throws InterruptedException{
		test = extent.startTest("verify_tapon_continueButton","verify_tapon_continueButton action started");
		Signinpage SI=new Signinpage(driver,test);
		Assert.assertTrue(SI.taponcontinuebutton());
		test.log(LogStatus.PASS, "verify_tapon_continueButton case Passed");
		Assert.assertTrue(SI.imageCheckbox_isvisble());
		extent.endTest(test);
	}
	@Test(priority=4)
	public void verify_enter_userPassword() throws InterruptedException, IOException{
		test = extent.startTest("verify_enter_userPassword","verify_enter_userPassword action started");
		Signinpage SI=new Signinpage(driver,test);
		Assert.assertTrue(SI.type_userPassword());
		test.log(LogStatus.PASS, "verify_enter_userPassword case Passed");
		extent.endTest(test);
	}
	
	@Test(priority=5)
	public void verify_tocheckimageconfirmation() throws InterruptedException{
		test = extent.startTest("verify_tocheckimageconfirmation","verify_tocheckimageconfirmation action started");
		Signinpage SI=new Signinpage(driver,test);
		Assert.assertTrue(SI.check_imagechkbox());
		test.log(LogStatus.PASS, "verify_tocheckimageconfirmation case Passed");
		extent.endTest(test);
	}
	@Test(priority=6)
	public void verify_taponLoginbutton() throws InterruptedException{
		test = extent.startTest("verify_taponLoginbutton","verify_taponLoginbutton action started");
		Signinpage SI=new Signinpage(driver,test);
		Assert.assertTrue(SI.taponLoginbutton());
		test.log(LogStatus.PASS, "verify_taponLoginbutton case Passed");
		Assert.assertTrue(SI.accountSummary_isvisible());
		extent.endTest(test);
	}
	
	@Test(priority=7)
	public void verify_DashboardpageRedirection(){
		test = extent.startTest("verify_DashboardpageRedirection","verify_DashboardpageRedirection action started");
		HomePage HP=new HomePage(driver,test);
		Assert.assertTrue(HP.dashboardpage_Redirection());
		test.log(LogStatus.PASS, "verify_DashboardpageRedirection case Passed");
		extent.endTest(test);
	}
	
	@Test(priority=8)
	public void verify_UserAccountNumber() throws InterruptedException, IOException{
		test = extent.startTest("verify_UserAccountNumber","verify_UserAccountNumber action started");
		HomePage HP=new HomePage(driver,test);
		Assert.assertEquals(GenericFun.getProperty("HDFCA/C"), HP.getuserAccount_No_Deatils());
		test.log(LogStatus.PASS, "verify_UserAccountNumber case Passed");
		extent.endTest(test);
	}
	
	@Test(priority=9)
	public void verify_UserAccountBalance() throws IOException, InterruptedException{
		test = extent.startTest("verify_UserAccountBalance","verify_UserAccountBalance action started");
		HomePage HP=new HomePage(driver,test);
		Assert.assertEquals(HP.getuserAccount_Balance_Details(),GenericFun.getProperty("BalanceAmt"));
		test.log(LogStatus.PASS, "verify_UserAccountBalance case Passed");
		extent.endTest(test);
	}
	
	@Test(priority=10)
	public void verify_FundTransferpageRedirection(){
		test = extent.startTest("verify_FundTransferpageRedirection","verify_FundTransferpageRedirection action started");
		HomePage HP=new HomePage(driver,test);
		Assert.assertTrue(HP.fundTransferpage_Redirection());
		test.log(LogStatus.PASS, "verify_FundTransferpageRedirection case Passed");
		extent.endTest(test);
	}
	
	@Test(priority=11)
	public void verify_tapon_NEFTTransaction() throws InterruptedException{
		test = extent.startTest("verify_tapon_NEFTTransaction","verify_tapon_NEFTTransaction action started");
		HomePage HP=new HomePage(driver,test);
		Assert.assertTrue(HP.tap_onNEFT_Transactionoption());
		test.log(LogStatus.PASS, "verify_tapon_NEFTTransaction case Passed");
		extent.endTest(test);
	}
	
	@Test(priority=12)
	public void verify_tapBeneficiaryDrpDownbox() throws InterruptedException{
		test = extent.startTest("verify_tapBeneficiaryDrpDownbox","verify_tapBeneficiaryDrpDownbox action started");
		HomePage HP=new HomePage(driver,test);
		Assert.assertTrue(HP.tap_onBeneficaryDrpDown());
		test.log(LogStatus.PASS, "verify_tapBeneficiaryDrpDownbox case Passed");
		extent.endTest(test);
	}
	
	@Test(priority=13)
	public void verify_BeneficiaryNames() throws IOException{
		test = extent.startTest("verify_BeneficiaryNames","verify_BeneficiaryNames action started");
		HomePage HP=new HomePage(driver,test);
		Assert.assertTrue(HP.getBeneficaryNames());
		test.log(LogStatus.PASS, "verify_BeneficiaryNames case Passed");
		extent.endTest(test);
		extent.flush();
	}
	
	  @AfterMethod
	  public void tearDown(ITestResult result) throws IOException
	  {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(GenericFun.getProperty("ScreenShotpath")+result.getMethod().getMethodName()+".png"));
		test.log(LogStatus.FAIL, "Snapshot below: " + test.addScreenCapture(GenericFun.getProperty("ScreenShotpath")+result.getMethod().getMethodName()+".png"));
	  test.log(LogStatus.FAIL, result.getThrowable());
	  }
	   
	  }
		
}
