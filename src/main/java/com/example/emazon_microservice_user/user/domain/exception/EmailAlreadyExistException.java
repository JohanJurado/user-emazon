package com.example.emazon_microservice_user.user.domain.exception;

public class EmailAlreadyExistException extends RuntimeException {

    private final String emailUser;

    public EmailAlreadyExistException(String message, String emailUser){
        super(message);
        this.emailUser = emailUser;
    }

    public String getEmailUser(){
        return emailUser;
    }

}
