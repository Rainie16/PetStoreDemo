package com.mercury.petstoredemo.controller;

import com.mercury.petstoredemo.bean.Breed;
import com.mercury.petstoredemo.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/breeds")
public class BreedController {

    @Autowired
    private BreedService breedService;

    @GetMapping
    public List<Breed> getAll() { return breedService.getAll();}

    @GetMapping("/{id}")
    public Breed getById(@PathVariable int id) { return breedService.getById(id); }

    @GetMapping("/species/{species}")
    public List<Breed> getBySpecies(@PathVariable String species) { return breedService.getBreedBySpecies(species);}
}
