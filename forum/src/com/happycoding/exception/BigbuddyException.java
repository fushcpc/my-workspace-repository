package com.happycoding.exception;

/**
 * @author DavidChen(陈基明) 电话：13480721426 Email: cjmiou@gmail.com
 * @version 2010-4-28  下午02:08:11
 */
@SuppressWarnings("serial")
public class BigbuddyException extends RuntimeException {

	public BigbuddyException() {
		super();
	}

	public BigbuddyException(String message, Throwable cause) {
		super(message, cause);
	}

	public BigbuddyException(String message) {
		super(message);
	}

	public BigbuddyException(Throwable cause) {
		super(cause);
	}

}
