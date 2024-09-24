package com.example.emazon_microservice_user.user.domain.spi;

import com.example.emazon_microservice_user.user.domain.model.User;

public interface IUserPersistencePort {

    User save(User user);

}
