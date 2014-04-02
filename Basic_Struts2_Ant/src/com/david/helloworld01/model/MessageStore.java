package com.david.helloworld01.model;

public class MessageStore {
	private String message;

	public MessageStore() {
		setMessage("Hello Struts User");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message + " (from toString)";
	}
}
