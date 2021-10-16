package com.mercury.petstoredemo.dao;

import com.mercury.petstoredemo.bean.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDao extends JpaRepository<Pet, Integer> {
}
