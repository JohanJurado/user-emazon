package com.example.emazon_microservice_user.user.domain.util.constants;

import com.example.emazon_microservice_user.user.domain.exception.*;
import com.example.emazon_microservice_user.user.domain.model.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class Validation {

    public User validation(User user){

        if (user.getNameUser().trim().isEmpty()){
            throw new TheNameUserCannotBeEmptyException(ExceptionConstantsUser.NAME_CANNOT_BE_EMPTY.getMessage());
        }
        if (user.getLastNameUser().trim().isEmpty()){
            throw new TheLastNameUserCannotBeEmptyException(ExceptionConstantsUser.LAST_NAME_CANNOT_BE_EMPTY.getMessage());
        }
        if (user.getIdDocumentUser() == null){
            throw new TheIdDocumentUserCannotBeEmptyException(ExceptionConstantsUser.ID_DOCUMENT_CANNOT_BE_EMPTY.getMessage());
        }
        if (user.getPhoneUser().trim().isEmpty()) {
            throw new ThePhoneUserCannotBeEmptyException(ExceptionConstantsUser.PHONE_CANNOT_BE_EMPTY.getMessage());
        } else {
            if (user.getPhoneUser().length() > 13){
                throw new MaxiumPhoneSizeExceededException(ExceptionConstantsUser.MAXIUM_PHONE_SIZE_EXCEEDED.getMessage(), user.getPhoneUser().length());
            }
            if (!this.isPhoneNumberValid(user.getPhoneUser())){
                throw new PhoneNotAllowedException(ExceptionConstantsUser.PHONE_NOT_ALLOWED.getMessage());
            }
        }
        if (user.getDateUser() == null) {
            throw new TheDateUserCannotBeEmptyException(ExceptionConstantsUser.DATE_CANNOT_BE_EMPTY.getMessage());
        } else if (!this.isOfLegalAge(user.getDateUser())){
                throw new NotOfLegalAgeException(ExceptionConstantsUser.NOT_OF_LEGAL_AGE.getMessage());
        }
        if (user.getEmailUser().trim().isEmpty()) {
            throw new TheEmailUserCannotBeEmptyException(ExceptionConstantsUser.EMAIL_CANNOT_BE_EMPTY.getMessage());
        } else if (!this.isEmailValid(user.getEmailUser())){
                throw new EmailNotAllowedException(ExceptionConstantsUser.EMAIL_NOT_ALLOWED.getMessage());
        }
        if (user.getPasswordUser().trim().isEmpty()){
            throw new ThePasswordUserCannotBeEmptyException(ExceptionConstantsUser.PASSWORD_CANNOT_BE_EMPTY.getMessage());
        }

        return user;
    }

    public boolean isEmailValid(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"; // Expresión regular para correo electrónico
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public boolean isPhoneNumberValid(String phoneNumber) {
        String phoneRegex = "^\\+?\\d{1,13}$"; // Expresión regular para el número de teléfono
        Pattern pattern = Pattern.compile(phoneRegex);
        return pattern.matcher(phoneNumber).matches();
    }

    public boolean isOfLegalAge(LocalDate date) {
        return Period.between(date, LocalDate.now()).getYears() >= 18;
    }

}
