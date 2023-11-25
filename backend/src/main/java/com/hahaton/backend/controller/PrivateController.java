package com.hahaton.backend.controller;


import com.hahaton.backend.dto.UserDto;
import com.hahaton.backend.service.UserService;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@Slf4j
@RequestMapping(path = "/users")
@AllArgsConstructor
public class PrivateController {
    private final UserService userService;

    @DeleteMapping("/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable @Positive Long userId) {
        log.info("Delete user by owner request accepted, id={}", userId);
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUser(@PathVariable @Positive Long userId) {
        log.info("Get user request accepted, id={}", userId);
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }


}
