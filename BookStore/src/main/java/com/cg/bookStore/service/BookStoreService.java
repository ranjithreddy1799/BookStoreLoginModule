package com.cg.bookStore.service;

import com.cg.bookStore.dto.AdminSignupForm;
import com.cg.bookStore.dto.CustomerSignupForm;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exception.EmailExistsException;
import com.cg.bookStore.exception.InvalidLoginDetailsException;

public interface BookStoreService {
	
	
	Admin loginAdmin(String email, String password) throws InvalidLoginDetailsException;

	String addAdmin(AdminSignupForm adminForm) throws EmailExistsException;

	String saveCustomer(CustomerSignupForm customerForm) throws EmailExistsException;

	CustomerInformation loginCustomer(String email, String password) throws InvalidLoginDetailsException;

	public String encryptUser(String email , String fullName);
	
	public String encryptString(String str);
	
	public String decryptString(String str);
	
	

}
