package com.cg.bookStore.dao;

import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.CustomerInformation;

public interface BookStoreDao {
	
	public CustomerInformation viewCustomer(String email);
	
	public Admin viewAdmin(String email);
	
	public boolean saveCustomer(CustomerInformation customer);
	
	public boolean saveAdmin(Admin admin);
	
	boolean checkAdminByEmail(String email);
	
	boolean checkCustomerByEmail(String email);
	
	public Long getMaxCustomerID();
	
	public Long getMaxAdminID();
	
	

}
