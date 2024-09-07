package com.dymometr.Dymometr.services.interfaces;

import com.dymometr.Dymometr.domain.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    boolean save(UserEntity userEntity);

    Optional<UserEntity> findUser(UserEntity userEntity);
}
