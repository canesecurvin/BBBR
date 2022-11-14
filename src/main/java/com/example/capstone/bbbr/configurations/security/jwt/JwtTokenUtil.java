package com.example.capstone.bbbr.configurations.security.jwt;

import com.example.capstone.bbbr.configurations.security.services.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class JwtTokenUtil {
    @Value("${bbbr.app.secret}")
    private String secret;
    @Value("${bbbr.app.expiration}")
    private String expiration;
    private SecretKey key;

    public String createJwtToken(Authentication authentication) throws ParseException {
        Calendar expireDate= Calendar.getInstance();
        expireDate.setTimeInMillis(System.currentTimeMillis() + Long.parseLong(expiration));
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println(secret);
        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(expireDate.getTime())
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUserName(String jwtToken) {
        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
