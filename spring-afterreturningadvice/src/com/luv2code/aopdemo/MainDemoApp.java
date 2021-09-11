package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		Account account = new Account("muhammad umar tariq","2");
		// call the business method
		theAccountDAO.addAccount(1,account,true);
		//theAccountDAO.doWork();
		//theAccountDAO.getName();//no pointcut should match on getter
		MembershipDAO membershipDAO = context.getBean("membershipDAO",MembershipDAO.class);
		//membershipDAO.addAccount();
		//membershipDAO.addAccountBoolean();
		membershipDAO.matchAnyMethodExample();
		// close the context
		context.close();
	}

}










