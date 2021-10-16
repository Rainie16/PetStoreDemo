package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoDao extends JpaRepository<PaymentInfo, Integer> {
}
