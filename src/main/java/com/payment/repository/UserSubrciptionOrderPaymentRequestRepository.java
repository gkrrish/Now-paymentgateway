package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.UserSubrciptionOrderPayment;

@Repository
public interface UserSubrciptionOrderPaymentRequestRepository extends JpaRepository<UserSubrciptionOrderPayment, Long> {
}
