package com.anymind.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.anymind.pos.domain.entity.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, String>{
	
	@Query("SELECT p from PaymentMethod p where p.paymentMethodCode = ?1")
	PaymentMethod findByPaymentMethod(String paymentMethodCode);
}	
