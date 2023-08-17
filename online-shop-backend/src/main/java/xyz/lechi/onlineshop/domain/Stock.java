package xyz.lechi.onlineshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xyz.lechi.onlineshop.domain.embeddable.StockId;

@Entity
@IdClass(StockId.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Stock {
    @Id
    @ManyToOne
    private Product product;

    @Id
    @ManyToOne
    private Location location;

    private long quantity;
}
