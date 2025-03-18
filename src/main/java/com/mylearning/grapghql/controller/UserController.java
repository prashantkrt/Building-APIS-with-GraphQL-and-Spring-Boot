package com.mylearning.grapghql.controller;

import com.mylearning.grapghql.dto.UserResponseDto;
import com.mylearning.grapghql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MutationMapping
    public UserResponseDto saveUser(@Argument("input") UserResponseDto userResponseDto) {
        return userService.saveUser(userResponseDto);
    }

    @MutationMapping
    public UserResponseDto updateUser(@Argument("input") UserResponseDto userResponseDto) {
        return userService.updateUser(userResponseDto);
    }

    @QueryMapping
    public UserResponseDto getUserById(@Argument Integer userId) {
        return userService.getUserById(userId);
    }

    @QueryMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public UserResponseDto getUserByEmail(@Argument String email) {
        return userService.getUserByEmail(email);
    }

    @MutationMapping
    public UserResponseDto deleteUser(@Argument("userId") Integer userId) {
        return userService.deleteUser(userId);
    }

}
