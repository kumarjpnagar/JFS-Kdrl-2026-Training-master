package com.aop.demo.service;

import org.springframework.stereotype.Service;

import com.aop.demo.model.Account;

@Service
public class AccountService  {
	//Account account
	public void addAccount(Account account) {
		
		System.out.println("Account Added Successfully!"+account.getAccountName());
	}
	
	public void addAccount(Account account,int x) {
		
		System.out.println("Account Added Successfully!"+account.getAccountName());
		System.out.println(x);
	}
	public void addAccount() {
		
		System.out.println("Account Added  Successfully Without Parameter!");
	}
}
