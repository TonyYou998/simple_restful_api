package com.uit.simple_restful.controller;

import com.uit.simple_restful.dto.GetUserDto;
import com.uit.simple_restful.dto.UserDto;
import com.uit.simple_restful.entity.User;
import com.uit.simple_restful.helper.ResponseHandler;
import com.uit.simple_restful.service.UserService;
import com.uit.simple_restful.util.Constants;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.Base_Url+Constants.User_Endpoint)
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @PostMapping(Constants.Login)
    public ResponseEntity<Object> login(@RequestBody GetUserDto request){
        UserDto response= userService.login(request);
        return ResponseHandler.getResponse(response, HttpStatus.OK);

    }
    @GetMapping(Constants.Get)
    public ResponseEntity<Object> getUser(){

       GetUserDto dto=new GetUserDto("admin","1234");
      return  ResponseHandler.getResponse(dto, HttpStatus.OK);
    }
}
