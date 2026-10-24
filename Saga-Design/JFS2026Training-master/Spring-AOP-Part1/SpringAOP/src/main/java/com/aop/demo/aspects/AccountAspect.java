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
	
	@Before("execution(public void com.aop.demo.service.AccountService.addAccount(..))")
	public void addSecurity(JoinPoint jp) {
	
		System.out.println(jp.getSignature());
		System.out.println(jp.getClass());
		System.out.println(jp.getArgs());
		System.out.println(jp.getTarget());
		System.out.println("Security Is Logged");
	}
	
	//Filter
	//f1 f2 f3 Servlet
	//@Around("execution(public void com.aop.demo.service.AccountService.addAccount(..))")
	public void addTransaction(ProceedingJoinPoint pjp) throws Throwable {
		
		long l1 =  System.currentTimeMillis();
		System.out.println("Before"+l1);
		long l2 = System.currentTimeMillis();
		System.out.println("Before"+l2);
		System.out.println("Time Taken" + (l2-l1));
		
		//System.out.println("Transaction Management");
	}
}
