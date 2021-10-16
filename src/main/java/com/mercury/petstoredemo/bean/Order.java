package com.mercury.petstoredemo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Project_Order")
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private Date purchaseDate;

    @Column
    private String status;

    @Column
    private String shippingAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "order")
    private List<OrderProduct> purchases;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private PaymentInfo paymentInfo;

    public Order() {
    }

    public Order(int id, Date purchaseDate, String status, String shippingAddress, User user, List<OrderProduct> purchases, PaymentInfo paymentInfo) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.shippingAddress = shippingAddress;
        this.user = user;
        this.purchases = purchases;
        this.paymentInfo = paymentInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderProduct> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<OrderProduct> purchases) {
        this.purchases = purchases;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", purchaseDate=" + purchaseDate +
                ", status='" + status + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", user=" + user +
                ", purchases=" + purchases +
                ", paymentInfo=" + paymentInfo +
                '}';
    }
}
