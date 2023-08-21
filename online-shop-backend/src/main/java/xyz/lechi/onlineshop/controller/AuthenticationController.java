package xyz.lechi.onlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.lechi.onlineshop.dto.LoginDto;
import xyz.lechi.onlineshop.dto.TokenDto;
import xyz.lechi.onlineshop.service.AuthenticationService;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto loginDto) {
        return authenticationService.login(loginDto);
    }
}
