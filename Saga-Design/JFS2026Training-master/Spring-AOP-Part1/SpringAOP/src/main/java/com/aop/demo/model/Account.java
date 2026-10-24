package com.aop.demo.model;


public class Account {

	private int accountId;
	private String accountName;
	private int accountbalance;
	
	public Account(int accountId, String accountName, int accountbalance) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountbalance = accountbalance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getAccountbalance() {
		return accountbalance;
	}
	public void setAccountbalance(int accountbalance) {
		this.accountbalance = accountbalance;
	}
	
	
	
}
