package com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role")
public class RoleEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_role")
        private Long idRole;

        @Column(name = "name_role")
        private String nameRole;

        @Column(name = "description_role")
        private String descriptionRole;

}
