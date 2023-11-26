package com.hahaton.backend.mapper;

import com.hahaton.backend.dto.user.NewUserDto;
import com.hahaton.backend.dto.user.UserDto;
import com.hahaton.backend.dto.user.UserShortDto;
import com.hahaton.backend.model.role.User;

public class UserMapper {

    public static User toUser(
            NewUserDto newUserDto
    ) {
        return User.builder()
                .email(newUserDto.getEmail())
                .name(newUserDto.getName())
                .surname(newUserDto.getSurname())
                .address(newUserDto.getAddress())
                .password(newUserDto.getPassword())
                .build();
    }

    public static UserDto toUserDto(
            User user
    ) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .surname(user.getSurname())
                .address(user.getAddress())
                .build();
    }

    public static UserShortDto toUserShortDto(
            User user
    ) {
        return UserShortDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }


}
