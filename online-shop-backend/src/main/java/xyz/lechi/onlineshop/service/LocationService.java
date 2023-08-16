package xyz.lechi.onlineshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.lechi.onlineshop.dto.CreateLocationDto;
import xyz.lechi.onlineshop.dto.LocationDto;
import xyz.lechi.onlineshop.dto.mapper.LocationMapper;
import xyz.lechi.onlineshop.repository.LocationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationDto addLocation(CreateLocationDto createDto) {
        var location = locationMapper.fromCreateDto(createDto);
        return locationMapper.toDto(locationRepository.save(location));
    }

    public List<LocationDto> getAllLocations() {
        return locationRepository
            .findAll()
            .stream()
            .map(locationMapper::toDto)
            .toList();
    }
}
