package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.StoreService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreServiceDao extends JpaRepository<StoreService, Integer> {

}
