package xyz.lechi.onlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.lechi.onlineshop.dto.CreateUserDto;
import xyz.lechi.onlineshop.dto.UserDto;
import xyz.lechi.onlineshop.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserDto addUser(@RequestBody CreateUserDto createDto) {
        return userService.addUser(createDto);
    }
}
