package com.anymind.pos.domain;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import com.anymind.pos.validator.DateConstraint;
import com.anymind.pos.validator.PaymentMethodConstraint;

import lombok.Data;

@Data
public class PaymentInput {
	
	@Min(value = 1L)
	@Digits(integer = 10, fraction = 0)
	int customerId;
	
	@PaymentMethodConstraint
	String paymentMethod;
	
	@Digits(integer = 10, fraction = 2)
	double price;
	
	@Digits(integer = 10, fraction = 2)
	double priceModifier;
	
	@DateConstraint(format = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	String dateTime;
	
	@Valid
	AdditionalItem additionalItem;
}
