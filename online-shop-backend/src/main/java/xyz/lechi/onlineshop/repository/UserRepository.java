package xyz.lechi.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lechi.onlineshop.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Empty
}
