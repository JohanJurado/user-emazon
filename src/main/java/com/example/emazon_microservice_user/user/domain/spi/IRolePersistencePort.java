package com.example.emazon_microservice_user.user.domain.spi;

import com.example.emazon_microservice_user.user.domain.model.Role;

import java.util.Optional;

public interface IRolePersistencePort {

    Role findByName(String nameRole);

}
