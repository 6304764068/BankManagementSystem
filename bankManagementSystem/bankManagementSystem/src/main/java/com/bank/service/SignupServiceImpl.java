package com.bank.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.config.MailConfig;
import com.bank.entity.Customer;
import com.bank.exceptionHandler.CustomerAlreadyExist;
import com.bank.repository.CustomerRepo;

@Service
public class SignupServiceImpl implements SignupService{

	@Autowired
	private CustomerRepo custolerRepo;
	
	@Autowired
	private MailConfig mailConfig;
	
	@Override
	public String validate(Customer customer) {
		
		List<Customer> customers = custolerRepo.findAll();
		
		Stream<Customer> s =  customers.stream();
		
		Long emailcount = customers.stream().filter((c)->c.getEmail().equals(customer.getEmail())).count();
		Long mobileCount = customers.stream().filter((c)->c.getMobile().equals(customer.getMobile())).count();
		Long aadharCount = customers.stream().filter((c)->c.getAadhar().equals(customer.getAadhar())).count();
		Long panCount = customers.stream().filter((c)->c.getPan().equals(customer.getPan())).count();
	
		System.out.println(emailcount+" "+mobileCount+" "+aadharCount+" "+panCount);
		
		if(emailcount != 0) {
			throw new CustomerAlreadyExist("Email exists");
		}
		else if(mobileCount !=0) {
			throw new CustomerAlreadyExist("Mobile exists");
		}
		else if(aadharCount !=0) {
			throw new CustomerAlreadyExist("Aadhar exists");
		}
		else if(panCount !=0) {
			throw new CustomerAlreadyExist("Pan exists");
		}
		
		else {
			customer.setAccountNum(generateAccountNumber());
			int pin = generateOtp();
			customer.setPin(pin);
			Customer customer1 = custolerRepo.save(customer);
			mailConfig.sendMail(customer1.getEmail(), "Union Bank of India ", "pin : "+customer1.getPin()+" \n Account number: "+customer1.getAccountNum());
			return "customer account created successfully";
		}
	}
	
	private static Long generateAccountNumber() {
		Random r = new Random();
		long num =  r.nextLong(100000000000l);
		if(num<10000000000l) {
			num+=10000000000l;
		}
		return num;
	}
	
	private static int generateOtp() {
		Random r = new Random();
		int num = r.nextInt(10000);
		if(num<1000) {
			num+=1000;
		}
		return num;
	}

	@Override
	public List<Customer> getCustomers() {
		return custolerRepo.findAll();
	}
	
}
