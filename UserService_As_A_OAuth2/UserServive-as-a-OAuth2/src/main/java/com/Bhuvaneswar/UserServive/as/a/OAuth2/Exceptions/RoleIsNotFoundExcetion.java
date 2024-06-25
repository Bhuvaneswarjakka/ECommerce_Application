package com.Bhuvaneswar.UserServive.as.a.OAuth2.Exceptions;

public class RoleIsNotFoundExcetion extends RuntimeException
{
    public RoleIsNotFoundExcetion() {
        super();
    }

    public RoleIsNotFoundExcetion(String message) {
        super(message);
    }

    public RoleIsNotFoundExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleIsNotFoundExcetion(Throwable cause) {
        super(cause);
    }

    protected RoleIsNotFoundExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
