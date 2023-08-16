package xyz.lechi.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lechi.onlineshop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Empty
}
