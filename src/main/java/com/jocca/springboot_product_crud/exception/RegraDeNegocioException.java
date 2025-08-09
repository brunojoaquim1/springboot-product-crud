package com.jocca.springboot_product_crud.exception;

public abstract class RegraDeNegocioException extends RuntimeException {
    public RegraDeNegocioException(String message) {
        super(message);
    }
}
