package com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository;

import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailUser(String emailUser);
    Optional<UserEntity> findByIdDocumentUser(String idDocumentUser);

}
