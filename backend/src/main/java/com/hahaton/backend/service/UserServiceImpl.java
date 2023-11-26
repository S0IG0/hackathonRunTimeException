package com.hahaton.backend.service;


import com.hahaton.backend.dto.user.NewUserDto;
import com.hahaton.backend.dto.user.UserDto;
import com.hahaton.backend.exception.ConflictException;
import com.hahaton.backend.exception.NotFoundException;
import com.hahaton.backend.mapper.UserMapper;
import com.hahaton.backend.model.role.User;
import com.hahaton.backend.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public UserDto postUser(NewUserDto newUserDto) {
        try {
            User user = UserMapper.toUser(newUserDto);
            UserDto savedUser = UserMapper.toUserDto(userRepository.save(user));
            log.info("User created: {}", savedUser);
            return savedUser;
        } catch (ConstraintViolationException | DataIntegrityViolationException e) {
            throw new ConflictException(e.getMessage());
        }
    }

    @Override
    public UserDto patchUser(UserDto userDto) {
        return null; //todo: add patch
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.deleteById(userId);
        log.info("Deleted user with id: {}", userId);
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        UserDto savedUser = UserMapper.toUserDto(user);
        log.info("Found user {}", savedUser);
        return savedUser;
    }
}
