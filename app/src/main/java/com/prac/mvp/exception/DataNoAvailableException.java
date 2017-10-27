package com.prac.mvp.exception;



public class DataNoAvailableException extends Exception {

    public DataNoAvailableException(String s) {
        super(s);
    }

    public DataNoAvailableException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public DataNoAvailableException(Throwable cause) {
        super(cause);
    }

    public DataNoAvailableException() {
    }
}
