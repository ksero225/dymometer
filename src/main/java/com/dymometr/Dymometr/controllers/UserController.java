package com.dymometr.Dymometr.controllers;

import com.dymometr.Dymometr.domain.dto.UserDto;
import com.dymometr.Dymometr.domain.entity.UserEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import com.dymometr.Dymometr.mapper.implementations.UserMapper;
import com.dymometr.Dymometr.services.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;
    private final Mapper<UserEntity, UserDto> userMapper;

    public UserController(UserService userService, Mapper<UserEntity, UserDto> userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<Void> registerUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.mapFrom(userDto);

        boolean isUserRegistered = userService.save(userEntity);

        if (isUserRegistered) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new RuntimeException("Login or email is already taken");
        }
    }

    @GetMapping(path = "/user")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.mapFrom(userDto);

        Optional<UserEntity> foundUserEntity = userService.findUser(userEntity);

        if (foundUserEntity.isEmpty()) {
            throw new RuntimeException("Failed to login, check your login or password");
        } else {
            return new ResponseEntity<>(
                    userMapper.mapTo(foundUserEntity.get()),
                    HttpStatus.OK
            );
        }

    }

}
