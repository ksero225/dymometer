package com.dymometr.Dymometr.services.implementations;

import com.dymometr.Dymometr.domain.entity.SensorEntity;
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

//    @Override
//    public void partialUpdate(UserEntity foundUser) {
//
//            Optional<UserEntity> user = userRepository.findById(foundUser.getUserId());
//
//            return user.map(existingUser -> {
//                Optional.ofNullable(foundUser.getUserLogin()).ifPresent(existingUser::setUserLogin);
//                Optional.ofNullable(foundUser.getUserLogin()).ifPresent(existingUser::setUserLogin);
//                Optional.ofNullable(foundUser.getUserLogin()).ifPresent(existingUser::setUserLogin);
//                Optional.ofNullable(foundUser.getUserLogin()).ifPresent(existingUser::setUserLogin);
//
//                return userRepository.save(existingSensor);
//            }).orElseThrow(() -> new RuntimeException("Sensor does not exist"));
//
//    }

    @Override
    public Optional<UserEntity> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<UserEntity> findUser(String userLogin, String userPassword) {
        return userRepository.findUserEntityByUserLoginAndUserPassword(
                userLogin,
                userPassword
        );
    }

    private boolean isLoginOrEmailAlreadyTaken(String userLogin, String userEmail) {
        return userRepository.existsUserEntityByUserLoginOrUserEmail(
                userLogin,
                userEmail
        );
    }


}
