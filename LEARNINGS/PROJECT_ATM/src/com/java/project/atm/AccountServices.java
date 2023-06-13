package com.java.project.atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AccountServices {

	Scanner input = new Scanner(System.in);
	DecimalFormat amountFormat = new DecimalFormat("'$' ###,##0.00");

	double depositFund(double currentBalance) {
		System.out.println("Please enter the amount which you wolud like to deposit : ");
		double amount = input.nextDouble(), totalBalance = 0;
		if (currentBalance + amount >= 0) {
			totalBalance = initiateDepositFund(amount, currentBalance);
			System.out.println("You have deposited " + amountFormat.format(amount));
			System.out.println("Your new account balance is " + amountFormat.format(totalBalance));
		} else {
			System.out.println("Invalid Entry !!, please enter the correct amount");
		}
		return totalBalance;
	}

	private double initiateDepositFund(double amount, double currentBalance) {
		return currentBalance = currentBalance + amount;
	}

	public double withdrawFund(double currentBalance) {
		System.out.println("Please enter the amount which you would like to withdraw :");
		double amount = input.nextDouble();
		return initiateWithdrawFund(amount, currentBalance);
	}

	private double initiateWithdrawFund(double amount, double currentBalance) {
		if (currentBalance - amount >= 0) {
			currentBalance = currentBalance - amount;
			System.out.println("You have withdrawn " + amountFormat.format(amount));
			System.out.println("Your new account balance is " + amountFormat.format(currentBalance));
		} else {
			System.out.println(
					"Insufficient Balance!!, currently your account balance is " + amountFormat.format(currentBalance));
		}
		return currentBalance;
	}

}
