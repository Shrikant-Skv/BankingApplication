package com.greatlearning.bank.service;

import com.greatlearning.bank.model.UserAccount;

public class InternetBankingService implements InternetBanking {

	private static final double MIN_BALANCE = 1000;
	private static final double MAX_DEPOSIT_AMOUNT = 1000000;

	@Override
	public void checkBalance(UserAccount account) {
		if (account.getBalance() < MIN_BALANCE) {
			System.out.println("Please maintian account minimum balance of " + MIN_BALANCE);
		}
		System.out.println("Current account balance is :" + account.getBalance());
	}

	@Override
	public boolean deposit(UserAccount account, double amount) {
		if (amount > 0 && amount <= MAX_DEPOSIT_AMOUNT) {
			double currBalance = account.getBalance();
			double newBalance = currBalance + amount;
			account.setBalance(newBalance);
			System.out.println("Amount deposited successfully..!");
			System.out.println("Updated account balance is" + account.getBalance());
			return true;
		}
		return false;
	}

	@Override
	public boolean withdraw(UserAccount account, double amount) {
		if (amount > 0 && amount <= account.getBalance()) {
			double currBalance = account.getBalance();
			double newBalance = currBalance - amount;
			account.setBalance(newBalance);
			System.out.println("Amount withdrawn successfully..!");
			System.out.println("Updated account balance is" + account.getBalance());
			return true;
		} else {
			System.out.println("Withrawl Failed.Insufficient Balance");
			return false;
		}

	}

	@Override
	public boolean transfer(UserAccount fromAccount, UserAccount toAccount, double amount, int otp) {
		if (otp == fromAccount.getOtp()) {
			System.out.println("OTP validation Successfull");
			if (amount > 0 && amount <= fromAccount.getBalance()) {

				double fromCurrBalance = fromAccount.getBalance();
				double fromNewBalance = fromCurrBalance - amount;
				fromAccount.setBalance(fromNewBalance);

				double toCurrBalance = toAccount.getBalance();
				double toNewBalance = toCurrBalance + amount;
				toAccount.setBalance(toNewBalance);

				System.out.println("Amount transffered successfully..!");

				System.out.println("Updated from account balance is" + fromAccount.getBalance());
				System.out.println("Updated to account balance is" + toAccount.getBalance());
				return true;
			} else {
				System.out.println("Withrawl Failed.Insufficient Balance");
				return false;
			}

		} else {
			System.out.println("OTP validation Failed");
			return false;
		}
	}

	@Override
	public boolean validateLogin(String accountNo, String password, UserAccount account) {
		if (accountNo.equals(account.getAccountNo()) && password.equals(account.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public int generateOTP() {
		OTPGenerator generator = new OTPGenerator();
		return generator.generateOTP();
	}

}