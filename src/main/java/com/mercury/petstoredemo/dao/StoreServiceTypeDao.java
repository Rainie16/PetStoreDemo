package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.StoreServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreServiceTypeDao extends JpaRepository<StoreServiceType, Integer> {
}
