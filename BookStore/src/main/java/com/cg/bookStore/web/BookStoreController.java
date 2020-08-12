package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.dto.AdminSignupForm;
import com.cg.bookStore.dto.CustomerSignupForm;
import com.cg.bookStore.exception.EmailExistsException;
import com.cg.bookStore.service.BookStoreService;
import com.cg.bookStore.util.BookStoreConstants;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookStoreController {
	
	@Autowired
	BookStoreService bookStoreService;
	
	
	@PostMapping(value="/admin/addAdmin",consumes= {"application/json"})
	public String addAdmin(@RequestBody AdminSignupForm adminForm) throws EmailExistsException {
		try 
		{	
			 bookStoreService.addAdmin(adminForm);
			 return BookStoreConstants.ADMIN_ACCOUNT_CREATED;
		}
		catch(NullPointerException bookStoreException)
		{
			throw new EmailExistsException(BookStoreConstants.EMAIL_EXISTS);
		}
	}
	
	
	
	@PostMapping("/addcustomer")
	public String addCustomer(@RequestBody CustomerSignupForm customerForm) throws EmailExistsException {
		try 
		{	
			 bookStoreService.saveCustomer(customerForm);
			 return BookStoreConstants.CUSTOMER_ACCOUNT_CREATED;
		}
		catch(NullPointerException bookStoreException)
		{
			throw new EmailExistsException(BookStoreConstants.EMAIL_EXISTS);
		}
	

}
	
}
