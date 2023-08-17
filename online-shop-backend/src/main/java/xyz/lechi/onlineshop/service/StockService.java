package xyz.lechi.onlineshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.lechi.onlineshop.dto.CreateStockDto;
import xyz.lechi.onlineshop.dto.StockDto;
import xyz.lechi.onlineshop.dto.mapper.StockMapper;
import xyz.lechi.onlineshop.repository.StockRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    public StockDto addStock(CreateStockDto createDto) {
        var stock = stockMapper.fromCreateDto(createDto);
        return stockMapper.toDto(stockRepository.save(stock));
    }

    public List<StockDto> getAllStocks() {
        return stockRepository
            .findAll()
            .stream()
            .map(stockMapper::toDto)
            .toList();
    }
}
