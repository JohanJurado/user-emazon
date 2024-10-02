package com.example.emazon_microservice_user.user.domain.exception;

public class TheLastNameUserCannotBeEmptyException extends RuntimeException {
    public TheLastNameUserCannotBeEmptyException(String message) {
        super(message);
    }
}
