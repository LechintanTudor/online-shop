package xyz.lechi.onlineshop.security;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import xyz.lechi.onlineshop.dto.AuthUserDto;

import java.util.Collections;
import java.util.UUID;

@Builder
@Getter
public class TokenAuthentication extends AbstractAuthenticationToken {
    private final UUID token;
    private final AuthUserDto user;

    public TokenAuthentication(UUID token, AuthUserDto user) {
        super(Collections.emptyList());
        this.token = token;
        this.user = user;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }
}
