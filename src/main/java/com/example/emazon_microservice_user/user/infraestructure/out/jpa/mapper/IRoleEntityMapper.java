package com.example.emazon_microservice_user.user.infraestructure.out.jpa.mapper;

import com.example.emazon_microservice_user.user.domain.model.Role;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface IRoleEntityMapper {

    @Mapping(target = "idRole", source = "idRole")
    @Mapping(target = "nameRole", source = "nameRole")
    @Mapping(target = "descriptionRole", source = "descriptionRole")
    Role toRole(RoleEntity roleEntity);

    @Mapping(target = "idRole", source = "idRole")
    @Mapping(target = "nameRole", source = "nameRole")
    @Mapping(target = "descriptionRole", source = "descriptionRole")
    RoleEntity toRoleEntity(Role role);

}
