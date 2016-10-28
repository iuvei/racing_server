package com.racing.util;

public class NoLoginException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoLoginException(String msg) {
		super(msg);
	}

	public NoLoginException() {
		super();
	}
	
}
