package com.cg.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.dto.AdminSignupForm;
import com.cg.bookStore.dto.CustomerSignupForm;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exception.EmailExistsException;
import com.cg.bookStore.exception.InvalidLoginDetailsException;
import com.cg.bookStore.util.BookStoreConstants;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
@Transactional
public class BookStoreServiceImpl implements BookStoreService{
	
	@Autowired
	private BookStoreDao bookStoreDao;
	

	Logger logger = LoggerFactory.getLogger(BookStoreServiceImpl.class);
	

	@Override
	public Admin loginAdmin(String email, String password) throws InvalidLoginDetailsException {
		Admin admin = bookStoreDao.viewAdmin(email);
		logger.debug("doing login process");
		
		if (admin != null && admin.getPassword().contentEquals(password)){
			logger.info("User Authenticated for " + email);
			return admin;
		}
		throw new InvalidLoginDetailsException(BookStoreConstants.INVALID_ACCOUNT);
	}
	
	@Override
	public String encryptString(String str) {
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch;
		for (int idx = 0; idx < arr.length; ++idx) {
			ch = arr[idx] + 3;
			sb.append((char) ch);
		}
		return sb.toString();
	}
	
	
	
	
	@Override
	public String decryptString(String str) {
		char[] arr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int ch;
		for (int idx = 0; idx < arr.length; ++idx) {
			ch = arr[idx] - 3;
			sb.append((char) ch);
		}
		return sb.toString();
	}
	
	@Override
	public CustomerInformation loginCustomer(String email, String password) throws InvalidLoginDetailsException {
		CustomerInformation customer = bookStoreDao.viewCustomer(email);
		logger.debug("doing login process");
		
		if (customer != null && customer.getPassword().contentEquals(password)){
			logger.info("User Authenticated for " + email);
			return customer;
		}
		throw new InvalidLoginDetailsException(BookStoreConstants.INVALID_ACCOUNT);
	}


	@Override
	public String addAdmin(AdminSignupForm adminForm) throws EmailExistsException {
		
		//Matcher matcher = patternForPassword.matcher(adSgn.getPassword());
		boolean check=bookStoreDao.checkAdminByEmail(adminForm.getEmail());
		if(check==true)
		{
			throw new EmailExistsException(BookStoreConstants.EMAIL_EXISTS);
		}
		
		Admin admin = new Admin();
		Long idAdmin = bookStoreDao.getMaxAdminID()+1;
		admin.setAdminId(idAdmin);
		admin.setEmail(adminForm.getEmail());
		admin.setFullName(adminForm.getFullName());
		admin.setPassword(adminForm.getPassword());
	   
		
	    bookStoreDao.saveAdmin(admin);
	    
	    return BookStoreConstants.ADMIN_ACCOUNT_CREATED;
	}

	@Override
	public String saveCustomer(CustomerSignupForm customerForm) throws EmailExistsException {
		
		Date dateNow = new Date( );
		SimpleDateFormat objectOfSimpleDateFormat =new SimpleDateFormat ("hh:mm a',' E dd MMM yyyy");
		boolean check=bookStoreDao.checkCustomerByEmail(customerForm.getEmail());
		if(check==true)
		{
			throw new EmailExistsException(BookStoreConstants.EMAIL_EXISTS);
		}
		
		CustomerInformation customer = new CustomerInformation();
		long idCustomer = bookStoreDao.getMaxCustomerID()+1;
		customer.setCustomerId(idCustomer);
	    customer.setRegisterDate(objectOfSimpleDateFormat.format(dateNow));
	    customer.setAddress(customerForm.getAddress());
	    customer.setCity(customerForm.getCity());
	    customer.setCountry(customerForm.getCountry());
	    customer.setEmail(customerForm.getEmail());
	    customer.setFullName(customerForm.getFullName());
	    customer.setPassword(customerForm.getPassword());
	    customer.setPhoneNumber(customerForm.getPhoneNumber());
	    customer.setPinCode(customerForm.getPinCode());
	    
		bookStoreDao.saveCustomer(customer);
		
		return BookStoreConstants.CUSTOMER_ACCOUNT_CREATED;
	}

	@Override
	public String encryptUser(String email, String fullName) {
		return encryptString(email)+"-" +encryptString(fullName) ;
	}

	

}
