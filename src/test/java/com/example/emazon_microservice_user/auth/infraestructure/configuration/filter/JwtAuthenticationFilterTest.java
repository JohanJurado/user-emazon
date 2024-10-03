package com.example.emazon_microservice_user.auth.infraestructure.configuration.filter;

import com.example.emazon_microservice_user.auth.application.service.JwtService;
import com.example.emazon_microservice_user.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JwtAuthenticationFilterTest {

    @Mock
    private JwtService jwtService;

    @Mock
    private UserDetailsService userDetailsService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @InjectMocks
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    private static final String BEARER_TOKEN = "Bearer jwt-token";
    private static final String JWT_TOKEN = "jwt-token";
    private static final String AUTHORIZATION_STRING = "Authorization";

    @BeforeEach
    void setUp() {
        jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtService, userDetailsService);

        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    void shouldAuthenticateWhenTokenIsValid() throws Exception {
        Constants constants = new Constants();

        // Simulamos SecurityContext y SecurityContextHolder
        SecurityContext securityContext = mock(SecurityContext.class);

        try (MockedStatic<SecurityContextHolder> mockedSecurityContextHolder = mockStatic(SecurityContextHolder.class)) {
            // Configurar el comportamiento de SecurityContextHolder.getContext()
            mockedSecurityContextHolder.when(SecurityContextHolder::getContext).thenReturn(securityContext);

            when(request.getHeader(AUTHORIZATION_STRING)).thenReturn(BEARER_TOKEN);
            when(jwtService.extractEmail(JWT_TOKEN)).thenReturn(constants.EMAIL);

            UserDetails userDetails = mock(UserDetails.class);
            when(userDetailsService.loadUserByUsername(constants.EMAIL)).thenReturn(userDetails);
            when(jwtService.isTokenValid(JWT_TOKEN, userDetails)).thenReturn(true);

            // Ejecutar el filtro
            jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

            // Verificamos que el SecurityContextHolder.setAuthentication fue llamado
            verify(securityContext).setAuthentication(any());
            verify(filterChain).doFilter(request, response);
        }
    }

    @Test
    void shouldNotAuthenticateWhenTokenIsInvalid() throws Exception {
        Constants constants = new Constants();

        // Simulamos SecurityContext y SecurityContextHolder
        SecurityContext securityContext = mock(SecurityContext.class);

        try (MockedStatic<SecurityContextHolder> mockedSecurityContextHolder = mockStatic(SecurityContextHolder.class)) {
            // Configurar el comportamiento de SecurityContextHolder.getContext()
            mockedSecurityContextHolder.when(SecurityContextHolder::getContext).thenReturn(securityContext);

            when(request.getHeader(AUTHORIZATION_STRING)).thenReturn(BEARER_TOKEN);
            when(jwtService.extractEmail(JWT_TOKEN)).thenReturn(constants.EMAIL);

            UserDetails userDetails = mock(UserDetails.class);
            when(userDetailsService.loadUserByUsername(constants.EMAIL)).thenReturn(userDetails);
            when(jwtService.isTokenValid(JWT_TOKEN, userDetails)).thenReturn(false);

            // Ejecutar el filtro
            jwtAuthenticationFilter.doFilterInternal(request, response, filterChain);

            // Verificar que no se llama a setAuthentication() cuando el token es inválido
            verify(securityContext, never()).setAuthentication(any());
            verify(filterChain).doFilter(request, response);  // Verifica que continúa sin autenticar
        }
    }
}

