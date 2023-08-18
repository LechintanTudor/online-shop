package xyz.lechi.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private List<String> roles;
}
