package com.ba.service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ba.dao.CustomerAccountDAO;

@Service
@Transactional(readOnly = true) //Class Level Transaction Management
public class CustomerAccountService {

	@Autowired
	CustomerAccountDAO customerAccountDAO;
//	@Transactional
//	1//select - read
//	@Transactional
//	2//select
//	@Transactional
//	3//select
	
	//update - write mode
	//delete - write mode
	//insert - write mode
	
	//This Service Class is calling the DAO Method
	//Annotation Based Transaction Handling
	//If its an Annotation based transaction handling, then
	//usually we need to enable The TransactionManager in the Traditional
	//Spring Application.
	//But, since we are under SpringBoot umbrella. this umbrella
	//will take care of enabling the transaction manager automatically
	//at the time of  bootstrapping
	//Without SpringBOOT
	//Method Level Transaction Management
	
	//Required (default): 
		//My method needs a transaction, either open one new tx for me or use an existing one 
	//Supports: 
		//I don’t really care if a transaction is open or not, i can work either way
	//Mandatory: I’m not going to open up a transaction myself, 
	//but I’m going to cry if no one else opened one up
	//Require_new: I want my completely own transaction 
	//Not_Supported: I really don’t like transactions, 
	//I will even try and suspend a current, running transaction
	//Never: I’m going to cry if someone else started up a transaction 
	@Transactional(readOnly = false,noRollbackFor =  {ArithmeticException.class},propagation = Propagation.REQUIRED )
	//Flagged as a transaction handling scope
	//In-Line Method Level Transaction settings will take priority
	//over class level transaction demarcation
	//rollBackFor ={}
	//noRollBackFor={}
	//rollBackForClassName={}
	//noRollBackForClassName={}
	public void depositAmount(int cid, int amount) {
		customerAccountDAO.depositAmount(cid, amount);
	}
	
//	select -> readOnly Operation
}
