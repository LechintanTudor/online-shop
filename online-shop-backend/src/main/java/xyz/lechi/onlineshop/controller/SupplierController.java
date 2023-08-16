package xyz.lechi.onlineshop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.lechi.onlineshop.dto.CreateSupplierDto;
import xyz.lechi.onlineshop.dto.SupplierDto;
import xyz.lechi.onlineshop.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@AllArgsConstructor
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping
    public SupplierDto addSupplier(@RequestBody CreateSupplierDto createDto) {
        return supplierService.addSupplier(createDto);
    }

    @GetMapping
    public List<SupplierDto> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }
}
