package com.anymind.pos.service;

import java.util.List;

import com.anymind.pos.domain.entity.PaymentMethod;

public interface PaymentMethodService {
	PaymentMethod retrievePaymentMethodByCode (String paymentMethodCode);
	
	List<PaymentMethod> retrieveAllPaymentMethod();
}
