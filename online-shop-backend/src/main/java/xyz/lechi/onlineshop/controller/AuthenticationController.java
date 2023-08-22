package xyz.lechi.onlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.lechi.onlineshop.dto.LoginDto;
import xyz.lechi.onlineshop.dto.TokenDto;
import xyz.lechi.onlineshop.service.AuthenticationService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public TokenDto login(@RequestBody LoginDto loginDto) {
        return authenticationService.login(loginDto);
    }

    @PostMapping("/logout")
    public void logout(Authentication authentication) {
        var token = (UUID) authentication.getCredentials();
        authenticationService.logout(token);
    }
}
