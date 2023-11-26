package com.hahaton.backend.service;

import com.hahaton.backend.dto.user.NewUserDto;
import com.hahaton.backend.dto.user.UserDto;

public interface UserService {

    UserDto postUser(NewUserDto userDto);

    UserDto patchUser(UserDto userDto);

    void deleteUser(Long userId);

    UserDto getUser(Long userId);
}
