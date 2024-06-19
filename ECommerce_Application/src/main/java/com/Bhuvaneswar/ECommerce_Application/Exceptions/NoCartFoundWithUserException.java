package com.Bhuvaneswar.ECommerce_Application.Exceptions;

public class NoCartFoundWithUserException extends RuntimeException
{
    public NoCartFoundWithUserException() {
        super();
    }

    public NoCartFoundWithUserException(String message) {
        super(message);
    }

    public NoCartFoundWithUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoCartFoundWithUserException(Throwable cause) {
        super(cause);
    }

    protected NoCartFoundWithUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
