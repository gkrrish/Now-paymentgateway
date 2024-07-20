package com.payment.gateway.service;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.payment.entity.UserSubrciptionOrderPayment;
import com.payment.repository.UserSubrciptionOrderPaymentRequestRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class UserSubscriberPayementGatewayService {

	@Autowired
	private UserSubrciptionOrderPaymentRequestRepository userSubscriptionOrderPaymentRequestRepository;

	@Value("${razorpay.key.id}")
	private String razorPayKey;
	
	@Value("${razorpay.secret.key}")
	private String razorPaySecret;
	
	private RazorpayClient razorpayClient;

	public UserSubrciptionOrderPayment createUserSubsciptionOrder(UserSubrciptionOrderPayment userSubscriptionRequest) throws RazorpayException {
		
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount", userSubscriptionRequest.getUserSubscriptionCharges() * 100);
		orderRequest.put("currency","INR");
		orderRequest.put("receipt", "kallemkishan204@gmail.com");
		
		this.razorpayClient = new RazorpayClient(razorPayKey, razorPaySecret);
		
		Order userSubscriptionRazorPayOrder = razorpayClient.orders.create(orderRequest);
		
		System.out.println("TESTING :: "+userSubscriptionRazorPayOrder);
		
		userSubscriptionRequest.setRazorpayUserPaymentOrderId(userSubscriptionRazorPayOrder.get("id"));
		userSubscriptionRequest.setUserOrderStatus(userSubscriptionRazorPayOrder.get("status"));
		
		userSubscriptionOrderPaymentRequestRepository.save(userSubscriptionRequest);
		
		return userSubscriptionRequest;
	}

	public Optional<UserSubrciptionOrderPayment> findById(Long id) {
		return userSubscriptionOrderPaymentRequestRepository.findById(id);
	}

}
