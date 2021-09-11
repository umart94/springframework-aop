package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundAdviceDemo {

	private static Logger myLogger = Logger.getLogger(AroundAdviceDemo.class.getName());
	
	
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		boolean tripWire = true;
		myLogger.info(  theFortuneService.getFortune(tripWire) );
		
		
		// close the context
		context.close();
	}

}










