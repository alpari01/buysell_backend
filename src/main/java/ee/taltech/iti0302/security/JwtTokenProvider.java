package ee.taltech.iti0302.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtTokenProvider {
    private static final byte[] keyBytes = Decoders.BASE64.decode("bXkgc2VjcmV0IHN1cGVyIHNlY3JldCBhbmQgbG9uZyBlbm91Z2ggc2VjcmV0");
    public static final Key key = Keys.hmacShaKeyFor(keyBytes);

    public static String generateToken(String userName) {
        long currentTimeMs = System.currentTimeMillis();
        long tokenDuration = 1000 * 60 * 60;
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", userName);

        return Jwts.builder()
            .setSubject("subject")
            .addClaims(claims)
            .setIssuedAt(new Date(currentTimeMs))
            .setExpiration(new Date(currentTimeMs + tokenDuration))
            .signWith(key)
            .compact();
    }
}
