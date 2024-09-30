package com.example.emazon_microservice_user.user.infraestructure.configuration;

import com.example.emazon_microservice_user.user.domain.api.IUserServicePort;
import com.example.emazon_microservice_user.user.domain.spi.IRolePersistencePort;
import com.example.emazon_microservice_user.user.domain.spi.IUserPersistencePort;
import com.example.emazon_microservice_user.user.domain.usecase.UserUseCase;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.adapter.RoleJpaAdapter;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.adapter.UserJpaAdapter;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.mapper.IRoleEntityMapper;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.mapper.IUserEntityMapper;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository.IRoleJpaRepository;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository.IUserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfigurationUser {

    private final IUserJpaRepository userJpaRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRoleJpaRepository roleJpaRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userEntityMapper, userJpaRepository);
    }

    @Bean
    public IRolePersistencePort rolePersistencePort(){
        return new RoleJpaAdapter(roleEntityMapper, roleJpaRepository);
    }

    @Bean
    public IUserServicePort brandServicePort(){
        return new UserUseCase(userPersistencePort(), rolePersistencePort());
    }
}
