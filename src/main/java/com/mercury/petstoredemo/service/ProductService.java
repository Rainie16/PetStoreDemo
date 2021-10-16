package com.mercury.petstoredemo.service;

import com.mercury.petstoredemo.bean.Product;
import com.mercury.petstoredemo.dao.ProductDao;
import com.mercury.petstoredemo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById(Integer id) { return productDao.findById(id).get(); }

    public List<Product> getAll() { return productDao.findAll(); }

    public Product getProductByName(String name) { return productDao.findByName(name); }

    public List<Product> getProductsByBrand(String brand) {
        return productDao.findAll().stream().filter(p -> {
            return p.getBrand().equalsIgnoreCase(brand);
        }).collect(Collectors.toList());
    }

    public List<Product> getProductsByPrice(double price) { return productDao.findByPrice(price);}

    public List<Product> getProductsByType(String type) {
        return productDao.findAll().stream().filter(p -> {
            return p.getType().equalsIgnoreCase(type);
        }).collect(Collectors.toList());
    }

    public Response save(Product product) {
        try{
            productDao.save(product);
            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

    public Response update(Product product) {
        try{
            Product p = productDao.getById(product.getId());
            p.setImage(product.getImage());
            p.setBrand(product.getBrand());
            p.setStock(product.getStock());
            p.setDescription(product.getDescription());
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setType(product.getType());
            productDao.save(p);
            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

    public Response deleteProducts(int id) {
        try {
            productDao.deleteById(id);
            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }
}
