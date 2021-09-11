package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice

	
	//match any addAccount Method in any class
	//@Before("execution(public void addAccount())")
	
	
	//match only addAccount method in AccountDAO class
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	
	
	//match methods starting with add keyword
	//@Before("execution(public void add*())")
	
	
	//match any return type method starting with add
	//@Before("execution(* add*())")
	
	
	//match any method starting with add and with parameter of Account class type
	//@Before("execution(* add*(com.luv2code.aopdemo.Account))")
	
	
	//match all methods inside package dao
	//@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	
	
	
	//match any number of arguments after account type
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	
	
	//match any number of arguments
	//@Before("execution(* add*(..))")
	
	
	
	//match only all methods inside all classes inside the same package
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
	}
}










