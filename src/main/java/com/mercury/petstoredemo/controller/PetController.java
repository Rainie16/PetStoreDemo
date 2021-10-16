package com.mercury.petstoredemo.controller;

import com.mercury.petstoredemo.bean.Pet;
import com.mercury.petstoredemo.http.Response;
import com.mercury.petstoredemo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAll() { return petService.getAll(); }

    @GetMapping("/{id}")
    public Pet getById(@PathVariable int id) { return petService.getById(id); }

    @PostMapping
    public Response save(@RequestBody Pet pet) {
        return petService.save(pet);
    }

    @PutMapping
    public Response update(@RequestBody Pet pet) {
        return petService.update(pet);
    }

    @DeleteMapping
    public Response delete(@RequestBody int id) {
        return petService.deletePet(id);
    }
}
