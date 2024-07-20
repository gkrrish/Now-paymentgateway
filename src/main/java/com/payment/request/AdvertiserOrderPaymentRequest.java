package com.payment.request;

import lombok.Data;

@Data
public class AdvertiserOrderPaymentRequest {

	private String advertiserMobileNumber;
	private String advertiserName;
	private String location;
	private double targetAdvertisementCharges;

}
