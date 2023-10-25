package com.uit.simple_restful.service;

import com.uit.simple_restful.dto.UserDetailsDto;
import com.uit.simple_restful.entity.User;
import com.uit.simple_restful.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class UserDetailServiceImpl implements UserDetailsService {
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repository.findByUsername(username);
        Set<GrantedAuthority> authorities=new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ user.getRole()));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
        return new UserDetailsDto(user.getUsername(),user.getPassword(),authorities);
    }
}
