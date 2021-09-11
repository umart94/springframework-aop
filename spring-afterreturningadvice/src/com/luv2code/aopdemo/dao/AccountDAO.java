package com.luv2code.aopdemo.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	
	private String name;
	private String serviceCode;

	public void addAccount(int thevalue,Account theAccount,boolean vipFlag) {
		
		System.out.println(getClass() + ": ACCOUNTDAO - ADDACCOUNT");
		
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork");
		
		return true;
	}

	public String getName() {
		System.out.println(getClass() + " inside getname");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " inside getServiceCode");
		
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	
	public List<Account> findAccounts(){
		List<Account> myAccounts = new ArrayList<>();
		Account account1 = new Account("muhammad umar tariq","platinum");
		Account account2 = new Account("tariq","platinum");
		Account account3 = new Account("talha","platinum");
		Account account4 = new Account("faisal","gold");
		Account account5 = new Account("atiq","silver");
		Account account6 = new Account("faraz","platinum");
		Account account7 = new Account("uzair","gold");
		Account account8 = new Account("rizwan","silver");
		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);
		myAccounts.add(account4);
		myAccounts.add(account5);
		myAccounts.add(account6);
		myAccounts.add(account7);
		myAccounts.add(account8);
		return myAccounts;
	}
	
	
}
