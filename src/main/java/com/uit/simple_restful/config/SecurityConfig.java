package com.uit.simple_restful.config;

import com.uit.simple_restful.util.JwtAuthorizationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private JwtAuthorizationFilter jwtAuthorizationFilter;
         @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.cors();
                http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                http.csrf().disable();
                http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
            http.authorizeHttpRequests(authorize->authorize
                    .requestMatchers(HttpMethod.POST, "/api/v1/tasks")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/api/v1/tasks/**")
                    .hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/v1/tasks/**")
                    .hasRole("ADMIN")
                    .anyRequest()
                    .permitAll()
            );
            return http.build();
    
    }
    @Bean
    PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder(12);
    }
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }
}
