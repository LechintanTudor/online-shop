package xyz.lechi.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ProductCategoryDto {
    private Long id;
    private String name;
    private String description;
}
