package com.example.emazon_microservice_user.user.domain.exception;

public class RoleNotFoundException extends RuntimeException {

    private final String nameRole;

    public RoleNotFoundException(String message, String nameRole) {
        super(message);
        this.nameRole = nameRole;
    }

    public String getNameRole(){
        return nameRole;
    }

}
