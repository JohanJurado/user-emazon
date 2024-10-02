package com.example.emazon_microservice_user.user.domain.exception;

public class ThePasswordUserCannotBeEmptyException extends RuntimeException {
    public ThePasswordUserCannotBeEmptyException(String message) {
        super(message);
    }
}
