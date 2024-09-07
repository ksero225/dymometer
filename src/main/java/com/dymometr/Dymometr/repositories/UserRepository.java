package com.dymometr.Dymometr.repositories;

import com.dymometr.Dymometr.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsUserEntityByUserLoginOrUserEmail(String userLogin, String userEmail);
    Optional<UserEntity> findUserEntityByUserLoginAndUserPassword(String userLogin, String userEmail);
}
