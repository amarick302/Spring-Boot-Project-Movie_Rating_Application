package com.atanu.userService.mapping;

import com.atanu.userService.dto.UserDto;
import com.atanu.userService.entities.User;


public class UserDtoMapping {

    public User fromUserDtoToUser(UserDto userDto){
        User user=new User();
        user.setUserId(userDto.getUserId());
        user.setUserName(userDto.getUserName());
        user.setUserPhone(Long.parseLong(userDto.getUserPhone()));
        user.setUserAddress(userDto.getUserAddress());
        return user;
    }

    public UserDto fromUserToUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setUserName(user.getUserName());
        userDto.setUserPhone(String.valueOf(user.getUserPhone()));
        userDto.setUserAddress(user.getUserAddress());
        return userDto;
    }
}
