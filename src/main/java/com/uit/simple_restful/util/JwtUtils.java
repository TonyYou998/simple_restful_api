package com.uit.simple_restful.util;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.uit.simple_restful.dto.UserDetailsDto;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class JwtUtils {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
     private Long jwtExpiration = 108000L;
    private String authHeader = "Authorization";
    private String tokenPrefix = "Bearer ";
    final String jwtSecret="tanvuu998";
    public String generateJwtToken(Authentication authentication){
//        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
        Date now=new Date();
        UserDetailsDto userDetailsDto=(UserDetailsDto) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = userDetailsDto.getAuthorities();
//        String email=userDetailsDto.getEmail();
        List<String> roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return  Jwts.builder()
                .claim("roles", roles)
                .setSubject(userDetailsDto.getUsername())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+jwtExpiration))
                .signWith(SignatureAlgorithm.HS512,jwtSecret)
                .compact();
    }

    public String getJwtTokenFromRequest(HttpServletRequest request) {
        String header=request.getHeader(authHeader);
        if(StringUtils.hasText(header)&&header.startsWith(tokenPrefix)){
            return header.substring(tokenPrefix.length());
        }
        return null;

    }
//    public String getTokenFromHeader(String authHeader){
//        if(StringUtils.hasText(authHeader) && authHeader.startsWith(tokenPrefix)){
//            return authHeader.substring(tokenPrefix.length());
//        }
//        return null;
//
//    }

    public boolean validadteJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException | MalformedJwtException | IllegalArgumentException | UnsupportedJwtException e) {
            logger.info(e.getMessage());
        }
        return false;

    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public String getEmailFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().get("email", String.class);
    }
    
}
