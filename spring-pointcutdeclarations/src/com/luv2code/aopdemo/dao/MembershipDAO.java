package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
public void addAccount() {
		
		System.out.println(getClass() + ": ADDACCOUNT");
		
	}

public boolean addAccountBoolean() {
	
	System.out.println(getClass() + ": ADDACCOUNTBOOLEAN");
	return true;
}


public boolean matchAnyMethodExample() {
	
	System.out.println(getClass() + ": MATCHANYMETHODEXAMPLE");
	return true;
}
}
