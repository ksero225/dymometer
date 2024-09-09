package com.dymometr.Dymometr.controllers;

import com.dymometr.Dymometr.domain.dto.UserDto;
import com.dymometr.Dymometr.domain.entity.UserEntity;
import com.dymometr.Dymometr.domain.entity.VisitEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import com.dymometr.Dymometr.mapper.implementations.UserMapper;
import com.dymometr.Dymometr.services.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/user")
    public ResponseEntity<UserDto> loginUser(
            @RequestParam(value = "login") String userLogin,
            @RequestParam(value = "password") String userPassword
    ) {

        Optional<UserEntity> foundUserEntity = userService.findUser(userLogin, userPassword);

        return foundUserEntity.map(user -> new ResponseEntity<>(
                userMapper.mapTo(user),
                HttpStatus.OK
        )).orElseGet(() -> new ResponseEntity<>(
                null,
                HttpStatus.CONFLICT
        ));
    }
    //zapytanie co zwraca count i avg
}
