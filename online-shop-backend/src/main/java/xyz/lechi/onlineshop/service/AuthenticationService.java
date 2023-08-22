package xyz.lechi.onlineshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.lechi.onlineshop.dto.LoginDto;
import xyz.lechi.onlineshop.dto.TokenDto;
import xyz.lechi.onlineshop.repository.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public TokenDto login(LoginDto loginDto) {
        var user = userRepository
            .findByUsername(loginDto.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPasswordHash())) {
            throw new BadCredentialsException("Invalid password");
        }

        return TokenDto.builder()
            .token(tokenService.createTokenForUser(user.getId()).toString())
            .build();
    }

    public void logout(UUID token) {
        tokenService.deleteToken(token);
    }
}
