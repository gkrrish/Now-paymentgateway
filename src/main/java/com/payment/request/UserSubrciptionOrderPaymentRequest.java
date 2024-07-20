package com.payment.request;

import lombok.Data;

@Data
public class UserSubrciptionOrderPaymentRequest {
	
	private String userSubscriberMobileNumber;
	 private String userName;
	 private double userSubscriptionCharges;

}
