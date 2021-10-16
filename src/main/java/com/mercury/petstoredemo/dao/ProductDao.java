package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {

    public Product findByName(String name);

    // below : is placeholder, when java invoke this method, it will move double price
    // to be the @Param and replace the query
    @Query("select p from Product p where p.price = :price")
    public List<Product> findByPrice(@Param("price") double price);
}
