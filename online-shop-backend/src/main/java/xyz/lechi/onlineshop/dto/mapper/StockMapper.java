package xyz.lechi.onlineshop.dto.mapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.domain.Stock;
import xyz.lechi.onlineshop.dto.CreateStockDto;
import xyz.lechi.onlineshop.dto.StockDto;
import xyz.lechi.onlineshop.repository.LocationRepository;
import xyz.lechi.onlineshop.repository.ProductRepository;

@Component
@RequiredArgsConstructor
public class StockMapper {
    private final ProductRepository productRepository;
    private final LocationRepository locationRepository;
    private final ProductMapper productMapper;
    private final LocationMapper locationMapper;

    public StockDto toDto(Stock stock) {
        return StockDto.builder()
            .product(productMapper.toDto(stock.getProduct()))
            .location(locationMapper.toDto(stock.getLocation()))
            .quantity(stock.getQuantity())
            .build();
    }

    public Stock fromCreateDto(CreateStockDto createDto) {
        var product = productRepository
            .findById(createDto.getProductId())
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        var location = locationRepository
            .findById(createDto.getLocationId())
            .orElseThrow(() -> new EntityNotFoundException("Location not found"));

        return Stock.builder()
            .product(product)
            .location(location)
            .quantity(createDto.getQuantity())
            .build();
    }
}
