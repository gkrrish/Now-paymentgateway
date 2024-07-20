package com.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entity.UserSubrciptionOrderPayment;
import com.payment.request.UserSubrciptionOrderPaymentRequest;
import com.payment.service.UserSubscriptionPaymentDelegateValidationService;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/api/user-subscription-payments")
public class UserSubscriptionPaymentController {

    @Autowired
    private UserSubscriptionPaymentDelegateValidationService userSubscriptionPaymentService;

    
    @PostMapping
	public ResponseEntity<UserSubrciptionOrderPayment> createPayment(@RequestBody UserSubrciptionOrderPaymentRequest paymentRequest) {
    	UserSubrciptionOrderPayment createdPayment = null;
		try {
			createdPayment = userSubscriptionPaymentService.createPayment(paymentRequest);
		} catch (RazorpayException e) {
			e.getMessage();
		}
        return ResponseEntity.ok(createdPayment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSubrciptionOrderPayment> getPaymentById(@PathVariable Long id) {
    	UserSubrciptionOrderPayment payment = userSubscriptionPaymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

}
