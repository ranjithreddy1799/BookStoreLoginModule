package com.cg.bookStore.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.dto.LoginForm;
import com.cg.bookStore.entity.Admin;
import com.cg.bookStore.exception.InvalidLoginDetailsException;
import com.cg.bookStore.service.BookStoreService;
import com.cg.bookStore.util.BookStoreConstants;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminLoginRestController {

	
	@Autowired
	private BookStoreService ser;

	private Map<String, Admin> authMap =  new HashMap<>();
	
	@GetMapping("/get")
	public String abc() {
		return "abcd";
	}
	
	@PostMapping("/adminlogin")
	public String getAdminLogin(@RequestBody LoginForm loginForm) throws InvalidLoginDetailsException {
		Admin admin = ser.loginAdmin(loginForm.getEmail(),loginForm.getPassword());
		String token = ser.encryptUser(admin.getEmail(), admin.getFullName());
		authMap.put(token,admin);
		return token;
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(@RequestHeader("email") String token,
			HttpServletRequest req) {
		authMap.remove(token);
		return BookStoreConstants.LOGOUT;
	}
	
	
}
