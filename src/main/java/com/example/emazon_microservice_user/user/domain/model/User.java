package com.example.emazon_microservice_user.user.domain.model;

import java.time.LocalDate;

public class User {

    private Long idUser;
    private String nameUser;
    private String lastNameUser;
    private Long idDocumentUser;
    private String phoneUser;
    private LocalDate dateUser;
    private String emailUser;
    private String passwordUser;
    private Role userRole;

    public User() {
    }

    public User(Long idUser, String nameUser, String lastNameUser, Long idDocumentUser, String phoneUser, LocalDate dateUser, String emailUser, String passwordUser, Role userRole) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.lastNameUser = lastNameUser;
        this.idDocumentUser = idDocumentUser;
        this.phoneUser = phoneUser;
        this.dateUser = dateUser;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
        this.userRole = userRole;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLastNameUser() {
        return lastNameUser;
    }

    public void setLastNameUser(String lastNameUser) {
        this.lastNameUser = lastNameUser;
    }

    public Long getIdDocumentUser() {
        return idDocumentUser;
    }

    public void setIdDocumentUser(Long idDocumentUser) {
        this.idDocumentUser = idDocumentUser;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        this.phoneUser = phoneUser;
    }

    public LocalDate getDateUser() {
        return dateUser;
    }

    public void setDateUser(LocalDate dateUser) {
        this.dateUser = dateUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }
}
