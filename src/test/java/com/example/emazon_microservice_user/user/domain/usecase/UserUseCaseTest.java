package com.example.emazon_microservice_user.user.domain.usecase;

import com.example.emazon_microservice_user.user.domain.exception.EmailAlreadyExistException;
import com.example.emazon_microservice_user.user.domain.exception.IdDocumentAlreadyExistException;
import com.example.emazon_microservice_user.user.domain.exception.RoleNotFoundException;
import com.example.emazon_microservice_user.user.domain.model.Role;
import com.example.emazon_microservice_user.user.domain.model.User;
import com.example.emazon_microservice_user.user.domain.spi.IRolePersistencePort;
import com.example.emazon_microservice_user.user.domain.spi.IUserPersistencePort;
import com.example.emazon_microservice_user.user.domain.util.constants.RoleEnum;
import com.example.emazon_microservice_user.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @Mock
    private IRolePersistencePort rolePersistencePort;

    @InjectMocks
    private UserUseCase userUseCase;

    @Test
    void shouldThrowRoleNotFoundExceptionWhenRoleDoesNotExist() {
        User user = new User();
        when(rolePersistencePort.findByName(RoleEnum.WAREHOUSE_ASSISTANT.toString())).thenReturn(null);

        assertThrows(RoleNotFoundException.class, () -> userUseCase.createWarehouseAssistant(user));

        verify(rolePersistencePort, times(1)).findByName(RoleEnum.WAREHOUSE_ASSISTANT.toString());
    }

    @Test
    void shouldThrowEmailAlreadyExistExceptionWhenEmailAlreadyExists() {
        Constants constants = new Constants();
        User user = constants.USER1;

        Role role = new Role();
        when(rolePersistencePort.findByName(RoleEnum.WAREHOUSE_ASSISTANT.toString())).thenReturn(role);
        when(userPersistencePort.findByEmailUser(user.getEmailUser().toLowerCase())).thenReturn(new User());

        assertThrows(EmailAlreadyExistException.class, () -> userUseCase.createWarehouseAssistant(user));

        verify(userPersistencePort, times(1)).findByEmailUser(user.getEmailUser().toLowerCase());
    }

    @Test
    void shouldThrowIdDocumentAlreadyExistExceptionWhenIdDocumentAlreadyExists() {
        Constants constants = new Constants();
        User user = constants.USER1;

        Role role = new Role();
        when(rolePersistencePort.findByName(RoleEnum.WAREHOUSE_ASSISTANT.toString())).thenReturn(role);
        when(userPersistencePort.findByEmailUser(user.getEmailUser().toLowerCase())).thenReturn(null);
        when(userPersistencePort.findByIdDocumentUser(user.getIdDocumentUser())).thenReturn(new User());

        assertThrows(IdDocumentAlreadyExistException.class, () -> userUseCase.createWarehouseAssistant(user));

        verify(userPersistencePort, times(1)).findByIdDocumentUser(user.getIdDocumentUser());
    }

    @Test
    void shouldSaveUserWhenNoValidationErrors() {
        Constants constants = new Constants();
        User user = constants.USER1;

        Role role = constants.ROLE1;
        when(rolePersistencePort.findByName(RoleEnum.WAREHOUSE_ASSISTANT.toString())).thenReturn(role);
        when(userPersistencePort.findByEmailUser(user.getEmailUser().toLowerCase())).thenReturn(null);
        when(userPersistencePort.findByIdDocumentUser(user.getIdDocumentUser())).thenReturn(null);
        when(userPersistencePort.save(any(User.class))).thenReturn(user);

        User savedUser = userUseCase.createWarehouseAssistant(user);

        verify(userPersistencePort, times(1)).save(user);
        verify(rolePersistencePort, times(1)).findByName(RoleEnum.WAREHOUSE_ASSISTANT.toString());
    }
}
