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

    @Override
    public User findByEmailUser(String emailUser) {
        return userEntityMapper.toUser(
                userJpaRepository.findByEmailUser(emailUser).orElse(null)
        );
    }

    @Override
    public User findByIdDocumentUser(String idDocumentUser) {
        return userEntityMapper.toUser(
                userJpaRepository.findByIdDocumentUser(idDocumentUser).orElse(null)
        );
    }
}
