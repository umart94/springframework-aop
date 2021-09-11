package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(int thevalue,Account theAccount,boolean vipFlag) {
		
		System.out.println(getClass() + ": ACCOUNTDAO - ADDACCOUNT");
		
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork");
		
		return true;
	}
}
