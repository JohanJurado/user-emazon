package com.example.emazon_microservice_user.user.domain.spi;

import com.example.emazon_microservice_user.user.domain.model.Role;

public interface IRolePersistencePort {

    Role findByName(String nameRole);

}
