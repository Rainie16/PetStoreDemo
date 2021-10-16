package com.mercury.petstoredemo.controller;

import com.mercury.petstoredemo.bean.StoreService;
import com.mercury.petstoredemo.http.Response;
import com.mercury.petstoredemo.service.StoreServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storeservices")
public class StoreServiceController {

    @Autowired
    private StoreServiceService storeServiceService;

    @GetMapping
    public List<StoreService> getAll() { return storeServiceService.getAll(); }

    @GetMapping("/{id}")
    public StoreService getById(@PathVariable int id) { return storeServiceService.getById(id); }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable int id) { return storeServiceService.deleteStoreService(id); }

}
