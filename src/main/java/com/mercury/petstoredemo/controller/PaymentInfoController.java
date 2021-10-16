package com.mercury.petstoredemo.controller;

import com.mercury.petstoredemo.bean.PaymentInfo;
import com.mercury.petstoredemo.http.Response;
import com.mercury.petstoredemo.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentinfos")
public class PaymentInfoController {

    @Autowired
    private PaymentInfoService paymentInfoService;

    @GetMapping
    public List<PaymentInfo> getAll() { return paymentInfoService.getAll(); }

    @GetMapping("/{id}")
    public PaymentInfo getById(@PathVariable int id) { return paymentInfoService.getById(id); }

    @PostMapping
    public Response save(@RequestBody PaymentInfo paymentInfo) { return paymentInfoService.upsert(paymentInfo); }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable int id) { return paymentInfoService.deletePaymentInfo(id); }
}
