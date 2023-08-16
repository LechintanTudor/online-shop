package xyz.lechi.onlineshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.lechi.onlineshop.dto.CreateProductCategoryDto;
import xyz.lechi.onlineshop.dto.ProductCategoryDto;
import xyz.lechi.onlineshop.dto.mapper.ProductCategoryMapper;
import xyz.lechi.onlineshop.repository.ProductCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryDto addProductCategory(CreateProductCategoryDto createDto) {
        var category = productCategoryMapper.fromCreateDto(createDto);
        return productCategoryMapper.toDto(productCategoryRepository.save(category));
    }

    public List<ProductCategoryDto> getAllProductCategories() {
        return productCategoryRepository
            .findAll()
            .stream()
            .map(productCategoryMapper::toDto)
            .toList();
    }
}
