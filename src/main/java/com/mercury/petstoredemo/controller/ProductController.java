package com.mercury.petstoredemo.controller;

import com.mercury.petstoredemo.bean.Product;
import com.mercury.petstoredemo.http.Response;
import com.mercury.petstoredemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() { return productService.getAll();}

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) { return productService.getProductById(id);}

    @GetMapping("/name/{name}")
    public Product getByName(@PathVariable String name) { return productService.getProductByName(name); }

    @GetMapping("/brand/{brand}")
    public List<Product> getByBrand(@PathVariable String brand) {
        brand.toLowerCase();
        return productService.getProductsByBrand(brand); }

    @GetMapping("/price/{price}")
    public List<Product> getByPrice(@PathVariable double price) { return productService.getProductsByPrice(price); }

    @GetMapping("/type/{type}")
    public List<Product> getByType(@PathVariable String type) { return productService.getProductsByType(type); }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping
    public Response save(@RequestBody Product product) {
        System.out.println("saving" + product);
        return productService.save(product);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PutMapping
    public Response update(@RequestBody Product product) {
        return productService.update(product);
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    public Response delete(@PathVariable int id) {
        return productService.deleteProducts(id);
    }

}
