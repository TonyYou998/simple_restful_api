package com.uit.simple_restful.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserDto {
    private  String username;
    private String password;
}
