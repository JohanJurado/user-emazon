package com.example.emazon_microservice_user.user.application.handler;

import com.example.emazon_microservice_user.user.application.dto.UserRequest;
import com.example.emazon_microservice_user.user.application.dto.UserResponse;

public interface IUserHandler {

    UserResponse saveWarehouseAssistant(UserRequest userRequest);

}
