package xyz.lechi.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CreateProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    private Long categoryId;
    private Long supplierId;
    private String imageUrl;
}
