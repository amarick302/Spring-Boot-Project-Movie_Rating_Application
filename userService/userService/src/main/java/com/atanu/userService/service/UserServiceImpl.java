package com.atanu.userService.service;

import com.atanu.userService.DAO.UserDAO;
import com.atanu.userService.dto.UserDto;
import com.atanu.userService.entities.User;
import com.atanu.userService.mapping.UserDtoMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    UserDtoMapping mapping=new UserDtoMapping();
    @Override
    public UserDto creteUser(UserDto userDto) {

        User user=mapping.fromUserDtoToUser(userDto);

       UserDto savedUser= mapping.fromUserToUserDto(userDAO.save(user));

        return savedUser;
    }

    @Override
    public UserDto getSingleUser(String id) {
        User user = userDAO.findById(id).get();
        return mapping.fromUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList= userDAO.findAll();
        List<UserDto> allUser=new ArrayList<>();
        for(User user:userList){
            UserDto userDto=mapping.fromUserToUserDto(user);
            allUser.add(userDto);
        }
        return allUser;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User user=mapping.fromUserDtoToUser(userDto);
        return mapping.fromUserToUserDto(userDAO.save(user));
    }

    @Override
    public boolean deleteUser(String id) {
        User user = userDAO.findById(id).get();
        if(user!=null){
            userDAO.delete(user);
            return true;
        }
        return false;
    }
}
