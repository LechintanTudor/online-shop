package xyz.lechi.onlineshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lechi.onlineshop.domain.Stock;
import xyz.lechi.onlineshop.domain.embeddable.StockId;

public interface StockRepository extends JpaRepository<Stock, StockId> {
    // Empty
}
