package com.jocca.springboot_product_crud.exception;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    // Method to handle IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiStandardError> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest servletRequest) {
        // Return a custom error message with HTTP 400 status
        List<String> e = List.of("Argumentos  incorretos passados para o método de destino"); ;
        ApiStandardError error = new ApiStandardError();
        error.setErrors(e);
        error.setApiPath(servletRequest.getRequestURI());
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setInstant(Instant.now());
        error.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Method to handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiStandardError> handleGeneralException(Exception ex, HttpServletRequest servletRequest) {
        // Return a custom error message with HTTP 500 status
        List<String> e = List.of("Erro inesperado para o método de destino" ); ;
        ApiStandardError error = new ApiStandardError();
        error.setErrors(e);
        error.setApiPath(servletRequest.getRequestURI());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setInstant(Instant.now());
        error.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);

    }



}
