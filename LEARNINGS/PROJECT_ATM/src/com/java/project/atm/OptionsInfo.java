package com.java.project.atm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionsInfo extends UserInfo {

	Scanner userInput = new Scanner(System.in);
	HashMap<Long, Integer> userData = new HashMap<>(); // To store the acc no. & pin
	DecimalFormat amountFormat = new DecimalFormat("'$' ###,##0.00");
	AccountServices as = new AccountServices();

	void userLogin() {

		System.out.println("\n==========================================");
		System.out.println("******  WELCOME TO ATM PROJECT  **********");
		System.out.println("==========================================");

		System.out.println("To login into your account, provide your account number and pin ");
		System.out.println("Please type your account number here : ");
		setAccountNumber(userInput.nextLong());

		System.out.println("Please type your pin number here : ");
		setUserPin(userInput.nextInt());

		userData.put(2480013530567L, 34562);
		userData.put(6485279230567L, 56562);

		if (userData.containsKey(getAccountNumber()) && userData.get(getAccountNumber()) == getUserPin()) {
			System.out.println("\nHi " + getAccountNumber() + " welcome back to your account services");
			getAccountType();
		} else {
			System.out.println("Invalid account number or pin, please enter the valid credentials.");
			userLogin();
		}

	}

	private void getAccountType() {

		System.out.println("\nPlease choose one of the following option ");
		System.out.println("Type 1 - Savings Account");
		System.out.println("Type 2 - Current Account");
		System.out.println("Type 3 - Change Pin");
		System.out.println("Type 4 - Change Mobile Number");
		System.out.println("Type 5 - Chnage Mail Id");
		System.out.println("Type 6 - Exit");
		System.out.println("Choice : ");

		int selection = userInput.nextInt();

		switch (selection) {
		case 1:
			getSavingsAccount();
			break;

		case 2:
			getCurrentAccount();
			break;

		case 6:
			System.out.println("Successfully exist from your account transaction...");
			userLogin();
			break;
		}
	}


	private void getSavingsAccount() {

		double currentBalance = getSavingsAccBalance();

		System.out.println("\nYou are in Savings Account, choose your options");
		System.out.println("Type 1 - View balance");
		System.out.println("Type 2 - Deposit fund");
		System.out.println("Type 3 - Withdraw fund");
		System.out.println("Type 4 - Exit ");
		System.out.println("Choice : ");

		int choice = userInput.nextInt();
		double totlaBalance;

		switch (choice) {
		case 1:
			System.out.println("Your current bank balance is " + amountFormat.format(getSavingsAccBalance()));
			getAccountType();
			break;

		case 2:
			totlaBalance = as.depositFund(currentBalance);
			setSavingsAccBalance(totlaBalance);
			getAccountType();
			break;

		case 3:
			totlaBalance = as.withdrawFund(currentBalance);
			setSavingsAccBalance(totlaBalance);
			getAccountType();
			break;
			
		case 4:
			System.out.println("Successfully exist from your account transaction...");
			getAccountType();
			break;

		default:
			break;
		}

	}
	
	
	
	private void getCurrentAccount() {

		double currentBalance = getCurrentAccBalance();

		System.out.println("\nYou are in Current Account, choose your options");
		System.out.println("Type 1 - View balance");
		System.out.println("Type 2 - Deposit fund");
		System.out.println("Type 3 - Withdraw fund");
		System.out.println("Type 4 - Exit ");
		System.out.println("Choice : ");

		int choice = userInput.nextInt();
		double totlaBalance;

		switch (choice) {
		case 1:
			System.out.println("Your current bank balance is " + amountFormat.format(getCurrentAccBalance()));
			getAccountType();
			break;

		case 2:
			totlaBalance = as.depositFund(currentBalance);
			setSavingsAccBalance(totlaBalance);
			getAccountType();
			break;

		case 3:
			totlaBalance = as.withdrawFund(currentBalance);
			setSavingsAccBalance(totlaBalance);
			getAccountType();
			break;
			
		case 4:
			System.out.println("Successfully exist from your account transaction...");
			getAccountType();
			break;

		default:
			break;
		}
	}

}
