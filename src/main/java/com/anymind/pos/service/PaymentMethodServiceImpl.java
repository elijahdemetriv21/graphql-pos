package com.anymind.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anymind.pos.domain.entity.PaymentMethod;
import com.anymind.pos.repository.PaymentMethodRepository;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService{

    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

	@Override
	public PaymentMethod retrievePaymentMethodByCode(String paymentMethodCode) {
		return paymentMethodRepository.findByPaymentMethod(paymentMethodCode);
	}

	@Override
	public List<PaymentMethod> retrieveAllPaymentMethod() {
		return paymentMethodRepository.findAll();
	}

}
