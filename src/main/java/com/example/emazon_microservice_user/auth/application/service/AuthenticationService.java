package com.example.emazon_microservice_user.auth.application.service;

import com.example.emazon_microservice_user.auth.application.dto.AuthenticationRequest;
import com.example.emazon_microservice_user.auth.application.dto.AuthenticationResponse;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.UserEntity;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository.IUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserJpaRepository userJpaRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmailUser(),
                        authenticationRequest.getPasswordUser()
                )
        );

        var user = userJpaRepository.findByEmailUser(authenticationRequest.getEmailUser()).orElseThrow();

        var jwtToken = jwtService.generateToken(user, generateExtraClaims(user));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    private Map<String, Object> generateExtraClaims(UserEntity user){

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("emailUser", user.getEmailUser());
        extraClaims.put("role", user.getUserRole().getNameRole());

        return extraClaims;
    }
}
