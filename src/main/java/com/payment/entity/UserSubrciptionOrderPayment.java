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
@Entity(name = "USER_SUBSCRIPTION_PAYMENT")
public class UserSubrciptionOrderPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_payment_order_id")
    private long userPaymentOrderId;
    
    @Column(name = "user_subscriber_mobile_number")
    private String userSubscriberMobileNumber;
    
    @Column(name = "current_time")
    private Timestamp currentTime;
    
    @Column(name = "user_name")
    private String userName;
    
    @Column(name = "user_subscription_charges")
    private double userSubscriptionCharges;
    
    @Column(name = "user_order_status")
    private String userOrderStatus;
    
    @Column(name = "razorpay_user_payment_order_id")
    private String razorpayUserPaymentOrderId;
}
