package xyz.lechi.onlineshop.domain.embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import xyz.lechi.onlineshop.domain.Location;
import xyz.lechi.onlineshop.domain.Product;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
public class StockId implements Serializable {
    private Product product;
    private Location location;
}
