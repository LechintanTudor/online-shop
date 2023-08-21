package xyz.lechi.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lechi.onlineshop.domain.Token;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    void deleteAllByUserId(Long userId);
}
