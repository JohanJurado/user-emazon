package com.example.emazon_microservice_user.user.domain.exception;

public class TheIdDocumentUserCannotBeEmptyException extends RuntimeException {
    public TheIdDocumentUserCannotBeEmptyException(String message) {
        super(message);
    }
}
