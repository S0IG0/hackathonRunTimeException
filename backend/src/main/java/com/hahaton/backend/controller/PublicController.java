package com.hahaton.backend.controller;


import com.hahaton.backend.dto.NewUserDto;
import com.hahaton.backend.dto.UserDto;
import com.hahaton.backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
@RequestMapping(path = "/")
@AllArgsConstructor
public class PublicController {
    private final UserService userService;


    @PostMapping("/register")
    ResponseEntity<UserDto> postUser(@RequestBody @Validated NewUserDto newUserDto) {
        log.info("User post accepted: {}", newUserDto);
        return new ResponseEntity<>(userService.postUser(newUserDto), HttpStatus.CREATED);
    }





}
