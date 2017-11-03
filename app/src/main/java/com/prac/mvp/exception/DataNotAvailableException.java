package com.prac.mvp.exception;



public class DataNotAvailableException extends Exception {

    public DataNotAvailableException(String s) {
        super(s);
    }

    public DataNotAvailableException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public DataNotAvailableException(Throwable cause) {
        super(cause);
    }

    public DataNotAvailableException() {
    }
}
