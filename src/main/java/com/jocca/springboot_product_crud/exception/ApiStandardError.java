package com.jocca.springboot_product_crud.exception;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

public class ApiStandardError {

    private HttpStatus status;
    private List<String> errors;
    private String message;
    private String apiPath;
    private Instant Instant;

    public ApiStandardError() {
    }

    public Instant getInstant() {
        return Instant;
    }

    public void setInstant(Instant instant) {
        Instant = instant;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }


}
