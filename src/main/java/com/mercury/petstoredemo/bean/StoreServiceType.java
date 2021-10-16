package com.mercury.petstoredemo.bean;

import javax.persistence.*;

@Entity
@Table(name = "Project_StoreServiceType")
public class StoreServiceType {
    @Id
    private int id;

    @Column
    private String type;

    @Column
    private double price;

    public StoreServiceType() {
    }

    public StoreServiceType(int id, String type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StoreServiceType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
