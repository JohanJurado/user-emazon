package com.example.emazon_microservice_user.auth.infraestructure.input.rest;

import com.example.emazon_microservice_user.auth.application.dto.AuthenticationRequest;
import com.example.emazon_microservice_user.auth.application.dto.AuthenticationResponse;
import com.example.emazon_microservice_user.auth.application.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest authenticationRequest){
        AuthenticationResponse tokenDto = authenticationService.login(authenticationRequest);
        return ResponseEntity.ok(tokenDto);
    }

}
