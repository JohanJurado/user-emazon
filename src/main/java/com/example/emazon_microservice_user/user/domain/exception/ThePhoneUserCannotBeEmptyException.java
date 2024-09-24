package com.example.emazon_microservice_user.user.domain.exception;

public class ThePhoneUserCannotBeEmptyException extends RuntimeException {
    public ThePhoneUserCannotBeEmptyException(String message) {
        super(message);
    }
}
