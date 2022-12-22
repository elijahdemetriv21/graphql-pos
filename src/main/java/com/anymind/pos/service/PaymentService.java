package com.anymind.pos.service;

import java.sql.Timestamp;
import java.util.List;

import com.anymind.pos.domain.PaymentInput;
import com.anymind.pos.domain.Sales;
import com.anymind.pos.domain.entity.Payment;

public interface PaymentService {
	
	Payment createPayment(PaymentInput paymentInput);
	
	List<Payment> findAll();
	
	List<Sales> retrieveHourlySales(Timestamp startDateTime, Timestamp endDateTime);
}
