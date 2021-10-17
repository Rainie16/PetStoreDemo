package com.mercury.petstoredemo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Project_Pet")
public class Pet {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column
    private String gender;

    @Column
    private String image;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breed_id")
    @JsonIgnore
    private Breed breed;

    public Pet() {
    }

    public Pet(int id, String name, Date birthday, String gender, String image, User user, Breed breed) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.image = image;
        this.user = user;
        this.breed = breed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", image='" + image + '\'' +
                ", user=" + user +
                ", breed=" + breed +
                '}';
    }
}
