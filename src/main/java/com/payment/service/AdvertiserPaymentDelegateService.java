package com.payment.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.entity.AdvertiserOrderPayment;
import com.payment.gateway.service.AdvertiserPayementGatewayService;
import com.payment.request.AdvertiserOrderPaymentRequest;
import com.razorpay.RazorpayException;

@Service
public class AdvertiserPaymentDelegateService {

	@Autowired
	private AdvertiserPayementGatewayService advertiserPayementGatewayService;

	public AdvertiserOrderPayment createPayment(AdvertiserOrderPaymentRequest advertiserPayement) throws RazorpayException {
	
		AdvertiserOrderPayment payment=new AdvertiserOrderPayment();
		payment.setAdvertiserMobileNumber(advertiserPayement.getAdvertiserMobileNumber());
		payment.setAdvertiserName(advertiserPayement.getAdvertiserName());
		payment.setAdvertiserOrderStatus("false");
		payment.setCurrentTime(Timestamp.from(Instant.now()));
		payment.setLocation(advertiserPayement.getLocation());
		payment.setTargetAdvertisementCharges(advertiserPayement.getTargetAdvertisementCharges());
		
		return advertiserPayementGatewayService.createOrderAdvertiserOrder(payment);
	}

	public AdvertiserOrderPayment getPaymentById(Long id) {
		Optional<AdvertiserOrderPayment> byId = advertiserPayementGatewayService.findById(id);

		if (byId.isPresent()) {
			return byId.get();
		}
		return null;
	}//handle later clearly

}
