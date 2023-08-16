package xyz.lechi.onlineshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.lechi.onlineshop.dto.CreateProductDto;
import xyz.lechi.onlineshop.dto.ProductDto;
import xyz.lechi.onlineshop.dto.mapper.ProductMapper;
import xyz.lechi.onlineshop.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDto addProduct(CreateProductDto createDto) {
        var product = productMapper.fromCreateDto(createDto);
        return productMapper.toDto(productRepository.save(product));
    }

    public List<ProductDto> getAllProducts() {
        return productRepository
            .findAll()
            .stream()
            .map(productMapper::toDto)
            .toList();
    }
}
