package com.paultamayo.exception;

public class DataBaseException extends Exception {

    private static final long serialVersionUID = -5196133418009308856L;

    public DataBaseException() {
        super();
    }

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataBaseException(Throwable cause) {
        super(cause);
    }

}
