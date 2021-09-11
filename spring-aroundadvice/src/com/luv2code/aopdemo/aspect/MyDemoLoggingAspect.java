package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;
import com.luv2code.aopdemo.AroundAdviceDemo;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {


	private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info(("\n>>>> executing @Around advice on method  "+method));
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		try {
		result = theProceedingJoinPoint.proceed();
		}catch(Exception e) {
			myLogger.info(e.getMessage());
			
			//result = "continuing";
			throw e;
		}
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		myLogger.info(("\n===> duration : " + duration/1000.0 + " seconds "));
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountsAdvice(JoinPoint theJoinPoint){
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n>>>> executing AfterAdvice on method  "+method);
		
	}
	
	
	
	
	
	@AfterThrowing(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n>>>> executing afterthrowing advice on method  "+method);
		
		
		System.out.println("\n>>>> the exception is :   "+theExc);
	}
	
	
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










