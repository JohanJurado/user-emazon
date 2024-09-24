package com.example.emazon_microservice_user.user.application.dto;

import com.example.emazon_microservice_user.user.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String nameUser;
    private String lastNameUser;
    private Long idDocumentUser;
    private String phoneUser;
    private LocalDate dateUser;
    private String emailUser;
    private String passwordUser;

}
