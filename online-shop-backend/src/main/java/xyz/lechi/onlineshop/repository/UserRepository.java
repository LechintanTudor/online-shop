package xyz.lechi.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lechi.onlineshop.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
