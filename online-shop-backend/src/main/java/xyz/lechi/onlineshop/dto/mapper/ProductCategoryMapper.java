package xyz.lechi.onlineshop.dto.mapper;

import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.domain.ProductCategory;
import xyz.lechi.onlineshop.dto.CreateProductCategoryDto;
import xyz.lechi.onlineshop.dto.ProductCategoryDto;

@Component
public class ProductCategoryMapper {
    public ProductCategoryDto toDto(ProductCategory category) {
        return ProductCategoryDto.builder()
            .id(category.getId())
            .name(category.getName())
            .description(category.getDescription())
            .build();
    }

    public ProductCategory fromCreateDto(CreateProductCategoryDto createDto) {
        return ProductCategory.builder()
            .name(createDto.getName())
            .description(createDto.getDescription())
            .build();
    }
}
