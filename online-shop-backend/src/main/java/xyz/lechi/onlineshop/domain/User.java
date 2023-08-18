package xyz.lechi.onlineshop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import xyz.lechi.onlineshop.domain.embeddable.UserRole;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @Column(name = "role", nullable = false)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id", nullable = false),
        uniqueConstraints = {
            @UniqueConstraint(
                name = "unique_user_role",
                columnNames = {"user_id", "role"}
            )
        }
    )
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    private List<UserRole> roles;
}
