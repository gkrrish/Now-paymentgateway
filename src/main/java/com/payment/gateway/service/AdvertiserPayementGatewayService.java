package com.payment.gateway.service;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.payment.entity.AdvertiserOrderPayment;
import com.payment.repository.AdvertiserOrderPaymentRequestRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class AdvertiserPayementGatewayService {

	@Autowired
	private AdvertiserOrderPaymentRequestRepository advertiserOrderPaymentRequestRepository;

	@Value("${razorpay.key.id}")
	private String razorPayKey;
	
	@Value("${razorpay.secret.key}")
	private String razorPaySecret;
	
	private RazorpayClient razorpayClient;

	public AdvertiserOrderPayment createOrderAdvertiserOrder(AdvertiserOrderPayment advertiserRequest) throws RazorpayException {
		
		JSONObject orderRequest = new JSONObject();
		
		orderRequest.put("amount", advertiserRequest.getTargetAdvertisementCharges() * 100);
		orderRequest.put("currency","INR");
		orderRequest.put("receipt", "kallemkishan204@gmail.com");
		
		this.razorpayClient = new RazorpayClient(razorPayKey, razorPaySecret);
		
		Order advertiserRazorPayOrder = razorpayClient.orders.create(orderRequest);
		
		System.out.println("TESTING :: "+advertiserRazorPayOrder);
		
		advertiserRequest.setRazorpayAdvertiserPaymentOrderId(advertiserRazorPayOrder.get("id"));
		advertiserRequest.setAdvertiserOrderStatus(advertiserRazorPayOrder.get("status"));
		
		advertiserOrderPaymentRequestRepository.save(advertiserRequest);
		
		return advertiserRequest;
	}

	public Optional<AdvertiserOrderPayment> findById(Long id) {
		return advertiserOrderPaymentRequestRepository.findById(id);
	}

}
