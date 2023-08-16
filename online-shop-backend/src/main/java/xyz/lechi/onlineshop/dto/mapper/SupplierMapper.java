package xyz.lechi.onlineshop.dto.mapper;

import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.domain.Supplier;
import xyz.lechi.onlineshop.dto.CreateSupplierDto;
import xyz.lechi.onlineshop.dto.SupplierDto;

@Component
public class SupplierMapper {
    public SupplierDto toDto(Supplier supplier) {
        return SupplierDto.builder()
            .id(supplier.getId())
            .name(supplier.getName())
            .build();
    }

    public Supplier fromCreateDto(CreateSupplierDto createDto) {
        return Supplier.builder()
            .name(createDto.getName())
            .build();
    }
}
