package xyz.lechi.onlineshop.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import xyz.lechi.onlineshop.service.TokenService;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private static final String BEARER_PREFIX = "Bearer ";

    private final TokenService tokenService;

    private static Optional<UUID> extractToken(String authorizationHeader) {
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

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        @NonNull HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        var tokenAuthentication = extractToken(request.getHeader("Authorization"))
            .flatMap(
                token -> tokenService
                    .getUserByToken(token)
                    .map(user -> new TokenAuthentication(token, user))
            );

        tokenAuthentication.ifPresent(authentication -> {
            var securityContext = SecurityContextHolder.getContext();

            if (securityContext.getAuthentication() == null) {
                securityContext.setAuthentication(authentication);
            }
        });

        filterChain.doFilter(request, response);
    }
}
