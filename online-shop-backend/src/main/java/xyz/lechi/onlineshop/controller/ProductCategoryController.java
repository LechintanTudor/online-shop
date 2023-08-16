package xyz.lechi.onlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.lechi.onlineshop.dto.CreateProductCategoryDto;
import xyz.lechi.onlineshop.dto.ProductCategoryDto;
import xyz.lechi.onlineshop.service.ProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
@RequiredArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @PostMapping
    public ProductCategoryDto addProductCategory(@RequestBody CreateProductCategoryDto createDto) {
        return productCategoryService.addProductCategory(createDto);
    }

    @GetMapping
    public List<ProductCategoryDto> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }
}
