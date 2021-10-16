package com.mercury.petstoredemo.service;

import com.mercury.petstoredemo.bean.Pet;
import com.mercury.petstoredemo.bean.StoreService;
import com.mercury.petstoredemo.dao.StoreServiceDao;
import com.mercury.petstoredemo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceService {

    @Autowired
    private StoreServiceDao storeServiceDao;

    public List<StoreService> getAll() { return storeServiceDao.findAll(); }

    public StoreService getById(int id) { return storeServiceDao.findById(id).get(); }


    public Response deleteStoreService(int id) {
        try{
            if (storeServiceDao.findById(id).get().getAppointment().compareTo(new Date()) > 0){
            storeServiceDao.deleteById(id);
            return new Response(true);
            } return new Response(false, 400, "too late to cancel");
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

}
