package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.AdvertiserOrderPayment;
import com.payment.request.AdvertiserOrderPaymentRequest;
import com.payment.service.AdvertiserPaymentDelegateService;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/api/advertiser-payments")
public class AdvertiserPaymentController {

    @Autowired
    private AdvertiserPaymentDelegateService advertiserPaymentService;

    @PostMapping
    public ResponseEntity<AdvertiserOrderPayment> createPayment(@RequestBody AdvertiserOrderPaymentRequest payment) {
    	AdvertiserOrderPayment createdPayment = null;
		try {
			createdPayment = advertiserPaymentService.createPayment(payment);
		} catch (RazorpayException e) {
			e.getMessage();
		}
        return ResponseEntity.ok(createdPayment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertiserOrderPayment> getPaymentById(@PathVariable Long id) {
    	AdvertiserOrderPayment payment = advertiserPaymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }
}
