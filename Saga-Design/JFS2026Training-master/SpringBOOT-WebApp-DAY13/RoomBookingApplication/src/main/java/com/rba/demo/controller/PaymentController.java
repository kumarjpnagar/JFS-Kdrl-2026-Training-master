package com.rba.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pc")
public class PaymentController {

	@GetMapping("/welcome")
	@ResponseBody
	public String modeOfPayment() {
		return "Credit/Debit Card Online Payment";
	}
}
