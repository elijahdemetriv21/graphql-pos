package com.anymind.pos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.spy;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.anymind.pos.domain.PaymentInput;
import com.anymind.pos.domain.entity.Payment;
import com.anymind.pos.domain.entity.PaymentMethod;
import com.anymind.pos.repository.PaymentRepository;
import com.anymind.pos.util.ParserUtil;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceTest {

	@InjectMocks
	private PaymentServiceImpl paymentService;
	
	@Mock
	private PaymentRepository paymentRepository;
	
	@Mock
	private PaymentMethodService paymentMethodService;
	
	private PaymentMethod paymentMethodStub;
	
	private Payment paymentStub;
	
	private PaymentInput paymentInputStub;
	
	@Before
	public void setup() {
		paymentInputStub = new PaymentInput();
		paymentInputStub.setCustomerId(12345);
		paymentInputStub.setPaymentMethod("CASH");
		paymentInputStub.setPrice(100);
		paymentInputStub.setPriceModifier(1);
		paymentInputStub.setDateTime("2022-01-01T00:00:00Z");
		
		paymentStub = new Payment();
		paymentStub.setCustomerId(12345);
		paymentStub.setPaymentMethodCode("CASH");
		paymentStub.setPrice(100);
		paymentStub.setPriceModifier(1);
		paymentStub.setFinalPrice(new BigDecimal("100"));
		paymentStub.setPoints(new BigDecimal("5"));
		paymentStub.setDateTime(ParserUtil.parseDateTime("2022-01-01T00:00:00Z"));
		
		paymentMethodStub = new PaymentMethod();
		paymentMethodStub.setPaymentMethodCode("CASH");
		paymentMethodStub.setMinPriceModifier(0.9);
		paymentMethodStub.setMaxPriceModifier(1);
		paymentMethodStub.setPointsModifier(0.05);
	}
	
	@Test
	public void shouldCreatePayment() {
		when(paymentRepository.save(any())).thenReturn(paymentStub);
		when(paymentMethodService.retrievePaymentMethodByCode(any())).thenReturn(paymentMethodStub);
					
		Payment payment = paymentService.createPayment(paymentInputStub);
		
		assertEquals(100, payment.getFinalPrice().intValue());
	}
}
