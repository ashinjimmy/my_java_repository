package com.java.project.atm;

public class UserInfo {

	private long accountNumber, mobileNumber;
	private int userPin;
	private double savingsAccBalance = 2000, currentAccBalance = 2000;
	private String mailId;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getUserPin() {
		return userPin;
	}

	public void setUserPin(int userPin) {
		this.userPin = userPin;
	}

	public double getSavingsAccBalance() {
		return savingsAccBalance;
	}

	public void setSavingsAccBalance(double savingsAccBalance) {
		this.savingsAccBalance = savingsAccBalance;
	}

	public double getCurrentAccBalance() {
		return currentAccBalance;
	}

	public void setCurrentAccBalance(double currentAccBalance) {
		this.currentAccBalance = currentAccBalance;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

}
