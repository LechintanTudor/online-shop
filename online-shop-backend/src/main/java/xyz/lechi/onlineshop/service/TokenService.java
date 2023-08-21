package xyz.lechi.onlineshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.lechi.onlineshop.dto.AuthUserDto;
import xyz.lechi.onlineshop.dto.mapper.TokenMapper;
import xyz.lechi.onlineshop.dto.mapper.UserMapper;
import xyz.lechi.onlineshop.repository.TokenRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final TokenRepository tokenRepository;
    private final TokenMapper tokenMapper;
    private final UserMapper userMapper;

    public UUID createTokenForUser(Long userId) {
        var token = tokenMapper.fromUserId(userId);
        return tokenRepository.save(token).getToken();
    }

    public Optional<AuthUserDto> getUserByToken(UUID token) {
        return tokenRepository
            .findById(token)
            .map(t -> userMapper.toAuthDto(t.getUser()));
    }

    public void deleteToken(UUID token) {
        tokenRepository.deleteById(token);
    }

    public void deleteAllTokensForUser(Long userId) {
        tokenRepository.deleteAllByUserId(userId);
    }
}
