package com.example.emazon_microservice_user.user.domain.util.constants;

import com.example.emazon_microservice_user.user.domain.exception.*;
import com.example.emazon_microservice_user.user.domain.model.User;
import com.example.emazon_microservice_user.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ValidationTest {

    private final Validation validation = new Validation();

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        User user = new User();
        user.setNameUser("");

        assertThrows(TheNameUserCannotBeEmptyException.class, () -> validation.validation(user));
    }

    @Test
    void shouldThrowExceptionWhenLastNameIsEmpty() {
        Constants constants = new Constants();
        User user = constants.USER1;
        user.setLastNameUser("");

        assertThrows(TheLastNameUserCannotBeEmptyException.class, () -> validation.validation(user));
    }

    @Test
    void shouldThrowExceptionWhenIdDocumentIsEmpty() {
        Constants constants = new Constants();
        User user = constants.USER1;
        user.setIdDocumentUser(null);

        assertThrows(TheIdDocumentUserCannotBeEmptyException.class, () -> validation.validation(user));
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsEmpty() {
        Constants constants = new Constants();
        User user = constants.USER1;
        user.setPhoneUser("");

        assertThrows(ThePhoneUserCannotBeEmptyException.class, () -> validation.validation(user));
    }

    @Test
    void shouldThrowExceptionWhenUserIsNotOfLegalAge() {
        Constants constants = new Constants();
        User user = constants.USER1;
        user.setDateUser(LocalDate.now().minusYears(15));

        assertThrows(NotOfLegalAgeException.class, () -> validation.validation(user));
    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid() {
        Constants constants = new Constants();
        User user = constants.USER1;
        user.setEmailUser("invalid_email");

        assertThrows(EmailNotAllowedException.class, () -> validation.validation(user));
    }

    @Test
    void shouldThrowExceptionWhenPhoneIsInvalid() {
        Constants constants = new Constants();
        User user = constants.USER1;
        user.setPhoneUser("invalid_phone");

        assertThrows(PhoneNotAllowedException.class, () -> validation.validation(user));
    }

    @Test
    void shouldPassValidationWhenUserIsValid() {
        Constants constants = new Constants();
        User user = constants.USER1;

        validation.validation(user);
    }

    @Test
    void shouldThrowMaxiumPhoneSizeExceededException() {
        Constants constants = new Constants();
        User user = constants.USER1;
        user.setPhoneUser("22222222222222222222222222222");

        assertThrows(MaxiumPhoneSizeExceededException.class, () -> validation.validation(user));

    }
}
