package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {


	
	@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning="result")
	public void afterReturningfindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n>>>> executing afterreturning advice on method  "+method);
		
		
		//System.out.println("\n>>>> result is "+result);
		
		if(!result.isEmpty()) {
			Account account = result.get(0);
			account.setLevel("zero");
			account.setName("daffy duck");
		}
		
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n>>>> result is "+result);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for(Account account : result) {
			String theUppername = account.getName().toUpperCase();
			account.setName(theUppername);
		}
		
	}











	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("method : " + methodSignature);

		//display method arguments
		Object[] args = theJoinPoint.getArgs();
		for(Object arg : args) {
			System.out.println(arg);
			
			if(arg instanceof Account) {
				Account theAccount = (Account) arg;
				System.out.println("account name "+theAccount.getName());
			}
		}
	
}
}










