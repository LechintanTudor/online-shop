package xyz.lechi.onlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.lechi.onlineshop.dto.CreateProductDto;
import xyz.lechi.onlineshop.dto.ProductDto;
import xyz.lechi.onlineshop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductDto addProduct(@RequestBody CreateProductDto createDto) {
        return productService.addProduct(createDto);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
