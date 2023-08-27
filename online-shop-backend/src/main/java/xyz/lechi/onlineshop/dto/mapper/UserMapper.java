package xyz.lechi.onlineshop.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.domain.User;
import xyz.lechi.onlineshop.domain.embeddable.UserRole;
import xyz.lechi.onlineshop.dto.AuthUserDto;
import xyz.lechi.onlineshop.dto.CreateUserDto;
import xyz.lechi.onlineshop.dto.UserDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;

    public UserDto toDto(User user) {
        var roles = user
            .getRoles()
            .stream()
            .map(UserRole::name)
            .toList();

        return UserDto.builder()
            .id(user.getId())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .roles(roles)
            .build();
    }

    public AuthUserDto toAuthDto(User user) {
        var roles = user
            .getRoles()
            .stream()
            .map(UserRole::name)
            .toList();

        return AuthUserDto.builder()
            .id(user.getId())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .username(user.getUsername())
            .email(user.getEmail())
            .roles(roles)
            .build();
    }

    public User fromCreateDto(CreateUserDto createDto) {
        var passwordHash = passwordEncoder.encode(createDto.getPassword());

        return User.builder()
            .firstName(createDto.getFirstName())
            .lastName(createDto.getLastName())
            .username(createDto.getUsername())
            .email(createDto.getEmail())
            .passwordHash(passwordHash)
            .roles(List.of(UserRole.CUSTOMER))
            .build();
    }
}
