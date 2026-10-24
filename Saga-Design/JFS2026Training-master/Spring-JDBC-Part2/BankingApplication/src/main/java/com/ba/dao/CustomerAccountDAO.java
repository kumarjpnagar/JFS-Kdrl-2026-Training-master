package com.ba.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.SavepointManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class CustomerAccountDAO {

	//1. Programmatic Transaction Management
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	//Declarative Way of Managing the Transaction
	//Caller of this Method is the Service Class
	//So, from the ServiceClass caller we need
	//To Activate the Transaction Scope
	public void depositAmount(int cid, int amount) {
		
		jdbcTemplate.update("update customer_acct set amount= amount + ? where customerid= ?",amount,cid);
		int x = 10/0; //don't apply try catch
	}
	
	//Programmatic Handling of Transaction Management
	public void depositAmount1(int cid, int amount) {
		//jdbcTemplate.update("update customer_acct set amount= amount + ? where customerid= ?",new Object[] {cid,amount});
		
		transactionTemplate.execute(new TransactionCallback<Object>() {
			
			@Override
			public Object doInTransaction(TransactionStatus status) {
				SavepointManager sm = null;
				try {
				jdbcTemplate.update("update customer_acct set amount= amount + ? where customerid= ?",amount,cid);
				//AutoCommit is always ON
				jdbcTemplate.update("update customer_acct set amount= amount + ? where customerid= ?",amount,cid);
				
				//sm = (SavepointManager)status.createSavepoint();
				
				jdbcTemplate.update("update customer_acct set amount= amount + ? where customerid= ?",amount,cid);
				
			
				int x = 10/0; //ArithmeticException
				
				System.out.println(x);
				}catch(ArithmeticException ae) {
					System.out.println(ae.getMessage());
					status.setRollbackOnly();
					//status.rollbackToSavepoint(sm);
				}
				
				return null;
			}
		});
		
//		Lambda Style Of Code
//		TransactionCallback<Object> tc = (status)->{
//			try {
//				jdbcTemplate.update("update customer_acct set amount= amount + ? where customerid= ?",amount,cid);
//				//AutoCommit is always ON
//				
//				int x = 10/0; //ArithmeticException
//				
//				System.out.println(x);
//				}catch(ArithmeticException ae) {
//					System.out.println(ae.getMessage());
//				}
//				
//			
//			return null;
//		};
//		
//		transactionTemplate.execute(tc);
		
		
	}
}
