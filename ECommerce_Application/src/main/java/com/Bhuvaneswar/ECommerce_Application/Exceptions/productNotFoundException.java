package com.Bhuvaneswar.ECommerce_Application.Exceptions;

public class productNotFoundException extends RuntimeException
{
    public productNotFoundException() {
        super();
    }

    public productNotFoundException(String message) {
        super(message);
    }

    public productNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public productNotFoundException(Throwable cause) {
        super(cause);
    }

    protected productNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
