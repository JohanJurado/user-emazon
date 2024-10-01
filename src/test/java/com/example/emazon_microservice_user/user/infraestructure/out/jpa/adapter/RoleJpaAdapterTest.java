package com.example.emazon_microservice_user.user.infraestructure.out.jpa.adapter;

import com.example.emazon_microservice_user.user.domain.model.Role;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.RoleEntity;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.mapper.IRoleEntityMapper;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository.IRoleJpaRepository;
import com.example.emazon_microservice_user.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleJpaAdapterTest {

    @Mock
    private IRoleJpaRepository roleJpaRepository;

    @Mock
    private IRoleEntityMapper roleEntityMapper;

    @InjectMocks
    private RoleJpaAdapter roleJpaAdapter;

    @Test
    void testFindByName_WhenRoleExists() {
        Constants constants = new Constants();

        String roleName = constants.NAME_ROLE_WAREHOUSE_ASSISTANT;
        Role role = constants.ROLE1;
        RoleEntity roleEntity = constants.ROLE_ENTITY1;

        when(roleJpaRepository.findByNameRole(roleName)).thenReturn(Optional.of(roleEntity));
        when(roleEntityMapper.toRole(roleEntity)).thenReturn(role);

        Role result = roleJpaAdapter.findByName(roleName);

        assertEquals(role, result);
        verify(roleJpaRepository, times(1)).findByNameRole(roleName);
        verify(roleEntityMapper, times(1)).toRole(roleEntity);
    }

    @Test
    void testFindByName_WhenRoleDoesNotExist() {
        Constants constants = new Constants();

        String roleName = constants.NAME_ROLE_UNKNOWN_ROLE;

        when(roleJpaRepository.findByNameRole(roleName)).thenReturn(Optional.empty());

        Role result = roleJpaAdapter.findByName(roleName);

        assertNull(result); // Como el rol no existe, esperamos un valor null
        verify(roleJpaRepository, times(1)).findByNameRole(roleName);
        verify(roleEntityMapper, times(1)).toRole(any()); // El mapeador no debería ser invocado
    }
}
