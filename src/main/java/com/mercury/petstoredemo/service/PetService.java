package com.mercury.petstoredemo.service;

import com.mercury.petstoredemo.bean.Pet;
import com.mercury.petstoredemo.dao.PetDao;
import com.mercury.petstoredemo.http.Response;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetDao petDao;

    public List<Pet> getAll() { return petDao.findAll(); }

    public Pet getById(int id) { return petDao.findById(id).get(); }

    //public List<Pet> getByUserId(int id) {return petDao.findAll().stream().filter(i -> {return i==petDao.getById()});}

    public Response save(Pet pet) {
        try {
            petDao.save(pet);
            return new Response(true);

        } catch (Exception e) {
            return new Response(false, 400, e.getMessage());
        }
    }

    public Response update(Pet pet) {
        try{
            Pet p = petDao.getById(pet.getId());
            p.setBirthday(pet.getBirthday());
            p.setBreed(pet.getBreed());
            p.setGender(pet.getGender());
            p.setName(pet.getName());
            p.setImage(pet.getImage());
            petDao.save(p);
            return new Response(true);

        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

    public Response deletePet(int id) {
        try {
            petDao.deleteById(id);
            return new Response(true);
        } catch(Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

}
