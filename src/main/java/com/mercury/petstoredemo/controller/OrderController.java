package com.mercury.petstoredemo.controller;

import com.mercury.petstoredemo.bean.Order;
import com.mercury.petstoredemo.http.Response;
import com.mercury.petstoredemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll() { return orderService.getAll(); }

    @GetMapping("/{id}")
    public Order getById(@PathVariable int id) { return orderService.getOrderById(id); }

    @PostMapping
    public Response save(@RequestBody Order order) { return orderService.save(order); }

    @PutMapping
    public Response update(@RequestBody Order order) { return orderService.edit(order); }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable int id) { return orderService.deleteOrder(id); }
}
