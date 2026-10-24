package com.aop.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ReusableAspect {

	@Pointcut("execution(public void com.aop.demo.service.AccountService.addAccount())")
	public void dummy1() {}
	
	@Pointcut("execution(public void com.aop.demo.service.AccountService.addAccount())")
	public void dummy2() {}
}
