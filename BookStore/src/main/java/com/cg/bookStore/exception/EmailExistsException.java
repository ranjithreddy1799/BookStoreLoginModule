package com.cg.bookStore.exception;

public class EmailExistsException extends Exception{
	
	
	public EmailExistsException(){
		super();
		
	}

	public EmailExistsException(String msg) {
		super(msg);
		
	}

}
