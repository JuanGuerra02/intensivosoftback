package com.intensivo.softc.exception;

public class ConException extends  Exception{
    public ConException() {
    }

    public ConException(String message) {
        super(message);
    }

    public ConException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConException(Throwable cause) {
        super(cause);
    }

    public ConException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
