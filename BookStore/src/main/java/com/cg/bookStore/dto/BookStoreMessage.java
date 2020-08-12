package com.cg.bookStore.dto;

public class BookStoreMessage {
	
	
	private String message;

	public BookStoreMessage(String mesage) {
		super();
		this.message = mesage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
