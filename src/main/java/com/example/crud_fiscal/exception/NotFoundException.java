package com.example.crud_fiscal.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NotFoundException extends ErrorException{
    public NotFoundException(String code, String message) {
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }

    public NotFoundException(String code, String message, ErrorDto data) {
        super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }
}
