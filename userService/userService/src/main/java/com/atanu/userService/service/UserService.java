package com.atanu.userService.service;

import com.atanu.userService.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto creteUser(UserDto userDto);
    public UserDto getSingleUser(String id);
    public List<UserDto> getAllUser();
    public UserDto updateUser(UserDto userDto);
    public boolean deleteUser(String id);

}
