package com.example.emazon_microservice_user.user.infraestructure.out.jpa.mapper;

import com.example.emazon_microservice_user.user.domain.model.User;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {

    @Mapping(target = "idUser", source = "idUser")
    @Mapping(target = "nameUser", source = "nameUser")
    @Mapping(target = "lastNameUser", source = "lastNameUser")
    @Mapping(target = "idDocumentUser", source = "idDocumentUser")
    @Mapping(target = "phoneUser", source = "phoneUser")
    @Mapping(target = "dateUser", source = "dateUser")
    @Mapping(target = "emailUser", source = "emailUser")
    @Mapping(target = "passwordUser", source = "passwordUser")
    @Mapping(target = "userRole", source = "userRole")
    User toUser(UserEntity userEntity);

    @Mapping(target = "idUser", source = "idUser")
    @Mapping(target = "nameUser", source = "nameUser")
    @Mapping(target = "lastNameUser", source = "lastNameUser")
    @Mapping(target = "idDocumentUser", source = "idDocumentUser")
    @Mapping(target = "phoneUser", source = "phoneUser")
    @Mapping(target = "dateUser", source = "dateUser")
    @Mapping(target = "emailUser", source = "emailUser")
    @Mapping(target = "passwordUser", source = "passwordUser")
    @Mapping(target = "userRole.idRole", source = "userRole.idRole")
    @Mapping(target = "userRole.nameRole", source = "userRole.nameRole")
    @Mapping(target = "userRole.descriptionRole", source = "userRole.descriptionRole")
    UserEntity toUserEntity(User user);

}
