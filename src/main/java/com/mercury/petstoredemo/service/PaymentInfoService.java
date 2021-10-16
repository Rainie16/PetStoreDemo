package com.mercury.petstoredemo.service;

import com.mercury.petstoredemo.bean.PaymentInfo;
import com.mercury.petstoredemo.dao.PaymentInfoDao;
import com.mercury.petstoredemo.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentInfoService {

    @Autowired
    private PaymentInfoDao paymentInfoDao;

    public List<PaymentInfo> getAll() { return paymentInfoDao.findAll();}

    public PaymentInfo getById(int id) { return paymentInfoDao.findById(id).get();}

    public Response upsert(PaymentInfo paymentInfo) {

        try{
            if(paymentInfo.getExpirationDate().compareTo(new Date())>0){
                paymentInfoDao.save(paymentInfo);
                return new Response(true);
            }else {
                return new Response(false, 400, "Card is expired");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }

    public Response deletePaymentInfo(int id) {
        try{
            paymentInfoDao.deleteById(id);
            return new Response(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(false, 400, e.getMessage());
        }
    }
}
