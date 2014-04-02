package com.titan.exception;

public class PaymentException extends Exception {

    private static final long serialVersionUID = -9006699539303839724L;

    public PaymentException() {
        super();
    }

    public PaymentException(String errMsg) {
        super(errMsg);
    }
}
