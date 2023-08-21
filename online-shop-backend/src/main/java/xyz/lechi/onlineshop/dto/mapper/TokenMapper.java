package xyz.lechi.onlineshop.dto.mapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.domain.Token;
import xyz.lechi.onlineshop.repository.UserRepository;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TokenMapper {
    private final UserRepository userRepository;

    public Token fromUserId(Long userId) {
        var user = userRepository
            .findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return Token.builder()
            .token(UUID.randomUUID())
            .user(user)
            .build();
    }
}
