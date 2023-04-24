package com.atanu.userService.DAO;

import com.atanu.userService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,String> {
}
