package com.dgsh.rest.web.services.restfulwebservices.helloworld;

public class HelloBean {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloBean [message=" + message + "]";
	}

	public HelloBean(String message) {
		super();
		this.message = message;
	}

	public HelloBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
