package com.example.emazon_microservice_user.user.domain.exception;

public class IdDocumentAlreadyExistException extends RuntimeException {

    private final String idDocumentUser;

    public IdDocumentAlreadyExistException(String message, String idDocumentUser){
        super(message);
        this.idDocumentUser = idDocumentUser;
    }

    public String getIdDocumentUser(){
        return idDocumentUser;
    }

}
