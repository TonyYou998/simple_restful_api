package com.uit.simple_restful.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String roleName;
    String token;
}
