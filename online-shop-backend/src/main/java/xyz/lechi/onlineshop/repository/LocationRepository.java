package xyz.lechi.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lechi.onlineshop.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
    // Empty
}
