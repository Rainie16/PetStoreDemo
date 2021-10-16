package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
