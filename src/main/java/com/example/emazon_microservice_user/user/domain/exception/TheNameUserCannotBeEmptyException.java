package com.example.emazon_microservice_user.user.domain.exception;

public class TheNameUserCannotBeEmptyException extends RuntimeException {
    public TheNameUserCannotBeEmptyException(String message) {
        super(message);
    }
}
