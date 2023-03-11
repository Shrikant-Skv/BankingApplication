package com.greatlearning.bank.service;

public class OTPGenerator {
	public int generateOTP() {
		return (int) (Math.random() * 9000)+ 1000; //0.2345 or 0.6532
	}
}
