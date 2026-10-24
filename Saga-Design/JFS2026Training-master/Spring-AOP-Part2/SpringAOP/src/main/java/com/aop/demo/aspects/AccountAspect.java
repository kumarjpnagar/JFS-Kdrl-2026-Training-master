package com.aop.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import com.aop.demo.model.Account;

@Aspect
@Configuration
public class AccountAspect {
	
	//@After("execution(public void com.aop.demo.service.AccountService.addAccount())")
	
	//@After("com.aop.demo.aspects.ReusableAspect.dummy1()")
	public void addLogging() {
		
		System.out.println("Method Is Logged");
	}
	
	@Before("execution(public void com.aop.demo.service.AccountService.addAccount(..)) && args(acc,dummy)")
	public void addSecurity(JoinPoint jp,Account acc, int dummy) {
		System.out.println("Inside the Before Aspect Advice!");
		System.out.println(acc.getAccountName());
		acc.setAccountName("Sabari");
		System.out.println(dummy);
		dummy = 999;
	System.out.println(acc.getAccountName());
//		System.out.println(jp.getSignature());
//		System.out.println(jp.getClass());
//		System.out.println(jp.getArgs());
//		System.out.println(jp.getTarget());
		System.out.println("Security Is Logged");
	}
	
	
	//@Before("execution(public void com.aop.demo.service.AccountService.addAccount(..)) ")
	public void addSecurity(JoinPoint jp) {
		System.out.println("Inside the Before Aspect Advice!");
		Object[] obj  = jp.getArgs();
		Account acc = (Account)obj[0];
		System.out.println(acc.getAccountName());
		acc.setAccountName("Sabari");
	    System.out.println(acc.getAccountName());
//		System.out.println(jp.getSignature());
//		System.out.println(jp.getClass());
//		System.out.println(jp.getArgs());
//		System.out.println(jp.getTarget());
		System.out.println("Security Is Logged");
	}
	//Filter
	//f1 f2 f3 Servlet
	//@Around("execution(public void com.aop.demo.service.AccountService.addAccount(..))")
	public void addTransaction(ProceedingJoinPoint pjp) throws Throwable {
		Object[] obj  = pjp.getArgs();
		Account acc = (Account)obj[0];
		int tmp = (Integer) obj[1];
		System.out.println(tmp);
		//newly created Object
		Account a = new Account(106,"Sachin",345);
		int pi = 314;
		System.out.println(acc.getAccountName());
		long l1 =  System.currentTimeMillis();
		System.out.println("Before"+l1);
		//pjp.proceed();
		pjp.proceed(new Object[] {a,pi});
		
		long l2 = System.currentTimeMillis();
		System.out.println("Before"+l2);
		System.out.println("Time Taken" + (l2-l1));
		
		//System.out.println("Transaction Management");
	}
}
