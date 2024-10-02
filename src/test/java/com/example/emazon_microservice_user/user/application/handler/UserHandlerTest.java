package com.example.emazon_microservice_user.user.application.handler;

import com.example.emazon_microservice_user.user.application.dto.UserRequest;
import com.example.emazon_microservice_user.user.application.dto.UserResponse;
import com.example.emazon_microservice_user.user.application.mapper.IUserMapper;
import com.example.emazon_microservice_user.user.domain.api.IUserServicePort;
import com.example.emazon_microservice_user.user.domain.model.User;
import com.example.emazon_microservice_user.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserHandlerTest {

    @Mock
    private IUserMapper userMapper;

    @Mock
    private IUserServicePort userServicePort;

    @InjectMocks
    private UserHandler userHandler;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    void shouldSaveWarehouseAssistant() {
        UserRequest userRequest = new UserRequest();
        Constants constants = new Constants();
        User user = constants.USER1;

        when(userMapper.toUser(userRequest)).thenReturn(user);
        when(userServicePort.createWarehouseAssistant(user)).thenReturn(user);
        when(userMapper.toUserResponse(user)).thenReturn(new UserResponse());

        userHandler.saveWarehouseAssistant(userRequest);

        verify(userMapper, times(1)).toUser(userRequest);
        verify(userServicePort, times(1)).createWarehouseAssistant(user);
        verify(userMapper, times(1)).toUserResponse(user);
    }
}
