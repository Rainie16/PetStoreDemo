package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedDao extends JpaRepository<Breed, Integer> {

}
