package com.greatlearning.bank.model;

public class UserAccount {
	private String accountNo;
	private String password;
	private double balance;
	private int otp;

	public UserAccount(String accountNo, String password, double balance) {
		this.accountNo = accountNo;
		this.password = password;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
}