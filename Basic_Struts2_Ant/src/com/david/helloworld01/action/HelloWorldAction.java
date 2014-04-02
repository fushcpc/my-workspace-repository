package com.david.helloworld01.action;

import com.david.helloworld01.model.MessageStore;
import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {

	private static int helloCount;

	private MessageStore message;

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public MessageStore getMessage() {
		return message;
	}

	public void setMessage(MessageStore message) {
		this.message = message;
	}

	// Get method can't be static!
	public int getHelloCount() {
		return helloCount;
	}

	public void setHelloCount(int helloCount) {
		HelloWorldAction.helloCount = helloCount;
	}

	@Override
	public String execute() throws Exception {
		message = new MessageStore();
		if (userName != null) {
			message.setMessage(message.getMessage() + " " + userName);
		}
		helloCount++;
		return SUCCESS;
	}
}
