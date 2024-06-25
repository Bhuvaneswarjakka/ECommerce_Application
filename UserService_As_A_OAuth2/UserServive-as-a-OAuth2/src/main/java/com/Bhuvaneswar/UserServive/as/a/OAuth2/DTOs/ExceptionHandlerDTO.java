package com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionHandlerDTO
{
    private String message;
    private int httpCode;

    public ExceptionHandlerDTO(String message, int httpCode) {
        this.message = message;
        this.httpCode = httpCode;
    }
}
