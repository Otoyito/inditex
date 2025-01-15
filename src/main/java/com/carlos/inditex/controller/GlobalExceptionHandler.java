package com.carlos.inditex.controller;

import com.carlos.inditex.exception.DateFormatException;
import com.carlos.inditex.exception.ErrorDTO;
import com.carlos.inditex.exception.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DateFormatException.class)
    public ResponseEntity<ErrorDTO> handleDateTimeParseException(DateTimeParseException e) {
        return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProductNotFoundException(ProductNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDTO> handleGenericError(Exception e) {
        return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage()));
    }
}
