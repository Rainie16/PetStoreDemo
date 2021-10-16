package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
