package com.example.emazon_microservice_user.user.infraestructure.out.jpa.adapter;

import com.example.emazon_microservice_user.user.domain.model.User;
import com.example.emazon_microservice_user.user.domain.spi.IUserPersistencePort;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.mapper.IUserEntityMapper;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository.IUserJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserEntityMapper userEntityMapper;
    private final IUserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        return userEntityMapper.toUser(
                userJpaRepository.save(userEntityMapper.toUserEntity(user))
        );
    }
}
