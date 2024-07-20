package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.AdvertiserOrderPayment;

@Repository
public interface AdvertiserOrderPaymentRequestRepository extends JpaRepository<AdvertiserOrderPayment, Long> {
}
