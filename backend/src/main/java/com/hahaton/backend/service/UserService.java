package com.hahaton.backend.service;

import com.hahaton.backend.dto.NewUserDto;
import com.hahaton.backend.dto.UserDto;

public interface UserService {

    UserDto postUser(NewUserDto userDto);

    UserDto patchUser (UserDto userDto);

    void deleteUser(Long userId);

    UserDto getUser(Long userId);
}
