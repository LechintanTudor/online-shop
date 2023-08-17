package xyz.lechi.onlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.lechi.onlineshop.dto.CreateStockDto;
import xyz.lechi.onlineshop.dto.StockDto;
import xyz.lechi.onlineshop.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @PostMapping
    public StockDto addStock(@RequestBody CreateStockDto createDto) {
        return stockService.addStock(createDto);
    }

    @GetMapping
    public List<StockDto> getAllStocks() {
        return stockService.getAllStocks();
    }
}
