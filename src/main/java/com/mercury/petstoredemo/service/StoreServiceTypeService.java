package com.mercury.petstoredemo.service;

import com.mercury.petstoredemo.bean.StoreServiceType;
import com.mercury.petstoredemo.dao.StoreServiceTypeDao;
import com.mercury.petstoredemo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceTypeService {

    @Autowired
    private StoreServiceTypeDao storeServiceTypeDao;

    public List<StoreServiceType> getAll() { return storeServiceTypeDao.findAll(); }

    public StoreServiceType getById(int id) { return storeServiceTypeDao.findById(id).get(); }

    public Response upsert(StoreServiceType storeServiceType) {
        try {
            storeServiceTypeDao.save(storeServiceType);
            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

    public Response deleteStoreService(int id) {
        try {
            storeServiceTypeDao.deleteById(id);
            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

}
