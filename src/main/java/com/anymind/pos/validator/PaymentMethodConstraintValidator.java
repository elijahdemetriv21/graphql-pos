package com.anymind.pos.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.anymind.pos.domain.entity.PaymentMethod;
import com.anymind.pos.repository.PaymentMethodRepository;

public class PaymentMethodConstraintValidator implements ConstraintValidator<PaymentMethodConstraint, String> {

	@Autowired
	PaymentMethodRepository repository;

    @Override
    public void initialize(final PaymentMethodConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
    	List<PaymentMethod> paymentMethod = repository.findAll();
    	
        return paymentMethod.stream().anyMatch(pm -> value.equals(pm.getPaymentMethodCode()));
    }

}
