package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
}
