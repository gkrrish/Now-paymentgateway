package com.payment.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.entity.UserSubrciptionOrderPayment;
import com.payment.gateway.service.UserSubscriberPayementGatewayService;
import com.payment.request.UserSubrciptionOrderPaymentRequest;
import com.razorpay.RazorpayException;

@Service
public class UserSubscriptionPaymentDelegateValidationService {

	@Autowired
	private UserSubscriberPayementGatewayService subscriberPayementGatewayService;

	/**
	 * Any validations are there before going to payment we can do here
	 */
	@Transactional
	public UserSubrciptionOrderPayment createPayment(UserSubrciptionOrderPaymentRequest userSubscriptionPayment) throws RazorpayException {
		
		UserSubrciptionOrderPayment payment =new UserSubrciptionOrderPayment();
		payment.setCurrentTime(Timestamp.from(Instant.now()));
		payment.setUserName(userSubscriptionPayment.getUserName());
		payment.setUserSubscriberMobileNumber(userSubscriptionPayment.getUserSubscriberMobileNumber());
		payment.setUserSubscriptionCharges(userSubscriptionPayment.getUserSubscriptionCharges());
		payment.setUserOrderStatus("false");

		return subscriberPayementGatewayService.createUserSubsciptionOrder(payment);
	}

	@Transactional
	public UserSubrciptionOrderPayment getPaymentById(Long id) {

		Optional<UserSubrciptionOrderPayment> detailById = subscriberPayementGatewayService.findById(id);
		if (detailById.isPresent()) {
			return detailById.get();
		}
		return new UserSubrciptionOrderPayment();
	}

}
