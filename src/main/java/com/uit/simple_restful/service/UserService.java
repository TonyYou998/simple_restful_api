package com.uit.simple_restful.service;

import com.uit.simple_restful.dto.GetUserDto;
import com.uit.simple_restful.dto.UserDto;

public interface UserService {
    UserDto login(GetUserDto request);
}
