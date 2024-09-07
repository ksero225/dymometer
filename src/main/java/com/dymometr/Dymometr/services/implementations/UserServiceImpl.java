package com.dymometr.Dymometr.services.implementations;

import com.dymometr.Dymometr.domain.entity.UserEntity;
import com.dymometr.Dymometr.repositories.UserRepository;
import com.dymometr.Dymometr.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean save(UserEntity userEntity) {
        if (!isLoginOrEmailAlreadyTaken(userEntity.getUserLogin(), userEntity.getUserEmail())) {
            userRepository.save(userEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<UserEntity> findUser(UserEntity userEntity) {
        return userRepository.findUserEntityByUserLoginAndUserPassword(
                userEntity.getUserLogin(),
                userEntity.getUserPassword()
        );
    }

    private boolean isLoginOrEmailAlreadyTaken(String userLogin, String userEmail) {
        return userRepository.existsUserEntityByUserLoginOrUserEmail(
                userLogin,
                userEmail
        );
    }


}
