package com.mylearning.grapghql.service;

import com.mylearning.grapghql.Helper.ExceptionHelper;
import com.mylearning.grapghql.Repository.UserRepository;
import com.mylearning.grapghql.dto.UserResponseDto;
import com.mylearning.grapghql.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserResponseDto saveUser(UserResponseDto userResponseDto) {
        return mapper.map(userRepository.save(mapper.map(userResponseDto, User.class)), UserResponseDto.class);
    }

    public UserResponseDto updateUser(UserResponseDto userResponseDto) {
        return mapper.map(userRepository.save(mapper.map(userResponseDto, User.class)), UserResponseDto.class);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> mapper.map(user, UserResponseDto.class)).toList();
    }

    public UserResponseDto getUserById(Integer userId) {
        return mapper.map(userRepository.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException), UserResponseDto.class);
    }

    public UserResponseDto deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepository.delete(user);
        return mapper.map(user, UserResponseDto.class);
    }
    public UserResponseDto getUserByEmail(String email) {
        return mapper.map(userRepository.findByEmail(email).orElseThrow(ExceptionHelper::throwResourceNotFoundException), UserResponseDto.class);
    }
}
