package com.example.emazon_microservice_user.user.domain.exception;

public class MaxiumPhoneSizeExceededException extends RuntimeException {

    private final int sizePhoneUser;

    public MaxiumPhoneSizeExceededException(String message, int sizePhoneUser) {
        super(message);
        this.sizePhoneUser = sizePhoneUser;
    }

    public int getSizePhoneUser(){
        return sizePhoneUser;
    }

}
