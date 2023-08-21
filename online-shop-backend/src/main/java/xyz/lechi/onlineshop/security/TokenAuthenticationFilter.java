package xyz.lechi.onlineshop.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.util.Optional;
import java.util.UUID;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private static final String BEARER_PREFIX = "Bearer ";

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        super("/**");
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return extractToken(request.getHeader("Authorization"))
            .map(token -> TokenAuthentication.builder().token(token).build())
            .map(tokenAuthentication -> getAuthenticationManager().authenticate(tokenAuthentication))
            .orElse(null);
    }

    private Optional<UUID> extractToken(String authorizationHeader) {
        if (authorizationHeader == null) {
            return Optional.empty();
        }

        if (!authorizationHeader.startsWith(BEARER_PREFIX)) {
            return Optional.empty();
        }

        try {
            var tokenString = authorizationHeader.substring(BEARER_PREFIX.length());
            return Optional.of(UUID.fromString(tokenString));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
