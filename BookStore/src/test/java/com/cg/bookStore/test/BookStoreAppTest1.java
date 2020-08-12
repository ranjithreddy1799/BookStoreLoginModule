package com.cg.bookStore.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.bookStore.BookStoreApplication;
import com.cg.bookStore.dto.AdminSignupForm;
import com.cg.bookStore.dto.CustomerSignupForm;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.entity.CustomerInformation;
import com.cg.bookStore.exception.EmailExistsException;
import com.cg.bookStore.exception.InvalidLoginDetailsException;
import com.cg.bookStore.service.BookStoreService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = BookStoreApplication.class)
@AutoConfigureMockMvc
public class BookStoreAppTest1 {
	
	@Mock
	private BookStoreService service;
	
	@Mock
	private Admin admin;
	
	@Mock
	private AdminSignupForm adminForm;
	
	@Mock
	private CustomerSignupForm customerForm;
	
	@Mock
	private CustomerInformation customer;

	@Test
	public void adminLoginTest() throws  InvalidLoginDetailsException {
		when(service.loginAdmin("ranjithreddybn99@gmail.com", "Ranjith@1")).thenReturn(admin);
		assertEquals(admin,service.loginAdmin("ranjithreddybn99@gmail.com", "Ranjith@1"));
		
	}
	
	@Test
	public void adminSignupTest() throws EmailExistsException {
		when(service.addAdmin(adminForm)).thenReturn("Admin account created");
		assertEquals("Admin account created",service.addAdmin(adminForm));
	}
	
	@Test
	public void customerLoginTest() throws  InvalidLoginDetailsException {
		when(service.loginCustomer("ranjithreddybn99@gmail.com", "Ranjith@1")).thenReturn(customer);
		assertEquals(customer,service.loginCustomer("ranjithreddybn99@gmail.com", "Ranjith@1"));
	}
	
	@Test
	public void customerSignupTest() throws EmailExistsException {
		when(service.saveCustomer(customerForm)).thenReturn("Customer account created");
		assertEquals("Customer account created" , service.saveCustomer(customerForm));
	}
	
	
	
	
}
