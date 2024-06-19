package com.Bhuvaneswar.ECommerce_Application.Exceptions;

import com.Bhuvaneswar.ECommerce_Application.DTOs.ExceptionResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.controller.ProductController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ExceptionHandlingsForProducts
{
    @ExceptionHandler(productNotFoundException.class)
    public ResponseEntity handleProductNotFoundException(productNotFoundException pe)
    {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                pe.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoProductPresentException.class)
    public ResponseEntity handleNoProductFoundException(NoProductPresentException pe)
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
