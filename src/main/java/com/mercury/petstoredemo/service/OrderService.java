package com.mercury.petstoredemo.service;

import com.mercury.petstoredemo.bean.Order;
import com.mercury.petstoredemo.bean.OrderProduct;
import com.mercury.petstoredemo.bean.Product;
import com.mercury.petstoredemo.dao.OrderDao;
import com.mercury.petstoredemo.dao.OrderProductDao;
import com.mercury.petstoredemo.dao.ProductDao;
import com.mercury.petstoredemo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderProductDao orderProductDao;

    @Autowired
    private ProductDao productDao;

    public List<Order> getAll() {
        return orderDao.findAll();
    }

    public Order getOrderById(Integer id) {
        return orderDao.findById(id).get();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Response save(Order order) {
        try {
            List<OrderProduct> purchases = order.getPurchases();
            AtomicBoolean flag = new AtomicBoolean(false);
            purchases.forEach((orderProduct) -> {

                Product product = productDao.findById(orderProduct.getProduct().getId()).get();
                if(product.getStock()-orderProduct.getQty()>0) {
                    product.setStock(product.getStock() - orderProduct.getQty());
                    flag.set(true);
                    orderProduct.setProduct(product);
                    productDao.save(product);
                    orderProduct.setOrder(order);
                }
            });
            if(flag.get()) {
                order.setPurchaseDate(new Date());
                order.setStatus("pending");
                orderDao.save(order);
            }
            return new Response(flag.get());
        } catch (Exception e) {
            return new Response(false);
        }
    }

    public Response edit(Order order) {
        try {
            if (order.getStatus() == "pending") {
                Order o = (Order) orderDao.findById(order.getId()).get();
                List<OrderProduct> purchasesToRemove = o.getPurchases();

                List<OrderProduct> purchases = order.getPurchases();

                purchases.forEach((orderProduct) -> {
                    Product product = productDao.findById(orderProduct.getProduct().getId()).get();
                    orderProduct.setProduct(product);
                    orderProduct.setOrder(o);
                });

                if (purchases.size() > 0) {
                    purchasesToRemove = purchasesToRemove.stream().filter((orderProduct) -> {
                        return !purchases.contains(orderProduct);
                    }).collect(Collectors.toList());
                }

                o.setPurchases(purchases);
                o.setPurchaseDate(new Date());
                orderDao.save(o);

                deleteOrderProducts(purchases);

                return new Response(true);
            } return new Response(false, 400, "statue is not pending, order unable to edit");

        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

    public void deleteOrderProducts(List<OrderProduct> purchases) {
        orderProductDao.deleteAll(purchases);
    }

    public Response deleteOrder(int id) {
        try {
            Order order = orderDao.getById(id);
            if(order.getStatus()=="pending") {
                orderDao.deleteById(id);
                return new Response(true);
            } else {
                return new Response(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

}