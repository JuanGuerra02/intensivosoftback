package com.intensivo.softc.exception;

public class FacException extends Exception{
    public FacException() {
    }

    public FacException(String message) {
        super(message);
    }

    public FacException(String message, Throwable cause) {
        super(message, cause);
    }

    public FacException(Throwable cause) {
        super(cause);
    }

    public FacException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
