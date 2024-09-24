package com.example.emazon_microservice_user.auth.infraestructure.configuration;

import com.example.emazon_microservice_user.auth.application.exception.util.ExceptionConstants;
import com.example.emazon_microservice_user.user.domain.exception.UserNotFoundException;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository.IUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Configuration
@RequiredArgsConstructor
@Component
public class SecurityBeansInjector {

    private final IUserJpaRepository userJpaRepository;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userJpaRepository.findByEmailUser(username)
                .orElseThrow(() -> new UserNotFoundException(ExceptionConstants.USER_NOT_FOUND.getMessage()));
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}
