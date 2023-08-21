package xyz.lechi.onlineshop.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import xyz.lechi.onlineshop.service.TokenService;

@Component
@RequiredArgsConstructor
public class TokenAuthenticationProvider implements AuthenticationProvider {
    private final TokenService tokenService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var tokenAuthentication = (TokenAuthentication) authentication;

        var user = tokenService
            .getUserByToken(tokenAuthentication.getToken())
            .orElseThrow(() -> new BadCredentialsException("Bad credentials provided"));

        return TokenAuthentication.builder()
            .token(tokenAuthentication.getToken())
            .user(user)
            .build();
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(TokenAuthentication.class);
    }
}
