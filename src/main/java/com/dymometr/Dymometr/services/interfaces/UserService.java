package com.dymometr.Dymometr.services.interfaces;

import com.dymometr.Dymometr.domain.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    boolean save(UserEntity userEntity);

    Optional<UserEntity> findUser(String userLogin, String userPassword);

    Optional<UserEntity> findById(Long userId);

    //void partialUpdate(UserEntity foundUser);
}
