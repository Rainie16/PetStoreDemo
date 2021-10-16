package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
