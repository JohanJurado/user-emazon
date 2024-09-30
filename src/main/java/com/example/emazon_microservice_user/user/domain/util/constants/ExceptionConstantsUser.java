package com.example.emazon_microservice_user.user.domain.util.constants;

public enum ExceptionConstantsUser {

    MAXIUM_PHONE_SIZE_EXCEEDED("The phone has exceeded the maximum number allowed: 13 < "),
    EMAIL_ALREADY_EXIST("The email of user already exist:"),
    ID_DOCUMENT_ALREADY_EXIST("The id document of user already exist:"),
    PHONE_NOT_ALLOWED("The phone format entered is not allowed"),
    ROLE_NOT_FOUND("Rol not found: "),
    EMAIL_NOT_ALLOWED("The email format entered is not allowed"),
    NOT_OF_LEGAL_AGE("The date of user is less than 18"),
    NAME_CANNOT_BE_EMPTY("The name cannot be empty"),
    LAST_NAME_CANNOT_BE_EMPTY("The last name cannot be empty"),
    DATE_CANNOT_BE_EMPTY("The date cannot be empty"),
    EMAIL_CANNOT_BE_EMPTY("The email cannot be empty"),
    ID_DOCUMENT_CANNOT_BE_EMPTY("The id document cannot be empty"),
    PHONE_CANNOT_BE_EMPTY("The phone cannot be empty"),
    PASSWORD_CANNOT_BE_EMPTY("The password cannot be empty");

    private final String message;

    ExceptionConstantsUser(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }



}
