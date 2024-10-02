package com.example.emazon_microservice_user.user.domain.api;

import com.example.emazon_microservice_user.user.domain.model.User;

public interface IUserServicePort {

    User createWarehouseAssistant(User user);
}
