package me.jeonguk.avatar_community.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final SecretKey secretKey;

    @Value("${jwt.expiration}")
    private Long expirationHours;

    private static final ZoneOffset UTC_OFFSET = ZoneOffset.UTC;

    public String generateToken(String username) {
        OffsetDateTime now = OffsetDateTime.now(UTC_OFFSET);
        OffsetDateTime expiryDate = now.plusHours(expirationHours);

        return Jwts.builder()
                .subject(username)
                .issuedAt(Date.from(now.toInstant()))
                .expiration(Date.from(expiryDate.toInstant()))
                .signWith(secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

}
