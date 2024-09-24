package com.example.emazon_microservice_user.user.domain.exception;

public class EmailNotAllowedException extends RuntimeException {
    public EmailNotAllowedException(String message) {
        super(message);
    }
}
