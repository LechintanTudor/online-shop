package xyz.lechi.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lechi.onlineshop.domain.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // Empty
}
