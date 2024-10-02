package com.example.emazon_microservice_user.user.infraestructure.out.jpa.adapter;

import com.example.emazon_microservice_user.user.domain.model.User;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.entity.UserEntity;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.mapper.IUserEntityMapper;
import com.example.emazon_microservice_user.user.infraestructure.out.jpa.repository.IUserJpaRepository;
import com.example.emazon_microservice_user.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserJpaAdapterTest {

    @Mock
    private IUserJpaRepository userJpaRepository;

    @Mock
    private IUserEntityMapper userEntityMapper;

    @InjectMocks
    private UserJpaAdapter userJpaAdapter;

    @Test
    void testSave() {
        Constants constants = new Constants();
        User user = constants.USER1;
        UserEntity userEntity = constants.USER_ENTITY1;

        when(userEntityMapper.toUserEntity(user)).thenReturn(userEntity);
        when(userJpaRepository.save(userEntity)).thenReturn(userEntity);
        when(userEntityMapper.toUser(userEntity)).thenReturn(user);

        User result = userJpaAdapter.save(user);

        assertEquals(user, result);
        verify(userJpaRepository, times(1)).save(userEntity);
        verify(userEntityMapper, times(1)).toUserEntity(user);
        verify(userEntityMapper, times(1)).toUser(userEntity);
    }

    @Test
    void testFindByEmailUser_WhenUserExists() {
        Constants constants = new Constants();

        User user = constants.USER1;
        UserEntity userEntity = constants.USER_ENTITY1;

        when(userJpaRepository.findByEmailUser(user.getEmailUser())).thenReturn(Optional.of(userEntity));
        when(userEntityMapper.toUser(userEntity)).thenReturn(user);

        User result = userJpaAdapter.findByEmailUser(user.getEmailUser());

        assertEquals(user, result);
        verify(userJpaRepository, times(1)).findByEmailUser(user.getEmailUser());
        verify(userEntityMapper, times(1)).toUser(userEntity);
    }

    @Test
    void testFindByEmailUser_WhenUserDoesNotExist() {
        Constants constants = new Constants();

        String email = constants.EMAIL;

        when(userJpaRepository.findByEmailUser(email)).thenReturn(Optional.empty());

        User result = userJpaAdapter.findByEmailUser(email);

        assertNull(result);
        verify(userJpaRepository, times(1)).findByEmailUser(email);
        verify(userEntityMapper, times(1)).toUser(any()); // El mapeador no debería ser invocado
    }

    @Test
    void testFindByIdDocumentUser_WhenUserExists() {
        Constants constants = new Constants();

        String idDocument = constants.ID_DOCUMENT;
        User user = new User();
        UserEntity userEntity = constants.USER_ENTITY1;

        when(userJpaRepository.findByIdDocumentUser(idDocument)).thenReturn(Optional.of(userEntity));
        when(userEntityMapper.toUser(userEntity)).thenReturn(user);

        User result = userJpaAdapter.findByIdDocumentUser(idDocument);

        assertEquals(user, result);
        verify(userJpaRepository, times(1)).findByIdDocumentUser(idDocument);
        verify(userEntityMapper, times(1)).toUser(userEntity);
    }

    @Test
    void testFindByIdDocumentUser_WhenUserDoesNotExist() {
        Constants constants = new Constants();

        String idDocument = constants.ID_DOCUMENT;

        when(userJpaRepository.findByIdDocumentUser(idDocument)).thenReturn(Optional.empty());

        User result = userJpaAdapter.findByIdDocumentUser(idDocument);

        assertNull(result);
        verify(userJpaRepository, times(1)).findByIdDocumentUser(idDocument);
        verify(userEntityMapper, times(1)).toUser(any()); // El mapeador no debería ser invocado
    }
}
