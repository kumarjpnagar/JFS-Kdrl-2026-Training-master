package com.rba.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/pc")
public class PaymentController {

	@GetMapping("/welcome")
	@ResponseBody
	public String modeOfPayment() {
		int x = 10/0;
		return "Credit/Debit";
	}
	
//	@ExceptionHandler(value = {ArithmeticException.class})
//	@ResponseBody
//	public String handleAnyException3(Exception ex) {
//		
//		return "This is an Arithmetic Error: "+ex.getMessage();
//	}
}
