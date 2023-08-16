package xyz.lechi.onlineshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xyz.lechi.onlineshop.domain.embeddable.Address;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Location {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "country", column = @Column(nullable = false)),
        @AttributeOverride(name = "city", column = @Column(nullable = false)),
        @AttributeOverride(name = "street", column = @Column(nullable = false)),
    })
    private Address address;
}
