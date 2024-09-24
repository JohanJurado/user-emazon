package com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository;

import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleJpaRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByNameRole(String nameRole);

}
