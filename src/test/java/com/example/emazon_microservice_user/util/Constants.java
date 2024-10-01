package com.example.emazon_microservice_user.util;

import com.example.emazon_microservice_user.user.domain.model.Role;
import com.example.emazon_microservice_user.user.domain.model.User;

import java.time.LocalDate;

public class Constants {

    public Constants(){
    }

    public Role ROLE1 = new Role(1L, "nameRole1", "descriptionRole1");
    public User USER1 = new User(1L, "nameUser1", "lastNameUser1", "idDocumentUser1", "3126374234", LocalDate.parse("2000-04-05"), "emailUser1@gmail.com", "passwordUser1", ROLE1);


}
