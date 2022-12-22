package com.anymind.pos.mutation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.anymind.pos.domain.PaymentInput;
import com.anymind.pos.domain.PaymentResponse;
import com.anymind.pos.domain.entity.Payment;
import com.anymind.pos.service.PaymentService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Validated
@Component
public class PaymentMutation implements GraphQLMutationResolver{

	@Autowired
	private PaymentService paymentService;
	
	public PaymentResponse createPayment(@Valid PaymentInput paymentInput) {
		  Payment payment = paymentService.createPayment(paymentInput);
		  
		  PaymentResponse response = new PaymentResponse();
		  response.setFinalPrice(payment.getFinalPrice());
		  response.setPoints(payment.getPoints());
		  
		  return response;
	}
	

}
