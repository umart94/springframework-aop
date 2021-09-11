package com.luv2code.aopdemo.dao;

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
	
	
	
}
