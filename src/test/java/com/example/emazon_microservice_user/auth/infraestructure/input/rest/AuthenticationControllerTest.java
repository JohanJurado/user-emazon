package com.example.emazon_microservice_user.auth.infraestructure.input.rest;

import com.example.emazon_microservice_user.auth.application.dto.AuthenticationRequest;
import com.example.emazon_microservice_user.auth.application.dto.AuthenticationResponse;
import com.example.emazon_microservice_user.auth.application.service.AuthenticationService;
import com.example.emazon_microservice_user.auth.infraestructure.input.rest.AuthenticationController;
import com.example.emazon_microservice_user.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private String EMAIL;
    private String PASSWORD;
    private static final String JWT_TOKEN = "jwt-token";
    private static final String ROUTE = "/auth/authenticate";


    @BeforeEach
    void setUp() {
        Constants constants = new Constants();

        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();
        EMAIL = constants.EMAIL;
        PASSWORD = constants.PASSSWORD;
    }

    @Test
    void shouldAuthenticateUserSuccessfully() throws Exception {
        AuthenticationRequest request = new AuthenticationRequest(EMAIL, PASSWORD);
        AuthenticationResponse response = AuthenticationResponse.builder().token(JWT_TOKEN).build();

        when(authenticationService.login(any(AuthenticationRequest.class))).thenReturn(response);

        mockMvc.perform(post(ROUTE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value(JWT_TOKEN));  // Verifica que el token JWT sea devuelto
    }
}
