package com.example.emazon_microservice_user.user.infraestructure.input.rest;

import com.example.emazon_microservice_user.auth.application.service.JwtService;
import com.example.emazon_microservice_user.user.application.dto.UserRequest;
import com.example.emazon_microservice_user.user.application.dto.UserResponse;
import com.example.emazon_microservice_user.user.application.handler.IUserHandler;
import com.example.emazon_microservice_user.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule; // Importar el módulo JSR310
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IUserHandler userHandler;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private UserController userController; // Inyectamos el controlador con los mocks

    private ObjectMapper objectMapper; // Declarar el ObjectMapper

    @BeforeEach
    void setUp() {
        // Inicializar manualmente ObjectMapper y registrar el módulo JSR310
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Registrar el módulo para manejar fechas Java 8

        // Configurar manualmente el MockMvc con el controlador
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void shouldCreateWarehouseAssistant() throws Exception {
        Constants constants = new Constants();
        UserRequest userRequest = constants.USER_REQUEST1;
        UserResponse userResponse = constants.USER_RESPONSE1;

        // Simular el comportamiento del handler
        when(userHandler.saveWarehouseAssistant(any(UserRequest.class))).thenReturn(userResponse);

        // Realizar la petición con MockMvc
        mockMvc.perform(post("/user/warehouse-assistant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest))) // Ahora ObjectMapper maneja LocalDate
                .andExpect(status().isCreated());
    }
}
