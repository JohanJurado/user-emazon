package com.example.emazon_microservice_user.user.domain.exception;

public class NotOfLegalAgeException extends RuntimeException {
    public NotOfLegalAgeException(String message) {
        super(message);
    }
}
