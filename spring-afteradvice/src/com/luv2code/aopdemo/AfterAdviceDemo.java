package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterAdviceDemo {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		
		List<Account> theAccounts = null;
		
		try {
				boolean tripWire = true;//if true then throw exception
				theAccountDAO.findAccounts(tripWire);
		}catch(Exception e) {
			System.out.println("\n\n main program ---> caught exception" + e);
		}
		System.out.println("\n\n Main Program: After ReturningDemoApp" );
		System.out.println(theAccounts);
		System.out.println("\n\n");
		
		
		
		// close the context
		context.close();
	}

}










