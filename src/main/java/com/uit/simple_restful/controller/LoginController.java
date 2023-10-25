package com.uit.simple_restful.controller;

import com.uit.simple_restful.dto.GetUserDto;
import com.uit.simple_restful.dto.UserDto;
import com.uit.simple_restful.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class LoginController {
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody GetUserDto request){
        UserDto response= userService.login(request);
        return ResponseEntity.ok(response);

    }
}
