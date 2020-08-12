package com.cg.bookStore.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.dto.LoginForm;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exception.InvalidLoginDetailsException;
import com.cg.bookStore.service.BookStoreService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerLoginRestController {
	
	@Autowired
	private BookStoreService ser;

	
	private Map<String, CustomerInformation> authMapCustomer =  new HashMap<>();;
	
	
	@PostMapping("/customerlogin")
	public String getCustomerLogin(@RequestBody LoginForm loginForm) throws InvalidLoginDetailsException {
		CustomerInformation customer = ser.loginCustomer(loginForm.getEmail(),loginForm.getPassword());
        
		String token = ser.encryptUser(customer.getEmail(), customer.getFullName());
		authMapCustomer.put(token, customer);
		return token;
	}

}
