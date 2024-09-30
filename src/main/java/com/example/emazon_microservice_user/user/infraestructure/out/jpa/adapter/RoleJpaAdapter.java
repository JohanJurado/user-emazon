package com.example.emazon_microservice_user.user.infraestructure.out.jpa.adapter;

import com.example.emazon_microservice_user.user.domain.model.Role;
import com.example.emazon_microservice_user.user.domain.spi.IRolePersistencePort;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.mapper.IRoleEntityMapper;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository.IRoleJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {

    private final IRoleEntityMapper roleEntityMapper;
    private final IRoleJpaRepository roleJpaRepository;

    @Override
    public Role findByName(String nameRole) {
        return roleEntityMapper.toRole(roleJpaRepository.findByNameRole(nameRole).orElse(null));
    }
}
