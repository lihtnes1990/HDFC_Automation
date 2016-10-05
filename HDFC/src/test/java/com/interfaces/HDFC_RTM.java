package com.interfaces;

import java.io.IOException;

public interface HDFC_RTM {
	public void verify_tapon_myAccount() throws InterruptedException;
	public void verify_tapon_customerID() throws InterruptedException;
	public void verify_enter_customerID() throws InterruptedException, IOException;
	public void verify_tapon_continueButton() throws InterruptedException;
	public void verify_enter_userPassword() throws InterruptedException, IOException;
	public void verify_tocheckimageconfirmation() throws InterruptedException;
	public void verify_taponLoginbutton() throws InterruptedException;
	public void verify_DashboardpageRedirection();
	public void verify_UserAccountNumber() throws InterruptedException, IOException;
	public void verify_UserAccountBalance() throws IOException, InterruptedException;
	public void verify_FundTransferpageRedirection();
	public void verify_tapon_NEFTTransaction() throws InterruptedException;
	public void verify_tapBeneficiaryDrpDownbox() throws InterruptedException;
	public void verify_BeneficiaryNames() throws IOException;
}
