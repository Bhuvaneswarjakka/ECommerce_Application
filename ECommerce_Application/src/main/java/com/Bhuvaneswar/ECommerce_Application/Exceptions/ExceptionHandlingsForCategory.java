package com.Bhuvaneswar.ECommerce_Application.Exceptions;

import com.Bhuvaneswar.ECommerce_Application.DTOs.ExceptionResponseDTO;
import com.Bhuvaneswar.ECommerce_Application.controller.CategoryController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CategoryController.class)
public class ExceptionHandlingsForCategory
{
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity handleCategoryNotFoundException(CategoryNotFoundException c)
    {
        ExceptionResponseDTO exceptionResponseDTO=new ExceptionResponseDTO(
                c.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }
}
