package com.mercury.petstoredemo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Project_StoreService")
public class StoreService {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private Date appointment;

    @Column
    private int petId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "storeServiceType_id")
    private StoreServiceType storeServiceType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public StoreService() {
    }

    public StoreService(int id, Date appointment, StoreServiceType storeServiceType, User user) {
        this.id = id;
        this.appointment = appointment;
        this.storeServiceType = storeServiceType;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public StoreServiceType getStoreServiceType() {
        return storeServiceType;
    }

    public void setStoreServiceType(StoreServiceType storeServiceType) {
        this.storeServiceType = storeServiceType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "StoreService{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", petId=" + petId +
                ", storeServiceType=" + storeServiceType +
                ", user=" + user +
                '}';
    }
}
