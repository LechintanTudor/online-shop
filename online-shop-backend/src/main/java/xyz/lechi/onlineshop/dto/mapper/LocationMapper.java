package xyz.lechi.onlineshop.dto.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.domain.Location;
import xyz.lechi.onlineshop.dto.CreateLocationDto;
import xyz.lechi.onlineshop.dto.LocationDto;

@Component
@AllArgsConstructor
public class LocationMapper {
    private final AddressMapper addressMapper;

    public LocationDto toDto(Location location) {
        return LocationDto.builder()
            .id(location.getId())
            .name(location.getName())
            .address(addressMapper.toDto(location.getAddress()))
            .build();
    }

    public Location fromCreateDto(CreateLocationDto createDto) {
        return Location.builder()
            .name(createDto.getName())
            .address(addressMapper.fromDto(createDto.getAddress()))
            .build();
    }
}
