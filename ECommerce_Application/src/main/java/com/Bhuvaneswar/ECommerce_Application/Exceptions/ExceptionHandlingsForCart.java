package com.Bhuvaneswar.ECommerce_Application.Exceptions;

import com.Bhuvaneswar.ECommerce_Application.DTOs.ExceptionResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.controller.CartController;
import com.Bhuvaneswar.ECommerce_Application.controller.ProductController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class ExceptionHandlingsForCart
{
    @ExceptionHandler(NoCartFoundWithUserException.class)
    public ResponseEntity handleNoCartFoundWithUserException(NoCartFoundWithUserException pe)
    {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                pe.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity handleInvalidInputException(InvalidInputException pe)
    {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                pe.getMessage(),
                400
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }
}
