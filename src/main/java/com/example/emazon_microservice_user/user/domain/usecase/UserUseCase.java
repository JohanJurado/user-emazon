package com.example.emazon_microservice_user.user.domain.usecase;

import com.example.emazon_microservice_user.user.domain.api.IUserServicePort;
import com.example.emazon_microservice_user.user.domain.exception.RoleNotFoundException;
import com.example.emazon_microservice_user.user.domain.model.Role;
import com.example.emazon_microservice_user.user.domain.model.User;
import com.example.emazon_microservice_user.user.domain.spi.IRolePersistencePort;
import com.example.emazon_microservice_user.user.domain.spi.IUserPersistencePort;
import com.example.emazon_microservice_user.user.domain.util.constants.ExceptionConstantsUser;
import com.example.emazon_microservice_user.user.domain.util.constants.RoleEnum;
import com.example.emazon_microservice_user.user.domain.util.constants.Validation;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;
    private final IRolePersistencePort rolePersistencePort;


    public UserUseCase(IUserPersistencePort userPersistencePort, IRolePersistencePort rolePersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public User createWarehouseAssistant(User user) {
        Role auxBodega = rolePersistencePort.findByName(RoleEnum.WAREHOUSE_ASSISTANT.toString());
        if (auxBodega == null){
            throw new RoleNotFoundException(ExceptionConstantsUser.ROLE_NOT_FOUND.getMessage(), RoleEnum.WAREHOUSE_ASSISTANT.name());
        }
        user.setUserRole(auxBodega);

        Validation validation = new Validation();

        return userPersistencePort.save(validation.validation(user));
    }

}
