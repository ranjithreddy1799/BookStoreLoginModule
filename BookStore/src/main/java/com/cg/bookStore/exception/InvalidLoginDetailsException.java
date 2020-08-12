package com.cg.bookStore.exception;

public class InvalidLoginDetailsException extends Exception{

	
	public InvalidLoginDetailsException(){
		super();
		
	}

	public InvalidLoginDetailsException(String message) {
		super(message);
		
	}

}
