package com.greatlearning.bank.service;

import com.greatlearning.bank.model.UserAccount;

public interface InternetBanking {

	public void checkBalance(UserAccount account);

	public boolean deposit(UserAccount account, double amount); //

	public boolean withdraw(UserAccount account, double amount); //

	public boolean transfer(UserAccount fromAccount, UserAccount toAccount, double amount, int otp); //

	public boolean validateLogin(String accountNo, String password, UserAccount account); //

	public int generateOTP();

}