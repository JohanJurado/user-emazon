package com.example.emazon_microservice_user.util;

import com.example.emazon_microservice_user.user.application.dto.RoleDto;
import com.example.emazon_microservice_user.user.application.dto.UserRequest;
import com.example.emazon_microservice_user.user.application.dto.UserResponse;
import com.example.emazon_microservice_user.user.domain.model.Role;
import com.example.emazon_microservice_user.user.domain.model.User;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.RoleEntity;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.UserEntity;

import java.time.LocalDate;

public class Constants {

    public Constants(){
    }

    public Role ROLE1 = new Role(1L, "nameRole1", "descriptionRole1");
    public RoleEntity ROLE_ENTITY1 = new RoleEntity(1L, "nameRole1", "descriptionRole1");
    public RoleDto ROLE_DTO1 = new RoleDto(1L, "nameRole1");
    public User USER1 = new User(1L, "nameUser1", "lastNameUser1", "idDocumentUser1", "3126374234", LocalDate.parse("2000-04-05"), "emailUser1@gmail.com", "passwordUser1", ROLE1);
    public UserEntity USER_ENTITY1 = new UserEntity(1L, "nameUser1", "lastNameUser1", "idDocumentUser1", "3126374234", LocalDate.parse("2000-04-05"), "emailUser1@gmail.com", "passwordUser1", ROLE_ENTITY1);
    public UserRequest USER_REQUEST1 = new UserRequest("nameUser1", "lastNameUser1", 12345678L, "3126374234", LocalDate.parse("2000-04-05"), "emailUser1@gmail.com", "passwordUser1");
    public UserResponse USER_RESPONSE1 = new UserResponse(1L, "nameUser1", "lastNameUser1", 12345678L, "3126374234", LocalDate.parse("2000-04-05"), "emailUser1@gmail.com", "passwordUser1", ROLE_DTO1);

    public String NAME_ROLE_WAREHOUSE_ASSISTANT = "WAREHOUSE_ASSISTANT";
    public String NAME_ROLE_UNKNOWN_ROLE = "UNKNOWN_ROLE";
    public String EMAIL = "unknown@example.com";
    public String ID_DOCUMENT = "123456";

}
