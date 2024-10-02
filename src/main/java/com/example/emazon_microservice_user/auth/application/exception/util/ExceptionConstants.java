package com.example.emazon_microservice_user.auth.application.exception.util;

public enum ExceptionConstants {

    UNAUTHORIZED("{ \"error\": \" The request does not have authentication credentials or the credentials are incorrect.\" }"),
    FORBIDDEN("{ \"error\": \"You do not have permission to access this resource.\" }"),
    USER_NOT_FOUND("User not found");

    private final String message;

    ExceptionConstants(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
