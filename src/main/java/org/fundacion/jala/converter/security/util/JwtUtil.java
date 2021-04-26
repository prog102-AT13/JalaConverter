/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Raymundo Guaraguara Sansusty
 */
package org.fundacion.jala.converter.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * This class creates a json web token.
 */
@Service
public class JwtUtil {
    private static final String SECRET_KEY = "secret";
    private static final int EXPIRATION_TIME = 1000 * 60 * 60 * 10;

    /**
     * Gets username from token.
     *
     * @param token a string with the token.
     * @return a String with username.
     */
    public String extractUsername(final String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Gets expiration date from token.
     *
     * @param token a string with the token.
     * @return a Date with expiration date.
     */
    public Date extractExpiration(final String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts all the claims.
     *
     * @param token a string with the token.
     * @param claimsResolver context information about an authorization request.
     * @param <T> generic class.
     * @return a generic with all the claims.
     */
    public <T> T extractClaim(final String token, final Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Gets all the claims from a token.
     *
     * @param token a string with the token.
     * @return a Claims object with the claims.
     */
    private Claims extractAllClaims(final String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    /**
     * Checks if the token is still valid.
     *
     * @param token a string with the token.
     * @return a boolean with the result.
     */
    private Boolean isTokenExpired(final String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Generates the token.
     *
     * @param userDetails the users information.
     * @return a String with the token.
     */
    public String generateToken(final UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    /**
     * Creates a token.
     *
     * @param claims pieces of information asserted about a subject.
     * @param subject the user.
     * @return a String with the token.
     */
    private String createToken(final Map<String, Object> claims, final String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    /**
     * Checks if the username matches the token and the token has not expired.
     *
     * @param token a string with the token.
     * @param userDetails the users information.
     * @return a Boolean with the result.
     */
    public Boolean validateToken(final String token, final UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
