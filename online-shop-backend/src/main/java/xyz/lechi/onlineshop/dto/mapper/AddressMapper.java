package xyz.lechi.onlineshop.dto.mapper;

import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.domain.embeddable.Address;
import xyz.lechi.onlineshop.dto.AddressDto;

@Component
public class AddressMapper {
    public AddressDto toDto(Address address) {
        return AddressDto.builder()
            .country(address.getCountry())
            .city(address.getCity())
            .street(address.getStreet())
            .build();
    }

    public Address fromDto(AddressDto addressDto) {
        return Address.builder()
            .country(addressDto.getCountry())
            .city(addressDto.getCity())
            .street(addressDto.getStreet())
            .build();
    }
}
