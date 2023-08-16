package xyz.lechi.onlineshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.lechi.onlineshop.dto.CreateLocationDto;
import xyz.lechi.onlineshop.dto.LocationDto;
import xyz.lechi.onlineshop.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping
    LocationDto addLocation(@RequestBody CreateLocationDto createDto) {
        return locationService.addLocation(createDto);
    }

    @GetMapping
    List<LocationDto> getAllLocations() {
        return locationService.getAllLocations();
    }
}
