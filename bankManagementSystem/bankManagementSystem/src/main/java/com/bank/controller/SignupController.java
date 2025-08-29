package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.Customer;
import com.bank.repository.CustomerRepo;
import com.bank.service.SignupService;
import com.bank.service.SignupServiceImpl;


@Controller
//@RestController
public class SignupController {
	
	@Autowired
	private SignupService signupService;
	
	@GetMapping("/")
	public String display() {
		return "index.html";
	}
	
	
	@PostMapping("/createAccount")
	@ResponseBody
	public String createAccount(Customer customer) {
		System.out.println(customer);
		String result = signupService.validate(customer);
		return result;
	}
	
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers(){
		return signupService.getCustomers();
	}
}
