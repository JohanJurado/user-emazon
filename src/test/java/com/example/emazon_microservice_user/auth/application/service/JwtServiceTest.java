package com.example.emazon_microservice_user.auth.application.service;

import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.UserEntity;
import com.example.emazon_microservice_user.util.Constants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JwtServiceTest {

    private JwtService jwtService;
    private UserEntity user;

    @BeforeEach
    void setUp() {
        Constants constants = new Constants();

        jwtService = new JwtService();
        user = constants.USER_ENTITY1;
    }

    @Test
    void shouldGenerateToken() {
        Map<String, Object> extraClaims = new HashMap<>();
        String token = jwtService.generateToken(user, extraClaims);

        assertNotNull(token);  // Verifica que el token no sea nulo
    }

    @Test
    void shouldExtractEmailFromToken() {
        String token = jwtService.generateToken(user, new HashMap<>());
        String extractedEmail = jwtService.extractEmail(token);

        assertEquals(user.getEmailUser(), extractedEmail);  // Verifica que el email extraído sea el correcto
    }

    @Test
    void shouldValidateTokenSuccessfully() {
        String token = jwtService.generateToken(user, new HashMap<>());

        UserDetails userDetails = mock(UserDetails.class);
        when(userDetails.getUsername()).thenReturn(user.getEmailUser());

        boolean isValid = jwtService.isTokenValid(token, userDetails);

        assertTrue(isValid);  // Verifica que el token sea válido
    }
}
