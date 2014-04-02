package com.titan.exception;

public class IncompleteConversationalSate extends Exception {

    private static final long serialVersionUID = 8155737985422136112L;

    public IncompleteConversationalSate() {
        super();
    }

    public IncompleteConversationalSate(String errMsg) {
        super(errMsg);
    }
}
