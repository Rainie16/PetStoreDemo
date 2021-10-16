package com.mercury.petstoredemo.service;

import com.mercury.petstoredemo.bean.Breed;
import com.mercury.petstoredemo.dao.BreedDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreedService {

    @Autowired
    private BreedDao breedDao;

    public List<Breed> getAll() { return breedDao.findAll(); }

    public Breed getById(int id) { return breedDao.findById(id).get(); }

    public List<Breed> getBreedBySpecies(String species) {
    //    return breedDao.findBySpecies(species);
        List<Breed> all = getAll();
        return all.stream().filter(breed -> {
            return breed.getSpecies().equalsIgnoreCase(species);
        }).collect(Collectors.toList());
    }


}
