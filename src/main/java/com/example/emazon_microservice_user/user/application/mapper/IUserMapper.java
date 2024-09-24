package com.example.emazon_microservice_user.user.application.mapper;

import com.example.emazon_microservice_user.user.application.dto.UserRequest;
import com.example.emazon_microservice_user.user.application.dto.UserResponse;
import com.example.emazon_microservice_user.user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserMapper {

    @Mapping(target = "idUser", ignore = true)
    @Mapping(target = "nameUser", source = "nameUser")
    @Mapping(target = "lastNameUser", source = "lastNameUser")
    @Mapping(target = "idDocumentUser", source = "idDocumentUser")
    @Mapping(target = "phoneUser", source = "phoneUser")
    @Mapping(target = "dateUser", source = "dateUser")
    @Mapping(target = "emailUser", source = "emailUser")
    @Mapping(target = "passwordUser", source = "passwordUser")
    @Mapping(target = "userRole", ignore = true)
    User toUser(UserRequest userRequest);

    @Mapping(target = "idUser", source = "idUser")
    @Mapping(target = "nameUser", source = "nameUser")
    @Mapping(target = "lastNameUser", source = "lastNameUser")
    @Mapping(target = "idDocumentUser", source = "idDocumentUser")
    @Mapping(target = "phoneUser", source = "phoneUser")
    @Mapping(target = "dateUser", source = "dateUser")
    @Mapping(target = "emailUser", source = "emailUser")
    @Mapping(target = "passwordUser", source = "passwordUser")
    @Mapping(target = "userRole", source = "userRole")
    UserResponse toUserResponse(User user);

}
