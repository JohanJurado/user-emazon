package com.example.emazon_microservice_user.auth.application.service;

import com.example.emazon_microservice_user.auth.application.dto.AuthenticationRequest;
import com.example.emazon_microservice_user.auth.application.dto.AuthenticationResponse;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.UserEntity;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository.IUserJpaRepository;
import com.example.emazon_microservice_user.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    @Mock
    private IUserJpaRepository userJpaRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthenticationService authenticationService;

    private UserEntity user;
    private AuthenticationRequest authenticationRequest;

    @BeforeEach
    void setUp() {
        Constants constants = new Constants();
        user = constants.USER_ENTITY1;

        authenticationRequest = new AuthenticationRequest(user.getEmailUser(), user.getPasswordUser());
    }

    @Test
    void shouldReturnAuthenticationResponseWithToken() {
        when(userJpaRepository.findByEmailUser(authenticationRequest.getEmailUser())).thenReturn(Optional.of(user));
        when(jwtService.generateToken(any(UserEntity.class), anyMap())).thenReturn("jwt-token");

        AuthenticationResponse response = authenticationService.login(authenticationRequest);

        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        assertEquals("jwt-token", response.getToken());
    }
}
