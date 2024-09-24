package com.example.emazon_microservice_user.user.domain.exception;

public class TheDateUserCannotBeEmptyException extends RuntimeException {
    public TheDateUserCannotBeEmptyException(String message) {
        super(message);
    }
}
