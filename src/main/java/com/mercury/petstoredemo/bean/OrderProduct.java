package com.mercury.petstoredemo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Project_Order_Product")
public class OrderProduct {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int qty;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Product product;

    public OrderProduct() {
    }

    public OrderProduct(int id, int qty, Order order, Product product) {
        this.id = id;
        this.qty = qty;
        this.order = order;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", qty=" + qty +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
