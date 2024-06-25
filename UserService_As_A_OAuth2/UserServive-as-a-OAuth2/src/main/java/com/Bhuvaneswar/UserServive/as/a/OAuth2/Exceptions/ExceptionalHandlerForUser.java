package com.Bhuvaneswar.UserServive.as.a.OAuth2.Exceptions;

import com.Bhuvaneswar.UserServive.as.a.OAuth2.DTOs.ExceptionHandlerDTO;
import com.Bhuvaneswar.UserServive.as.a.OAuth2.Entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionalHandlerForUser
{
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity handleInvalidCredentialsException(InvalidCredentialsException I)
    {
        ExceptionHandlerDTO exceptionHandlerDTO=new ExceptionHandlerDTO(
                I.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionHandlerDTO, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TokenInvalidException.class)
    public ResponseEntity handleTokenInvalidException(TokenInvalidException I)
    {
        ExceptionHandlerDTO exceptionHandlerDTO=new ExceptionHandlerDTO(
                I.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionHandlerDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleIsNotFoundExcetion.class)
    public ResponseEntity handleRoleIsNotFoundExcetion(RoleIsNotFoundExcetion R)
    {
        ExceptionHandlerDTO exceptionHandlerDTO=new ExceptionHandlerDTO(
                R.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionHandlerDTO, HttpStatus.NOT_FOUND);
    }
}
