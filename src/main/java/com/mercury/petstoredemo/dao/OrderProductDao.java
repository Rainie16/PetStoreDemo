package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductDao extends JpaRepository<OrderProduct, Integer> {
}
