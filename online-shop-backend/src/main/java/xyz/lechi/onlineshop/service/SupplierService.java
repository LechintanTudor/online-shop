package xyz.lechi.onlineshop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.lechi.onlineshop.dto.CreateSupplierDto;
import xyz.lechi.onlineshop.dto.SupplierDto;
import xyz.lechi.onlineshop.dto.mapper.SupplierMapper;
import xyz.lechi.onlineshop.repository.SupplierRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierDto addSupplier(CreateSupplierDto createDto) {
        var supplier = supplierMapper.fromCreateDto(createDto);
        return supplierMapper.toDto(supplierRepository.save(supplier));
    }

    public List<SupplierDto> getAllSuppliers() {
        return supplierRepository
            .findAll()
            .stream()
            .map(supplierMapper::toDto)
            .toList();
    }
}
