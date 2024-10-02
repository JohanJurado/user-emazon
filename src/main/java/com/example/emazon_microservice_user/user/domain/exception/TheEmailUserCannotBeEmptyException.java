package com.example.emazon_microservice_user.user.domain.exception;

public class TheEmailUserCannotBeEmptyException extends RuntimeException {
    public TheEmailUserCannotBeEmptyException(String message) {
        super(message);
    }
}
