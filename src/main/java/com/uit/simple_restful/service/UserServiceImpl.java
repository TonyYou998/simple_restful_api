package com.uit.simple_restful.service;

import com.uit.simple_restful.dto.GetUserDto;
import com.uit.simple_restful.dto.UserDto;
import com.uit.simple_restful.util.JwtUtils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;
    @Override
    public UserDto login(GetUserDto request) {
        UserDto response = new UserDto();


        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);
            String token = jwtUtils.generateJwtToken(auth);
            response.setToken(token);

        } catch (AuthenticationException e) {
                logger.info(e.getMessage());

        }
        return response;
    }
}
