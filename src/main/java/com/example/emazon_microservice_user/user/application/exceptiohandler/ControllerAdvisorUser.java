package com.example.emazon_microservice_user.user.application.exceptiohandler;

import com.example.emazon_microservice_user.user.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisorUser {

    private static final String MESSAGE = "Message";

    @ExceptionHandler(EmailNotAllowedException.class)
    public ResponseEntity<Map<String, String>> handleEmailNotAllowedException(
            EmailNotAllowedException emailNotAllowedException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, emailNotAllowedException.getMessage()));
    }

    @ExceptionHandler(MaxiumPhoneSizeExceededException.class)
    public ResponseEntity<Map<String, String>> handleMaxiumPhoneSizeExceededException(
            MaxiumPhoneSizeExceededException maxiumPhoneSizeExceededException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, maxiumPhoneSizeExceededException.getMessage()+maxiumPhoneSizeExceededException.getSizePhoneUser()));
    }

    @ExceptionHandler(NotOfLegalAgeException.class)
    public ResponseEntity<Map<String, String>> handleNotOfLegalAgeException(
            NotOfLegalAgeException notOfLegalAgeException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, notOfLegalAgeException.getMessage()));
    }

    @ExceptionHandler(PhoneNotAllowedException.class)
    public ResponseEntity<Map<String, String>> handlePhoneNotAllowedException(
            PhoneNotAllowedException phoneNotAllowedException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, phoneNotAllowedException.getMessage()));
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRoleNotFoundException(
            RoleNotFoundException roleNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, roleNotFoundException.getMessage()));
    }

    @ExceptionHandler(TheEmailUserCannotBeEmptyException.class)
    public ResponseEntity<Map<String, String>> handleTheEmailUserCannotBeEmptyException(
            TheEmailUserCannotBeEmptyException theEmailUserCannotBeEmptyException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, theEmailUserCannotBeEmptyException.getMessage()));
    }

    @ExceptionHandler(TheIdDocumentUserCannotBeEmptyException.class)
    public ResponseEntity<Map<String, String>> handleTheIdDocumentUserCannotBeEmptyException(
            TheIdDocumentUserCannotBeEmptyException theIdDocumentUserCannotBeEmptyException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, theIdDocumentUserCannotBeEmptyException.getMessage()));
    }

    @ExceptionHandler(TheLastNameUserCannotBeEmptyException.class)
    public ResponseEntity<Map<String, String>> handleTheLastNameUserCannotBeEmptyException(
            TheLastNameUserCannotBeEmptyException theLastNameUserCannotBeEmptyException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, theLastNameUserCannotBeEmptyException.getMessage()));
    }

    @ExceptionHandler(TheNameUserCannotBeEmptyException.class)
    public ResponseEntity<Map<String, String>> handleTheNameUserCannotBeEmptyException(
            TheNameUserCannotBeEmptyException theNameUserCannotBeEmptyException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, theNameUserCannotBeEmptyException.getMessage()));
    }

    @ExceptionHandler(ThePasswordUserCannotBeEmptyException.class)
    public ResponseEntity<Map<String, String>> handleThePasswordUserCannotBeEmptyException(
            ThePasswordUserCannotBeEmptyException thePasswordUserCannotBeEmptyException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, thePasswordUserCannotBeEmptyException.getMessage()));
    }

    @ExceptionHandler(ThePhoneUserCannotBeEmptyException.class)
    public ResponseEntity<Map<String, String>> handleThePhoneUserCannotBeEmptyException(
            ThePhoneUserCannotBeEmptyException thePhoneUserCannotBeEmptyException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, thePhoneUserCannotBeEmptyException.getMessage()));
    }

    @ExceptionHandler(TheDateUserCannotBeEmptyException.class)
    public ResponseEntity<Map<String, String>> handleTheDateUserCannotBeEmptyException(
            TheDateUserCannotBeEmptyException theDateUserCannotBeEmptyException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, theDateUserCannotBeEmptyException.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(
            UserNotFoundException userNotFoundException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, userNotFoundException.getMessage()));
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExistException(
            EmailAlreadyExistException emailAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, emailAlreadyExistException.getMessage()+" "+emailAlreadyExistException.getEmailUser()));
    }

    @ExceptionHandler(IdDocumentAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleIdDocumentAlreadyExistException(
            IdDocumentAlreadyExistException idDocumentAlreadyExistException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(MESSAGE, idDocumentAlreadyExistException.getMessage()+" "+idDocumentAlreadyExistException.getIdDocumentUser()));
    }

}

