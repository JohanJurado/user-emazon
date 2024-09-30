package com.example.emazon_microservice_user.user.application.handler;

import com.example.emazon_microservice_user.user.application.dto.UserRequest;
import com.example.emazon_microservice_user.user.application.dto.UserResponse;
import com.example.emazon_microservice_user.user.application.mapper.IUserMapper;
import com.example.emazon_microservice_user.user.domain.api.IUserServicePort;
import com.example.emazon_microservice_user.user.domain.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserMapper userMapper;
    private final IUserServicePort userServicePort;
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public UserResponse saveWarehouseAssistant(UserRequest userRequest) {

        User user = userMapper.toUser(userRequest);
        if (user.getPasswordUser() == null || user.getPasswordUser().isEmpty()){
            user.setPasswordUser(null);
        } else {
            user.setPasswordUser(passwordEncoder.encode(user.getPasswordUser()));
        }

        return userMapper.toUserResponse(userServicePort.createWarehouseAssistant(user));
    }

}
