package com.cg.bookStore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.bookStore.exception.EmailExistsException;
import com.cg.bookStore.exception.InvalidLoginDetailsException;
import com.cg.bookStore.util.BookStoreConstants;


@RestControllerAdvice
public class LoginExceptionAdvice {

	Logger logger = LoggerFactory.getLogger(Exception.class);
	
	@ExceptionHandler(value = {InvalidLoginDetailsException.class})
	@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = BookStoreConstants.INVALID_ACCOUNT)
	public ErrorInfo  handleException1(Exception ex) {
		logger.error(ex.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(ex.getMessage());
		return error;
	}
	
	
	@ExceptionHandler(value = {EmailExistsException.class})
	@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason = BookStoreConstants.EMAIL_EXISTS)
	public ErrorInfo  handleException2(Exception ex) {
		logger.error(ex.getMessage());
		ErrorInfo error = new ErrorInfo();
		error.setMessage(ex.getMessage());
		return error;
	}

	
	
	
	
	
	
}
