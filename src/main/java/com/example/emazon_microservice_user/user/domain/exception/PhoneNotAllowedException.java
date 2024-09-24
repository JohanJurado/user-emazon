package com.example.emazon_microservice_user.user.domain.exception;

public class PhoneNotAllowedException extends RuntimeException {
    public PhoneNotAllowedException(String message) {
        super(message);
    }
}
