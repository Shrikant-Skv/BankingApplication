package com.greatlearning.bank.main;

import java.util.Scanner;

import com.greatlearning.bank.model.UserAccount;
import com.greatlearning.bank.service.InternetBanking;
import com.greatlearning.bank.service.InternetBankingService;

public class DriverClass {

	public static void main(String[] args) {

		UserAccount account1 = new UserAccount("05361843", "password123", 5000.00);
		UserAccount account2 = new UserAccount("05361844", "password123", 7000.00);

		InternetBanking service = new InternetBankingService(); // new MobileBankingService();

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to InternetBanking ... !");

		System.out.println(" Please enter the account no");
		String accountNo = sc.nextLine();

		System.out.println(" Please enter the password");
		String password = sc.nextLine();

		if (service.validateLogin(accountNo, password, account1)) {
			System.out.println("Login Successfull..!");
			int option;
			do {
				System.out.println("-------------------------------------");
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Transfer");
				System.out.println("0. Logout");
				System.out.println("-------------------------------------");
				System.out.println("Enter the option to perform");
				option = sc.nextInt();
				switch (option) {
				case 0:
					option = 0;
					break;
				case 1:
					service.checkBalance(account1);
					break;
				case 2:
					System.out.println("Enter the amount to be deposited");
					double amount = sc.nextDouble();
					service.deposit(account1, amount);
					break;
				case 3:
					System.out.println("Enter the amount to be withdrawn");
					double withdrawAmount = sc.nextDouble();
					service.withdraw(account1, withdrawAmount);
					break;
				case 4:
					System.out.println("Generating OTP .. !");
					int otp = service.generateOTP();
					System.out.println("Generated OTP is " + otp);
					account1.setOtp(otp);
					System.out.println("Enter the amount to be transferred");
					double transferAmount = sc.nextDouble();
					service.transfer(account1, account2, transferAmount, otp);
					break;
				default:
					System.out.println("Select valid option");
					break;
				}

			} while (option != 0);
		} else {
			System.out.println("Invalid credentials");
		}

	}

}