package com.beaconfireabc.employee.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

public class JWTUtil {

    public static boolean isAuthenticated(HttpServletRequest httpServletRequest, String jwtTokenCookieName, String signingKey){

//        String token = getBearerToken(httpServletRequest);
        String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
        if(token == null) {
            token = getBearerToken(httpServletRequest);
        }
        System.out.println(token);
        if(token == null) return false;
        return validateToken(httpServletRequest, token, signingKey);
    }

    public static String getBearerToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public static boolean validateToken(HttpServletRequest request, String token, String secretKey) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            if (claims.getBody().getExpiration().before(new Date())) {
                return false;
            }
            if (claims.getBody().get("userId") == null) {
                return false;
            }
            System.out.println("validtate");
            System.out.println(claims.getBody().get("userId"));
            request.getSession().setAttribute("userId", claims.getBody().get("userId"));
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }

    }

}
