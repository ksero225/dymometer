package com.dymometr.Dymometr.controllers;

import com.dymometr.Dymometr.domain.dto.VisitDto;
import com.dymometr.Dymometr.domain.entity.DoctorEntity;
import com.dymometr.Dymometr.domain.entity.UserEntity;
import com.dymometr.Dymometr.domain.entity.VisitEntity;
import com.dymometr.Dymometr.mapper.Mapper;
import com.dymometr.Dymometr.services.interfaces.DoctorService;
import com.dymometr.Dymometr.services.interfaces.UserService;
import com.dymometr.Dymometr.services.interfaces.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class VisitController {
    private final VisitService visitService;
    private final UserService userService;
    private final DoctorService doctorService;
    private final Mapper<VisitEntity, VisitDto> visitMapper;

    public VisitController(VisitService visitService, UserService userService, DoctorService doctorService, Mapper<VisitEntity, VisitDto> visitMapper) {
        this.visitService = visitService;
        this.userService = userService;
        this.doctorService = doctorService;
        this.visitMapper = visitMapper;
    }

    @PostMapping(path = "/visit")
    public ResponseEntity<Void> addVisitToUser(@RequestParam(value = "userId") Long userId,
                                               @RequestParam(value = "doctorId") Long doctorId,
                                               @RequestParam(value = "visitDate") String visitDate
    ){
        Optional<UserEntity> foundUser = userService.findById(userId);
        Optional<DoctorEntity> foundDoctor = doctorService.existsById(doctorId);

        if(foundUser.isEmpty() || foundDoctor.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        VisitEntity savedVisit = visitService.addVisit(foundUser.get(), foundDoctor.get(), visitDate);

        List<VisitEntity> visitList = foundUser.get().getUserVisits();

        visitList.add(savedVisit);

        foundUser.get().setUserVisits(visitList);

        userService.save(foundUser.get());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/visit/user")
    public List<VisitDto> getUserVisits(@RequestParam(value = "userId") Long userId){
        Optional<UserEntity> foundUserEntity = userService.findById(userId);

        if(foundUserEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        List<VisitEntity> userVisits = foundUserEntity.get().getUserVisits();

        return userVisits.stream().map(visitMapper::mapTo).collect(Collectors.toList());
    }


}
