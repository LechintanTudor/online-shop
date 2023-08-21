package xyz.lechi.onlineshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "active_token")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Token {
    @Id
    private UUID token;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
