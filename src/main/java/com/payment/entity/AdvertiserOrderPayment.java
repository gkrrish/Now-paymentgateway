package com.payment.entity;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity(name = "ADVERTISER_PAYMENT")
public class AdvertiserOrderPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertiser_payment_order_id")
    private long advertiserPaymentOrderId;
    
    @Column(name = "advertiser_mobile_number")
    private String advertiserMobileNumber;
    
    @Column(name = "current_time")
    private Timestamp currentTime;
    
    @Column(name = "advertiser_name")
    private String advertiserName;
    
    @Column(name = "location")
    private String location;
    
    @Column(name = "target_advertisement_charges")
    private double targetAdvertisementCharges;
    
    @Column(name = "advertiser_order_status")
    private String advertiserOrderStatus;
    
    @Column(name = "razorpay_advertiser_payment_order_id")
    private String razorpayAdvertiserPaymentOrderId;
}
