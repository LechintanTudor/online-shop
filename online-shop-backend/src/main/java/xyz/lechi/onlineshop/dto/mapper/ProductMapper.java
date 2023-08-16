package xyz.lechi.onlineshop.dto.mapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.domain.Product;
import xyz.lechi.onlineshop.dto.CreateProductDto;
import xyz.lechi.onlineshop.dto.ProductDto;
import xyz.lechi.onlineshop.repository.ProductCategoryRepository;
import xyz.lechi.onlineshop.repository.SupplierRepository;

@Component
@AllArgsConstructor
public class ProductMapper {
    private final ProductCategoryRepository productCategoryRepository;
    private final SupplierRepository supplierRepository;
    private final ProductCategoryMapper productCategoryMapper;
    private final SupplierMapper supplierMapper;

    public ProductDto toDto(Product product) {
        return ProductDto.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .weight(product.getWeight())
            .category(productCategoryMapper.toDto(product.getCategory()))
            .supplier(supplierMapper.toDto(product.getSupplier()))
            .imageUrl(product.getImageUrl())
            .build();
    }

    public Product fromCreateDto(CreateProductDto createDto) {
        var category = productCategoryRepository
            .findById(createDto.getCategoryId())
            .orElseThrow(() -> new EntityNotFoundException("Product category not found"));

        var supplier = supplierRepository
            .findById(createDto.getSupplierId())
            .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));

        return Product.builder()
            .name(createDto.getName())
            .description(createDto.getDescription())
            .price(createDto.getPrice())
            .weight(createDto.getWeight())
            .category(category)
            .supplier(supplier)
            .imageUrl(createDto.getImageUrl())
            .build();
    }
}
